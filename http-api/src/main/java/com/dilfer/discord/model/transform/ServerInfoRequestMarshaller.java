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
 * ServerInfoRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class ServerInfoRequestMarshaller {

    private static final MarshallingInfo<String> GAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("game").build();
    private static final MarshallingInfo<String> GUILD_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("guild").build();

    private static final ServerInfoRequestMarshaller instance = new ServerInfoRequestMarshaller();

    public static ServerInfoRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(ServerInfoRequest serverInfoRequest, ProtocolMarshaller protocolMarshaller) {

        if (serverInfoRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(serverInfoRequest.getGame(), GAME_BINDING);
            protocolMarshaller.marshall(serverInfoRequest.getGuild(), GUILD_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
