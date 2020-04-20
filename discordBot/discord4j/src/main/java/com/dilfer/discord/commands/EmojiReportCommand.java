package com.dilfer.discord.commands;

import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiStats;
import com.dilfer.discord.model.Empty;
import com.dilfer.discord.model.GetEmojiReportUsernameRequest;
import com.dilfer.discord.model.GetEmojiReportUsernameResult;
import com.google.common.collect.Lists;
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
        String submittedUser = arguments.iterator().next();

        String userToUseForReportRequest = determineProperUser(submittedUser, message, guild);

        GetEmojiReportUsernameRequest emojiReportUsernameRequest = new GetEmojiReportUsernameRequest()
                .username(userToUseForReportRequest);
        GetEmojiReportUsernameResult emojiReport = discordBotApi.getEmojiReportUsername(emojiReportUsernameRequest);

        Map<String, GuildEmoji> guildEmojis = Objects.requireNonNull(guild.getEmojis().collectList().block())
                .stream()
                .filter(emoji -> !emoji.isAnimated())
                .collect(Collectors.toMap(guildEmoji -> ":" + guildEmoji.getName() + ":", guildEmoji -> guildEmoji));

        Map<Integer, List<String>> emojiListByCount = emojiReport.getEmojiReportResponse().getEmojiStats().stream()
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
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!reportLines.isEmpty())
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Emoji Report for ")
                    .append(userToUseForReportRequest)
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
                        stringBuilder.append("\n")
                        .append("\n");
                    }
                }
                else
                {
                    stringBuilder.append("\n");
                    messageChannel.createMessage(stringBuilder.toString()).subscribe();
                }
            }
        }
        return Mono.empty();
    }

    private String determineProperUser(final String submittedUser, Message originalMessage, Guild guild)
    {
        Set<Member> memberSet = new HashSet<>(Objects.requireNonNull(guild.getMembers().collectList().block()));
        Map<String, String> memberNamesByNickname = memberSet
                .stream()
                .filter(member -> member.getNickname().isPresent())
                .collect(Collectors.toMap(member -> member.getNickname().get().toLowerCase(), Member::getUsername));

        //works for mentions
        if (submittedUser.startsWith("<@"))
        {
            String remappedUser = submittedUser.replace("<", "")
                    .replace(">", "")
                    .replace("@", "")
                    .replace("!", "");
            return guild.getMemberById(Snowflake.of(remappedUser)).block().getUsername().toLowerCase();
        }
        //shortcut for me
        else if("me".equalsIgnoreCase(submittedUser))
        {
            return originalMessage.getAuthor().orElseThrow(() -> new RuntimeException("Could not get message author.")).getUsername().toLowerCase();
        }
        else if ("global".equalsIgnoreCase(submittedUser))
        {
            return "global";
        }
        //works for nicknames
        else if (memberNamesByNickname.containsKey(submittedUser.toLowerCase()))
        {
            return memberNamesByNickname.get(submittedUser.toLowerCase()).toLowerCase();
        }
        else
        {
            return memberSet.stream().map(Member::getUsername)
                    .filter(username -> username.equalsIgnoreCase(submittedUser))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("Could not find a member to query by based on the the input " + submittedUser))
                    .toLowerCase();
        }
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

    private List<String> convertEntrySetToHumanReadableLine(Map.Entry<Integer, List<String>> entrySet)
    {
        List<String> returnStrings = new ArrayList<>();

        List<List<String>> listsPartitioned = Lists.partition(entrySet.getValue(), 15);

        for (List<String> partitionedEmojiList : listsPartitioned)
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("\t")
                    .append("\t");
            stringBuilder.append(entrySet.getKey().toString())
                    .append(" times :");
            partitionedEmojiList.forEach(stringBuilder::append);
            stringBuilder.append("\n");
            returnStrings.add(stringBuilder.toString());
        }
        return returnStrings;
    }
}
