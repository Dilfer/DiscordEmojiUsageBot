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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ra6ngodkx3-2020-04-14T21:58:16Z/ServerInfoResponse"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ServerInfoResponse implements Serializable, Cloneable, StructuredPojo {

    private String instanceState;

    private String ipAddress;

    private String name;

    /**
     * @param instanceState
     */

    public void setInstanceState(String instanceState) {
        this.instanceState = instanceState;
    }

    /**
     * @return
     */

    public String getInstanceState() {
        return this.instanceState;
    }

    /**
     * @param instanceState
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ServerInfoResponse instanceState(String instanceState) {
        setInstanceState(instanceState);
        return this;
    }

    /**
     * @param ipAddress
     */

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return
     */

    public String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * @param ipAddress
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ServerInfoResponse ipAddress(String ipAddress) {
        setIpAddress(ipAddress);
        return this;
    }

    /**
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ServerInfoResponse name(String name) {
        setName(name);
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
        if (getInstanceState() != null)
            sb.append("InstanceState: ").append(getInstanceState()).append(",");
        if (getIpAddress() != null)
            sb.append("IpAddress: ").append(getIpAddress()).append(",");
        if (getName() != null)
            sb.append("Name: ").append(getName());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ServerInfoResponse == false)
            return false;
        ServerInfoResponse other = (ServerInfoResponse) obj;
        if (other.getInstanceState() == null ^ this.getInstanceState() == null)
            return false;
        if (other.getInstanceState() != null && other.getInstanceState().equals(this.getInstanceState()) == false)
            return false;
        if (other.getIpAddress() == null ^ this.getIpAddress() == null)
            return false;
        if (other.getIpAddress() != null && other.getIpAddress().equals(this.getIpAddress()) == false)
            return false;
        if (other.getName() == null ^ this.getName() == null)
            return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getInstanceState() == null) ? 0 : getInstanceState().hashCode());
        hashCode = prime * hashCode + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode());
        return hashCode;
    }

    @Override
    public ServerInfoResponse clone() {
        try {
            return (ServerInfoResponse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.dilfer.discord.model.transform.ServerInfoResponseMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
