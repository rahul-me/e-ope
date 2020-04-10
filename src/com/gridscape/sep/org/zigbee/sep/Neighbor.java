
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains 802.15.4 link layer specific attributes.
 * 
 * <p>Java class for Neighbor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Neighbor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="isChild" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="linkQuality" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="shortAddress" type="{http://zigbee.org/sep}UInt16"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Neighbor", propOrder = {
    "isChild",
    "linkQuality",
    "shortAddress"
})
public class Neighbor
    extends Resource
{

    protected boolean isChild;
    protected short linkQuality;
    protected int shortAddress;

    /**
     * Gets the value of the isChild property.
     * 
     */
    public boolean isIsChild() {
        return isChild;
    }

    /**
     * Sets the value of the isChild property.
     * 
     */
    public void setIsChild(boolean value) {
        this.isChild = value;
    }

    /**
     * Gets the value of the linkQuality property.
     * 
     */
    public short getLinkQuality() {
        return linkQuality;
    }

    /**
     * Sets the value of the linkQuality property.
     * 
     */
    public void setLinkQuality(short value) {
        this.linkQuality = value;
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
