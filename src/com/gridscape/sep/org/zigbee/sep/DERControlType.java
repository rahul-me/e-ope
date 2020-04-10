
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Control modes supported by the DER.  Bit positions SHALL be defined as follows:
 *  0 - Volt-VAr Mode 
 *  1 - Frequency-Watt Mode 
 *  2 - Watt-PowerFactor Mode 
 *  3 - Volt-Watt Mode 
 *  4 - Low Voltage Ride Through Mode 
 *  5 - High Voltage Ride Through Mode
 *  6-9 - reserved 
 *  10 - setGenConnect
 *  11 - setStorConnect
 *  12 - Fixed W
 *  13 - Fixed VAr
 *  14 - Fixed PF
 *  15 - Charge mode
 *  16 - Discharge mode
 * All other values reserved.
 * 
 * <p>Java class for DERControlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERControlType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>HexBinary32">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERControlType", propOrder = {
    "value"
})
public class DERControlType {

    @XmlValue
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] value;

    /**
     * A 32-bit field encoded as a hex string (8 hex characters max). Where applicable, bit 0, or the least significant bit, goes on the right. Note that hexBinary requires pairs of hex characters, so an odd number of characters requires a leading "0".
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(byte[] value) {
        this.value = value;
    }

}
