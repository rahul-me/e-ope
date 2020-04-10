
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Used for signed percentages, specified in hundredths of a percent, -10000 - 10000. (10000 = 100%)
 * 
 * <p>Java class for SignedPerCent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SignedPerCent">
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
@XmlType(name = "SignedPerCent", propOrder = {
    "value"
})
public class SignedPerCent {

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
