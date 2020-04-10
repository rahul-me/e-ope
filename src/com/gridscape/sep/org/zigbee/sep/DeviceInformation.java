
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Contains identification and other information about the device that changes very infrequently, typically only when updates are applied, if ever.
 * 
 * <p>Java class for DeviceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="DRLCCapabilities" type="{http://zigbee.org/sep}DRLCCapabilities" minOccurs="0"/>
 *         &lt;element name="functionsImplemented" type="{http://zigbee.org/sep}HexBinary64" minOccurs="0"/>
 *         &lt;element name="lFDI" type="{http://zigbee.org/sep}HexBinary160"/>
 *         &lt;element name="mfDate" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="mfHwVer" type="{http://zigbee.org/sep}String32"/>
 *         &lt;element name="mfID" type="{http://zigbee.org/sep}PENType"/>
 *         &lt;element name="mfInfo" type="{http://zigbee.org/sep}String32" minOccurs="0"/>
 *         &lt;element name="mfModel" type="{http://zigbee.org/sep}String32"/>
 *         &lt;element name="mfSerNum" type="{http://zigbee.org/sep}String32"/>
 *         &lt;element name="primaryPower" type="{http://zigbee.org/sep}PowerSourceType"/>
 *         &lt;element name="secondaryPower" type="{http://zigbee.org/sep}PowerSourceType"/>
 *         &lt;element name="SupportedLocaleListLink" type="{http://zigbee.org/sep}SupportedLocaleListLink" minOccurs="0"/>
 *         &lt;element name="swActTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="swVer" type="{http://zigbee.org/sep}String32"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceInformation", propOrder = {
    "drlcCapabilities",
    "functionsImplemented",
    "lfdi",
    "mfDate",
    "mfHwVer",
    "mfID",
    "mfInfo",
    "mfModel",
    "mfSerNum",
    "primaryPower",
    "secondaryPower",
    "supportedLocaleListLink",
    "swActTime",
    "swVer"
})
@XmlRootElement(name = "DeviceInformation")
public class DeviceInformation
    extends Resource
{

    @XmlElement(name = "DRLCCapabilities")
    protected DRLCCapabilities drlcCapabilities;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] functionsImplemented;
    @XmlElement(name = "lFDI", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] lfdi;
    @XmlElement(required = true)
    protected TimeType mfDate;
    @XmlElement(required = true)
    protected String mfHwVer;
    @XmlElement(required = true)
    protected PENType mfID;
    protected String mfInfo;
    @XmlElement(required = true)
    protected String mfModel;
    @XmlElement(required = true)
    protected String mfSerNum;
    @XmlElement(required = true)
    protected PowerSourceType primaryPower;
    @XmlElement(required = true)
    protected PowerSourceType secondaryPower;
    @XmlElement(name = "SupportedLocaleListLink")
    protected SupportedLocaleListLink supportedLocaleListLink;
    @XmlElement(required = true)
    protected TimeType swActTime;
    @XmlElement(required = true)
    protected String swVer;

    /**
     * Gets the value of the drlcCapabilities property.
     * 
     * @return
     *     possible object is
     *     {@link DRLCCapabilities }
     *     
     */
    public DRLCCapabilities getDRLCCapabilities() {
        return drlcCapabilities;
    }

    /**
     * Sets the value of the drlcCapabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link DRLCCapabilities }
     *     
     */
    public void setDRLCCapabilities(DRLCCapabilities value) {
        this.drlcCapabilities = value;
    }

    /**
     * Gets the value of the functionsImplemented property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getFunctionsImplemented() {
        return functionsImplemented;
    }

    /**
     * Sets the value of the functionsImplemented property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionsImplemented(byte[] value) {
        this.functionsImplemented = value;
    }

    /**
     * Gets the value of the lfdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getLFDI() {
        return lfdi;
    }

    /**
     * Sets the value of the lfdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLFDI(byte[] value) {
        this.lfdi = value;
    }

    /**
     * Gets the value of the mfDate property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getMfDate() {
        return mfDate;
    }

    /**
     * Sets the value of the mfDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setMfDate(TimeType value) {
        this.mfDate = value;
    }

    /**
     * Gets the value of the mfHwVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfHwVer() {
        return mfHwVer;
    }

    /**
     * Sets the value of the mfHwVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfHwVer(String value) {
        this.mfHwVer = value;
    }

    /**
     * Gets the value of the mfID property.
     * 
     * @return
     *     possible object is
     *     {@link PENType }
     *     
     */
    public PENType getMfID() {
        return mfID;
    }

    /**
     * Sets the value of the mfID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PENType }
     *     
     */
    public void setMfID(PENType value) {
        this.mfID = value;
    }

    /**
     * Gets the value of the mfInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfInfo() {
        return mfInfo;
    }

    /**
     * Sets the value of the mfInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfInfo(String value) {
        this.mfInfo = value;
    }

    /**
     * Gets the value of the mfModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfModel() {
        return mfModel;
    }

    /**
     * Sets the value of the mfModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfModel(String value) {
        this.mfModel = value;
    }

    /**
     * Gets the value of the mfSerNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfSerNum() {
        return mfSerNum;
    }

    /**
     * Sets the value of the mfSerNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfSerNum(String value) {
        this.mfSerNum = value;
    }

    /**
     * Gets the value of the primaryPower property.
     * 
     * @return
     *     possible object is
     *     {@link PowerSourceType }
     *     
     */
    public PowerSourceType getPrimaryPower() {
        return primaryPower;
    }

    /**
     * Sets the value of the primaryPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerSourceType }
     *     
     */
    public void setPrimaryPower(PowerSourceType value) {
        this.primaryPower = value;
    }

    /**
     * Gets the value of the secondaryPower property.
     * 
     * @return
     *     possible object is
     *     {@link PowerSourceType }
     *     
     */
    public PowerSourceType getSecondaryPower() {
        return secondaryPower;
    }

    /**
     * Sets the value of the secondaryPower property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerSourceType }
     *     
     */
    public void setSecondaryPower(PowerSourceType value) {
        this.secondaryPower = value;
    }

    /**
     * Gets the value of the supportedLocaleListLink property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedLocaleListLink }
     *     
     */
    public SupportedLocaleListLink getSupportedLocaleListLink() {
        return supportedLocaleListLink;
    }

    /**
     * Sets the value of the supportedLocaleListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedLocaleListLink }
     *     
     */
    public void setSupportedLocaleListLink(SupportedLocaleListLink value) {
        this.supportedLocaleListLink = value;
    }

    /**
     * Gets the value of the swActTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getSwActTime() {
        return swActTime;
    }

    /**
     * Sets the value of the swActTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setSwActTime(TimeType value) {
        this.swActTime = value;
    }

    /**
     * Gets the value of the swVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwVer() {
        return swVer;
    }

    /**
     * Sets the value of the swVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwVer(String value) {
        this.swVer = value;
    }

}
