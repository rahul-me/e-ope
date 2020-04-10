
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Current status information relevant to a specific object. The Status object is used to indicate the current status of an Event. Devices can read the containing resource (e.g. TextMessage) to get the most up to date status of the event.  Devices can also subscribe to a specific resource instance to get updates when any of its attributes change, including the Status object.
 * 
 * <p>Java class for EventStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentStatus" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="dateTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="potentiallySuperseded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="potentiallySupersededTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://zigbee.org/sep}String192" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventStatus", propOrder = {
    "currentStatus",
    "dateTime",
    "potentiallySuperseded",
    "potentiallySupersededTime",
    "reason"
})
public class EventStatus {

    protected short currentStatus;
    @XmlElement(required = true)
    protected TimeType dateTime;
    protected boolean potentiallySuperseded;
    protected TimeType potentiallySupersededTime;
    protected String reason;

    /**
     * Gets the value of the currentStatus property.
     * 
     */
    public short getCurrentStatus() {
        return currentStatus;
    }

    /**
     * Sets the value of the currentStatus property.
     * 
     */
    public void setCurrentStatus(short value) {
        this.currentStatus = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setDateTime(TimeType value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the potentiallySuperseded property.
     * 
     */
    public boolean isPotentiallySuperseded() {
        return potentiallySuperseded;
    }

    /**
     * Sets the value of the potentiallySuperseded property.
     * 
     */
    public void setPotentiallySuperseded(boolean value) {
        this.potentiallySuperseded = value;
    }

    /**
     * Gets the value of the potentiallySupersededTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getPotentiallySupersededTime() {
        return potentiallySupersededTime;
    }

    /**
     * Sets the value of the potentiallySupersededTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setPotentiallySupersededTime(TimeType value) {
        this.potentiallySupersededTime = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

}
