package com.dilfer.discord.commands;

import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiStats;
import com.dilfer.discord.model.GetEmojiReportRequest;
import com.dilfer.discord.model.GetEmojiReportResult;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.GuildEmoji;

import java.util.*;
import java.util.stream.Collectors;

public enum EmojiCommands
{
    report(new EmojiReportCommand("!emoji report", "Returns a list of global emoji usage.", Collections.emptyList()));

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

    private static class EmojiReportCommand extends AbstractServerManagerCommand
    {
        public EmojiReportCommand(String commandString,
                                  String infoMessage,
                                  List<String> expectedArguments)
        {
            super(commandString, infoMessage, expectedArguments);
        }

        @Override
        String callApiAndGetUserFriendlyMessage(List<String> suppliedArguments, Guild guild, DiscordBotApi discordBotApi)
        {
            GetEmojiReportRequest getEmojiRequest = new GetEmojiReportRequest ();
            GetEmojiReportResult emojiReport = discordBotApi.getEmojiReport(getEmojiRequest);
            List<EmojiStats> emojiStats = emojiReport.getEmojiReportResponse().getEmojiStats();

            Map<String, GuildEmoji> guildEmojis = Objects.requireNonNull(guild.getEmojis().collectList().block())
                    .stream().collect(Collectors.toMap(guildEmoji -> ":" + guildEmoji.getName() + ":", guildEmoji -> guildEmoji));

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Emoji Report!")
                    .append("\n")
                    .append("\n");

            emojiStats.stream()
                    .sorted(Comparator.comparing(EmojiStats::getUsageCount, Comparator.reverseOrder()))
                    .filter(stat -> guildEmojis.containsKey(stat.getEmojiTextKey()))
                    .forEachOrdered(stat ->
                    {
                        GuildEmoji guildEmoji = guildEmojis.get(stat.getEmojiTextKey());
                        String emojiOutputText = String.format("<%s%d>", stat.getEmojiTextKey(), guildEmoji.getId().asLong());

                        stringBuilder.append("\t")
                                .append(String.format("%s : %d", emojiOutputText, stat.getUsageCount()))
                                .append("\n");
                    });

            return stringBuilder.toString();
        }
    }
}
