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
 * PostServermanagerStopResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStopResultJsonUnmarshaller implements Unmarshaller<PostServermanagerStopResult, JsonUnmarshallerContext> {

    public PostServermanagerStopResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerStopResult postServermanagerStopResult = new PostServermanagerStopResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerStopResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerStopResult.setStopServerResponse(StopServerResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerStopResult;
    }

    private static PostServermanagerStopResultJsonUnmarshaller instance;

    public static PostServermanagerStopResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerStopResultJsonUnmarshaller();
        return instance;
    }
}
