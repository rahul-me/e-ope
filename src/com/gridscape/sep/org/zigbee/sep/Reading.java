
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Specific value measured by a meter or other asset.
 * 
 * <p>Java class for Reading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Reading">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}ReadingBase">
 *       &lt;sequence>
 *         &lt;element name="localID" type="{http://zigbee.org/sep}HexBinary16" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="subscribable" type="{http://zigbee.org/sep}SubscribableType" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reading", propOrder = {
    "localID"
})
public class Reading
    extends ReadingBase
{

    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] localID;
    @XmlAttribute(name = "subscribable")
    protected Short subscribable;

    /**
     * Gets the value of the localID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getLocalID() {
        return localID;
    }

    /**
     * Sets the value of the localID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalID(byte[] value) {
        this.localID = value;
    }

    /**
     * Gets the value of the subscribable property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getSubscribable() {
        if (subscribable == null) {
            return ((short) 0);
        } else {
            return subscribable;
        }
    }

    /**
     * Sets the value of the subscribable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSubscribable(Short value) {
        this.subscribable = value;
    }

}
