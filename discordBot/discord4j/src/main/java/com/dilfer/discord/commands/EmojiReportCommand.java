package com.dilfer.discord.commands;

import com.amazonaws.util.StringUtils;
import com.dilfer.discord.DiscordBotApi;
import com.dilfer.discord.model.EmojiStats;
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
        try
        {
            String messageContents = message.getContent().orElse("");
            String submittedUser = messageContents.replace(commandString, "").trim();

            Optional<User> optional = message.getAuthor();
            String userToUseForReportRequest = determineProperUser(submittedUser, guild, optional);

            if ("unknown".equalsIgnoreCase(userToUseForReportRequest))
            {
                messageChannel.createMessage(String.format("Smarten the fuck up %s and read the help command. %s was not a valid input.", optional.map(user -> user.getUsername().toLowerCase()).orElse("unknown"), submittedUser)).subscribe();
                return Mono.empty();
            }

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
                    .filter(emojiStat -> "global".equalsIgnoreCase(userToUseForReportRequest) || emojiStat.getUsageCount() > 0)
                    .collect(Collectors.groupingBy(EmojiStats::getUsageCount,
                            Collectors.mapping(emojiStat -> convertToDiscordFriendlyStringWithSnowflake(guildEmojis.get(emojiStat.getEmojiTextKey()), emojiStat),
                                    Collectors.toList())));

            int totalEmojisUsed = emojiListByCount.entrySet().stream()
                    .mapToInt(entry -> entry.getKey() * entry.getValue().size())
                    .sum();

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
                        .append("Total Number of Emojis Used: ")
                        .append(totalEmojisUsed)
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
        }
        catch (RuntimeException e)
        {
            messageChannel.createMessage(e.getMessage()).subscribe();
            return Mono.empty();
        }
        return Mono.empty();
    }

    private String determineProperUser(final String submittedUser, Guild guild, Optional<User> author)
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
            return author.map(user -> user.getUsername().toLowerCase()).orElse("unknown");
        }
        else if ("global".equalsIgnoreCase(submittedUser) || StringUtils.isNullOrEmpty(submittedUser))
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
                    .orElse("unknown")
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
                    .append(" times : ");
            partitionedEmojiList.forEach(stringBuilder::append);
            stringBuilder.append("\n");
            returnStrings.add(stringBuilder.toString());
        }
        return returnStrings;
    }
}
