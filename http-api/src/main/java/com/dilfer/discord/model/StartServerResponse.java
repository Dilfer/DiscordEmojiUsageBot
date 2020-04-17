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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/StartServerResponse"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class StartServerResponse implements Serializable, Cloneable, StructuredPojo {

    private String newState;

    private String originalState;

    /**
     * @param newState
     */

    public void setNewState(String newState) {
        this.newState = newState;
    }

    /**
     * @return
     */

    public String getNewState() {
        return this.newState;
    }

    /**
     * @param newState
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public StartServerResponse newState(String newState) {
        setNewState(newState);
        return this;
    }

    /**
     * @param originalState
     */

    public void setOriginalState(String originalState) {
        this.originalState = originalState;
    }

    /**
     * @return
     */

    public String getOriginalState() {
        return this.originalState;
    }

    /**
     * @param originalState
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public StartServerResponse originalState(String originalState) {
        setOriginalState(originalState);
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
        if (getNewState() != null)
            sb.append("NewState: ").append(getNewState()).append(",");
        if (getOriginalState() != null)
            sb.append("OriginalState: ").append(getOriginalState());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof StartServerResponse == false)
            return false;
        StartServerResponse other = (StartServerResponse) obj;
        if (other.getNewState() == null ^ this.getNewState() == null)
            return false;
        if (other.getNewState() != null && other.getNewState().equals(this.getNewState()) == false)
            return false;
        if (other.getOriginalState() == null ^ this.getOriginalState() == null)
            return false;
        if (other.getOriginalState() != null && other.getOriginalState().equals(this.getOriginalState()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getNewState() == null) ? 0 : getNewState().hashCode());
        hashCode = prime * hashCode + ((getOriginalState() == null) ? 0 : getOriginalState().hashCode());
        return hashCode;
    }

    @Override
    public StartServerResponse clone() {
        try {
            return (StartServerResponse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.StartServerResponseMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
