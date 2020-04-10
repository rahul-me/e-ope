
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Instructs an EndDevice to perform a specified action.
 * 
 * <p>Java class for EndDeviceControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndDeviceControl">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}RandomizableEvent">
 *       &lt;sequence>
 *         &lt;element name="ApplianceLoadReduction" type="{http://zigbee.org/sep}ApplianceLoadReduction" minOccurs="0"/>
 *         &lt;element name="deviceCategory" type="{http://zigbee.org/sep}DeviceCategoryType"/>
 *         &lt;element name="drProgramMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DutyCycle" type="{http://zigbee.org/sep}DutyCycle" minOccurs="0"/>
 *         &lt;element name="loadShiftForward" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Offset" type="{http://zigbee.org/sep}Offset" minOccurs="0"/>
 *         &lt;element name="overrideDuration" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="SetPoint" type="{http://zigbee.org/sep}SetPoint" minOccurs="0"/>
 *         &lt;element name="TargetReduction" type="{http://zigbee.org/sep}TargetReduction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndDeviceControl", propOrder = {
    "applianceLoadReduction",
    "deviceCategory",
    "drProgramMandatory",
    "dutyCycle",
    "loadShiftForward",
    "offset",
    "overrideDuration",
    "setPoint",
    "targetReduction"
})
public class EndDeviceControl
    extends RandomizableEvent
{

    @XmlElement(name = "ApplianceLoadReduction")
    protected ApplianceLoadReduction applianceLoadReduction;
    @XmlElement(required = true)
    protected DeviceCategoryType deviceCategory;
    protected boolean drProgramMandatory;
    @XmlElement(name = "DutyCycle")
    protected DutyCycle dutyCycle;
    protected boolean loadShiftForward;
    @XmlElement(name = "Offset")
    protected Offset offset;
    protected Integer overrideDuration;
    @XmlElement(name = "SetPoint")
    protected SetPoint setPoint;
    @XmlElement(name = "TargetReduction")
    protected TargetReduction targetReduction;

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
     * Gets the value of the deviceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceCategoryType }
     *     
     */
    public DeviceCategoryType getDeviceCategory() {
        return deviceCategory;
    }

    /**
     * Sets the value of the deviceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceCategoryType }
     *     
     */
    public void setDeviceCategory(DeviceCategoryType value) {
        this.deviceCategory = value;
    }

    /**
     * Gets the value of the drProgramMandatory property.
     * 
     */
    public boolean isDrProgramMandatory() {
        return drProgramMandatory;
    }

    /**
     * Sets the value of the drProgramMandatory property.
     * 
     */
    public void setDrProgramMandatory(boolean value) {
        this.drProgramMandatory = value;
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
     * Gets the value of the loadShiftForward property.
     * 
     */
    public boolean isLoadShiftForward() {
        return loadShiftForward;
    }

    /**
     * Sets the value of the loadShiftForward property.
     * 
     */
    public void setLoadShiftForward(boolean value) {
        this.loadShiftForward = value;
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

    /**
     * Gets the value of the targetReduction property.
     * 
     * @return
     *     possible object is
     *     {@link TargetReduction }
     *     
     */
    public TargetReduction getTargetReduction() {
        return targetReduction;
    }

    /**
     * Sets the value of the targetReduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetReduction }
     *     
     */
    public void setTargetReduction(TargetReduction value) {
        this.targetReduction = value;
    }

}
