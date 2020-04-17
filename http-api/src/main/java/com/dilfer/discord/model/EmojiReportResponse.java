/**
 * null
 */
package com.dilfer.discord.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/EmojiReportResponse"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EmojiReportResponse implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<EmojiStats> emojiStats;

    /**
     * @return
     */

    public java.util.List<EmojiStats> getEmojiStats() {
        return emojiStats;
    }

    /**
     * @param emojiStats
     */

    public void setEmojiStats(java.util.Collection<EmojiStats> emojiStats) {
        if (emojiStats == null) {
            this.emojiStats = null;
            return;
        }

        this.emojiStats = new java.util.ArrayList<EmojiStats>(emojiStats);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setEmojiStats(java.util.Collection)} or {@link #withEmojiStats(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param emojiStats
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public EmojiReportResponse emojiStats(EmojiStats... emojiStats) {
        if (this.emojiStats == null) {
            setEmojiStats(new java.util.ArrayList<EmojiStats>(emojiStats.length));
        }
        for (EmojiStats ele : emojiStats) {
            this.emojiStats.add(ele);
        }
        return this;
    }

    /**
     * @param emojiStats
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public EmojiReportResponse emojiStats(java.util.Collection<EmojiStats> emojiStats) {
        setEmojiStats(emojiStats);
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
        if (getEmojiStats() != null)
            sb.append("EmojiStats: ").append(getEmojiStats());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof EmojiReportResponse == false)
            return false;
        EmojiReportResponse other = (EmojiReportResponse) obj;
        if (other.getEmojiStats() == null ^ this.getEmojiStats() == null)
            return false;
        if (other.getEmojiStats() != null && other.getEmojiStats().equals(this.getEmojiStats()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEmojiStats() == null) ? 0 : getEmojiStats().hashCode());
        return hashCode;
    }

    @Override
    public EmojiReportResponse clone() {
        try {
            return (EmojiReportResponse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.EmojiReportResponseMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
