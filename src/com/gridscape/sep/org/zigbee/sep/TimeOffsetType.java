
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A signed time offset, typically applied to a Time value, expressed in seconds.
 * 
 * <p>Java class for TimeOffsetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeOffsetType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>Int32">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeOffsetType", propOrder = {
    "value"
})
public class TimeOffsetType {

    @XmlValue
    protected int value;

    /**
     * Signed integer, max inclusive 2147483647 (2^31), min inclusive -2147483647 (same as xs:int)
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
