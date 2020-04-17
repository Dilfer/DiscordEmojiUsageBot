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
 * ListGamesRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ListGamesRequestMarshaller {

    private static final MarshallingInfo<String> GUILD_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("guild").build();

    private static final ListGamesRequestMarshaller instance = new ListGamesRequestMarshaller();

    public static ListGamesRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ListGamesRequest listGamesRequest, ProtocolMarshaller protocolMarshaller) {

        if (listGamesRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(listGamesRequest.getGuild(), GUILD_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
