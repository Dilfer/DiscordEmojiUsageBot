package com.dilfer.discord.commands;

import java.util.*;
import java.util.stream.Collectors;

public enum EmojiCommands
{
    register(new EmojiRegistrationCommand("!emoji register", "Registers all guild emojis in the table with an initial count of 0. No harm running multiple times.", Collections.emptyList())),
    report(new EmojiReportCommand("!emoji report", "Returns a list of emoji usage for either a " +
            "specific user or global. Use 'me' for yourself, 'global' for server wide. Nicknames do not work.",
            Collections.singletonList("user")));

    private final ServerCommand serverCommand;

    EmojiCommands(ServerCommand serverCommand)
    {
        this.serverCommand = serverCommand;
    }

    public ServerCommand getServerCommand()
    {
        return serverCommand;
    }

    public static List<ServerCommand> getEmojiCommands()
    {
        return Arrays.stream(EmojiCommands.values())
                .map(EmojiCommands::getServerCommand)
                .collect(Collectors.toList());
    }

}
