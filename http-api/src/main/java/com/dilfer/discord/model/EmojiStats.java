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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/EmojiStats" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class EmojiStats implements Serializable, Cloneable, StructuredPojo {

    private String emojiTextKey;

    private Integer usageCount;

    /**
     * @param emojiTextKey
     */

    public void setEmojiTextKey(String emojiTextKey) {
        this.emojiTextKey = emojiTextKey;
    }

    /**
     * @return
     */

    public String getEmojiTextKey() {
        return this.emojiTextKey;
    }

    /**
     * @param emojiTextKey
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public EmojiStats emojiTextKey(String emojiTextKey) {
        setEmojiTextKey(emojiTextKey);
        return this;
    }

    /**
     * @param usageCount
     */

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    /**
     * @return
     */

    public Integer getUsageCount() {
        return this.usageCount;
    }

    /**
     * @param usageCount
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public EmojiStats usageCount(Integer usageCount) {
        setUsageCount(usageCount);
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
        if (getEmojiTextKey() != null)
            sb.append("EmojiTextKey: ").append(getEmojiTextKey()).append(",");
        if (getUsageCount() != null)
            sb.append("UsageCount: ").append(getUsageCount());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof EmojiStats == false)
            return false;
        EmojiStats other = (EmojiStats) obj;
        if (other.getEmojiTextKey() == null ^ this.getEmojiTextKey() == null)
            return false;
        if (other.getEmojiTextKey() != null && other.getEmojiTextKey().equals(this.getEmojiTextKey()) == false)
            return false;
        if (other.getUsageCount() == null ^ this.getUsageCount() == null)
            return false;
        if (other.getUsageCount() != null && other.getUsageCount().equals(this.getUsageCount()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEmojiTextKey() == null) ? 0 : getEmojiTextKey().hashCode());
        hashCode = prime * hashCode + ((getUsageCount() == null) ? 0 : getUsageCount().hashCode());
        return hashCode;
    }

    @Override
    public EmojiStats clone() {
        try {
            return (EmojiStats) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.EmojiStatsMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
