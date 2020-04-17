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
 * PostEmojiUpdateRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostEmojiUpdateRequestMarshaller {

    private static final MarshallingInfo<String> MESSAGEDEDUPLICATIONID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.QUERY_PARAM).marshallLocationName("MessageDeduplicationId").build();
    private static final MarshallingInfo<String> MESSAGEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.QUERY_PARAM).marshallLocationName("MessageGroupId").build();
    private static final MarshallingInfo<StructuredPojo> UPDATEEMOJISREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostEmojiUpdateRequestMarshaller instance = new PostEmojiUpdateRequestMarshaller();

    public static PostEmojiUpdateRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostEmojiUpdateRequest postEmojiUpdateRequest, ProtocolMarshaller protocolMarshaller) {

        if (postEmojiUpdateRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postEmojiUpdateRequest.getMessageDeduplicationId(), MESSAGEDEDUPLICATIONID_BINDING);
            protocolMarshaller.marshall(postEmojiUpdateRequest.getMessageGroupId(), MESSAGEGROUPID_BINDING);
            protocolMarshaller.marshall(postEmojiUpdateRequest.getUpdateEmojisRequest(), UPDATEEMOJISREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
