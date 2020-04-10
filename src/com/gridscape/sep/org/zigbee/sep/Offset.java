
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * If a temperature offset is sent that causes the heating or cooling temperature set point to exceed the limit boundaries that are programmed into the device, the device SHALL respond by setting the temperature at the limit.
 * If an EDC is being targeted at multiple devices or to a device that controls multiple devices (e.g., EMS), it can provide multiple Offset types within one EDC. For events with multiple Offset types, a client SHALL select the Offset that best fits their operating function. 
 * Alternatively, an event with a single Offset type can be targeted at an EMS in order to request a percentage load reduction on the average energy usage of the entire premise. An EMS SHOULD use the Metering function set to determine the initial load in the premise, reduce energy consumption by controlling devices at its disposal, and at the conclusion of the event, once again use the Metering function set to determine if the desired load reduction was achieved.
 * 
 * <p>Java class for Offset complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Offset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coolingOffset" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="heatingOffset" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="loadAdjustmentPercentageOffset" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Offset", propOrder = {
    "coolingOffset",
    "heatingOffset",
    "loadAdjustmentPercentageOffset"
})
public class Offset {

    protected Short coolingOffset;
    protected Short heatingOffset;
    protected Short loadAdjustmentPercentageOffset;

    /**
     * Gets the value of the coolingOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCoolingOffset() {
        return coolingOffset;
    }

    /**
     * Sets the value of the coolingOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCoolingOffset(Short value) {
        this.coolingOffset = value;
    }

    /**
     * Gets the value of the heatingOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getHeatingOffset() {
        return heatingOffset;
    }

    /**
     * Sets the value of the heatingOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setHeatingOffset(Short value) {
        this.heatingOffset = value;
    }

    /**
     * Gets the value of the loadAdjustmentPercentageOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getLoadAdjustmentPercentageOffset() {
        return loadAdjustmentPercentageOffset;
    }

    /**
     * Sets the value of the loadAdjustmentPercentageOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setLoadAdjustmentPercentageOffset(Short value) {
        this.loadAdjustmentPercentageOffset = value;
    }

}
