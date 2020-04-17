package com.dilfer.aws.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.util.json.Jackson;
import com.dilfer.discord.model.EmojiUpdate;
import com.dilfer.discord.model.UpdateEmojisRequest;

import java.util.*;
import java.util.stream.Collectors;

public class UpdateEmojiStatsRequestHandler implements RequestHandler<UpdateRequestParams, Void>
{
    private final AmazonSQS sqsClient;
    private final AmazonDynamoDB dynamoDB;

    public UpdateEmojiStatsRequestHandler()
    {
        this(AmazonSQSClientBuilder.defaultClient(), AmazonDynamoDBClientBuilder.defaultClient());
    }

    public UpdateEmojiStatsRequestHandler(AmazonSQS sqsClient,
                                          AmazonDynamoDB dynamoDB)
    {

        this.sqsClient = sqsClient;
        this.dynamoDB = dynamoDB;
    }

    @Override
    public Void handleRequest(UpdateRequestParams input, Context context)
    {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest()
                .withQueueUrl(input.getSqsUrl())
                .withMaxNumberOfMessages(10);

        ReceiveMessageResult receiveMessageResult;
        do
        {
            receiveMessageResult = sqsClient.receiveMessage(receiveMessageRequest);
            List<Message> messages = receiveMessageResult.getMessages();
            List<EmojiUpdateAggregate> arregateUpdates = getArregateUpdates(messages);
            arregateUpdates.forEach(emojiUpdateAggregate -> updateDynamo(emojiUpdateAggregate, input.getDynamoTableName()));
            //messages.forEach(message -> sqsClient.deleteMessage(input.getSqsUrl(), message.getReceiptHandle()));
        }
        while (!receiveMessageResult.getMessages().isEmpty());

        return null;
    }

    //This tries to aggregate a bunch of data in Java memory to avoid too many Dynamo UpdateItem API actions. May be over engineering.
    private List<EmojiUpdateAggregate> getArregateUpdates(List<Message> sqsMessages)
    {
        Map<String, List<EmojiUpdate>> emojiUpdatesMap = sqsMessages
                .stream()
                .map(message -> Jackson.fromJsonString(message.getBody(), UpdateEmojisRequest.class))
                .map(UpdateEmojisRequest::getEmojiUpdates)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(EmojiUpdate::getEmojiTextKey, Collectors.toList()));

        return emojiUpdatesMap.entrySet().stream().map(entry ->
        {
            Map<String, Integer> userUsage = entry.getValue()
                    .stream()
                    .collect(Collectors.groupingBy(EmojiUpdate::getDiscordUser,
                            Collectors.mapping(EmojiUpdate::getUsageCount, Collectors.summingInt(usageCount -> usageCount))));
            int usageTotal = userUsage.values().stream().mapToInt(i -> i).sum();
            return new EmojiUpdateAggregate(entry.getKey(), usageTotal, userUsage);
        }).collect(Collectors.toList());
    }

    private void updateDynamo(EmojiUpdateAggregate emojiUpdateAggregate, String dynamoTableName)
    {
        Map<String, AttributeValueUpdate> attributeValueUpdateMap = new HashMap<>();
        attributeValueUpdateMap.put("usageCount", new AttributeValueUpdate(new AttributeValue().withN(Integer.toString(emojiUpdateAggregate.getUsageCount())), AttributeAction.ADD));

        emojiUpdateAggregate.getUserMap().forEach((key, value) -> attributeValueUpdateMap.put(String.format("usageCount_%s", key), new AttributeValueUpdate(new AttributeValue().withN(value.toString()), AttributeAction.ADD)));

        UpdateItemRequest updateItemRequest = new UpdateItemRequest(dynamoTableName,
                Collections.singletonMap("emoji_text", new AttributeValue(emojiUpdateAggregate.getEmojiKey())),
                attributeValueUpdateMap);

        dynamoDB.updateItem(updateItemRequest);
    }
}
