
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * The SetPoint object is used to apply specific temperature set points to a temperature control device. The values of the heatingSetpoint and coolingSetpoint attributes SHALL be calculated as follows:
 * Cooling/Heating Temperature Set Point / 100 = temperature in degrees Celsius where -273.15�C &lt;= temperature &lt;= 327.67�C, corresponding to a Cooling and/or Heating Temperature Set Point. The maximum resolution this format allows is 0.01�C. 
 * The field not present in a Response indicates that this field has not been used by the end device. 
 * If a temperature is sent that exceeds the temperature limit boundaries that are programmed into the device, the device SHALL respond by setting the temperature at the limit.
 * 
 * <p>Java class for SetPoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetPoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coolingSetpoint" type="{http://zigbee.org/sep}Int16" minOccurs="0"/>
 *         &lt;element name="heatingSetpoint" type="{http://zigbee.org/sep}Int16" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetPoint", propOrder = {
    "coolingSetpoint",
    "heatingSetpoint"
})
public class SetPoint {

    protected Short coolingSetpoint;
    protected Short heatingSetpoint;

    /**
     * Gets the value of the coolingSetpoint property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCoolingSetpoint() {
        return coolingSetpoint;
    }

    /**
     * Sets the value of the coolingSetpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCoolingSetpoint(Short value) {
        this.coolingSetpoint = value;
    }

    /**
     * Gets the value of the heatingSetpoint property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getHeatingSetpoint() {
        return heatingSetpoint;
    }

    /**
     * Sets the value of the heatingSetpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setHeatingSetpoint(Short value) {
        this.heatingSetpoint = value;
    }

}
