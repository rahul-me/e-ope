
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 *  0 - Delay Appliance Load
 * Parameter requesting the appliance to respond by providing a moderate load reduction for the duration of a delay period.  Typically referring to a “non-emergency” event in which appliances can continue operating if already in a load consuming period.
 * 
 *  1 - Temporary Appliance Load Reduction
 * Parameter requesting the appliance to respond by providing an aggressive load reduction for a short time period.  Typically referring to an “emergency/spinning reserve” event in which an appliance should start shedding load if currently in a load consuming period. 
 * 
 * * Full definition of how appliances react when receiving each parameter is document in the EPA document - ENERGY STAR® Program Requirements, Product Specification for Residential Refrigerators and Freezers, Eligibility Criteria 5, Draft 2 Version 5.0.
 * 
 * All other values reserved.
 * 
 * <p>Java class for ApplianceLoadReductionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplianceLoadReductionType">
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
@XmlType(name = "ApplianceLoadReductionType", propOrder = {
    "value"
})
public class ApplianceLoadReductionType {

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
