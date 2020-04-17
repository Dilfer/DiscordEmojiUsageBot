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
 * UpdateEmojisRequest JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateEmojisRequestJsonUnmarshaller implements Unmarshaller<UpdateEmojisRequest, JsonUnmarshallerContext> {

    public UpdateEmojisRequest unmarshall(JsonUnmarshallerContext context) throws Exception {
        UpdateEmojisRequest updateEmojisRequest = new UpdateEmojisRequest();

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
                if (context.testExpression("emojiUpdates", targetDepth)) {
                    context.nextToken();
                    updateEmojisRequest.setEmojiUpdates(new ListUnmarshaller<EmojiUpdate>(EmojiUpdateJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return updateEmojisRequest;
    }

    private static UpdateEmojisRequestJsonUnmarshaller instance;

    public static UpdateEmojisRequestJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new UpdateEmojisRequestJsonUnmarshaller();
        return instance;
    }
}
