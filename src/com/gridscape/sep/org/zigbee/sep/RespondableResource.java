
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A Resource to which a Response can be requested.
 * 
 * <p>Java class for RespondableResource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespondableResource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;attribute name="replyTo" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="responseRequired" type="{http://zigbee.org/sep}HexBinary8" default="00" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespondableResource")
@XmlSeeAlso({
    RespondableIdentifiedObject.class,
    RespondableSubscribableIdentifiedObject.class
})
public class RespondableResource
    extends Resource
{

    @XmlAttribute(name = "replyTo")
    @XmlSchemaType(name = "anyURI")
    protected String replyTo;
    @XmlAttribute(name = "responseRequired")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] responseRequired;

    /**
     * Gets the value of the replyTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * Sets the value of the replyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyTo(String value) {
        this.replyTo = value;
    }

    /**
     * Gets the value of the responseRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getResponseRequired() {
        if (responseRequired == null) {
            return new HexBinaryAdapter().unmarshal("00");
        } else {
            return responseRequired;
        }
    }

    /**
     * Sets the value of the responseRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseRequired(byte[] value) {
        this.responseRequired = value;
    }

}
