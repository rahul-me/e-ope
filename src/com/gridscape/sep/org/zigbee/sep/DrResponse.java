
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A response to a Demand Response Load Control (EndDeviceControl) message.
 * 
 * <p>Java class for DrResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Response">
 *       &lt;sequence>
 *         &lt;element name="ApplianceLoadReduction" type="{http://zigbee.org/sep}ApplianceLoadReduction" minOccurs="0"/>
 *         &lt;element name="AppliedTargetReduction" type="{http://zigbee.org/sep}AppliedTargetReduction" minOccurs="0"/>
 *         &lt;element name="DutyCycle" type="{http://zigbee.org/sep}DutyCycle" minOccurs="0"/>
 *         &lt;element name="Offset" type="{http://zigbee.org/sep}Offset" minOccurs="0"/>
 *         &lt;element name="overrideDuration" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="SetPoint" type="{http://zigbee.org/sep}SetPoint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrResponse", propOrder = {
    "applianceLoadReduction",
    "appliedTargetReduction",
    "dutyCycle",
    "offset",
    "overrideDuration",
    "setPoint"
})
public class DrResponse
    extends Response
{

    @XmlElement(name = "ApplianceLoadReduction")
    protected ApplianceLoadReduction applianceLoadReduction;
    @XmlElement(name = "AppliedTargetReduction")
    protected AppliedTargetReduction appliedTargetReduction;
    @XmlElement(name = "DutyCycle")
    protected DutyCycle dutyCycle;
    @XmlElement(name = "Offset")
    protected Offset offset;
    protected Integer overrideDuration;
    @XmlElement(name = "SetPoint")
    protected SetPoint setPoint;

    /**
     * Gets the value of the applianceLoadReduction property.
     * 
     * @return
     *     possible object is
     *     {@link ApplianceLoadReduction }
     *     
     */
    public ApplianceLoadReduction getApplianceLoadReduction() {
        return applianceLoadReduction;
    }

    /**
     * Sets the value of the applianceLoadReduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplianceLoadReduction }
     *     
     */
    public void setApplianceLoadReduction(ApplianceLoadReduction value) {
        this.applianceLoadReduction = value;
    }

    /**
     * Gets the value of the appliedTargetReduction property.
     * 
     * @return
     *     possible object is
     *     {@link AppliedTargetReduction }
     *     
     */
    public AppliedTargetReduction getAppliedTargetReduction() {
        return appliedTargetReduction;
    }

    /**
     * Sets the value of the appliedTargetReduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppliedTargetReduction }
     *     
     */
    public void setAppliedTargetReduction(AppliedTargetReduction value) {
        this.appliedTargetReduction = value;
    }

    /**
     * Gets the value of the dutyCycle property.
     * 
     * @return
     *     possible object is
     *     {@link DutyCycle }
     *     
     */
    public DutyCycle getDutyCycle() {
        return dutyCycle;
    }

    /**
     * Sets the value of the dutyCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link DutyCycle }
     *     
     */
    public void setDutyCycle(DutyCycle value) {
        this.dutyCycle = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Offset }
     *     
     */
    public Offset getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offset }
     *     
     */
    public void setOffset(Offset value) {
        this.offset = value;
    }

    /**
     * Gets the value of the overrideDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverrideDuration() {
        return overrideDuration;
    }

    /**
     * Sets the value of the overrideDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverrideDuration(Integer value) {
        this.overrideDuration = value;
    }

    /**
     * Gets the value of the setPoint property.
     * 
     * @return
     *     possible object is
     *     {@link SetPoint }
     *     
     */
    public SetPoint getSetPoint() {
        return setPoint;
    }

    /**
     * Sets the value of the setPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetPoint }
     *     
     */
    public void setSetPoint(SetPoint value) {
        this.setPoint = value;
    }

}
