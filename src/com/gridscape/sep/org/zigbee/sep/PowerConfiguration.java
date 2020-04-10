
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains configuration related to the device's power sources
 * 
 * <p>Java class for PowerConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="batteryInstallTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="lowChargeThreshold" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerConfiguration", propOrder = {
    "batteryInstallTime",
    "lowChargeThreshold"
})
public class PowerConfiguration {

    protected TimeType batteryInstallTime;
    protected Long lowChargeThreshold;

    /**
     * Gets the value of the batteryInstallTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getBatteryInstallTime() {
        return batteryInstallTime;
    }

    /**
     * Sets the value of the batteryInstallTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setBatteryInstallTime(TimeType value) {
        this.batteryInstallTime = value;
    }

    /**
     * Gets the value of the lowChargeThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLowChargeThreshold() {
        return lowChargeThreshold;
    }

    /**
     * Sets the value of the lowChargeThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLowChargeThreshold(Long value) {
        this.lowChargeThreshold = value;
    }

}
