/**
 * null
 */
package com.dilfer.discord.model.transform;

import java.math.*;

import javax.annotation.Generated;

import com.dilfer.discord.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * ServerInfoResponse JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ServerInfoResponseJsonUnmarshaller implements Unmarshaller<ServerInfoResponse, JsonUnmarshallerContext> {

    public ServerInfoResponse unmarshall(JsonUnmarshallerContext context) throws Exception {
        ServerInfoResponse serverInfoResponse = new ServerInfoResponse();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return null;
        }

        while (true) {
            if (token == null)
                break;

            if (token == FIELD_NAME || token == START_OBJECT) {
                if (context.testExpression("instanceState", targetDepth)) {
                    context.nextToken();
                    serverInfoResponse.setInstanceState(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("ipAddress", targetDepth)) {
                    context.nextToken();
                    serverInfoResponse.setIpAddress(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("name", targetDepth)) {
                    context.nextToken();
                    serverInfoResponse.setName(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return serverInfoResponse;
    }

    private static ServerInfoResponseJsonUnmarshaller instance;

    public static ServerInfoResponseJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ServerInfoResponseJsonUnmarshaller();
        return instance;
    }
}
