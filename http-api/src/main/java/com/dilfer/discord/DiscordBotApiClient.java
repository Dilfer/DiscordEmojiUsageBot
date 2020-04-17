/**
 * null
 */
package com.dilfer.discord;

import java.net.*;
import java.util.*;

import javax.annotation.Generated;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.opensdk.protect.model.transform.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;

import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;

import com.amazonaws.client.ClientHandler;
import com.amazonaws.client.ClientHandlerParams;
import com.amazonaws.client.ClientExecutionParams;
import com.amazonaws.opensdk.protect.client.SdkClientHandler;
import com.amazonaws.SdkBaseException;

import com.dilfer.discord.model.*;
import com.dilfer.discord.model.transform.*;

/**
 * Client for accessing DiscordBotApi. All service calls made using this client are blocking, and will not return until
 * the service call completes.
 * <p>
 * 
 */
@ThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class DiscordBotApiClient implements DiscordBotApi {

    private final ClientHandler clientHandler;

    private static final com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl protocolFactory = new com.amazonaws.opensdk.protect.protocol.ApiGatewayProtocolFactoryImpl(
            new JsonClientMetadata().withProtocolVersion("1.1").withSupportsCbor(false).withSupportsIon(false).withContentTypeOverride("application/json")
                    .withBaseServiceExceptionClass(com.dilfer.discord.model.DiscordBotApiException.class));

    /**
     * Constructs a new client to invoke service methods on DiscordBotApi using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not return until the service call
     * completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    DiscordBotApiClient(AwsSyncClientParams clientParams) {
        this.clientHandler = new SdkClientHandler(new ClientHandlerParams().withClientParams(clientParams));
    }

    /**
     * @param getEmojiReportRequest
     * @return Result of the GetEmojiReport operation returned by the service.
     * @sample DiscordBotApi.GetEmojiReport
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/GetEmojiReport"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetEmojiReportResult getEmojiReport(GetEmojiReportRequest getEmojiReportRequest) {
        HttpResponseHandler<GetEmojiReportResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new GetEmojiReportResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetEmojiReportRequest, GetEmojiReportResult>()
                .withMarshaller(new GetEmojiReportRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getEmojiReportRequest));
    }

    /**
     * @param getServermanagerListgamesRequest
     * @return Result of the GetServermanagerListgames operation returned by the service.
     * @sample DiscordBotApi.GetServermanagerListgames
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/GetServermanagerListgames"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public GetServermanagerListgamesResult getServermanagerListgames(GetServermanagerListgamesRequest getServermanagerListgamesRequest) {
        HttpResponseHandler<GetServermanagerListgamesResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata()
                .withPayloadJson(true).withHasStreamingSuccessResponse(false), new GetServermanagerListgamesResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<GetServermanagerListgamesRequest, GetServermanagerListgamesResult>()
                .withMarshaller(new GetServermanagerListgamesRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(getServermanagerListgamesRequest));
    }

    /**
     * @param postEmojiUpdateRequest
     * @return Result of the PostEmojiUpdate operation returned by the service.
     * @sample DiscordBotApi.PostEmojiUpdate
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostEmojiUpdate"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostEmojiUpdateResult postEmojiUpdate(PostEmojiUpdateRequest postEmojiUpdateRequest) {
        HttpResponseHandler<PostEmojiUpdateResult> responseHandler = protocolFactory.createResponseHandler(new JsonOperationMetadata().withPayloadJson(true)
                .withHasStreamingSuccessResponse(false), new PostEmojiUpdateResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostEmojiUpdateRequest, PostEmojiUpdateResult>()
                .withMarshaller(new PostEmojiUpdateRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postEmojiUpdateRequest));
    }

    /**
     * @param postServermanagerInfoRequest
     * @return Result of the PostServermanagerInfo operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerInfo
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerInfo"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerInfoResult postServermanagerInfo(PostServermanagerInfoRequest postServermanagerInfoRequest) {
        HttpResponseHandler<PostServermanagerInfoResult> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerInfoResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerInfoRequest, PostServermanagerInfoResult>()
                .withMarshaller(new PostServermanagerInfoRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerInfoRequest));
    }

    /**
     * @param postServermanagerStartRequest
     * @return Result of the PostServermanagerStart operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerStart
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerStart"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerStartResult postServermanagerStart(PostServermanagerStartRequest postServermanagerStartRequest) {
        HttpResponseHandler<PostServermanagerStartResult> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerStartResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerStartRequest, PostServermanagerStartResult>()
                .withMarshaller(new PostServermanagerStartRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerStartRequest));
    }

    /**
     * @param postServermanagerStopRequest
     * @return Result of the PostServermanagerStop operation returned by the service.
     * @sample DiscordBotApi.PostServermanagerStop
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerStop"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public PostServermanagerStopResult postServermanagerStop(PostServermanagerStopRequest postServermanagerStopRequest) {
        HttpResponseHandler<PostServermanagerStopResult> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true).withHasStreamingSuccessResponse(false), new PostServermanagerStopResultJsonUnmarshaller());

        HttpResponseHandler<SdkBaseException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<PostServermanagerStopRequest, PostServermanagerStopResult>()
                .withMarshaller(new PostServermanagerStopRequestProtocolMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                .withErrorResponseHandler(errorResponseHandler).withInput(postServermanagerStopRequest));
    }

    /**
     * Create the error response handler for the operation.
     * 
     * @param errorShapeMetadata
     *        Error metadata for the given operation
     * @return Configured error response handler to pass to HTTP layer
     */
    private HttpResponseHandler<SdkBaseException> createErrorResponseHandler(JsonErrorShapeMetadata... errorShapeMetadata) {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata().withErrorShapes(Arrays.asList(errorShapeMetadata)));
    }

    @Override
    public void shutdown() {
        clientHandler.shutdown();
    }

}
