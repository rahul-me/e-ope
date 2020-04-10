
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This resource contains various settings to control the operation of the device
 * 
 * <p>Java class for Configuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Configuration">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="currentLocale" type="{http://zigbee.org/sep}LocaleType"/>
 *         &lt;element name="PowerConfiguration" type="{http://zigbee.org/sep}PowerConfiguration" minOccurs="0"/>
 *         &lt;element name="PriceResponseCfgListLink" type="{http://zigbee.org/sep}PriceResponseCfgListLink" minOccurs="0"/>
 *         &lt;element name="TimeConfiguration" type="{http://zigbee.org/sep}TimeConfiguration" minOccurs="0"/>
 *         &lt;element name="userDeviceName" type="{http://zigbee.org/sep}String32"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration", propOrder = {
    "currentLocale",
    "powerConfiguration",
    "priceResponseCfgListLink",
    "timeConfiguration",
    "userDeviceName"
})
public class Configuration
    extends SubscribableResource
{

    @XmlElement(required = true)
    protected LocaleType currentLocale;
    @XmlElement(name = "PowerConfiguration")
    protected PowerConfiguration powerConfiguration;
    @XmlElement(name = "PriceResponseCfgListLink")
    protected PriceResponseCfgListLink priceResponseCfgListLink;
    @XmlElement(name = "TimeConfiguration")
    protected TimeConfiguration timeConfiguration;
    @XmlElement(required = true)
    protected String userDeviceName;

    /**
     * Gets the value of the currentLocale property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleType }
     *     
     */
    public LocaleType getCurrentLocale() {
        return currentLocale;
    }

    /**
     * Sets the value of the currentLocale property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleType }
     *     
     */
    public void setCurrentLocale(LocaleType value) {
        this.currentLocale = value;
    }

    /**
     * Gets the value of the powerConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link PowerConfiguration }
     *     
     */
    public PowerConfiguration getPowerConfiguration() {
        return powerConfiguration;
    }

    /**
     * Sets the value of the powerConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerConfiguration }
     *     
     */
    public void setPowerConfiguration(PowerConfiguration value) {
        this.powerConfiguration = value;
    }

    /**
     * Gets the value of the priceResponseCfgListLink property.
     * 
     * @return
     *     possible object is
     *     {@link PriceResponseCfgListLink }
     *     
     */
    public PriceResponseCfgListLink getPriceResponseCfgListLink() {
        return priceResponseCfgListLink;
    }

    /**
     * Sets the value of the priceResponseCfgListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceResponseCfgListLink }
     *     
     */
    public void setPriceResponseCfgListLink(PriceResponseCfgListLink value) {
        this.priceResponseCfgListLink = value;
    }

    /**
     * Gets the value of the timeConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link TimeConfiguration }
     *     
     */
    public TimeConfiguration getTimeConfiguration() {
        return timeConfiguration;
    }

    /**
     * Sets the value of the timeConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeConfiguration }
     *     
     */
    public void setTimeConfiguration(TimeConfiguration value) {
        this.timeConfiguration = value;
    }

    /**
     * Gets the value of the userDeviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDeviceName() {
        return userDeviceName;
    }

    /**
     * Sets the value of the userDeviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDeviceName(String value) {
        this.userDeviceName = value;
    }

}
