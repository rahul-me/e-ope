
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the representation of time, constantly updated.
 * 
 * <p>Java class for Time complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Time">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="currentTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="dstEndTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="dstOffset" type="{http://zigbee.org/sep}TimeOffsetType"/>
 *         &lt;element name="dstStartTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="localTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="quality" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="tzOffset" type="{http://zigbee.org/sep}TimeOffsetType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Time", propOrder = {
    "currentTime",
    "dstEndTime",
    "dstOffset",
    "dstStartTime",
    "localTime",
    "quality",
    "tzOffset"
})
@XmlRootElement(name = "Time")
public class Time
    extends Resource
{

    @XmlElement(required = true)
    protected TimeType currentTime;
    @XmlElement(required = true)
    protected TimeType dstEndTime;
    @XmlElement(required = true)
    protected TimeOffsetType dstOffset;
    @XmlElement(required = true)
    protected TimeType dstStartTime;
    protected TimeType localTime;
    protected short quality;
    @XmlElement(required = true)
    protected TimeOffsetType tzOffset;

    /**
     * Gets the value of the currentTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the value of the currentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCurrentTime(TimeType value) {
        this.currentTime = value;
    }

    /**
     * Gets the value of the dstEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getDstEndTime() {
        return dstEndTime;
    }

    /**
     * Sets the value of the dstEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setDstEndTime(TimeType value) {
        this.dstEndTime = value;
    }

    /**
     * Gets the value of the dstOffset property.
     * 
     * @return
     *     possible object is
     *     {@link TimeOffsetType }
     *     
     */
    public TimeOffsetType getDstOffset() {
        return dstOffset;
    }

    /**
     * Sets the value of the dstOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeOffsetType }
     *     
     */
    public void setDstOffset(TimeOffsetType value) {
        this.dstOffset = value;
    }

    /**
     * Gets the value of the dstStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getDstStartTime() {
        return dstStartTime;
    }

    /**
     * Sets the value of the dstStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setDstStartTime(TimeType value) {
        this.dstStartTime = value;
    }

    /**
     * Gets the value of the localTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getLocalTime() {
        return localTime;
    }

    /**
     * Sets the value of the localTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setLocalTime(TimeType value) {
        this.localTime = value;
    }

    /**
     * Gets the value of the quality property.
     * 
     */
    public short getQuality() {
        return quality;
    }

    /**
     * Sets the value of the quality property.
     * 
     */
    public void setQuality(short value) {
        this.quality = value;
    }

    /**
     * Gets the value of the tzOffset property.
     * 
     * @return
     *     possible object is
     *     {@link TimeOffsetType }
     *     
     */
    public TimeOffsetType getTzOffset() {
        return tzOffset;
    }

    /**
     * Sets the value of the tzOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeOffsetType }
     *     
     */
    public void setTzOffset(TimeOffsetType value) {
        this.tzOffset = value;
    }

}
