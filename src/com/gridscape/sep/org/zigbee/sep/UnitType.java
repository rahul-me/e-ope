
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The unit types defined for end device control target reductions.
 *  0 - kWh 
 *  1 - kW  
 *  2 - Watts 
 *  3 - Cubic Meters 
 *  4 - Cubic Feet 
 *  5 - US Gallons 
 *  6 - Imperial Gallons 
 *  7 - BTUs 
 *  8 - Liters 
 *  9 - kPA (gauge) 
 *  10 - kPA (absolute)  
 *  11 - Mega Joule 
 *  12 - Unitless
 * All other values reserved.
 * 
 * <p>Java class for UnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnitType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>UInt8">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitType", propOrder = {
    "value"
})
public class UnitType {

    @XmlValue
    protected short value;

    /**
     * Unsigned integer, max inclusive 255 (2^8-1)
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
