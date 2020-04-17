package com.dilfer.discord.commands;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;
import reactor.core.publisher.Mono;

import java.util.List;

public class HelpCommand
{
    public static final String CMD_MESSAGE = "!manager help";

    public Mono<Message> run(MessageChannel messageChannel)
    {
        List<ServerCommand> serverCommands = EmojiCommands.getEmojiCommands();

        StringBuilder outputStringBuilder = new StringBuilder().append("Here is the list of available commands! \n\n");

        serverCommands.forEach(command ->
                outputStringBuilder.append(command.getHelpCommandExample())
                                   .append("\n")
                                   .append("\t\t")
                                   .append(command.getInfoMessage())
                                   .append("\n\n"));
        return messageChannel.createMessage(outputStringBuilder.toString());
    }
}
