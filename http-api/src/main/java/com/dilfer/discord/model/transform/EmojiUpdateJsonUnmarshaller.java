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
 * EmojiUpdate JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EmojiUpdateJsonUnmarshaller implements Unmarshaller<EmojiUpdate, JsonUnmarshallerContext> {

    public EmojiUpdate unmarshall(JsonUnmarshallerContext context) throws Exception {
        EmojiUpdate emojiUpdate = new EmojiUpdate();

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
                if (context.testExpression("discordUser", targetDepth)) {
                    context.nextToken();
                    emojiUpdate.setDiscordUser(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("emojiTextKey", targetDepth)) {
                    context.nextToken();
                    emojiUpdate.setEmojiTextKey(context.getUnmarshaller(String.class).unmarshall(context));
                }
                if (context.testExpression("usageCount", targetDepth)) {
                    context.nextToken();
                    emojiUpdate.setUsageCount(context.getUnmarshaller(Integer.class).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return emojiUpdate;
    }

    private static EmojiUpdateJsonUnmarshaller instance;

    public static EmojiUpdateJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new EmojiUpdateJsonUnmarshaller();
        return instance;
    }
}
