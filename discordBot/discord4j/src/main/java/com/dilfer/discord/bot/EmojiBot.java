package com.dilfer.discord.bot;

import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.commands.EmojiCommands;
import com.dilfer.discord.commands.EmojiMessageParser;
import com.dilfer.discord.commands.HelpCommand;
import com.dilfer.discord.commands.ServerCommand;
import com.dilfer.discord.model.EmojiUpdate;
import com.dilfer.discord.model.PostEmojiUpdateRequest;
import com.dilfer.discord.model.UpdateEmojisRequest;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.event.domain.message.ReactionRemoveEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EmojiBot
{
    private static final Logger logger = LoggerFactory.getLogger(EmojiBot.class);

    private final DiscordBotApi discordBotApi;
    private final DiscordClient client;
    private final EmojiMessageParser emojiMessageParser;

    public EmojiBot(DiscordBotApi discordBotApi,
                      DiscordClient client,
                      EmojiMessageParser emojiMessageParser)
    {

        this.discordBotApi = discordBotApi;
        this.client = client;
        this.emojiMessageParser = emojiMessageParser;
    }

    public void run()
    {
        logger.info("Registering all commands.");
        registerHelpCommand();
        registerEmojiCommands();
        registerEmoteEventActions();
        loginAndBlockThread(client);
    }

    private void registerHelpCommand()
    {
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(EmojiBot::messageIsFromNormalUser)
                .filter(message -> HelpCommand.CMD_MESSAGE.equals(message.getContent().orElse("")))
                .flatMap(message -> new HelpCommand().run(Objects.requireNonNull(message.getChannel().block())))
                .subscribe();
    }

    private void registerEmojiCommands()
    {
        for (ServerCommand command : EmojiCommands.getEmojiCommands())
        {
            client.getEventDispatcher().on(MessageCreateEvent.class)
                    .map(MessageCreateEvent::getMessage)
                    .filter(EmojiBot::messageIsFromNormalUser)
                    .filter(message -> message.getContent().orElse("").startsWith(command.getCommandString()))
                    .flatMap(message -> runCommand(discordBotApi, command, message))
                    .subscribe();
        }
    }

    private void registerEmoteEventActions()
    {
        User botUser = client.getSelf().block();

        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(EmojiBot::messageIsFromNormalUser)
                .map(message -> emojiMessageParser.getEmojiUpdates(message, botUser))
                .filter(emojiUpdateList -> !emojiUpdateList.isEmpty())
                .subscribe(getEmojiUpdateListConsumer());

        client.getEventDispatcher().on(ReactionAddEvent.class)
                .filter(event -> event.getEmoji().asCustomEmoji().isPresent())
                .map(event -> Collections.singletonList(new EmojiUpdate()
                        .discordUser(event.getUser().block().getUsername())
                        .emojiTextKey(String.format(":%s:", event.getEmoji().asCustomEmoji().get().getName()))
                        .usageCount(1)))
                .subscribe(getEmojiUpdateListConsumer());


        client.getEventDispatcher().on(ReactionRemoveEvent.class)
                .filter(event -> event.getEmoji().asCustomEmoji().isPresent())
                .map(event -> Collections.singletonList(new EmojiUpdate()
                        .discordUser(event.getUser().block().getUsername())
                        .emojiTextKey(String.format(":%s:", event.getEmoji().asCustomEmoji().get().getName()))
                        .usageCount(-1)))
                .subscribe(getEmojiUpdateListConsumer());
    }

    private static boolean messageIsFromNormalUser(Message message)
    {
        return message.getAuthor().map(user -> !user.isBot()).orElse(false);
    }

    private static Mono<Void> runCommand(DiscordBotApi discordBotApi, ServerCommand command, Message message)
    {
        Guild guild = message.getGuild().block();

        try
        {
            return command.run(message.getChannel().block(),
                    discordBotApi,
                    Objects.requireNonNull(guild),
                    message);
        }
        catch (NullPointerException e)
        {
            logger.error("Received a null pointer exception from message : " + message.getContent().orElse("UNKNOWN"));
            return Mono.empty();
        }
    }

    private static Supplier<RuntimeException> throwRuntime()
    {
        return () -> new RuntimeException("Message content is empty somehow when trying to run command.");
    }

    private Consumer<List<EmojiUpdate>> getEmojiUpdateListConsumer()
    {
        return emojiUpdateList -> {

            UpdateEmojisRequest updateEmojisRequest = new UpdateEmojisRequest().emojiUpdates(emojiUpdateList);

            PostEmojiUpdateRequest postRequest = new PostEmojiUpdateRequest()
                    .updateEmojisRequest(updateEmojisRequest)
                    .messageGroupId(UUID.randomUUID().toString())
                    .messageDeduplicationId(UUID.randomUUID().toString());

            discordBotApi.postEmojiUpdate(postRequest);
        };
    }

    private static void loginAndBlockThread(DiscordClient client)
    {
        logger.info("Logging in.");
        client.login().block();
    }
}
