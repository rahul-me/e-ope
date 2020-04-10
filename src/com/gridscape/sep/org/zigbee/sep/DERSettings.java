
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Distributed energy resource settings
 * 
 * <p>Java class for DERSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERSettings">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="setGenConnect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="setGradW" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="setMaxChargeRate" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *         &lt;element name="setMaxDischargeRate" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *         &lt;element name="setMaxVA" type="{http://zigbee.org/sep}ApparentPower" minOccurs="0"/>
 *         &lt;element name="setMaxVAr" type="{http://zigbee.org/sep}ReactivePower" minOccurs="0"/>
 *         &lt;element name="setMaxVArNeg" type="{http://zigbee.org/sep}ReactivePower" minOccurs="0"/>
 *         &lt;element name="setMaxW" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="setMinPF" type="{http://zigbee.org/sep}UnsignedFixedPointType" minOccurs="0"/>
 *         &lt;element name="setMinPFNeg" type="{http://zigbee.org/sep}FixedPointType" minOccurs="0"/>
 *         &lt;element name="setStorConnect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="setVRef" type="{http://zigbee.org/sep}VoltageRMS" minOccurs="0"/>
 *         &lt;element name="setVRefOfs" type="{http://zigbee.org/sep}VoltageRMS" minOccurs="0"/>
 *         &lt;element name="updatedTime" type="{http://zigbee.org/sep}TimeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERSettings", propOrder = {
    "setGenConnect",
    "setGradW",
    "setMaxChargeRate",
    "setMaxDischargeRate",
    "setMaxVA",
    "setMaxVAr",
    "setMaxVArNeg",
    "setMaxW",
    "setMinPF",
    "setMinPFNeg",
    "setStorConnect",
    "setVRef",
    "setVRefOfs",
    "updatedTime"
})
@XmlRootElement(name = "DERSettings")
public class DERSettings
    extends SubscribableResource
{

    protected Boolean setGenConnect;
    protected int setGradW;
    protected ActivePower setMaxChargeRate;
    protected ActivePower setMaxDischargeRate;
    protected ApparentPower setMaxVA;
    protected ReactivePower setMaxVAr;
    protected ReactivePower setMaxVArNeg;
    @XmlElement(required = true)
    protected ActivePower setMaxW;
    protected UnsignedFixedPointType setMinPF;
    protected FixedPointType setMinPFNeg;
    protected Boolean setStorConnect;
    protected VoltageRMS setVRef;
    protected VoltageRMS setVRefOfs;
    @XmlElement(required = true)
    protected TimeType updatedTime;

    /**
     * Gets the value of the setGenConnect property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSetGenConnect() {
        return setGenConnect;
    }

    /**
     * Sets the value of the setGenConnect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSetGenConnect(Boolean value) {
        this.setGenConnect = value;
    }

    /**
     * Gets the value of the setGradW property.
     * 
     */
    public int getSetGradW() {
        return setGradW;
    }

    /**
     * Sets the value of the setGradW property.
     * 
     */
    public void setSetGradW(int value) {
        this.setGradW = value;
    }

    /**
     * Gets the value of the setMaxChargeRate property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getSetMaxChargeRate() {
        return setMaxChargeRate;
    }

    /**
     * Sets the value of the setMaxChargeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setSetMaxChargeRate(ActivePower value) {
        this.setMaxChargeRate = value;
    }

    /**
     * Gets the value of the setMaxDischargeRate property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getSetMaxDischargeRate() {
        return setMaxDischargeRate;
    }

    /**
     * Sets the value of the setMaxDischargeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setSetMaxDischargeRate(ActivePower value) {
        this.setMaxDischargeRate = value;
    }

    /**
     * Gets the value of the setMaxVA property.
     * 
     * @return
     *     possible object is
     *     {@link ApparentPower }
     *     
     */
    public ApparentPower getSetMaxVA() {
        return setMaxVA;
    }

    /**
     * Sets the value of the setMaxVA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApparentPower }
     *     
     */
    public void setSetMaxVA(ApparentPower value) {
        this.setMaxVA = value;
    }

    /**
     * Gets the value of the setMaxVAr property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePower }
     *     
     */
    public ReactivePower getSetMaxVAr() {
        return setMaxVAr;
    }

    /**
     * Sets the value of the setMaxVAr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePower }
     *     
     */
    public void setSetMaxVAr(ReactivePower value) {
        this.setMaxVAr = value;
    }

    /**
     * Gets the value of the setMaxVArNeg property.
     * 
     * @return
     *     possible object is
     *     {@link ReactivePower }
     *     
     */
    public ReactivePower getSetMaxVArNeg() {
        return setMaxVArNeg;
    }

    /**
     * Sets the value of the setMaxVArNeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReactivePower }
     *     
     */
    public void setSetMaxVArNeg(ReactivePower value) {
        this.setMaxVArNeg = value;
    }

    /**
     * Gets the value of the setMaxW property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getSetMaxW() {
        return setMaxW;
    }

    /**
     * Sets the value of the setMaxW property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setSetMaxW(ActivePower value) {
        this.setMaxW = value;
    }

    /**
     * Gets the value of the setMinPF property.
     * 
     * @return
     *     possible object is
     *     {@link UnsignedFixedPointType }
     *     
     */
    public UnsignedFixedPointType getSetMinPF() {
        return setMinPF;
    }

    /**
     * Sets the value of the setMinPF property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnsignedFixedPointType }
     *     
     */
    public void setSetMinPF(UnsignedFixedPointType value) {
        this.setMinPF = value;
    }

    /**
     * Gets the value of the setMinPFNeg property.
     * 
     * @return
     *     possible object is
     *     {@link FixedPointType }
     *     
     */
    public FixedPointType getSetMinPFNeg() {
        return setMinPFNeg;
    }

    /**
     * Sets the value of the setMinPFNeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedPointType }
     *     
     */
    public void setSetMinPFNeg(FixedPointType value) {
        this.setMinPFNeg = value;
    }

    /**
     * Gets the value of the setStorConnect property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSetStorConnect() {
        return setStorConnect;
    }

    /**
     * Sets the value of the setStorConnect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSetStorConnect(Boolean value) {
        this.setStorConnect = value;
    }

    /**
     * Gets the value of the setVRef property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageRMS }
     *     
     */
    public VoltageRMS getSetVRef() {
        return setVRef;
    }

    /**
     * Sets the value of the setVRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageRMS }
     *     
     */
    public void setSetVRef(VoltageRMS value) {
        this.setVRef = value;
    }

    /**
     * Gets the value of the setVRefOfs property.
     * 
     * @return
     *     possible object is
     *     {@link VoltageRMS }
     *     
     */
    public VoltageRMS getSetVRefOfs() {
        return setVRefOfs;
    }

    /**
     * Sets the value of the setVRefOfs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoltageRMS }
     *     
     */
    public void setSetVRefOfs(VoltageRMS value) {
        this.setVRefOfs = value;
    }

    /**
     * Gets the value of the updatedTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getUpdatedTime() {
        return updatedTime;
    }

    /**
     * Sets the value of the updatedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setUpdatedTime(TimeType value) {
        this.updatedTime = value;
    }

}
