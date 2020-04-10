
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Distributed Energy Resource (DER) control values.
 * 
 * <p>Java class for DERControlBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERControlBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opModFixedFlow" type="{http://zigbee.org/sep}SignedPerCent" minOccurs="0"/>
 *         &lt;element name="opModFixedPF" type="{http://zigbee.org/sep}FixedPowerFactor" minOccurs="0"/>
 *         &lt;element name="opModFixedVAr" type="{http://zigbee.org/sep}FixedVAr" minOccurs="0"/>
 *         &lt;element name="opModFixedW" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="opModFreqWatt" type="{http://zigbee.org/sep}DERCurveLink" minOccurs="0"/>
 *         &lt;element name="opModHVRT" type="{http://zigbee.org/sep}CurvePairType" minOccurs="0"/>
 *         &lt;element name="opModLVRT" type="{http://zigbee.org/sep}CurvePairType" minOccurs="0"/>
 *         &lt;element name="opModVoltVAr" type="{http://zigbee.org/sep}DERCurveLink" minOccurs="0"/>
 *         &lt;element name="opModVoltWatt" type="{http://zigbee.org/sep}DERCurveLink" minOccurs="0"/>
 *         &lt;element name="opModWattPF" type="{http://zigbee.org/sep}DERCurveLink" minOccurs="0"/>
 *         &lt;element name="rampTms" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERControlBase", propOrder = {
    "opModFixedFlow",
    "opModFixedPF",
    "opModFixedVAr",
    "opModFixedW",
    "opModFreqWatt",
    "opModHVRT",
    "opModLVRT",
    "opModVoltVAr",
    "opModVoltWatt",
    "opModWattPF",
    "rampTms"
})
public class DERControlBase {

    protected SignedPerCent opModFixedFlow;
    protected FixedPowerFactor opModFixedPF;
    protected FixedVAr opModFixedVAr;
    protected PerCent opModFixedW;
    protected DERCurveLink opModFreqWatt;
    protected CurvePairType opModHVRT;
    protected CurvePairType opModLVRT;
    protected DERCurveLink opModVoltVAr;
    protected DERCurveLink opModVoltWatt;
    protected DERCurveLink opModWattPF;
    protected Integer rampTms;

    /**
     * Gets the value of the opModFixedFlow property.
     * 
     * @return
     *     possible object is
     *     {@link SignedPerCent }
     *     
     */
    public SignedPerCent getOpModFixedFlow() {
        return opModFixedFlow;
    }

    /**
     * Sets the value of the opModFixedFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedPerCent }
     *     
     */
    public void setOpModFixedFlow(SignedPerCent value) {
        this.opModFixedFlow = value;
    }

    /**
     * Gets the value of the opModFixedPF property.
     * 
     * @return
     *     possible object is
     *     {@link FixedPowerFactor }
     *     
     */
    public FixedPowerFactor getOpModFixedPF() {
        return opModFixedPF;
    }

    /**
     * Sets the value of the opModFixedPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedPowerFactor }
     *     
     */
    public void setOpModFixedPF(FixedPowerFactor value) {
        this.opModFixedPF = value;
    }

    /**
     * Gets the value of the opModFixedVAr property.
     * 
     * @return
     *     possible object is
     *     {@link FixedVAr }
     *     
     */
    public FixedVAr getOpModFixedVAr() {
        return opModFixedVAr;
    }

    /**
     * Sets the value of the opModFixedVAr property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedVAr }
     *     
     */
    public void setOpModFixedVAr(FixedVAr value) {
        this.opModFixedVAr = value;
    }

    /**
     * Gets the value of the opModFixedW property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getOpModFixedW() {
        return opModFixedW;
    }

    /**
     * Sets the value of the opModFixedW property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setOpModFixedW(PerCent value) {
        this.opModFixedW = value;
    }

    /**
     * Gets the value of the opModFreqWatt property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getOpModFreqWatt() {
        return opModFreqWatt;
    }

    /**
     * Sets the value of the opModFreqWatt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setOpModFreqWatt(DERCurveLink value) {
        this.opModFreqWatt = value;
    }

    /**
     * Gets the value of the opModHVRT property.
     * 
     * @return
     *     possible object is
     *     {@link CurvePairType }
     *     
     */
    public CurvePairType getOpModHVRT() {
        return opModHVRT;
    }

    /**
     * Sets the value of the opModHVRT property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurvePairType }
     *     
     */
    public void setOpModHVRT(CurvePairType value) {
        this.opModHVRT = value;
    }

    /**
     * Gets the value of the opModLVRT property.
     * 
     * @return
     *     possible object is
     *     {@link CurvePairType }
     *     
     */
    public CurvePairType getOpModLVRT() {
        return opModLVRT;
    }

    /**
     * Sets the value of the opModLVRT property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurvePairType }
     *     
     */
    public void setOpModLVRT(CurvePairType value) {
        this.opModLVRT = value;
    }

    /**
     * Gets the value of the opModVoltVAr property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getOpModVoltVAr() {
        return opModVoltVAr;
    }

    /**
     * Sets the value of the opModVoltVAr property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setOpModVoltVAr(DERCurveLink value) {
        this.opModVoltVAr = value;
    }

    /**
     * Gets the value of the opModVoltWatt property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getOpModVoltWatt() {
        return opModVoltWatt;
    }

    /**
     * Sets the value of the opModVoltWatt property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setOpModVoltWatt(DERCurveLink value) {
        this.opModVoltWatt = value;
    }

    /**
     * Gets the value of the opModWattPF property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveLink }
     *     
     */
    public DERCurveLink getOpModWattPF() {
        return opModWattPF;
    }

    /**
     * Sets the value of the opModWattPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveLink }
     *     
     */
    public void setOpModWattPF(DERCurveLink value) {
        this.opModWattPF = value;
    }

    /**
     * Gets the value of the rampTms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRampTms() {
        return rampTms;
    }

    /**
     * Sets the value of the rampTms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRampTms(Integer value) {
        this.rampTms = value;
    }

}
