
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the status of the device's power sources
 * 
 * <p>Java class for PowerStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="batteryStatus" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="changedTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="currentPowerSource" type="{http://zigbee.org/sep}PowerSourceType"/>
 *         &lt;element name="estimatedChargeRemaining" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="estimatedTimeRemaining" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="PEVInfo" type="{http://zigbee.org/sep}PEVInfo" minOccurs="0"/>
 *         &lt;element name="sessionTimeOnBattery" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="totalTimeOnBattery" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerStatus", propOrder = {
    "batteryStatus",
    "changedTime",
    "currentPowerSource",
    "estimatedChargeRemaining",
    "estimatedTimeRemaining",
    "pevInfo",
    "sessionTimeOnBattery",
    "totalTimeOnBattery"
})
public class PowerStatus
    extends Resource
{

    protected short batteryStatus;
    @XmlElement(required = true)
    protected TimeType changedTime;
    @XmlElement(required = true)
    protected PowerSourceType currentPowerSource;
    protected PerCent estimatedChargeRemaining;
    protected Long estimatedTimeRemaining;
    @XmlElement(name = "PEVInfo")
    protected PEVInfo pevInfo;
    protected Long sessionTimeOnBattery;
    protected Long totalTimeOnBattery;

    /**
     * Gets the value of the batteryStatus property.
     * 
     */
    public short getBatteryStatus() {
        return batteryStatus;
    }

    /**
     * Sets the value of the batteryStatus property.
     * 
     */
    public void setBatteryStatus(short value) {
        this.batteryStatus = value;
    }

    /**
     * Gets the value of the changedTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getChangedTime() {
        return changedTime;
    }

    /**
     * Sets the value of the changedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setChangedTime(TimeType value) {
        this.changedTime = value;
    }

    /**
     * Gets the value of the currentPowerSource property.
     * 
     * @return
     *     possible object is
     *     {@link PowerSourceType }
     *     
     */
    public PowerSourceType getCurrentPowerSource() {
        return currentPowerSource;
    }

    /**
     * Sets the value of the currentPowerSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerSourceType }
     *     
     */
    public void setCurrentPowerSource(PowerSourceType value) {
        this.currentPowerSource = value;
    }

    /**
     * Gets the value of the estimatedChargeRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getEstimatedChargeRemaining() {
        return estimatedChargeRemaining;
    }

    /**
     * Sets the value of the estimatedChargeRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setEstimatedChargeRemaining(PerCent value) {
        this.estimatedChargeRemaining = value;
    }

    /**
     * Gets the value of the estimatedTimeRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEstimatedTimeRemaining() {
        return estimatedTimeRemaining;
    }

    /**
     * Sets the value of the estimatedTimeRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEstimatedTimeRemaining(Long value) {
        this.estimatedTimeRemaining = value;
    }

    /**
     * Gets the value of the pevInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PEVInfo }
     *     
     */
    public PEVInfo getPEVInfo() {
        return pevInfo;
    }

    /**
     * Sets the value of the pevInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PEVInfo }
     *     
     */
    public void setPEVInfo(PEVInfo value) {
        this.pevInfo = value;
    }

    /**
     * Gets the value of the sessionTimeOnBattery property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSessionTimeOnBattery() {
        return sessionTimeOnBattery;
    }

    /**
     * Sets the value of the sessionTimeOnBattery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSessionTimeOnBattery(Long value) {
        this.sessionTimeOnBattery = value;
    }

    /**
     * Gets the value of the totalTimeOnBattery property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalTimeOnBattery() {
        return totalTimeOnBattery;
    }

    /**
     * Sets the value of the totalTimeOnBattery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalTimeOnBattery(Long value) {
        this.totalTimeOnBattery = value;
    }

}
