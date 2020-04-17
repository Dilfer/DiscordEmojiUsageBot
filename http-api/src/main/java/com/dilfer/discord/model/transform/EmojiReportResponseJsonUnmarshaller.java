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
 * EmojiReportResponse JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EmojiReportResponseJsonUnmarshaller implements Unmarshaller<EmojiReportResponse, JsonUnmarshallerContext> {

    public EmojiReportResponse unmarshall(JsonUnmarshallerContext context) throws Exception {
        EmojiReportResponse emojiReportResponse = new EmojiReportResponse();

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
                if (context.testExpression("emojiStats", targetDepth)) {
                    context.nextToken();
                    emojiReportResponse.setEmojiStats(new ListUnmarshaller<EmojiStats>(EmojiStatsJsonUnmarshaller.getInstance()).unmarshall(context));
                }
            } else if (token == END_ARRAY || token == END_OBJECT) {
                if (context.getLastParsedParentElement() == null || context.getLastParsedParentElement().equals(currentParentElement)) {
                    if (context.getCurrentDepth() <= originalDepth)
                        break;
                }
            }
            token = context.nextToken();
        }

        return emojiReportResponse;
    }

    private static EmojiReportResponseJsonUnmarshaller instance;

    public static EmojiReportResponseJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new EmojiReportResponseJsonUnmarshaller();
        return instance;
    }
}
