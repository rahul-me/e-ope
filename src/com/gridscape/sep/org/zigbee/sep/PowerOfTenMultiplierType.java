
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * -9 = nano=x10^-9
 * -6 = micro=x10^-6
 * -3 = milli=x10^-3
 *  0 = none=x1 (default, if not specified)
 *  1 = deca=x10
 *  2 = hecto=x100
 *  3 = kilo=x1000
 *  6 = Mega=x10^6
 *  9 = Giga=x10^9
 * This is not a complete list. Any integer between -9 and 9 SHALL be supported, indicating the power of ten multiplier for the units.
 * 
 * <p>Java class for PowerOfTenMultiplierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerOfTenMultiplierType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>Int8">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerOfTenMultiplierType", propOrder = {
    "value"
})
public class PowerOfTenMultiplierType {

    @XmlValue
    protected byte value;

    /**
     * Signed integer, min -128 max +127
     * 
     */
    public byte getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(byte value) {
        this.value = value;
    }

}
