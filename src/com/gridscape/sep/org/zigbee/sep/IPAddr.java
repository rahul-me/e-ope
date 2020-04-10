
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * An Internet Protocol address object.
 * 
 * <p>Java class for IPAddr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPAddr">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://zigbee.org/sep}HexBinary128"/>
 *         &lt;element name="RPLInstanceListLink" type="{http://zigbee.org/sep}RPLInstanceListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPAddr", propOrder = {
    "address",
    "rplInstanceListLink"
})
public class IPAddr
    extends Resource
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] address;
    @XmlElement(name = "RPLInstanceListLink")
    protected RPLInstanceListLink rplInstanceListLink;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(byte[] value) {
        this.address = value;
    }

    /**
     * Gets the value of the rplInstanceListLink property.
     * 
     * @return
     *     possible object is
     *     {@link RPLInstanceListLink }
     *     
     */
    public RPLInstanceListLink getRPLInstanceListLink() {
        return rplInstanceListLink;
    }

    /**
     * Sets the value of the rplInstanceListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RPLInstanceListLink }
     *     
     */
    public void setRPLInstanceListLink(RPLInstanceListLink value) {
        this.rplInstanceListLink = value;
    }

}
