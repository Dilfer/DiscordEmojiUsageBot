package com.dilfer.discord.commands;

import java.util.*;
import java.util.stream.Collectors;

public enum EmojiCommands
{
    leaderBoard(new EmojiLeaderboardCommand("!emoji leaderboard", "Returns a leaderboard of users to num times used.  Use 'global' or an empty string for all emojis, or a specific emojis. ", Collections.singletonList("emojis"))),
    register(new EmojiRegistrationCommand("!emoji register", "Registers all guild emojis in the table with an initial count of 0. No harm running multiple times.", Collections.emptyList())),
    report(new EmojiReportCommand("!emoji report", "Returns a list of emoji usage for either a " +
            "specific user or global. Use 'me' for yourself, 'global' for server wide, a persons server nickname or discord user name. Not case sensitive.",
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
