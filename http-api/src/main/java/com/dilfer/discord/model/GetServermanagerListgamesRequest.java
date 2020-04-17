/**
 * null
 */
package com.dilfer.discord.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/GetServermanagerListgames"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetServermanagerListgamesRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private ListGamesRequest listGamesRequest;

    /**
     * @param listGamesRequest
     */

    public void setListGamesRequest(ListGamesRequest listGamesRequest) {
        this.listGamesRequest = listGamesRequest;
    }

    /**
     * @return
     */

    public ListGamesRequest getListGamesRequest() {
        return this.listGamesRequest;
    }

    /**
     * @param listGamesRequest
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetServermanagerListgamesRequest listGamesRequest(ListGamesRequest listGamesRequest) {
        setListGamesRequest(listGamesRequest);
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
        if (getListGamesRequest() != null)
            sb.append("ListGamesRequest: ").append(getListGamesRequest());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetServermanagerListgamesRequest == false)
            return false;
        GetServermanagerListgamesRequest other = (GetServermanagerListgamesRequest) obj;
        if (other.getListGamesRequest() == null ^ this.getListGamesRequest() == null)
            return false;
        if (other.getListGamesRequest() != null && other.getListGamesRequest().equals(this.getListGamesRequest()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getListGamesRequest() == null) ? 0 : getListGamesRequest().hashCode());
        return hashCode;
    }

    @Override
    public GetServermanagerListgamesRequest clone() {
        return (GetServermanagerListgamesRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public GetServermanagerListgamesRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
