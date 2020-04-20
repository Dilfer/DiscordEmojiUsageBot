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
 * GetEmojiReportUsernameResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetEmojiReportUsernameResultJsonUnmarshaller implements Unmarshaller<GetEmojiReportUsernameResult, JsonUnmarshallerContext> {

    public GetEmojiReportUsernameResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetEmojiReportUsernameResult getEmojiReportUsernameResult = new GetEmojiReportUsernameResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getEmojiReportUsernameResult;
        }

        while (true) {
            if (token == null)
                break;

            getEmojiReportUsernameResult.setEmojiReportResponse(EmojiReportResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getEmojiReportUsernameResult;
    }

    private static GetEmojiReportUsernameResultJsonUnmarshaller instance;

    public static GetEmojiReportUsernameResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetEmojiReportUsernameResultJsonUnmarshaller();
        return instance;
    }
}
