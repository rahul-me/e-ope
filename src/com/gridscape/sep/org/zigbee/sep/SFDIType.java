
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Unsigned integer, max inclusive 687194767359, which is 2^36-1 (68719476735), with added check digit. See Section 8.3.2 for check digit calculation.
 * 
 * <p>Java class for SFDIType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SFDIType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>UInt40">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SFDIType", propOrder = {
    "value"
})
public class SFDIType {

    @XmlValue
    protected long value;

    /**
     * Unsigned integer, max inclusive 1099511627775 (2^40-1)
     * 
     */
    public long getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(long value) {
        this.value = value;
    }

}
