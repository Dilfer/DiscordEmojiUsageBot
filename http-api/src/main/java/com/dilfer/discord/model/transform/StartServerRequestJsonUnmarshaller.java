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
 * StartServerRequest JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class StartServerRequestJsonUnmarshaller implements Unmarshaller<StartServerRequest, JsonUnmarshallerContext> {

    public StartServerRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        StartServerRequest startServerRequest = new StartServerRequest();

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
                    startServerRequest.setGame(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("guild", targetDepth)) {
                    context.nextToken();
                    startServerRequest.setGuild(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return startServerRequest;
    }

    private static StartServerRequestJsonUnmarshaller instance;

    public static StartServerRequestJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new StartServerRequestJsonUnmarshaller();
        return instance;
    }
}
