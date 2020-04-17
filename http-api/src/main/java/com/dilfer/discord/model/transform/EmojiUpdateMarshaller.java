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
 * EmojiUpdateMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class EmojiUpdateMarshaller {

    private static final MarshallingInfo<String> DISCORDUSER_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("discordUser").build();
    private static final MarshallingInfo<String> EMOJITEXTKEY_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("emojiTextKey").build();
    private static final MarshallingInfo<Integer> USAGECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("usageCount").build();

    private static final EmojiUpdateMarshaller instance = new EmojiUpdateMarshaller();

    public static EmojiUpdateMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(EmojiUpdate emojiUpdate, ProtocolMarshaller protocolMarshaller) {

        if (emojiUpdate == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(emojiUpdate.getDiscordUser(), DISCORDUSER_BINDING);
            protocolMarshaller.marshall(emojiUpdate.getEmojiTextKey(), EMOJITEXTKEY_BINDING);
            protocolMarshaller.marshall(emojiUpdate.getUsageCount(), USAGECOUNT_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
