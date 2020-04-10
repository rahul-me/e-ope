
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 *  0 = Not Applicable (default, if not specified)
 *  32 = Phase C (and S2)
 *  33 = Phase CN (and S2N)
 *  40 = Phase CA
 *  64 = Phase B
 *  65 = Phase BN
 *  66 = Phase BC
 *  128 = Phase A (and S1)
 *  129 = Phase AN (and S1N)
 *  132 = Phase AB
 *  224 = Phase ABC
 * All other values reserved.
 * 
 * <p>Java class for PhaseCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhaseCode">
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
@XmlType(name = "PhaseCode", propOrder = {
    "value"
})
public class PhaseCode {

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
