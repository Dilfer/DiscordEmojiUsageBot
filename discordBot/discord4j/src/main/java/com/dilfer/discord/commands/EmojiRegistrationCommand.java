package com.dilfer.discord.commands;

import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiUpdate;
import com.dilfer.discord.model.PostEmojiUpdateRequest;
import com.dilfer.discord.model.UpdateEmojisRequest;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.GuildEmoji;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class EmojiRegistrationCommand implements ServerCommand
{
    private final String commandString;
    private final String helpInfoString;
    private final List<String> arguments;

    public EmojiRegistrationCommand(String commandString, String helpInfoString, List<String> arguments)
    {
        this.commandString = commandString;
        this.helpInfoString = helpInfoString;
        this.arguments = arguments;
    }

    @Override
    public Mono<Void> run(MessageChannel messageChannel, DiscordBotApi discordBotApi, Guild guild, Message message)
    {
        List<GuildEmoji> guildEmojis = Objects.requireNonNull(guild.getEmojis().collectList().block())
                .stream()
                .filter(emoji -> !emoji.isAnimated())
                .collect(Collectors.toList());

        List<EmojiUpdate> emojiRegistrationUpdates = guildEmojis.stream()
                .map(guildEmoji -> new EmojiUpdate()
                        .emojiTextKey(String.format(":%s:", guildEmoji.getName()))
                        .usageCount(0)
                        .discordUser(message.getAuthor().orElseThrow(() -> new RuntimeException("Couldnt get message author")).getUsername()))
                .collect(Collectors.toList());

        discordBotApi.postEmojiUpdate(new PostEmojiUpdateRequest()
                .updateEmojisRequest(new UpdateEmojisRequest().emojiUpdates(emojiRegistrationUpdates))
                .messageDeduplicationId(UUID.randomUUID().toString())
                .messageGroupId(UUID.randomUUID().toString()));

        messageChannel.createMessage("Successfully registered all emojis with a count of 0. Should be reflected in 5 minutes.")
                .subscribe();
        return Mono.empty();
    }

    @Override
    public String getCommandString()
    {
        return commandString;
    }

    @Override
    public String getInfoMessage()
    {
        return helpInfoString;
    }

    @Override
    public List<String> getArguments()
    {
        return arguments;
    }
}
