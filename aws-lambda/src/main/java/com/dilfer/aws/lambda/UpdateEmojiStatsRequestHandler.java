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
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.util.json.Jackson;
import com.dilfer.discord.model.EmojiUpdate;
import com.dilfer.discord.model.UpdateEmojisRequest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            List<EmojiUpdate> emojiUpdates = receiveMessageResult.getMessages()
                    .stream()
                    .map(message -> Jackson.fromJsonString(message.getBody(), UpdateEmojisRequest.class))
                    .map(UpdateEmojisRequest::getEmojiUpdates)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            Map<String, List<EmojiUpdate>> emojiUpdatesByDiscordUser = emojiUpdates.stream()
                    .collect(Collectors.groupingBy(EmojiUpdate::getDiscordUser));

            List<UpdateItemRequest> updateItemRequests = emojiUpdatesByDiscordUser
                    .entrySet()
                    .stream()
                    .map(entry -> getUpdateItemRequests(entry, input.getDynamoTableName()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            updateItemRequests.forEach(dynamoDB::updateItem);
            receiveMessageResult.getMessages().forEach(message -> sqsClient.deleteMessage(input.getSqsUrl(), message.getReceiptHandle()));
        }
        while (!receiveMessageResult.getMessages().isEmpty());

        return null;
    }


    private List<UpdateItemRequest> getUpdateItemRequests(Map.Entry<String, List<EmojiUpdate>> emojiUpdatesByUser, String dynamoTableName)
    {
        Map<String, AttributeValueUpdate> attributeValueUpdateMap = getAttributeValueUpdateMap(emojiUpdatesByUser.getValue());

        UpdateItemRequest userUpdateItemRequest = new UpdateItemRequest(dynamoTableName,
                Collections.singletonMap("discordUser", new AttributeValue(emojiUpdatesByUser.getKey().toLowerCase())),
                attributeValueUpdateMap);

        UpdateItemRequest globalItemRequest = new UpdateItemRequest(dynamoTableName,
                Collections.singletonMap("discordUser", new AttributeValue("global")),
                attributeValueUpdateMap);

        return Stream.of(userUpdateItemRequest, globalItemRequest).collect(Collectors.toList());
    }

    private Map<String, AttributeValueUpdate> getAttributeValueUpdateMap(List<EmojiUpdate> value)
    {
        Map<String, Integer> emojiKeysSummedUp = value.stream()
                .collect(Collectors.groupingBy(EmojiUpdate::getEmojiTextKey,
                        Collectors.mapping(EmojiUpdate::getUsageCount, Collectors.summingInt(usageCount -> usageCount))));

        return emojiKeysSummedUp.entrySet()
                .stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), new AttributeValueUpdate(new AttributeValue().withN(Integer.toString(entry.getValue())), AttributeAction.ADD)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
