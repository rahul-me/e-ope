
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a setpoint for Displacement Power Factor, the ratio between apparent and active powers at the fundamental frequency (e.g. 60 Hz).
 * 
 * <p>Java class for FixedPowerFactor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FixedPowerFactor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="displacement" type="{http://zigbee.org/sep}Int16"/>
 *         &lt;element name="multiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixedPowerFactor", propOrder = {
    "displacement",
    "multiplier"
})
public class FixedPowerFactor {

    protected short displacement;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType multiplier;

    /**
     * Gets the value of the displacement property.
     * 
     */
    public short getDisplacement() {
        return displacement;
    }

    /**
     * Sets the value of the displacement property.
     * 
     */
    public void setDisplacement(short value) {
        this.displacement = value;
    }

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

}
