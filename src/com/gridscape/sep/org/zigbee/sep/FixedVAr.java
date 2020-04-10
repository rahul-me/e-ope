
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a signed setpoint for reactive power.
 * 
 * <p>Java class for FixedVAr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FixedVAr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refType" type="{http://zigbee.org/sep}DERUnitRefType"/>
 *         &lt;element name="value" type="{http://zigbee.org/sep}SignedPerCent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixedVAr", propOrder = {
    "refType",
    "value"
})
public class FixedVAr {

    @XmlElement(required = true)
    protected DERUnitRefType refType;
    @XmlElement(required = true)
    protected SignedPerCent value;

    /**
     * Gets the value of the refType property.
     * 
     * @return
     *     possible object is
     *     {@link DERUnitRefType }
     *     
     */
    public DERUnitRefType getRefType() {
        return refType;
    }

    /**
     * Sets the value of the refType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERUnitRefType }
     *     
     */
    public void setRefType(DERUnitRefType value) {
        this.refType = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link SignedPerCent }
     *     
     */
    public SignedPerCent getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedPerCent }
     *     
     */
    public void setValue(SignedPerCent value) {
        this.value = value;
    }

}
