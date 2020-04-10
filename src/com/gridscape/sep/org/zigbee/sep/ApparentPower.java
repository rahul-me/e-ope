
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The apparent power S (in VA) is the product of root mean square (RMS) voltage and RMS current.
 * 
 * <p>Java class for ApparentPower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApparentPower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="multiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *         &lt;element name="value" type="{http://zigbee.org/sep}UInt16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApparentPower", propOrder = {
    "multiplier",
    "value"
})
public class ApparentPower {

    @XmlElement(required = true)
    protected PowerOfTenMultiplierType multiplier;
    protected int value;

    /**
     * Gets the value of the multiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setMultiplier(PowerOfTenMultiplierType value) {
        this.multiplier = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
