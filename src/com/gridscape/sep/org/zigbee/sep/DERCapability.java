
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Distributed energy resource type and nameplate ratings.
 * 
 * <p>Java class for DERCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="modesSupported" type="{http://zigbee.org/sep}DERControlType"/>
 *         &lt;element name="rtgA" type="{http://zigbee.org/sep}CurrentRMS"/>
 *         &lt;element name="rtgAh" type="{http://zigbee.org/sep}AmpereHour" minOccurs="0"/>
 *         &lt;element name="rtgMaxChargeRate" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *         &lt;element name="rtgMaxDischargeRate" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *         &lt;element name="rtgMinPF" type="{http://zigbee.org/sep}UnsignedFixedPointType" minOccurs="0"/>
 *         &lt;element name="rtgMinPFNeg" type="{http://zigbee.org/sep}FixedPointType" minOccurs="0"/>
 *         &lt;element name="rtgVA" type="{http://zigbee.org/sep}ApparentPower" minOccurs="0"/>
 *         &lt;element name="rtgVAr" type="{http://zigbee.org/sep}ReactivePower" minOccurs="0"/>
 *         &lt;element name="rtgVArNeg" type="{http://zigbee.org/sep}ReactivePower" minOccurs="0"/>
 *         &lt;element name="rtgW" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="rtgWh" type="{http://zigbee.org/sep}WattHour" minOccurs="0"/>
 *         &lt;element name="type" type="{http://zigbee.org/sep}DERType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERCapability", propOrder = {
    "modesSupported",
    "rtgA",
    "rtgAh",
    "rtgMaxChargeRate",
    "rtgMaxDischargeRate",
    "rtgMinPF",
    "rtgMinPFNeg",
    "rtgVA",
    "rtgVAr",
    "rtgVArNeg",
    "rtgW",
    "rtgWh",
    "type"
})
@XmlRootElement(name = "DERCapability")
public class DERCapability
    extends Resource
{

    @XmlElement(required = true)
    protected DERControlType modesSupported;
    @XmlElement(required = true)
    protected CurrentRMS rtgA;
    protected AmpereHour rtgAh;
    protected ActivePower rtgMaxChargeRate;
    protected ActivePower rtgMaxDischargeRate;
    protected UnsignedFixedPointType rtgMinPF;
    protected FixedPointType rtgMinPFNeg;
    protected ApparentPower rtgVA;
    protected ReactivePower rtgVAr;
    protected ReactivePower rtgVArNeg;
    @XmlElement(required = true)
    protected ActivePower rtgW;
    protected WattHour rtgWh;
    @XmlElement(required = true)
    protected DERType type;

    /**
     * Gets the value of the modesSupported property.
     * 
     * @return
     *     possible object is
     *     {@link DERControlType }
     *     
     */
    public DERControlType getModesSupported() {
        return modesSupported;
    }

    /**
     * Sets the value of the modesSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERControlType }
     *     
     */
    public void setModesSupported(DERControlType value) {
        this.modesSupported = value;
    }

    /**
     * Gets the value of the rtgA property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentRMS }
     *     
     */
    public CurrentRMS getRtgA() {
        return rtgA;
    }

    /**
     * Sets the value of the rtgA property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentRMS }
     *     
     */
    public void setRtgA(CurrentRMS value) {
        this.rtgA = value;
    }

    /**
     * Gets the value of the rtgAh property.
     * 
     * @return
     *     possible object is
     *     {@link AmpereHour }
     *     
     */
    public AmpereHour getRtgAh() {
        return rtgAh;
    }

    /**
     * Sets the value of the rtgAh property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmpereHour }
     *     
     */
    public void setRtgAh(AmpereHour value) {
        this.rtgAh = value;
    }

    /**
     * Gets the value of the rtgMaxChargeRate property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getRtgMaxChargeRate() {
        return rtgMaxChargeRate;
    }

    /**
     * Sets the value of the rtgMaxChargeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setRtgMaxChargeRate(ActivePower value) {
        this.rtgMaxChargeRate = value;
    }

    /**
     * Gets the value of the rtgMaxDischargeRate property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getRtgMaxDischargeRate() {
        return rtgMaxDischargeRate;
    }

    /**
     * Sets the value of the rtgMaxDischargeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setRtgMaxDischargeRate(ActivePower value) {
        this.rtgMaxDischargeRate = value;
    }

    /**
     * Gets the value of the rtgMinPF property.
     * 
     * @return
     *     possible object is
     *     {@link UnsignedFixedPointType }
     *     
     */
    public UnsignedFixedPointType getRtgMinPF() {
        return rtgMinPF;
    }

    /**
     * Sets the value of the rtgMinPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnsignedFixedPointType }
     *     
     */
    public void setRtgMinPF(UnsignedFixedPointType value) {
        this.rtgMinPF = value;
    }

    /**
     * Gets the value of the rtgMinPFNeg property.
     * 
     * @return
     *     possible object is
     *     {@link FixedPointType }
     *     
     */
    public FixedPointType getRtgMinPFNeg() {
        return rtgMinPFNeg;
    }

    /**
     * Sets the value of the rtgMinPFNeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedPointType }
     *     
     */
    public void setRtgMinPFNeg(FixedPointType value) {
        this.rtgMinPFNeg = value;
    }

    /**
     * Gets the value of the rtgVA property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPower }
     *     
     */
    public ApparentPower getRtgVA() {
        return rtgVA;
    }

    /**
     * Sets the value of the rtgVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPower }
     *     
     */
    public void setRtgVA(ApparentPower value) {
        this.rtgVA = value;
    }

    /**
     * Gets the value of the rtgVAr property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePower }
     *     
     */
    public ReactivePower getRtgVAr() {
        return rtgVAr;
    }

    /**
     * Sets the value of the rtgVAr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePower }
     *     
     */
    public void setRtgVAr(ReactivePower value) {
        this.rtgVAr = value;
    }

    /**
     * Gets the value of the rtgVArNeg property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePower }
     *     
     */
    public ReactivePower getRtgVArNeg() {
        return rtgVArNeg;
    }

    /**
     * Sets the value of the rtgVArNeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePower }
     *     
     */
    public void setRtgVArNeg(ReactivePower value) {
        this.rtgVArNeg = value;
    }

    /**
     * Gets the value of the rtgW property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getRtgW() {
        return rtgW;
    }

    /**
     * Sets the value of the rtgW property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setRtgW(ActivePower value) {
        this.rtgW = value;
    }

    /**
     * Gets the value of the rtgWh property.
     * 
     * @return
     *     possible object is
     *     {@link WattHour }
     *     
     */
    public WattHour getRtgWh() {
        return rtgWh;
    }

    /**
     * Sets the value of the rtgWh property.
     * 
     * @param value
     *     allowed object is
     *     {@link WattHour }
     *     
     */
    public void setRtgWh(WattHour value) {
        this.rtgWh = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link DERType }
     *     
     */
    public DERType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERType }
     *     
     */
    public void setType(DERType value) {
        this.type = value;
    }

}
