
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A master resource identifier. The IANA PEN [PEN] provider ID SHALL be specified in bits 0-31, the least-significant bits, and objects created by that provider SHALL be assigned unique IDs with the remaining 96 bits. 
 *  0xFFFFFFFFFFFFFFFFFFFFFFFF[XXXXXXXX], where [XXXXXXXX] is the PEN, is reserved for a object that is being created (e.g., a ReadingSet for the current time that is still accumulating). 
 * Except for this special reserved identifier, each modification of an object (resource) representation MUST have a different "version".
 * 
 * <p>Java class for mRIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mRIDType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>HexBinary128">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mRIDType", propOrder = {
    "value"
})
public class MRIDType {

    @XmlValue
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] value;

    /**
     * A 128-bit field encoded as a hex string (32 hex characters max). Where applicable, bit 0, or the least significant bit, goes on the right. Note that hexBinary requires pairs of hex characters, so an odd number of characters requires a leading "0".
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
