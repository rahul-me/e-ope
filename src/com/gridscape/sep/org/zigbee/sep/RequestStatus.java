
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The RequestStatus object is used to indicate the current status of a Flow Reservation Request.
 * 
 * <p>Java class for RequestStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="requestStatus" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestStatus", propOrder = {
    "dateTime",
    "requestStatus"
})
public class RequestStatus {

    @XmlElement(required = true)
    protected TimeType dateTime;
    protected short requestStatus;

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
     * Gets the value of the requestStatus property.
     * 
     */
    public short getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the value of the requestStatus property.
     * 
     */
    public void setRequestStatus(short value) {
        this.requestStatus = value;
    }

}
