
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * DER InverterStatus value:
 *  0 - N/A
 *  1 - off
 *  2 - sleeping (auto-shutdown) or DER is at low output power/voltage
 *  3 - starting up or ON but not producing power
 *  4 - tracking MPPT power point
 *  5 - forced power reduction/derating
 *  6 - shutting down
 *  7 - one or more faults exist
 *  8 - standby (service on unit) - DER may be at high output voltage/power
 *  9 - test mode
 *  10 - as defined in manufacturer status
 * All other values reserved.
 * 
 * <p>Java class for InverterStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InverterStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="value" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InverterStatusType", propOrder = {
    "dateTime",
    "value"
})
public class InverterStatusType {

    @XmlElement(required = true)
    protected TimeType dateTime;
    protected short value;

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
     * Gets the value of the value property.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

}
