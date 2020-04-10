
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Indicates a condition that must be satisfied for the Notification to be triggered.
 * 
 * <p>Java class for Condition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Condition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributeIdentifier" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="lowerThreshold" type="{http://zigbee.org/sep}Int48"/>
 *         &lt;element name="upperThreshold" type="{http://zigbee.org/sep}Int48"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condition", propOrder = {
    "attributeIdentifier",
    "lowerThreshold",
    "upperThreshold"
})
public class Condition {

    protected short attributeIdentifier;
    protected long lowerThreshold;
    protected long upperThreshold;

    /**
     * Gets the value of the attributeIdentifier property.
     * 
     */
    public short getAttributeIdentifier() {
        return attributeIdentifier;
    }

    /**
     * Sets the value of the attributeIdentifier property.
     * 
     */
    public void setAttributeIdentifier(short value) {
        this.attributeIdentifier = value;
    }

    /**
     * Gets the value of the lowerThreshold property.
     * 
     */
    public long getLowerThreshold() {
        return lowerThreshold;
    }

    /**
     * Sets the value of the lowerThreshold property.
     * 
     */
    public void setLowerThreshold(long value) {
        this.lowerThreshold = value;
    }

    /**
     * Gets the value of the upperThreshold property.
     * 
     */
    public long getUpperThreshold() {
        return upperThreshold;
    }

    /**
     * Sets the value of the upperThreshold property.
     * 
     */
    public void setUpperThreshold(long value) {
        this.upperThreshold = value;
    }

}
