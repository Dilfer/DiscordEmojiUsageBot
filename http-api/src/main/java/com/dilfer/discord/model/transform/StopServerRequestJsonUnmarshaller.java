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
 * StopServerRequest JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class StopServerRequestJsonUnmarshaller implements Unmarshaller<StopServerRequest, JsonUnmarshallerContext> {

    public StopServerRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        StopServerRequest stopServerRequest = new StopServerRequest();

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
                    stopServerRequest.setGame(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("guild", targetDepth)) {
                    context.nextToken();
                    stopServerRequest.setGuild(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return stopServerRequest;
    }

    private static StopServerRequestJsonUnmarshaller instance;

    public static StopServerRequestJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new StopServerRequestJsonUnmarshaller();
        return instance;
    }
}
