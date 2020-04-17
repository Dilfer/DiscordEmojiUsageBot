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
 * PostServermanagerStartResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStartResultJsonUnmarshaller implements Unmarshaller<PostServermanagerStartResult, JsonUnmarshallerContext> {

    public PostServermanagerStartResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerStartResult postServermanagerStartResult = new PostServermanagerStartResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerStartResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerStartResult.setStartServerResponse(StartServerResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerStartResult;
    }

    private static PostServermanagerStartResultJsonUnmarshaller instance;

    public static PostServermanagerStartResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerStartResultJsonUnmarshaller();
        return instance;
    }
}
