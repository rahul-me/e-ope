
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a change to the service status.
 * 
 * <p>Java class for ServiceChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceChange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newStatus" type="{http://zigbee.org/sep}ServiceStatusType"/>
 *         &lt;element name="startTime" type="{http://zigbee.org/sep}TimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceChange", propOrder = {
    "newStatus",
    "startTime"
})
public class ServiceChange {

    @XmlElement(required = true)
    protected ServiceStatusType newStatus;
    @XmlElement(required = true)
    protected TimeType startTime;

    /**
     * Gets the value of the newStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusType }
     *     
     */
    public ServiceStatusType getNewStatus() {
        return newStatus;
    }

    /**
     * Sets the value of the newStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusType }
     *     
     */
    public void setNewStatus(ServiceStatusType value) {
        this.newStatus = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setStartTime(TimeType value) {
        this.startTime = value;
    }

}
