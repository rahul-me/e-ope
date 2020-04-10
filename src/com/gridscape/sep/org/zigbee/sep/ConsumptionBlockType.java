
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 *  0 = Not Applicable (default, if not specified)
 *  1 = Block 1
 *  2 = Block 2
 *  3 = Block 3
 *  4 = Block 4
 *  5 = Block 5
 *  6 = Block 6
 *  7 = Block 7
 *  8 = Block 8
 *  9 = Block 9
 *  10 = Block 10
 *  11 = Block 11
 *  12 = Block 12
 *  13 = Block 13
 *  14 = Block 14
 *  15 = Block 15
 *  16 = Block 16
 * All other values reserved.
 * 
 * <p>Java class for ConsumptionBlockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionBlockType">
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
@XmlType(name = "ConsumptionBlockType", propOrder = {
    "value"
})
public class ConsumptionBlockType {

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
