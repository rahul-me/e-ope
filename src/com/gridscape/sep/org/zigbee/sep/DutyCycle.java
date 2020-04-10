
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Duty cycle control is a device specific issue and is managed by the device.  The duty cycle of the device under control should span the shortest practical time period in accordance with the nature of the device under control and the intent of the request for demand reduction.  The default factory setting SHOULD be three minutes for each 10% of duty cycle.  This indicates that the default time period over which a duty cycle is applied is 30 minutes, meaning a 10% duty cycle would cause a device to be ON for 3 minutes.   The “off state” SHALL precede the “on state”.
 * 
 * <p>Java class for DutyCycle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DutyCycle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="normalValue" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DutyCycle", propOrder = {
    "normalValue"
})
public class DutyCycle {

    protected short normalValue;

    /**
     * Gets the value of the normalValue property.
     * 
     */
    public short getNormalValue() {
        return normalValue;
    }

    /**
     * Sets the value of the normalValue property.
     * 
     */
    public void setNormalValue(short value) {
        this.normalValue = value;
    }

}
