
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This resource contains various meta-data describing a file's characteristics.  The meta-data provides general file information and also is used to support filtered queries of file lists
 * 
 * <p>Java class for File complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="File">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="activateTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="fileURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="lFDI" type="{http://zigbee.org/sep}HexBinary160" minOccurs="0"/>
 *         &lt;element name="mfHwVer" type="{http://zigbee.org/sep}String32" minOccurs="0"/>
 *         &lt;element name="mfID" type="{http://zigbee.org/sep}PENType"/>
 *         &lt;element name="mfModel" type="{http://zigbee.org/sep}String32"/>
 *         &lt;element name="mfSerNum" type="{http://zigbee.org/sep}String32" minOccurs="0"/>
 *         &lt;element name="mfVer" type="{http://zigbee.org/sep}String16"/>
 *         &lt;element name="size" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="type" type="{http://zigbee.org/sep}HexBinary16"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File", propOrder = {
    "activateTime",
    "fileURI",
    "lfdi",
    "mfHwVer",
    "mfID",
    "mfModel",
    "mfSerNum",
    "mfVer",
    "size",
    "type"
})
public class File
    extends Resource
{

    protected TimeType activateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String fileURI;
    @XmlElement(name = "lFDI", type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] lfdi;
    protected String mfHwVer;
    @XmlElement(required = true)
    protected PENType mfID;
    @XmlElement(required = true)
    protected String mfModel;
    protected String mfSerNum;
    @XmlElement(required = true)
    protected String mfVer;
    protected long size;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] type;

    /**
     * Gets the value of the activateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getActivateTime() {
        return activateTime;
    }

    /**
     * Sets the value of the activateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setActivateTime(TimeType value) {
        this.activateTime = value;
    }

    /**
     * Gets the value of the fileURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileURI() {
        return fileURI;
    }

    /**
     * Sets the value of the fileURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileURI(String value) {
        this.fileURI = value;
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
     * Gets the value of the mfVer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMfVer() {
        return mfVer;
    }

    /**
     * Sets the value of the mfVer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMfVer(String value) {
        this.mfVer = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(byte[] value) {
        this.type = value;
    }

}
