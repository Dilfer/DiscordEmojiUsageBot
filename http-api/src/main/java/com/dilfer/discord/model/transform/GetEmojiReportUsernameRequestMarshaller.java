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
 * GetEmojiReportUsernameRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetEmojiReportUsernameRequestMarshaller {

    private static final MarshallingInfo<String> USERNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PATH)
            .marshallLocationName("username").build();

    private static final GetEmojiReportUsernameRequestMarshaller instance = new GetEmojiReportUsernameRequestMarshaller();

    public static GetEmojiReportUsernameRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetEmojiReportUsernameRequest getEmojiReportUsernameRequest, ProtocolMarshaller protocolMarshaller) {

        if (getEmojiReportUsernameRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getEmojiReportUsernameRequest.getUsername(), USERNAME_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
