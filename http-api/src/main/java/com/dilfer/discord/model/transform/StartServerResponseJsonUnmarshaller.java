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
 * StartServerResponse JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class StartServerResponseJsonUnmarshaller implements Unmarshaller<StartServerResponse, JsonUnmarshallerContext> {

    public StartServerResponse unmarshall(JsonUnmarshallerContext context) throws Exception {
        StartServerResponse startServerResponse = new StartServerResponse();

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
                if (context.testExpression("newState", targetDepth)) {
                    context.nextToken();
                    startServerResponse.setNewState(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("originalState", targetDepth)) {
                    context.nextToken();
                    startServerResponse.setOriginalState(context.getUnmarshaller(String.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return startServerResponse;
    }

    private static StartServerResponseJsonUnmarshaller instance;

    public static StartServerResponseJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new StartServerResponseJsonUnmarshaller();
        return instance;
    }
}
