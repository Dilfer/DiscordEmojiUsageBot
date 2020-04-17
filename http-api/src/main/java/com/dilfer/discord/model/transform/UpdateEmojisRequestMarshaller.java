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
 * UpdateEmojisRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class UpdateEmojisRequestMarshaller {

    private static final MarshallingInfo<List> EMOJIUPDATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("emojiUpdates").build();

    private static final UpdateEmojisRequestMarshaller instance = new UpdateEmojisRequestMarshaller();

    public static UpdateEmojisRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(UpdateEmojisRequest updateEmojisRequest, ProtocolMarshaller protocolMarshaller) {

        if (updateEmojisRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(updateEmojisRequest.getEmojiUpdates(), EMOJIUPDATES_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
