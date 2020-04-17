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
 * PostServermanagerInfoRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class PostServermanagerInfoRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> SERVERINFOREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final PostServermanagerInfoRequestMarshaller instance = new PostServermanagerInfoRequestMarshaller();

    public static PostServermanagerInfoRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(PostServermanagerInfoRequest postServermanagerInfoRequest, ProtocolMarshaller protocolMarshaller) {

        if (postServermanagerInfoRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(postServermanagerInfoRequest.getServerInfoRequest(), SERVERINFOREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
