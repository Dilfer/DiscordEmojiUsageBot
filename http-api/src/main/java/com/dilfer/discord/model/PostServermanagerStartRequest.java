/**
 * null
 */
package com.dilfer.discord.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostServermanagerStart"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostServermanagerStartRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private StartServerRequest startServerRequest;

    /**
     * @param startServerRequest
     */

    public void setStartServerRequest(StartServerRequest startServerRequest) {
        this.startServerRequest = startServerRequest;
    }

    /**
     * @return
     */

    public StartServerRequest getStartServerRequest() {
        return this.startServerRequest;
    }

    /**
     * @param startServerRequest
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostServermanagerStartRequest startServerRequest(StartServerRequest startServerRequest) {
        setStartServerRequest(startServerRequest);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getStartServerRequest() != null)
            sb.append("StartServerRequest: ").append(getStartServerRequest());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostServermanagerStartRequest == false)
            return false;
        PostServermanagerStartRequest other = (PostServermanagerStartRequest) obj;
        if (other.getStartServerRequest() == null ^ this.getStartServerRequest() == null)
            return false;
        if (other.getStartServerRequest() != null && other.getStartServerRequest().equals(this.getStartServerRequest()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getStartServerRequest() == null) ? 0 : getStartServerRequest().hashCode());
        return hashCode;
    }

    @Override
    public PostServermanagerStartRequest clone() {
        return (PostServermanagerStartRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostServermanagerStartRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
