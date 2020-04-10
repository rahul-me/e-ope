
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 *  0 = Not Applicable (default, if not specified)
 *  5 = A (Current in Amperes (RMS))
 *  6 = Kelvin (Temperature)
 *  23 = Degrees Celsius (Relative temperature)
 *  29 = Voltage
 *  31 = J (Energy joule)
 *  33 = Hz (Frequency)
 *  38 =W (Real power in Watts)
 *  42 = m3 (Cubic Meter)
 *  61 = VA (Apparent power)
 *  63 = var (Reactive power)
 *  65 = CosTheta (Displacement Power Factor)
 *  67 = V� (Volts squared)
 *  69 = A� (Amp squared)
 *  71 = VAh (Apparent energy)
 *  72 = Wh (Real energy in Watt-hours)
 *  73 = varh (Reactive energy)
 *  106 = Ah (Ampere-hours / Available Charge)
 *  119 = ft3 (Cubic Feet)
 *  122 = ft3/h (Cubic Feet per Hour)
 *  125 = m3/h (Cubic Meter per Hour)
 *  128 = US gl (US Gallons)
 *  129 = US gl/h (US Gallons per Hour)
 *  130 = IMP gl (Imperial Gallons)
 *  131 = IMP gl/h (Imperial Gallons per Hour)
 *  132 = BTU
 *  133 = BTU/h
 *  134 = Liter
 *  137 = L/h (Liters per Hour)
 *  140 = PA(gauge)
 *  155 = PA(absolute)
 *  169 = Therm
 * All other values reserved.
 * 
 * <p>Java class for UomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UomType">
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
@XmlType(name = "UomType", propOrder = {
    "value"
})
public class UomType {

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
