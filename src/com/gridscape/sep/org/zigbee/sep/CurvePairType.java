
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a pair of DERCurves.
 * 
 * <p>Java class for CurvePairType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurvePairType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lowerLimit" type="{http://zigbee.org/sep}DERCurveLink"/>
 *         &lt;element name="upperLimit" type="{http://zigbee.org/sep}DERCurveLink"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurvePairType", propOrder = {
    "lowerLimit",
    "upperLimit"
})
public class CurvePairType {

    @XmlElement(required = true)
    protected DERCurveLink lowerLimit;
    @XmlElement(required = true)
    protected DERCurveLink upperLimit;

    /**
     * Gets the value of the lowerLimit property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Sets the value of the lowerLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setLowerLimit(DERCurveLink value) {
        this.lowerLimit = value;
    }

    /**
     * Gets the value of the upperLimit property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getUpperLimit() {
        return upperLimit;
    }

    /**
     * Sets the value of the upperLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setUpperLimit(DERCurveLink value) {
        this.upperLimit = value;
    }

}
