
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains attributes that can be exposed by PEVs and other devices that have charging requirements.
 * 
 * <p>Java class for PEVInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PEVInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargingPowerNow" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="energyRequestNow" type="{http://zigbee.org/sep}RealEnergy"/>
 *         &lt;element name="maxForwardPower" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="minimumChargingDuration" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="targetStateOfCharge" type="{http://zigbee.org/sep}PerCent"/>
 *         &lt;element name="timeChargeIsNeeded" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="timeChargingStatusPEV" type="{http://zigbee.org/sep}TimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PEVInfo", propOrder = {
    "chargingPowerNow",
    "energyRequestNow",
    "maxForwardPower",
    "minimumChargingDuration",
    "targetStateOfCharge",
    "timeChargeIsNeeded",
    "timeChargingStatusPEV"
})
public class PEVInfo {

    @XmlElement(required = true)
    protected ActivePower chargingPowerNow;
    @XmlElement(required = true)
    protected RealEnergy energyRequestNow;
    @XmlElement(required = true)
    protected ActivePower maxForwardPower;
    protected long minimumChargingDuration;
    @XmlElement(required = true)
    protected PerCent targetStateOfCharge;
    @XmlElement(required = true)
    protected TimeType timeChargeIsNeeded;
    @XmlElement(required = true)
    protected TimeType timeChargingStatusPEV;

    /**
     * Gets the value of the chargingPowerNow property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getChargingPowerNow() {
        return chargingPowerNow;
    }

    /**
     * Sets the value of the chargingPowerNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setChargingPowerNow(ActivePower value) {
        this.chargingPowerNow = value;
    }

    /**
     * Gets the value of the energyRequestNow property.
     * 
     * @return
     *     possible object is
     *     {@link RealEnergy }
     *     
     */
    public RealEnergy getEnergyRequestNow() {
        return energyRequestNow;
    }

    /**
     * Sets the value of the energyRequestNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEnergy }
     *     
     */
    public void setEnergyRequestNow(RealEnergy value) {
        this.energyRequestNow = value;
    }

    /**
     * Gets the value of the maxForwardPower property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getMaxForwardPower() {
        return maxForwardPower;
    }

    /**
     * Sets the value of the maxForwardPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setMaxForwardPower(ActivePower value) {
        this.maxForwardPower = value;
    }

    /**
     * Gets the value of the minimumChargingDuration property.
     * 
     */
    public long getMinimumChargingDuration() {
        return minimumChargingDuration;
    }

    /**
     * Sets the value of the minimumChargingDuration property.
     * 
     */
    public void setMinimumChargingDuration(long value) {
        this.minimumChargingDuration = value;
    }

    /**
     * Gets the value of the targetStateOfCharge property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getTargetStateOfCharge() {
        return targetStateOfCharge;
    }

    /**
     * Sets the value of the targetStateOfCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setTargetStateOfCharge(PerCent value) {
        this.targetStateOfCharge = value;
    }

    /**
     * Gets the value of the timeChargeIsNeeded property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getTimeChargeIsNeeded() {
        return timeChargeIsNeeded;
    }

    /**
     * Sets the value of the timeChargeIsNeeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setTimeChargeIsNeeded(TimeType value) {
        this.timeChargeIsNeeded = value;
    }

    /**
     * Gets the value of the timeChargingStatusPEV property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getTimeChargingStatusPEV() {
        return timeChargingStatusPEV;
    }

    /**
     * Sets the value of the timeChargingStatusPEV property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setTimeChargingStatusPEV(TimeType value) {
        this.timeChargingStatusPEV = value;
    }

}
