package com.dilfer.aws.lambda;

import java.util.Map;

public class EmojiUpdateAggregate
{
    private final String emojiKey;
    private final int usageCount;
    private final Map<String, Integer> userMap;

    public EmojiUpdateAggregate(String emojiKey, int usageCount, Map<String, Integer> userMap)
    {
        this.emojiKey = emojiKey;
        this.usageCount = usageCount;
        this.userMap = userMap;
    }

    public String getEmojiKey()
    {
        return emojiKey;
    }

    public int getUsageCount()
    {
        return usageCount;
    }

    public Map<String, Integer> getUserMap()
    {
        return userMap;
    }
}
