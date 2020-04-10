
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a change to the credit type.
 * 
 * <p>Java class for CreditTypeChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditTypeChange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newType" type="{http://zigbee.org/sep}CreditTypeType"/>
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
@XmlType(name = "CreditTypeChange", propOrder = {
    "newType",
    "startTime"
})
public class CreditTypeChange {

    @XmlElement(required = true)
    protected CreditTypeType newType;
    @XmlElement(required = true)
    protected TimeType startTime;

    /**
     * Gets the value of the newType property.
     * 
     * @return
     *     possible object is
     *     {@link CreditTypeType }
     *     
     */
    public CreditTypeType getNewType() {
        return newType;
    }

    /**
     * Sets the value of the newType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTypeType }
     *     
     */
    public void setNewType(CreditTypeType value) {
        this.newType = value;
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
