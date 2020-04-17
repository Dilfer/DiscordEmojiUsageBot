/**
 * null
 */
package com.dilfer.discord.model.transform;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.dilfer.discord.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * EmojiStatsMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class EmojiStatsMarshaller {

    private static final MarshallingInfo<String> EMOJITEXTKEY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("emojiTextKey").build();
    private static final MarshallingInfo<Integer> USAGECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("usageCount").build();

    private static final EmojiStatsMarshaller instance = new EmojiStatsMarshaller();

    public static EmojiStatsMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(EmojiStats emojiStats, ProtocolMarshaller protocolMarshaller) {

        if (emojiStats == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(emojiStats.getEmojiTextKey(), EMOJITEXTKEY_BINDING);
            protocolMarshaller.marshall(emojiStats.getUsageCount(), USAGECOUNT_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
