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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/ListGamesRequest"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ListGamesRequest implements Serializable, Cloneable, StructuredPojo {

    private String guild;

    /**
     * @param guild
     */

    public void setGuild(String guild) {
        this.guild = guild;
    }

    /**
     * @return
     */

    public String getGuild() {
        return this.guild;
    }

    /**
     * @param guild
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListGamesRequest guild(String guild) {
        setGuild(guild);
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
        if (getGuild() != null)
            sb.append("Guild: ").append(getGuild());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ListGamesRequest == false)
            return false;
        ListGamesRequest other = (ListGamesRequest) obj;
        if (other.getGuild() == null ^ this.getGuild() == null)
            return false;
        if (other.getGuild() != null && other.getGuild().equals(this.getGuild()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getGuild() == null) ? 0 : getGuild().hashCode());
        return hashCode;
    }

    @Override
    public ListGamesRequest clone() {
        try {
            return (ListGamesRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.ListGamesRequestMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
