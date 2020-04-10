
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The TargetReduction object is used by a Demand Response service provider to provide a RECOMMENDED threshold that a device/premises should maintain its consumption below. For example, a service provider can provide a RECOMMENDED threshold of some kWh for a 3-hour event. This means that the device/premises would maintain its consumption below the specified limit for the specified period.
 * 
 * <p>Java class for TargetReduction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetReduction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://zigbee.org/sep}UnitType"/>
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
@XmlType(name = "TargetReduction", propOrder = {
    "type",
    "value"
})
public class TargetReduction {

    @XmlElement(required = true)
    protected UnitType type;
    protected int value;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link UnitType }
     *     
     */
    public UnitType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitType }
     *     
     */
    public void setType(UnitType value) {
        this.type = value;
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
