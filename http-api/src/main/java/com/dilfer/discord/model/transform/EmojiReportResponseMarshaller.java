/**
 * null
 */
package com.dilfer.discord.model.transform;

import java.util.List;
import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.dilfer.discord.model.*;

import com.amazonaws.protocol.*;
import com.amazonaws.annotation.SdkInternalApi;

/**
 * EmojiReportResponseMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class EmojiReportResponseMarshaller {

    private static final MarshallingInfo<List> EMOJISTATS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("emojiStats").build();

    private static final EmojiReportResponseMarshaller instance = new EmojiReportResponseMarshaller();

    public static EmojiReportResponseMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(EmojiReportResponse emojiReportResponse, ProtocolMarshaller protocolMarshaller) {

        if (emojiReportResponse == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(emojiReportResponse.getEmojiStats(), EMOJISTATS_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
