
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Specifies the roles that apply to a usage point.
 * Bit 0 - isMirror - SHALL be set if the server is not the measurement device
 * Bit 1 - isPremisesAggregationPoint - SHALL be set if the UsagePoint is the point of delivery for a premises
 * Bit 2 - isPEV - SHALL be set if the usage applies to an electric vehicle
 * Bit 3 - isDER - SHALL be set if the usage applies to a distributed energy resource, capable of delivering power to the grid.
 * Bit 4 - isRevenueQuality - SHALL be set if usage was measured by a device certified as revenue quality
 * Bit 5 - isDC - SHALL be set if the usage point measures direct current 
 * Bit 6 - isSubmeter - SHALL be set if the usage point is not a premises aggregation point
 * Bit 7-15 - Reserved
 * 
 * <p>Java class for RoleFlagsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoleFlagsType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://zigbee.org/sep>HexBinary16">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleFlagsType", propOrder = {
    "value"
})
public class RoleFlagsType {

    @XmlValue
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] value;

    /**
     * A 16-bit field encoded as a hex string (4 hex characters max). Where applicable, bit 0, or the least significant bit, goes on the right. Note that hexBinary requires pairs of hex characters, so an odd number of characters requires a leading "0".
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
