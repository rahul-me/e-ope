
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Demand response program.
 * 
 * <p>Java class for DemandResponseProgram complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DemandResponseProgram">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ActiveEndDeviceControlListLink" type="{http://zigbee.org/sep}ActiveEndDeviceControlListLink" minOccurs="0"/>
 *         &lt;element name="availabilityUpdatePercentChangeThreshold" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="availabilityUpdatePowerChangeThreshold" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *         &lt;element name="EndDeviceControlListLink" type="{http://zigbee.org/sep}EndDeviceControlListLink" minOccurs="0"/>
 *         &lt;element name="primacy" type="{http://zigbee.org/sep}PrimacyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DemandResponseProgram", propOrder = {
    "activeEndDeviceControlListLink",
    "availabilityUpdatePercentChangeThreshold",
    "availabilityUpdatePowerChangeThreshold",
    "endDeviceControlListLink",
    "primacy"
})
public class DemandResponseProgram
    extends IdentifiedObject
{

    @XmlElement(name = "ActiveEndDeviceControlListLink")
    protected ActiveEndDeviceControlListLink activeEndDeviceControlListLink;
    protected PerCent availabilityUpdatePercentChangeThreshold;
    protected ActivePower availabilityUpdatePowerChangeThreshold;
    @XmlElement(name = "EndDeviceControlListLink")
    protected EndDeviceControlListLink endDeviceControlListLink;
    @XmlElement(required = true)
    protected PrimacyType primacy;

    /**
     * Gets the value of the activeEndDeviceControlListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveEndDeviceControlListLink }
     *     
     */
    public ActiveEndDeviceControlListLink getActiveEndDeviceControlListLink() {
        return activeEndDeviceControlListLink;
    }

    /**
     * Sets the value of the activeEndDeviceControlListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveEndDeviceControlListLink }
     *     
     */
    public void setActiveEndDeviceControlListLink(ActiveEndDeviceControlListLink value) {
        this.activeEndDeviceControlListLink = value;
    }

    /**
     * Gets the value of the availabilityUpdatePercentChangeThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getAvailabilityUpdatePercentChangeThreshold() {
        return availabilityUpdatePercentChangeThreshold;
    }

    /**
     * Sets the value of the availabilityUpdatePercentChangeThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setAvailabilityUpdatePercentChangeThreshold(PerCent value) {
        this.availabilityUpdatePercentChangeThreshold = value;
    }

    /**
     * Gets the value of the availabilityUpdatePowerChangeThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getAvailabilityUpdatePowerChangeThreshold() {
        return availabilityUpdatePowerChangeThreshold;
    }

    /**
     * Sets the value of the availabilityUpdatePowerChangeThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setAvailabilityUpdatePowerChangeThreshold(ActivePower value) {
        this.availabilityUpdatePowerChangeThreshold = value;
    }

    /**
     * Gets the value of the endDeviceControlListLink property.
     * 
     * @return
     *     possible object is
     *     {@link EndDeviceControlListLink }
     *     
     */
    public EndDeviceControlListLink getEndDeviceControlListLink() {
        return endDeviceControlListLink;
    }

    /**
     * Sets the value of the endDeviceControlListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndDeviceControlListLink }
     *     
     */
    public void setEndDeviceControlListLink(EndDeviceControlListLink value) {
        this.endDeviceControlListLink = value;
    }

    /**
     * Gets the value of the primacy property.
     * 
     * @return
     *     possible object is
     *     {@link PrimacyType }
     *     
     */
    public PrimacyType getPrimacy() {
        return primacy;
    }

    /**
     * Sets the value of the primacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimacyType }
     *     
     */
    public void setPrimacy(PrimacyType value) {
        this.primacy = value;
    }

}
