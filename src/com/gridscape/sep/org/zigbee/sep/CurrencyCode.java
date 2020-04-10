
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Follows codes defined in [ISO 4217]. 
 *  0 - Not Applicable (default, if not specified)
 *  36 - Australian Dollar
 *  124 - Canadian Dollar
 *  840 - US Dollar
 *  978 - Euro
 * This is not a complete list.
 * 
 * <p>Java class for CurrencyCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrencyCode">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>UInt16">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyCode", propOrder = {
    "value"
})
public class CurrencyCode {

    @XmlValue
    protected int value;

    /**
     * Unsigned integer, max inclusive 65535 (2^16-1)
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
