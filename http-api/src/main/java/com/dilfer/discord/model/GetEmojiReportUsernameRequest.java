/**
 * null
 */
package com.dilfer.discord.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-20T22:22:57Z/GetEmojiReportUsername"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetEmojiReportUsernameRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private String username;

    /**
     * @param username
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */

    public String getUsername() {
        return this.username;
    }

    /**
     * @param username
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetEmojiReportUsernameRequest username(String username) {
        setUsername(username);
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
        if (getUsername() != null)
            sb.append("Username: ").append(getUsername());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetEmojiReportUsernameRequest == false)
            return false;
        GetEmojiReportUsernameRequest other = (GetEmojiReportUsernameRequest) obj;
        if (other.getUsername() == null ^ this.getUsername() == null)
            return false;
        if (other.getUsername() != null && other.getUsername().equals(this.getUsername()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getUsername() == null) ? 0 : getUsername().hashCode());
        return hashCode;
    }

    @Override
    public GetEmojiReportUsernameRequest clone() {
        return (GetEmojiReportUsernameRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public GetEmojiReportUsernameRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
