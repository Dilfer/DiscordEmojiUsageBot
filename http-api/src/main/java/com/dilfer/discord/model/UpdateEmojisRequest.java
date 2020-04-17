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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/UpdateEmojisRequest"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateEmojisRequest implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<EmojiUpdate> emojiUpdates;

    /**
     * @return
     */

    public java.util.List<EmojiUpdate> getEmojiUpdates() {
        return emojiUpdates;
    }

    /**
     * @param emojiUpdates
     */

    public void setEmojiUpdates(java.util.Collection<EmojiUpdate> emojiUpdates) {
        if (emojiUpdates == null) {
            this.emojiUpdates = null;
            return;
        }

        this.emojiUpdates = new java.util.ArrayList<EmojiUpdate>(emojiUpdates);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setEmojiUpdates(java.util.Collection)} or {@link #withEmojiUpdates(java.util.Collection)} if you want to
     * override the existing values.
     * </p>
     * 
     * @param emojiUpdates
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateEmojisRequest emojiUpdates(EmojiUpdate... emojiUpdates) {
        if (this.emojiUpdates == null) {
            setEmojiUpdates(new java.util.ArrayList<EmojiUpdate>(emojiUpdates.length));
        }
        for (EmojiUpdate ele : emojiUpdates) {
            this.emojiUpdates.add(ele);
        }
        return this;
    }

    /**
     * @param emojiUpdates
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UpdateEmojisRequest emojiUpdates(java.util.Collection<EmojiUpdate> emojiUpdates) {
        setEmojiUpdates(emojiUpdates);
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
        if (getEmojiUpdates() != null)
            sb.append("EmojiUpdates: ").append(getEmojiUpdates());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UpdateEmojisRequest == false)
            return false;
        UpdateEmojisRequest other = (UpdateEmojisRequest) obj;
        if (other.getEmojiUpdates() == null ^ this.getEmojiUpdates() == null)
            return false;
        if (other.getEmojiUpdates() != null && other.getEmojiUpdates().equals(this.getEmojiUpdates()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getEmojiUpdates() == null) ? 0 : getEmojiUpdates().hashCode());
        return hashCode;
    }

    @Override
    public UpdateEmojisRequest clone() {
        try {
            return (UpdateEmojisRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.UpdateEmojisRequestMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
