
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Returned by the URI provided by DNS-SD, to allow clients to find the URIs to the resources in which they are interested.
 * 
 * <p>Java class for DeviceCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}FunctionSetAssignmentsBase">
 *       &lt;sequence>
 *         &lt;element name="EndDeviceListLink" type="{http://zigbee.org/sep}EndDeviceListLink" minOccurs="0"/>
 *         &lt;element name="MirrorUsagePointListLink" type="{http://zigbee.org/sep}MirrorUsagePointListLink" minOccurs="0"/>
 *         &lt;element name="SelfDeviceLink" type="{http://zigbee.org/sep}SelfDeviceLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceCapability", propOrder = {
    "endDeviceListLink",
    "mirrorUsagePointListLink",
    "selfDeviceLink"
})
@XmlRootElement(name = "DeviceCapability")
public class DeviceCapability
    extends FunctionSetAssignmentsBase
{

    @XmlElement(name = "EndDeviceListLink")
    protected EndDeviceListLink endDeviceListLink;
    @XmlElement(name = "MirrorUsagePointListLink")
    protected MirrorUsagePointListLink mirrorUsagePointListLink;
    @XmlElement(name = "SelfDeviceLink")
    protected SelfDeviceLink selfDeviceLink;

    /**
     * Gets the value of the endDeviceListLink property.
     * 
     * @return
     *     possible object is
     *     {@link EndDeviceListLink }
     *     
     */
    public EndDeviceListLink getEndDeviceListLink() {
        return endDeviceListLink;
    }

    /**
     * Sets the value of the endDeviceListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndDeviceListLink }
     *     
     */
    public void setEndDeviceListLink(EndDeviceListLink value) {
        this.endDeviceListLink = value;
    }

    /**
     * Gets the value of the mirrorUsagePointListLink property.
     * 
     * @return
     *     possible object is
     *     {@link MirrorUsagePointListLink }
     *     
     */
    public MirrorUsagePointListLink getMirrorUsagePointListLink() {
        return mirrorUsagePointListLink;
    }

    /**
     * Sets the value of the mirrorUsagePointListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link MirrorUsagePointListLink }
     *     
     */
    public void setMirrorUsagePointListLink(MirrorUsagePointListLink value) {
        this.mirrorUsagePointListLink = value;
    }

    /**
     * Gets the value of the selfDeviceLink property.
     * 
     * @return
     *     possible object is
     *     {@link SelfDeviceLink }
     *     
     */
    public SelfDeviceLink getSelfDeviceLink() {
        return selfDeviceLink;
    }

    /**
     * Sets the value of the selfDeviceLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelfDeviceLink }
     *     
     */
    public void setSelfDeviceLink(SelfDeviceLink value) {
        this.selfDeviceLink = value;
    }

}
