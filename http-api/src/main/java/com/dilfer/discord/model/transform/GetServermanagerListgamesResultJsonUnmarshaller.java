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
 * GetServermanagerListgamesResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetServermanagerListgamesResultJsonUnmarshaller implements Unmarshaller<GetServermanagerListgamesResult, JsonUnmarshallerContext> {

    public GetServermanagerListgamesResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetServermanagerListgamesResult getServermanagerListgamesResult = new GetServermanagerListgamesResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getServermanagerListgamesResult;
        }

        while (true) {
            if (token == null)
                break;

            getServermanagerListgamesResult.setListGamesResponse(ListGamesResponseJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getServermanagerListgamesResult;
    }

    private static GetServermanagerListgamesResultJsonUnmarshaller instance;

    public static GetServermanagerListgamesResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetServermanagerListgamesResultJsonUnmarshaller();
        return instance;
    }
}
