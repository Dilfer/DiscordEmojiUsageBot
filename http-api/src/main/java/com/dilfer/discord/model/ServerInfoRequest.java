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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/ServerInfoRequest"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ServerInfoRequest implements Serializable, Cloneable, StructuredPojo {

    private String game;

    private String guild;

    /**
     * @param game
     */

    public void setGame(String game) {
        this.game = game;
    }

    /**
     * @return
     */

    public String getGame() {
        return this.game;
    }

    /**
     * @param game
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ServerInfoRequest game(String game) {
        setGame(game);
        return this;
    }

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

    public ServerInfoRequest guild(String guild) {
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
        if (getGame() != null)
            sb.append("Game: ").append(getGame()).append(",");
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

        if (obj instanceof ServerInfoRequest == false)
            return false;
        ServerInfoRequest other = (ServerInfoRequest) obj;
        if (other.getGame() == null ^ this.getGame() == null)
            return false;
        if (other.getGame() != null && other.getGame().equals(this.getGame()) == false)
            return false;
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

        hashCode = prime * hashCode + ((getGame() == null) ? 0 : getGame().hashCode());
        hashCode = prime * hashCode + ((getGuild() == null) ? 0 : getGuild().hashCode());
        return hashCode;
    }

    @Override
    public ServerInfoRequest clone() {
        try {
            return (ServerInfoRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.ServerInfoRequestMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
