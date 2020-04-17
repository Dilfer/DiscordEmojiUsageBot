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
 * GetServermanagerListgamesRequestMarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
@SdkInternalApi
public class GetServermanagerListgamesRequestMarshaller {

    private static final MarshallingInfo<StructuredPojo> LISTGAMESREQUEST_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
            .marshallLocation(MarshallLocation.PAYLOAD).isExplicitPayloadMember(true).build();

    private static final GetServermanagerListgamesRequestMarshaller instance = new GetServermanagerListgamesRequestMarshaller();

    public static GetServermanagerListgamesRequestMarshaller getInstance() {
        return instance;
    }

    /**
     * Marshall the given parameter object.
     */
    public void marshall(GetServermanagerListgamesRequest getServermanagerListgamesRequest, ProtocolMarshaller protocolMarshaller) {

        if (getServermanagerListgamesRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        try {
            protocolMarshaller.marshall(getServermanagerListgamesRequest.getListGamesRequest(), LISTGAMESREQUEST_BINDING);
        } catch (Exception e) {
            throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
        }
    }

}
