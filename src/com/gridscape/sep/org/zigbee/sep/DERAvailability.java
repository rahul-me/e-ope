
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Indicates current reserve generation status
 * 
 * <p>Java class for DERAvailability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERAvailability">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="availabilityDuration" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="maxChargeDuration" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="readingTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="reserveChargePercent" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="reservePercent" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="statVArAvail" type="{http://zigbee.org/sep}ReactivePower" minOccurs="0"/>
 *         &lt;element name="statWAvail" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERAvailability", propOrder = {
    "availabilityDuration",
    "maxChargeDuration",
    "readingTime",
    "reserveChargePercent",
    "reservePercent",
    "statVArAvail",
    "statWAvail"
})
public class DERAvailability
    extends SubscribableResource
{

    protected Long availabilityDuration;
    protected Long maxChargeDuration;
    @XmlElement(required = true)
    protected TimeType readingTime;
    protected PerCent reserveChargePercent;
    protected PerCent reservePercent;
    protected ReactivePower statVArAvail;
    protected ActivePower statWAvail;

    /**
     * Gets the value of the availabilityDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailabilityDuration() {
        return availabilityDuration;
    }

    /**
     * Sets the value of the availabilityDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailabilityDuration(Long value) {
        this.availabilityDuration = value;
    }

    /**
     * Gets the value of the maxChargeDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxChargeDuration() {
        return maxChargeDuration;
    }

    /**
     * Sets the value of the maxChargeDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxChargeDuration(Long value) {
        this.maxChargeDuration = value;
    }

    /**
     * Gets the value of the readingTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getReadingTime() {
        return readingTime;
    }

    /**
     * Sets the value of the readingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setReadingTime(TimeType value) {
        this.readingTime = value;
    }

    /**
     * Gets the value of the reserveChargePercent property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getReserveChargePercent() {
        return reserveChargePercent;
    }

    /**
     * Sets the value of the reserveChargePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setReserveChargePercent(PerCent value) {
        this.reserveChargePercent = value;
    }

    /**
     * Gets the value of the reservePercent property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getReservePercent() {
        return reservePercent;
    }

    /**
     * Sets the value of the reservePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setReservePercent(PerCent value) {
        this.reservePercent = value;
    }

    /**
     * Gets the value of the statVArAvail property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePower }
     *     
     */
    public ReactivePower getStatVArAvail() {
        return statVArAvail;
    }

    /**
     * Sets the value of the statVArAvail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePower }
     *     
     */
    public void setStatVArAvail(ReactivePower value) {
        this.statVArAvail = value;
    }

    /**
     * Gets the value of the statWAvail property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getStatWAvail() {
        return statWAvail;
    }

    /**
     * Sets the value of the statWAvail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setStatWAvail(ActivePower value) {
        this.statWAvail = value;
    }

}
