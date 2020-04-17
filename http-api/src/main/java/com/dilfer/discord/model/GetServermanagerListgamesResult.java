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
public class GetServermanagerListgamesResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ListGamesResponse listGamesResponse;

    /**
     * @param listGamesResponse
     */

    public void setListGamesResponse(ListGamesResponse listGamesResponse) {
        this.listGamesResponse = listGamesResponse;
    }

    /**
     * @return
     */

    public ListGamesResponse getListGamesResponse() {
        return this.listGamesResponse;
    }

    /**
     * @param listGamesResponse
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetServermanagerListgamesResult listGamesResponse(ListGamesResponse listGamesResponse) {
        setListGamesResponse(listGamesResponse);
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
        if (getListGamesResponse() != null)
            sb.append("ListGamesResponse: ").append(getListGamesResponse());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetServermanagerListgamesResult == false)
            return false;
        GetServermanagerListgamesResult other = (GetServermanagerListgamesResult) obj;
        if (other.getListGamesResponse() == null ^ this.getListGamesResponse() == null)
            return false;
        if (other.getListGamesResponse() != null && other.getListGamesResponse().equals(this.getListGamesResponse()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getListGamesResponse() == null) ? 0 : getListGamesResponse().hashCode());
        return hashCode;
    }

    @Override
    public GetServermanagerListgamesResult clone() {
        try {
            return (GetServermanagerListgamesResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
