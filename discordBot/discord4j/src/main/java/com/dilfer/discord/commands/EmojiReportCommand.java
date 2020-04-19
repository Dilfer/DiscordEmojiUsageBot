package com.dilfer.discord.commands;

import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiStats;
import com.dilfer.discord.model.GetEmojiReportRequest;
import com.dilfer.discord.model.GetEmojiReportResult;
import discord4j.core.object.entity.*;
import discord4j.core.object.util.Snowflake;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

class EmojiReportCommand implements ServerCommand
{
    private final String commandString;
    private final String infoMessage;
    private final List<String> expectedArguments;

    public EmojiReportCommand(String commandString,
                              String infoMessage,
                              List<String> expectedArguments)
    {
        this.commandString = commandString;
        this.infoMessage = infoMessage;
        this.expectedArguments = expectedArguments;
    }

    @Override
    public Mono<Void> run(MessageChannel messageChannel, DiscordBotApi discordBotApi, Guild guild, Message message)
    {
        String messageContents = message.getContent().orElse("");
        List<String> arguments = ArgumentValidator.getArguments(this, messageContents);
        String user = arguments.iterator().next();

        List<EmojiStats> emojiStats;

        if ("global".equalsIgnoreCase(user))
        {
            GetEmojiReportRequest getEmojiRequest = new GetEmojiReportRequest();
            GetEmojiReportResult emojiReport = discordBotApi.getEmojiReport(getEmojiRequest);
            emojiStats = emojiReport.getEmojiReportResponse().getEmojiStats();
        }
        else
        {
            String memberForReport;
            if (user.startsWith("<@"))
            {
                user = user.replace("<", "")
                     .replace(">", "")
                     .replace("@", "")
                     .replace("!", "");
                memberForReport = guild.getMemberById(Snowflake.of(user)).block().getUsername();
            }
            else if("me".equalsIgnoreCase(user))
            {
                memberForReport = message.getAuthor().orElseThrow(() -> new RuntimeException("Could not get message author.")).getUsername();
            }

            emojiStats = Collections.emptyList();
        }

        Map<String, GuildEmoji> guildEmojis = Objects.requireNonNull(guild.getEmojis().collectList().block())
                .stream()
                .filter(emoji -> !emoji.isAnimated())
                .collect(Collectors.toMap(guildEmoji -> ":" + guildEmoji.getName() + ":", guildEmoji -> guildEmoji));

        Map<Integer, List<String>> emojiListByCount = emojiStats.stream()
                .filter(emojiStat -> guildEmojis.containsKey(emojiStat.getEmojiTextKey()))
                .sorted(Comparator.comparing(EmojiStats::getUsageCount, Comparator.reverseOrder()))
                .filter(stat -> guildEmojis.containsKey(stat.getEmojiTextKey()))
                .collect(Collectors.groupingBy(EmojiStats::getUsageCount,
                        Collectors.mapping(emojiStat -> convertToDiscordFriendlyStringWithSnowflake(guildEmojis.get(emojiStat.getEmojiTextKey()), emojiStat),
                                Collectors.toList())));

        List<String> reportLines = emojiListByCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(this::convertEntrySetToHumanReadableLine)
                .collect(Collectors.toList());

        if (!reportLines.isEmpty())
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Global Emoji Report!")
                    .append("\n")
                    .append("\n");

            for (int i = 0; i < reportLines.size(); i++)
            {
                String reportLine = reportLines.get(i);
                stringBuilder.append(reportLine);

                if (i + 1 < reportLines.size())
                {
                    if (stringBuilder.length() + reportLines.get(i + 1).length() > 2000)
                    {
                        messageChannel.createMessage(stringBuilder.toString()).subscribe();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Report continued:");
                        stringBuilder.append("\n");
                    }
                }
                else
                {
                    messageChannel.createMessage(stringBuilder.toString()).subscribe();
                }
            }
        }
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
        return infoMessage;
    }

    @Override
    public List<String> getArguments()
    {
        return expectedArguments;
    }

    private String convertToDiscordFriendlyStringWithSnowflake(GuildEmoji guildEmoji, EmojiStats emojiStat)
    {
        return String.format("<%s%d>", emojiStat.getEmojiTextKey(), guildEmoji.getId().asLong());
    }

    private String convertEntrySetToHumanReadableLine(Map.Entry<Integer, List<String>> entrySet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\t")
                .append("\t");
        stringBuilder.append(entrySet.getKey().toString())
                .append(" times :");
        entrySet.getValue().forEach(stringBuilder::append);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
