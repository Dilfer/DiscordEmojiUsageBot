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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/ListGamesResponse"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ListGamesResponse implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<String> games;

    /**
     * @return
     */

    public java.util.List<String> getGames() {
        return games;
    }

    /**
     * @param games
     */

    public void setGames(java.util.Collection<String> games) {
        if (games == null) {
            this.games = null;
            return;
        }

        this.games = new java.util.ArrayList<String>(games);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setGames(java.util.Collection)} or {@link #withGames(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param games
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListGamesResponse games(String... games) {
        if (this.games == null) {
            setGames(new java.util.ArrayList<String>(games.length));
        }
        for (String ele : games) {
            this.games.add(ele);
        }
        return this;
    }

    /**
     * @param games
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ListGamesResponse games(java.util.Collection<String> games) {
        setGames(games);
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
        if (getGames() != null)
            sb.append("Games: ").append(getGames());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ListGamesResponse == false)
            return false;
        ListGamesResponse other = (ListGamesResponse) obj;
        if (other.getGames() == null ^ this.getGames() == null)
            return false;
        if (other.getGames() != null && other.getGames().equals(this.getGames()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getGames() == null) ? 0 : getGames().hashCode());
        return hashCode;
    }

    @Override
    public ListGamesResponse clone() {
        try {
            return (ListGamesResponse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.ListGamesResponseMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
