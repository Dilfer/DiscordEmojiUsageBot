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
 * StopServerResponseMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class StopServerResponseMarshaller {

    private static final MarshallingInfo<String> NEWSTATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
            .marshallLocationName("newState").build();
    private static final MarshallingInfo<String> ORIGINALSTATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
            .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("originalState").build();

    private static final StopServerResponseMarshaller instance = new StopServerResponseMarshaller();

    public static StopServerResponseMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(StopServerResponse stopServerResponse, ProtocolMarshaller protocolMarshaller) {

        if (stopServerResponse == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(stopServerResponse.getNewState(), NEWSTATE_BINDING);
            protocolMarshaller.marshall(stopServerResponse.getOriginalState(), ORIGINALSTATE_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
