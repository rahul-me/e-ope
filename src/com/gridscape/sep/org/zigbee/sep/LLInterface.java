
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A link-layer interface object.
 * 
 * <p>Java class for LLInterface complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LLInterface">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="CRCerrors" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="EUI64" type="{http://zigbee.org/sep}HexBinary64"/>
 *         &lt;element name="IEEE_802_15_4" type="{http://zigbee.org/sep}IEEE_802_15_4" minOccurs="0"/>
 *         &lt;element name="linkLayerType" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="LLAckNotRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLCSMAFail" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLFramesDropRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLFramesDropTx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLFramesRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLFramesTx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLMediaAccessFail" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLOctetsRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLOctetsTx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLRetryCount" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="LLSecurityErrorRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="loWPAN" type="{http://zigbee.org/sep}loWPAN" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LLInterface", propOrder = {
    "crCerrors",
    "eui64",
    "ieee802154",
    "linkLayerType",
    "llAckNotRx",
    "llcsmaFail",
    "llFramesDropRx",
    "llFramesDropTx",
    "llFramesRx",
    "llFramesTx",
    "llMediaAccessFail",
    "llOctetsRx",
    "llOctetsTx",
    "llRetryCount",
    "llSecurityErrorRx",
    "loWPAN"
})
public class LLInterface
    extends Resource
{

    @XmlElement(name = "CRCerrors")
    protected long crCerrors;
    @XmlElement(name = "EUI64", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] eui64;
    @XmlElement(name = "IEEE_802_15_4")
    protected IEEE802154 ieee802154;
    protected short linkLayerType;
    @XmlElement(name = "LLAckNotRx")
    protected Long llAckNotRx;
    @XmlElement(name = "LLCSMAFail")
    protected Long llcsmaFail;
    @XmlElement(name = "LLFramesDropRx")
    protected Long llFramesDropRx;
    @XmlElement(name = "LLFramesDropTx")
    protected Long llFramesDropTx;
    @XmlElement(name = "LLFramesRx")
    protected Long llFramesRx;
    @XmlElement(name = "LLFramesTx")
    protected Long llFramesTx;
    @XmlElement(name = "LLMediaAccessFail")
    protected Long llMediaAccessFail;
    @XmlElement(name = "LLOctetsRx")
    protected Long llOctetsRx;
    @XmlElement(name = "LLOctetsTx")
    protected Long llOctetsTx;
    @XmlElement(name = "LLRetryCount")
    protected Long llRetryCount;
    @XmlElement(name = "LLSecurityErrorRx")
    protected Long llSecurityErrorRx;
    protected LoWPAN loWPAN;

    /**
     * Gets the value of the crCerrors property.
     * 
     */
    public long getCRCerrors() {
        return crCerrors;
    }

    /**
     * Sets the value of the crCerrors property.
     * 
     */
    public void setCRCerrors(long value) {
        this.crCerrors = value;
    }

    /**
     * Gets the value of the eui64 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getEUI64() {
        return eui64;
    }

    /**
     * Sets the value of the eui64 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEUI64(byte[] value) {
        this.eui64 = value;
    }

    /**
     * Gets the value of the ieee802154 property.
     * 
     * @return
     *     possible object is
     *     {@link IEEE802154 }
     *     
     */
    public IEEE802154 getIEEE802154() {
        return ieee802154;
    }

    /**
     * Sets the value of the ieee802154 property.
     * 
     * @param value
     *     allowed object is
     *     {@link IEEE802154 }
     *     
     */
    public void setIEEE802154(IEEE802154 value) {
        this.ieee802154 = value;
    }

    /**
     * Gets the value of the linkLayerType property.
     * 
     */
    public short getLinkLayerType() {
        return linkLayerType;
    }

    /**
     * Sets the value of the linkLayerType property.
     * 
     */
    public void setLinkLayerType(short value) {
        this.linkLayerType = value;
    }

    /**
     * Gets the value of the llAckNotRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLAckNotRx() {
        return llAckNotRx;
    }

    /**
     * Sets the value of the llAckNotRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLAckNotRx(Long value) {
        this.llAckNotRx = value;
    }

    /**
     * Gets the value of the llcsmaFail property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLCSMAFail() {
        return llcsmaFail;
    }

    /**
     * Sets the value of the llcsmaFail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLCSMAFail(Long value) {
        this.llcsmaFail = value;
    }

    /**
     * Gets the value of the llFramesDropRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLFramesDropRx() {
        return llFramesDropRx;
    }

    /**
     * Sets the value of the llFramesDropRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLFramesDropRx(Long value) {
        this.llFramesDropRx = value;
    }

    /**
     * Gets the value of the llFramesDropTx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLFramesDropTx() {
        return llFramesDropTx;
    }

    /**
     * Sets the value of the llFramesDropTx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLFramesDropTx(Long value) {
        this.llFramesDropTx = value;
    }

    /**
     * Gets the value of the llFramesRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLFramesRx() {
        return llFramesRx;
    }

    /**
     * Sets the value of the llFramesRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLFramesRx(Long value) {
        this.llFramesRx = value;
    }

    /**
     * Gets the value of the llFramesTx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLFramesTx() {
        return llFramesTx;
    }

    /**
     * Sets the value of the llFramesTx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLFramesTx(Long value) {
        this.llFramesTx = value;
    }

    /**
     * Gets the value of the llMediaAccessFail property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLMediaAccessFail() {
        return llMediaAccessFail;
    }

    /**
     * Sets the value of the llMediaAccessFail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLMediaAccessFail(Long value) {
        this.llMediaAccessFail = value;
    }

    /**
     * Gets the value of the llOctetsRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLOctetsRx() {
        return llOctetsRx;
    }

    /**
     * Sets the value of the llOctetsRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLOctetsRx(Long value) {
        this.llOctetsRx = value;
    }

    /**
     * Gets the value of the llOctetsTx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLOctetsTx() {
        return llOctetsTx;
    }

    /**
     * Sets the value of the llOctetsTx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLOctetsTx(Long value) {
        this.llOctetsTx = value;
    }

    /**
     * Gets the value of the llRetryCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLRetryCount() {
        return llRetryCount;
    }

    /**
     * Sets the value of the llRetryCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLRetryCount(Long value) {
        this.llRetryCount = value;
    }

    /**
     * Gets the value of the llSecurityErrorRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLLSecurityErrorRx() {
        return llSecurityErrorRx;
    }

    /**
     * Sets the value of the llSecurityErrorRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLLSecurityErrorRx(Long value) {
        this.llSecurityErrorRx = value;
    }

    /**
     * Gets the value of the loWPAN property.
     * 
     * @return
     *     possible object is
     *     {@link LoWPAN }
     *     
     */
    public LoWPAN getLoWPAN() {
        return loWPAN;
    }

    /**
     * Sets the value of the loWPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoWPAN }
     *     
     */
    public void setLoWPAN(LoWPAN value) {
        this.loWPAN = value;
    }

}
