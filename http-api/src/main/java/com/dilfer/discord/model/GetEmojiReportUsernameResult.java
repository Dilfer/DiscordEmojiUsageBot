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
public class GetEmojiReportUsernameResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private EmojiReportResponse emojiReportResponse;

    /**
     * @param emojiReportResponse
     */

    public void setEmojiReportResponse(EmojiReportResponse emojiReportResponse) {
        this.emojiReportResponse = emojiReportResponse;
    }

    /**
     * @return
     */

    public EmojiReportResponse getEmojiReportResponse() {
        return this.emojiReportResponse;
    }

    /**
     * @param emojiReportResponse
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetEmojiReportUsernameResult emojiReportResponse(EmojiReportResponse emojiReportResponse) {
        setEmojiReportResponse(emojiReportResponse);
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
        if (getEmojiReportResponse() != null)
            sb.append("EmojiReportResponse: ").append(getEmojiReportResponse());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetEmojiReportUsernameResult == false)
            return false;
        GetEmojiReportUsernameResult other = (GetEmojiReportUsernameResult) obj;
        if (other.getEmojiReportResponse() == null ^ this.getEmojiReportResponse() == null)
            return false;
        if (other.getEmojiReportResponse() != null && other.getEmojiReportResponse().equals(this.getEmojiReportResponse()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEmojiReportResponse() == null) ? 0 : getEmojiReportResponse().hashCode());
        return hashCode;
    }

    @Override
    public GetEmojiReportUsernameResult clone() {
        try {
            return (GetEmojiReportUsernameResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
