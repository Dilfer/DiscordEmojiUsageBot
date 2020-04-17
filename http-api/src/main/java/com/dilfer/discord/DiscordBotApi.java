/**
 * null
 */
package com.dilfer.discord;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import com.dilfer.discord.model.*;

/**
 * Interface for accessing DiscordBotApi.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface DiscordBotApi {

    /**
     * @param getEmojiReportRequest
     * @return Result of the GetEmojiReport operation returned by the service.
     * @sample DiscordBotApi.GetEmojiReport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/GetEmojiReport"
     *      target="_top">AWS API Documentation</a>
     */
    GetEmojiReportResult getEmojiReport(GetEmojiReportRequest getEmojiReportRequest);

    /**
     * @param getServermanagerListgamesRequest
     * @return Result of the GetServermanagerListgames operation returned by the service.
     * @sample DiscordBotApi.GetServermanagerListgames
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/GetServermanagerListgames"
     *      target="_top">AWS API Documentation</a>
     */
    GetServermanagerListgamesResult getServermanagerListgames(GetServermanagerListgamesRequest getServermanagerListgamesRequest);

    /**
     * @param postEmojiUpdateRequest
     * @return Result of the PostEmojiUpdate operation returned by the service.
     * @sample DiscordBotApi.PostEmojiUpdate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostEmojiUpdate"
     *      target="_top">AWS API Documentation</a>
     */
    PostEmojiUpdateResult postEmojiUpdate(PostEmojiUpdateRequest postEmojiUpdateRequest);

    /**
     * @param postServermanagerInfoRequest
     * @return Result of the PostServermanagerInfo operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerInfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerInfo"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerInfoResult postServermanagerInfo(PostServermanagerInfoRequest postServermanagerInfoRequest);

    /**
     * @param postServermanagerStartRequest
     * @return Result of the PostServermanagerStart operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerStart
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerStart"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerStartResult postServermanagerStart(PostServermanagerStartRequest postServermanagerStartRequest);

    /**
     * @param postServermanagerStopRequest
     * @return Result of the PostServermanagerStop operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerStop
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerStop"
     *      target="_top">AWS API Documentation</a>
     */
    PostServermanagerStopResult postServermanagerStop(PostServermanagerStopRequest postServermanagerStopRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static DiscordBotApiClientBuilder builder() {
        return new DiscordBotApiClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
