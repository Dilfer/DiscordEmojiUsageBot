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
 * ServerInfoRequest JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ServerInfoRequestJsonUnmarshaller implements Unmarshaller<ServerInfoRequest, JsonUnmarshallerContext> {

    public ServerInfoRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        ServerInfoRequest serverInfoRequest = new ServerInfoRequest();

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
                if (context.testExpression("game", targetDepth)) {
                    context.nextToken();
                    serverInfoRequest.setGame(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("guild", targetDepth)) {
                    context.nextToken();
                    serverInfoRequest.setGuild(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return serverInfoRequest;
    }

    private static ServerInfoRequestJsonUnmarshaller instance;

    public static ServerInfoRequestJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new ServerInfoRequestJsonUnmarshaller();
        return instance;
    }
}
