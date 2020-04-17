/**
 * null
 */
package com.dilfer.discord.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/PostEmojiUpdate"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostEmojiUpdateRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private String messageDeduplicationId;

    private String messageGroupId;

    private UpdateEmojisRequest updateEmojisRequest;

    /**
     * @param messageDeduplicationId
     */

    public void setMessageDeduplicationId(String messageDeduplicationId) {
        this.messageDeduplicationId = messageDeduplicationId;
    }

    /**
     * @return
     */

    public String getMessageDeduplicationId() {
        return this.messageDeduplicationId;
    }

    /**
     * @param messageDeduplicationId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostEmojiUpdateRequest messageDeduplicationId(String messageDeduplicationId) {
        setMessageDeduplicationId(messageDeduplicationId);
        return this;
    }

    /**
     * @param messageGroupId
     */

    public void setMessageGroupId(String messageGroupId) {
        this.messageGroupId = messageGroupId;
    }

    /**
     * @return
     */

    public String getMessageGroupId() {
        return this.messageGroupId;
    }

    /**
     * @param messageGroupId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostEmojiUpdateRequest messageGroupId(String messageGroupId) {
        setMessageGroupId(messageGroupId);
        return this;
    }

    /**
     * @param updateEmojisRequest
     */

    public void setUpdateEmojisRequest(UpdateEmojisRequest updateEmojisRequest) {
        this.updateEmojisRequest = updateEmojisRequest;
    }

    /**
     * @return
     */

    public UpdateEmojisRequest getUpdateEmojisRequest() {
        return this.updateEmojisRequest;
    }

    /**
     * @param updateEmojisRequest
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostEmojiUpdateRequest updateEmojisRequest(UpdateEmojisRequest updateEmojisRequest) {
        setUpdateEmojisRequest(updateEmojisRequest);
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
        if (getMessageDeduplicationId() != null)
            sb.append("MessageDeduplicationId: ").append(getMessageDeduplicationId()).append(",");
        if (getMessageGroupId() != null)
            sb.append("MessageGroupId: ").append(getMessageGroupId()).append(",");
        if (getUpdateEmojisRequest() != null)
            sb.append("UpdateEmojisRequest: ").append(getUpdateEmojisRequest());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostEmojiUpdateRequest == false)
            return false;
        PostEmojiUpdateRequest other = (PostEmojiUpdateRequest) obj;
        if (other.getMessageDeduplicationId() == null ^ this.getMessageDeduplicationId() == null)
            return false;
        if (other.getMessageDeduplicationId() != null && other.getMessageDeduplicationId().equals(this.getMessageDeduplicationId()) == false)
            return false;
        if (other.getMessageGroupId() == null ^ this.getMessageGroupId() == null)
            return false;
        if (other.getMessageGroupId() != null && other.getMessageGroupId().equals(this.getMessageGroupId()) == false)
            return false;
        if (other.getUpdateEmojisRequest() == null ^ this.getUpdateEmojisRequest() == null)
            return false;
        if (other.getUpdateEmojisRequest() != null && other.getUpdateEmojisRequest().equals(this.getUpdateEmojisRequest()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getMessageDeduplicationId() == null) ? 0 : getMessageDeduplicationId().hashCode());
        hashCode = prime * hashCode + ((getMessageGroupId() == null) ? 0 : getMessageGroupId().hashCode());
        hashCode = prime * hashCode + ((getUpdateEmojisRequest() == null) ? 0 : getUpdateEmojisRequest().hashCode());
        return hashCode;
    }

    @Override
    public PostEmojiUpdateRequest clone() {
        return (PostEmojiUpdateRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostEmojiUpdateRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
