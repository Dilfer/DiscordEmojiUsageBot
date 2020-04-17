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
 * PostEmojiUpdateResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostEmojiUpdateResultJsonUnmarshaller implements Unmarshaller<PostEmojiUpdateResult, JsonUnmarshallerContext> {

    public PostEmojiUpdateResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostEmojiUpdateResult postEmojiUpdateResult = new PostEmojiUpdateResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postEmojiUpdateResult;
        }

        while (true) {
            if (token == null)
                break;

            postEmojiUpdateResult.setEmpty(EmptyJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postEmojiUpdateResult;
    }

    private static PostEmojiUpdateResultJsonUnmarshaller instance;

    public static PostEmojiUpdateResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostEmojiUpdateResultJsonUnmarshaller();
        return instance;
    }
}
