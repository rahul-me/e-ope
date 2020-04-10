
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Service kind
 *  0 - electricity
 *  1 - gas
 *  2 - water
 *  3 - time
 *  4 - pressure
 *  5 - heat
 *  6 - cooling
 * All other values reserved.
 * 
 * <p>Java class for ServiceKind complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceKind">
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
@XmlType(name = "ServiceKind", propOrder = {
    "value"
})
public class ServiceKind {

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
