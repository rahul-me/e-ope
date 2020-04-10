
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Contains 802.15.4 link layer specific attributes.
 * 
 * <p>Java class for IEEE_802_15_4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IEEE_802_15_4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capabilityInfo" type="{http://zigbee.org/sep}HexBinary8"/>
 *         &lt;element name="NeighborListLink" type="{http://zigbee.org/sep}NeighborListLink" minOccurs="0"/>
 *         &lt;element name="shortAddress" type="{http://zigbee.org/sep}UInt16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IEEE_802_15_4", propOrder = {
    "capabilityInfo",
    "neighborListLink",
    "shortAddress"
})
public class IEEE802154 {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] capabilityInfo;
    @XmlElement(name = "NeighborListLink")
    protected NeighborListLink neighborListLink;
    protected int shortAddress;

    /**
     * Gets the value of the capabilityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getCapabilityInfo() {
        return capabilityInfo;
    }

    /**
     * Sets the value of the capabilityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapabilityInfo(byte[] value) {
        this.capabilityInfo = value;
    }

    /**
     * Gets the value of the neighborListLink property.
     * 
     * @return
     *     possible object is
     *     {@link NeighborListLink }
     *     
     */
    public NeighborListLink getNeighborListLink() {
        return neighborListLink;
    }

    /**
     * Sets the value of the neighborListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeighborListLink }
     *     
     */
    public void setNeighborListLink(NeighborListLink value) {
        this.neighborListLink = value;
    }

    /**
     * Gets the value of the shortAddress property.
     * 
     */
    public int getShortAddress() {
        return shortAddress;
    }

    /**
     * Sets the value of the shortAddress property.
     * 
     */
    public void setShortAddress(int value) {
        this.shortAddress = value;
    }

}
