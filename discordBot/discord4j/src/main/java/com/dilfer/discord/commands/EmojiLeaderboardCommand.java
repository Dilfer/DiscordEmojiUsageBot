package com.dilfer.discord.commands;

import com.amazonaws.util.StringUtils;
import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiStats;
import com.dilfer.discord.model.GetEmojiReportUsernameRequest;
import com.dilfer.discord.model.GetEmojiReportUsernameResult;
import discord4j.core.object.entity.*;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmojiLeaderboardCommand implements ServerCommand
{
    private final EmojiMessageParser emojiMessageParser = new EmojiMessageParser();
    private final String commandString;
    private final List<String> expectedArguments;
    private final String infoMessage;

    public EmojiLeaderboardCommand(String commandString,
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
        List<String> userNames = Objects.requireNonNull(guild.getMembers().collectList().block()).stream()
                .filter(member -> !member.isBot())
                .map(Member::getUsername)
                .collect(Collectors.toList());

        Map<String, GuildEmoji> guildEmojis = Objects.requireNonNull(guild.getEmojis().collectList().block())
                .stream()
                .filter(emoji -> !emoji.isAnimated())
                .collect(Collectors.toMap(guildEmoji -> ":" + guildEmoji.getName() + ":", guildEmoji -> guildEmoji));

        String messageContents = message.getContent().orElse("");
        String messageWithoutCommand = messageContents.replace(commandString, "").trim();

        List<UserEmojiCounts> leaderboard = userNames.stream()
                .map(user -> getUserCounts(discordBotApi, user, guildEmojis))
                .sorted(Comparator.comparing(UserEmojiCounts::getNumEmojisUsed, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        if (messageWithoutCommand.equalsIgnoreCase("global") || StringUtils.isNullOrEmpty(messageWithoutCommand))
        {
            String globalReport = getGlobalReport(leaderboard);
            messageChannel.createMessage(globalReport).subscribe();
        }
        else
        {
            List<String> emojiStrings = emojiMessageParser.getEmojiStrings(message);
            emojiStrings.forEach(emoji ->
                    {
                        String emojiReport = getEmojiSpecificReport(emoji, leaderboard);
                        messageChannel.createMessage(emojiReport).subscribe();
                    });
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

    private String getGlobalReport(List<UserEmojiCounts> userEmojiCounts)
    {
        StringBuilder stringBuilder = new StringBuilder()
                .append("Global Emoji Leaderboards")
                .append("\n")
                .append("\n");

        int totalTimesUsed = userEmojiCounts.stream()
                .mapToInt(UserEmojiCounts::getNumEmojisUsed)
                .sum();

        stringBuilder
                .append("Total Number of Emojis Used: ")
                .append(totalTimesUsed)
                .append("\n");

        for (int i = 0; i < userEmojiCounts.size(); i++)
        {
            UserEmojiCounts userEmojiCount = userEmojiCounts.get(i);
            stringBuilder.append(String.format("%d. %s : %d", i + 1, userEmojiCount.user, userEmojiCount.numEmojisUsed));

            if (userEmojiCount.numEmojisUsed == 0)
            {
                stringBuilder.append("  Get a load of this fucking n00b here.");
            }

            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private String getEmojiSpecificReport(String specificEmoji, List<UserEmojiCounts> userEmojiCounts)
    {
        StringBuilder stringBuilder = new StringBuilder()
                .append(specificEmoji)
                .append(" Emoji Leaderboards")
                .append("\n")
                .append("\n");

        List<UserEmojiCounts> peopleWhoHaveUsedEmoji = userEmojiCounts
                .stream()
                .filter(userEmojiCount -> userEmojiCount.userHasUsedSpecificEmoji(specificEmoji))
                .sorted(Comparator.comparing(emojiCount -> emojiCount.getNumTimesSpecificEmojiUsed(specificEmoji), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        int totalTimesUsed = peopleWhoHaveUsedEmoji.stream()
                .mapToInt(emojiCount -> emojiCount.getNumTimesSpecificEmojiUsed(specificEmoji))
                .sum();

        stringBuilder
                .append("Total Number of Times Used: ")
                .append(totalTimesUsed)
                .append("\n");

        for (int i = 0; i < peopleWhoHaveUsedEmoji.size(); i++)
        {
            UserEmojiCounts userEmojiCount = peopleWhoHaveUsedEmoji.get(i);
            stringBuilder.append(String.format("%d. %s : %d", i + 1, userEmojiCount.user, userEmojiCount.getNumTimesSpecificEmojiUsed(specificEmoji)));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private UserEmojiCounts getUserCounts(DiscordBotApi discordBotApi, String user, Map<String, GuildEmoji> guildEmojis)
    {
        GetEmojiReportUsernameRequest emojiReportUsernameRequest = new GetEmojiReportUsernameRequest()
                .username(user.toLowerCase());
        GetEmojiReportUsernameResult emojiReport = discordBotApi.getEmojiReportUsername(emojiReportUsernameRequest);

        Map<Integer, List<String>> emojiListByCount = emojiReport.getEmojiReportResponse().getEmojiStats().stream()
                .filter(emojiStat -> guildEmojis.containsKey(emojiStat.getEmojiTextKey()))
                .sorted(Comparator.comparing(EmojiStats::getUsageCount, Comparator.reverseOrder()))
                .filter(stat -> guildEmojis.containsKey(stat.getEmojiTextKey()))
                .filter(emojiStat -> "global".equalsIgnoreCase(user) || emojiStat.getUsageCount() > 0)
                .collect(Collectors.groupingBy(EmojiStats::getUsageCount,
                        Collectors.mapping(emojiStat -> convertToDiscordFriendlyStringWithSnowflake(guildEmojis.get(emojiStat.getEmojiTextKey()), emojiStat),
                                Collectors.toList())));

        return new UserEmojiCounts(user, emojiListByCount);
    }

    private String convertToDiscordFriendlyStringWithSnowflake(GuildEmoji guildEmoji, EmojiStats emojiStat)
    {
        return String.format("<%s%d>", emojiStat.getEmojiTextKey(), guildEmoji.getId().asLong());
    }

    private static class UserEmojiCounts
    {
        private final String user;
        private final Map<Integer, List<String>> emojiListByCount;
        private final int numEmojisUsed;

        private UserEmojiCounts(String user, Map<Integer, List<String>> emojiListByCount)
        {
            this.user = user;
            this.emojiListByCount = emojiListByCount;
            this.numEmojisUsed = emojiListByCount.entrySet().stream().mapToInt(entry -> entry.getKey() * entry.getValue().size()).sum();
        }

        public int getNumEmojisUsed()
        {
            return numEmojisUsed;
        }

        public boolean userHasUsedSpecificEmoji(String specificEmoji)
        {
            return emojiListByCount
                    .entrySet()
                    .stream()
                    .anyMatch(entry -> entry.getValue().contains(specificEmoji));
        }

        public int getNumTimesSpecificEmojiUsed(String emoji)
        {
            return emojiListByCount.entrySet().stream().filter(entry -> entry.getValue().contains(emoji))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(0);
        }
    }
}
