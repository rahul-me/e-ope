
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Registration represents an authorization to access the resources on a host.
 * 
 * <p>Java class for Registration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Registration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="dateTimeRegistered" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="pIN" type="{http://zigbee.org/sep}PINType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Registration", propOrder = {
    "dateTimeRegistered",
    "pin"
})
@XmlRootElement(name = "Registration")
public class Registration
    extends Resource
{

    @XmlElement(required = true)
    protected TimeType dateTimeRegistered;
    @XmlElement(name = "pIN", required = true)
    protected PINType pin;

    /**
     * Gets the value of the dateTimeRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getDateTimeRegistered() {
        return dateTimeRegistered;
    }

    /**
     * Sets the value of the dateTimeRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setDateTimeRegistered(TimeType value) {
        this.dateTimeRegistered = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link PINType }
     *     
     */
    public PINType getPIN() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link PINType }
     *     
     */
    public void setPIN(PINType value) {
        this.pin = value;
    }

}
