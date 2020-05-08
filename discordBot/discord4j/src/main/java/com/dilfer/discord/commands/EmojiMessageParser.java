package com.dilfer.discord.commands;

import com.dilfer.discord.model.EmojiUpdate;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiMessageParser
{
    public static final Pattern customEmojiPattern = Pattern.compile("(<:[A-Za-z0-9]*:[0-9]*>)");

    public List<String> getEmojiStrings(Message message)
    {
        Matcher matcher = customEmojiPattern.matcher(message.getContent().orElse(""));

        List<String> matches = new ArrayList<>();
        while (matcher.find())
        {
            matches.add(matcher.group());
        }

        return matches;
    }

    public List<EmojiUpdate> getEmojiUpdates(Message message,
                                             User discordBotUser)
    {
        List<String> matches = getEmojiStrings(message);


        Map<String, Long> collect = matches.stream()
                .collect(Collectors.groupingBy(this::getEmojiTextFromWeirdDiscordString, Collectors.counting()));

        return collect.entrySet()
                .stream()
                .map(entry -> new EmojiUpdate()
                        .usageCount(entry.getValue().intValue())
                        .emojiTextKey(entry.getKey())
                        .discordUser(message.getAuthor().orElse(discordBotUser).getUsername()))
                .collect(Collectors.toList());
    }

    private String getEmojiTextFromWeirdDiscordString(String discordEmojiString)
    {
        return discordEmojiString.substring(discordEmojiString.indexOf(":"), discordEmojiString.lastIndexOf(":") + 1);
    }
}
