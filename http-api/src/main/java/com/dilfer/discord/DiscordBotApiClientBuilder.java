/**
 * null
 */
package com.dilfer.discord;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;
import com.amazonaws.opensdk.protect.client.SdkSyncClientBuilder;
import com.amazonaws.opensdk.internal.config.ApiGatewayClientConfigurationFactory;
import com.amazonaws.util.RuntimeHttpUtils;
import com.amazonaws.Protocol;

import java.net.URI;
import javax.annotation.Generated;

/**
 * Fluent builder for {@link com.dilfer.discord.DiscordBotApi}.
 * 
 * @see com.dilfer.discord.DiscordBotApi#builder
 **/
@NotThreadSafe
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public final class DiscordBotApiClientBuilder extends SdkSyncClientBuilder<DiscordBotApiClientBuilder, DiscordBotApi> {

    private static final URI DEFAULT_ENDPOINT = RuntimeHttpUtils.toUri("ra6ngodkx3.execute-api.ca-central-1.amazonaws.com", Protocol.HTTPS);
    private static final String DEFAULT_REGION = "ca-central-1";

    /**
     * Package private constructor - builder should be created via {@link DiscordBotApi#builder()}
     */
    DiscordBotApiClientBuilder() {
        super(new ApiGatewayClientConfigurationFactory());
    }

    /**
     * Specify the API Key to send with requests.
     *
     * @param apiKey
     *        API Key that identifies caller.
     * @return This object for method chaining.
     */
    @Override
    public void setApiKey(String apiKey) {
        super.setApiKey(apiKey);
    }

    /**
     * Specify the API Key to send with requests.
     *
     * @param apiKey
     *        API Key that identifies caller.
     * @return This object for method chaining.
     */
    public DiscordBotApiClientBuilder apiKey(String apiKey) {
        setApiKey(apiKey);
        return this;
    }

    /**
     * Construct a synchronous implementation of DiscordBotApi using the current builder configuration.
     *
     * @param params
     *        Current builder configuration represented as a parameter object.
     * @return Fully configured implementation of DiscordBotApi.
     */
    @Override
    protected DiscordBotApi build(AwsSyncClientParams params) {
        return new DiscordBotApiClient(params);
    }

    @Override
    protected URI defaultEndpoint() {
        return DEFAULT_ENDPOINT;
    }

    @Override
    protected String defaultRegion() {
        return DEFAULT_REGION;
    }

}
