
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the applicable charges for a single component of the rate, which could be generation price or consumption price, for example.
 * 
 * <p>Java class for RateComponent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RateComponent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ActiveTimeTariffIntervalListLink" type="{http://zigbee.org/sep}ActiveTimeTariffIntervalListLink" minOccurs="0"/>
 *         &lt;element name="flowRateEndLimit" type="{http://zigbee.org/sep}UnitValueType" minOccurs="0"/>
 *         &lt;element name="flowRateStartLimit" type="{http://zigbee.org/sep}UnitValueType" minOccurs="0"/>
 *         &lt;element name="ReadingTypeLink" type="{http://zigbee.org/sep}ReadingTypeLink"/>
 *         &lt;element name="roleFlags" type="{http://zigbee.org/sep}RoleFlagsType"/>
 *         &lt;element name="TimeTariffIntervalListLink" type="{http://zigbee.org/sep}TimeTariffIntervalListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateComponent", propOrder = {
    "activeTimeTariffIntervalListLink",
    "flowRateEndLimit",
    "flowRateStartLimit",
    "readingTypeLink",
    "roleFlags",
    "timeTariffIntervalListLink"
})
public class RateComponent
    extends IdentifiedObject
{

    @XmlElement(name = "ActiveTimeTariffIntervalListLink")
    protected ActiveTimeTariffIntervalListLink activeTimeTariffIntervalListLink;
    protected UnitValueType flowRateEndLimit;
    protected UnitValueType flowRateStartLimit;
    @XmlElement(name = "ReadingTypeLink", required = true)
    protected ReadingTypeLink readingTypeLink;
    @XmlElement(required = true)
    protected RoleFlagsType roleFlags;
    @XmlElement(name = "TimeTariffIntervalListLink")
    protected TimeTariffIntervalListLink timeTariffIntervalListLink;

    /**
     * Gets the value of the activeTimeTariffIntervalListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveTimeTariffIntervalListLink }
     *     
     */
    public ActiveTimeTariffIntervalListLink getActiveTimeTariffIntervalListLink() {
        return activeTimeTariffIntervalListLink;
    }

    /**
     * Sets the value of the activeTimeTariffIntervalListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveTimeTariffIntervalListLink }
     *     
     */
    public void setActiveTimeTariffIntervalListLink(ActiveTimeTariffIntervalListLink value) {
        this.activeTimeTariffIntervalListLink = value;
    }

    /**
     * Gets the value of the flowRateEndLimit property.
     * 
     * @return
     *     possible object is
     *     {@link UnitValueType }
     *     
     */
    public UnitValueType getFlowRateEndLimit() {
        return flowRateEndLimit;
    }

    /**
     * Sets the value of the flowRateEndLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitValueType }
     *     
     */
    public void setFlowRateEndLimit(UnitValueType value) {
        this.flowRateEndLimit = value;
    }

    /**
     * Gets the value of the flowRateStartLimit property.
     * 
     * @return
     *     possible object is
     *     {@link UnitValueType }
     *     
     */
    public UnitValueType getFlowRateStartLimit() {
        return flowRateStartLimit;
    }

    /**
     * Sets the value of the flowRateStartLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitValueType }
     *     
     */
    public void setFlowRateStartLimit(UnitValueType value) {
        this.flowRateStartLimit = value;
    }

    /**
     * Gets the value of the readingTypeLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingTypeLink }
     *     
     */
    public ReadingTypeLink getReadingTypeLink() {
        return readingTypeLink;
    }

    /**
     * Sets the value of the readingTypeLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingTypeLink }
     *     
     */
    public void setReadingTypeLink(ReadingTypeLink value) {
        this.readingTypeLink = value;
    }

    /**
     * Gets the value of the roleFlags property.
     * 
     * @return
     *     possible object is
     *     {@link RoleFlagsType }
     *     
     */
    public RoleFlagsType getRoleFlags() {
        return roleFlags;
    }

    /**
     * Sets the value of the roleFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleFlagsType }
     *     
     */
    public void setRoleFlags(RoleFlagsType value) {
        this.roleFlags = value;
    }

    /**
     * Gets the value of the timeTariffIntervalListLink property.
     * 
     * @return
     *     possible object is
     *     {@link TimeTariffIntervalListLink }
     *     
     */
    public TimeTariffIntervalListLink getTimeTariffIntervalListLink() {
        return timeTariffIntervalListLink;
    }

    /**
     * Sets the value of the timeTariffIntervalListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeTariffIntervalListLink }
     *     
     */
    public void setTimeTariffIntervalListLink(TimeTariffIntervalListLink value) {
        this.timeTariffIntervalListLink = value;
    }

}
