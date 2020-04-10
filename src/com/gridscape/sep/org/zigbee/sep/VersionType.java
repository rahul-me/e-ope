
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Version SHALL indicate a distinct identifier for each revision of an IdentifiedObject. If not specified, a default version of "0" (initial version) SHALL be assumed. Upon modification of any IdentifiedObject, the mRID SHALL remain the same, but the version SHALL be incremented. Servers MAY NOT modify objects that they did not create, unless they were notified of the change from the entity controlling the object's PEN.
 * 
 * <p>Java class for VersionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionType">
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
@XmlType(name = "VersionType", propOrder = {
    "value"
})
public class VersionType {

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
