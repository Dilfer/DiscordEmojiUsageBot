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
 * PostServermanagerInfoResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerInfoResultJsonUnmarshaller implements Unmarshaller<PostServermanagerInfoResult, JsonUnmarshallerContext> {

    public PostServermanagerInfoResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostServermanagerInfoResult postServermanagerInfoResult = new PostServermanagerInfoResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postServermanagerInfoResult;
        }

        while (true) {
            if (token == null)
                break;

            postServermanagerInfoResult.setServerInfoResponse(ServerInfoResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postServermanagerInfoResult;
    }

    private static PostServermanagerInfoResultJsonUnmarshaller instance;

    public static PostServermanagerInfoResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostServermanagerInfoResultJsonUnmarshaller();
        return instance;
    }
}
