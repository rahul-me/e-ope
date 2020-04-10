
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A signed time offset, typically applied to a Time value, expressed in seconds, with range -3600 to 3600.
 * 
 * <p>Java class for OneHourRangeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneHourRangeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>Int16">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneHourRangeType", propOrder = {
    "value"
})
public class OneHourRangeType {

    @XmlValue
    protected short value;

    /**
     * Signed integer, min -32768 max +32767
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
