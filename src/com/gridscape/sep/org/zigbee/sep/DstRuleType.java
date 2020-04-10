
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Bit map encoded rule from which is calculated the start or end time, within the current year, to which daylight savings time offset must be applied. 
 * 
 * The rule encoding:
 * Bits  0 - 11: seconds 0 - 3599
 * Bits 12 - 16: hours 0 - 23
 * Bits 17 - 19: day of the week 0 = not applicable, 1 - 7 (Monday = 1)
 * Bits:20 - 24: day of the month 0 = not applicable, 1 - 31
 * Bits: 25 - 27: operator  (detailed below)
 * Bits: 28 - 31: month 1 - 12
 * 
 * Rule value of 0xFFFFFFFF means rule processing/DST correction is disabled.
 * 
 * The operators:
 * 
 *  0: DST starts/ends on the Day of the Month
 *  1: DST starts/ends on the Day of the Week that is on or after the Day of the Month
 *  2: DST starts/ends on the first occurrence of the Day of the Week in a month
 *  3: DST starts/ends on the second occurrence of the Day of the Week in a month
 *  4: DST starts/ends on the third occurrence of the Day of the Week in a month
 *  5: DST starts/ends on the forth occurrence of the Day of the Week in a month
 *  6: DST starts/ends on the fifth occurrence of the Day of the Week in a month
 *  7: DST starts/ends on the last occurrence of the Day of the Week in a month
 * 
 * An example: DST starts on third Friday in March at 1:45 AM.  The rule...
 * Seconds: 2700
 * Hours: 1
 * Day of Week: 5
 * Day of Month: 0
 * Operator: 4
 * Month: 3
 * 
 * <p>Java class for DstRuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DstRuleType">
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
@XmlType(name = "DstRuleType", propOrder = {
    "value"
})
public class DstRuleType {

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
