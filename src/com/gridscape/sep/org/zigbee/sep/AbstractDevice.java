
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The EndDevice providing the resources available within the DeviceCapabilities.
 * 
 * <p>Java class for AbstractDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="ConfigurationLink" type="{http://zigbee.org/sep}ConfigurationLink" minOccurs="0"/>
 *         &lt;element name="DERListLink" type="{http://zigbee.org/sep}DERListLink" minOccurs="0"/>
 *         &lt;element name="DeviceInformationLink" type="{http://zigbee.org/sep}DeviceInformationLink" minOccurs="0"/>
 *         &lt;element name="DeviceStatusLink" type="{http://zigbee.org/sep}DeviceStatusLink" minOccurs="0"/>
 *         &lt;element name="FileStatusLink" type="{http://zigbee.org/sep}FileStatusLink" minOccurs="0"/>
 *         &lt;element name="IPInterfaceListLink" type="{http://zigbee.org/sep}IPInterfaceListLink" minOccurs="0"/>
 *         &lt;element name="LoadShedAvailabilityLink" type="{http://zigbee.org/sep}LoadShedAvailabilityLink" minOccurs="0"/>
 *         &lt;element name="loadShedDeviceCategory" type="{http://zigbee.org/sep}DeviceCategoryType" minOccurs="0"/>
 *         &lt;element name="LogEventListLink" type="{http://zigbee.org/sep}LogEventListLink" minOccurs="0"/>
 *         &lt;element name="PowerStatusLink" type="{http://zigbee.org/sep}PowerStatusLink" minOccurs="0"/>
 *         &lt;element name="sFDI" type="{http://zigbee.org/sep}SFDIType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractDevice", propOrder = {
    "configurationLink",
    "derListLink",
    "deviceInformationLink",
    "deviceStatusLink",
    "fileStatusLink",
    "ipInterfaceListLink",
    "loadShedAvailabilityLink",
    "loadShedDeviceCategory",
    "logEventListLink",
    "powerStatusLink",
    "sfdi"
})
@XmlSeeAlso({
    EndDevice.class,
    SelfDevice.class
})
public class AbstractDevice
    extends SubscribableResource
{

    @XmlElement(name = "ConfigurationLink")
    protected ConfigurationLink configurationLink;
    @XmlElement(name = "DERListLink")
    protected DERListLink derListLink;
    @XmlElement(name = "DeviceInformationLink")
    protected DeviceInformationLink deviceInformationLink;
    @XmlElement(name = "DeviceStatusLink")
    protected DeviceStatusLink deviceStatusLink;
    @XmlElement(name = "FileStatusLink")
    protected FileStatusLink fileStatusLink;
    @XmlElement(name = "IPInterfaceListLink")
    protected IPInterfaceListLink ipInterfaceListLink;
    @XmlElement(name = "LoadShedAvailabilityLink")
    protected LoadShedAvailabilityLink loadShedAvailabilityLink;
    protected DeviceCategoryType loadShedDeviceCategory;
    @XmlElement(name = "LogEventListLink")
    protected LogEventListLink logEventListLink;
    @XmlElement(name = "PowerStatusLink")
    protected PowerStatusLink powerStatusLink;
    @XmlElement(name = "sFDI", required = true)
    protected SFDIType sfdi;

    /**
     * Gets the value of the configurationLink property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigurationLink }
     *     
     */
    public ConfigurationLink getConfigurationLink() {
        return configurationLink;
    }

    /**
     * Sets the value of the configurationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigurationLink }
     *     
     */
    public void setConfigurationLink(ConfigurationLink value) {
        this.configurationLink = value;
    }

    /**
     * Gets the value of the derListLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERListLink }
     *     
     */
    public DERListLink getDERListLink() {
        return derListLink;
    }

    /**
     * Sets the value of the derListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERListLink }
     *     
     */
    public void setDERListLink(DERListLink value) {
        this.derListLink = value;
    }

    /**
     * Gets the value of the deviceInformationLink property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceInformationLink }
     *     
     */
    public DeviceInformationLink getDeviceInformationLink() {
        return deviceInformationLink;
    }

    /**
     * Sets the value of the deviceInformationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceInformationLink }
     *     
     */
    public void setDeviceInformationLink(DeviceInformationLink value) {
        this.deviceInformationLink = value;
    }

    /**
     * Gets the value of the deviceStatusLink property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceStatusLink }
     *     
     */
    public DeviceStatusLink getDeviceStatusLink() {
        return deviceStatusLink;
    }

    /**
     * Sets the value of the deviceStatusLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceStatusLink }
     *     
     */
    public void setDeviceStatusLink(DeviceStatusLink value) {
        this.deviceStatusLink = value;
    }

    /**
     * Gets the value of the fileStatusLink property.
     * 
     * @return
     *     possible object is
     *     {@link FileStatusLink }
     *     
     */
    public FileStatusLink getFileStatusLink() {
        return fileStatusLink;
    }

    /**
     * Sets the value of the fileStatusLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileStatusLink }
     *     
     */
    public void setFileStatusLink(FileStatusLink value) {
        this.fileStatusLink = value;
    }

    /**
     * Gets the value of the ipInterfaceListLink property.
     * 
     * @return
     *     possible object is
     *     {@link IPInterfaceListLink }
     *     
     */
    public IPInterfaceListLink getIPInterfaceListLink() {
        return ipInterfaceListLink;
    }

    /**
     * Sets the value of the ipInterfaceListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPInterfaceListLink }
     *     
     */
    public void setIPInterfaceListLink(IPInterfaceListLink value) {
        this.ipInterfaceListLink = value;
    }

    /**
     * Gets the value of the loadShedAvailabilityLink property.
     * 
     * @return
     *     possible object is
     *     {@link LoadShedAvailabilityLink }
     *     
     */
    public LoadShedAvailabilityLink getLoadShedAvailabilityLink() {
        return loadShedAvailabilityLink;
    }

    /**
     * Sets the value of the loadShedAvailabilityLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadShedAvailabilityLink }
     *     
     */
    public void setLoadShedAvailabilityLink(LoadShedAvailabilityLink value) {
        this.loadShedAvailabilityLink = value;
    }

    /**
     * Gets the value of the loadShedDeviceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceCategoryType }
     *     
     */
    public DeviceCategoryType getLoadShedDeviceCategory() {
        return loadShedDeviceCategory;
    }

    /**
     * Sets the value of the loadShedDeviceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceCategoryType }
     *     
     */
    public void setLoadShedDeviceCategory(DeviceCategoryType value) {
        this.loadShedDeviceCategory = value;
    }

    /**
     * Gets the value of the logEventListLink property.
     * 
     * @return
     *     possible object is
     *     {@link LogEventListLink }
     *     
     */
    public LogEventListLink getLogEventListLink() {
        return logEventListLink;
    }

    /**
     * Sets the value of the logEventListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogEventListLink }
     *     
     */
    public void setLogEventListLink(LogEventListLink value) {
        this.logEventListLink = value;
    }

    /**
     * Gets the value of the powerStatusLink property.
     * 
     * @return
     *     possible object is
     *     {@link PowerStatusLink }
     *     
     */
    public PowerStatusLink getPowerStatusLink() {
        return powerStatusLink;
    }

    /**
     * Sets the value of the powerStatusLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerStatusLink }
     *     
     */
    public void setPowerStatusLink(PowerStatusLink value) {
        this.powerStatusLink = value;
    }

    /**
     * Gets the value of the sfdi property.
     * 
     * @return
     *     possible object is
     *     {@link SFDIType }
     *     
     */
    public SFDIType getSFDI() {
        return sfdi;
    }

    /**
     * Sets the value of the sfdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link SFDIType }
     *     
     */
    public void setSFDI(SFDIType value) {
        this.sfdi = value;
    }

}
