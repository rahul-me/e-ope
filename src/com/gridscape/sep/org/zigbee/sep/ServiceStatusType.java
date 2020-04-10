
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 *  0 - Connected
 *  1 - Disconnected
 *  2 - Armed for Connect
 *  3 - Armed for Disconnect
 *  4 - No Contactor
 *  5 - Load Limited
 * All other values reserved.
 * 
 * <p>Java class for ServiceStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceStatusType">
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
@XmlType(name = "ServiceStatusType", propOrder = {
    "value"
})
public class ServiceStatusType {

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
