package com.dilfer.discord.commands;

import com.dilfer.discord.DiscordBotApi;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ServerCommand
{
    Mono<Message> run(MessageChannel messageChannel, DiscordBotApi discordBotApi, Guild guild, String message);

    String getCommandString();

    String getInfoMessage();

    List<String> getArguments();

    default String getHelpCommandExample()
    {
        final StringBuilder helpCommandExample = new StringBuilder();
        helpCommandExample.append(getCommandString());
        getArguments().forEach(argument -> helpCommandExample.append(" ").append("<").append(argument).append(">"));
        return helpCommandExample.toString();
    }
}
