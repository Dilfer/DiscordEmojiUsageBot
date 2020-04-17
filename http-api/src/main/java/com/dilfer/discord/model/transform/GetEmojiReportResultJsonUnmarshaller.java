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
 * GetEmojiReportResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetEmojiReportResultJsonUnmarshaller implements Unmarshaller<GetEmojiReportResult, JsonUnmarshallerContext> {

    public GetEmojiReportResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetEmojiReportResult getEmojiReportResult = new GetEmojiReportResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getEmojiReportResult;
        }

        while (true) {
            if (token == null)
                break;

            getEmojiReportResult.setEmojiReportResponse(EmojiReportResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getEmojiReportResult;
    }

    private static GetEmojiReportResultJsonUnmarshaller instance;

    public static GetEmojiReportResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetEmojiReportResultJsonUnmarshaller();
        return instance;
    }
}
