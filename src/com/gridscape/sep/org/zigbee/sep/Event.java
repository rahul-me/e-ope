
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An Event indicates information that applies to a particular period of time. Events SHALL be executed relative to the time of the server, as described in the Time function set section 11.1.
 * 
 * <p>Java class for Event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Event">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}RespondableSubscribableIdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="creationTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="EventStatus" type="{http://zigbee.org/sep}EventStatus"/>
 *         &lt;element name="interval" type="{http://zigbee.org/sep}DateTimeInterval"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
    "creationTime",
    "eventStatus",
    "interval"
})
@XmlSeeAlso({
    AbstractFlowReservation.class,
    FlowReservationResponse.class,
    RandomizableEvent.class,
    TextMessage.class
})
public class Event
    extends RespondableSubscribableIdentifiedObject
{

    @XmlElement(required = true)
    protected TimeType creationTime;
    @XmlElement(name = "EventStatus", required = true)
    protected EventStatus eventStatus;
    @XmlElement(required = true)
    protected DateTimeInterval interval;

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreationTime(TimeType value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the eventStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EventStatus }
     *     
     */
    public EventStatus getEventStatus() {
        return eventStatus;
    }

    /**
     * Sets the value of the eventStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventStatus }
     *     
     */
    public void setEventStatus(EventStatus value) {
        this.eventStatus = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setInterval(DateTimeInterval value) {
        this.interval = value;
    }

}
