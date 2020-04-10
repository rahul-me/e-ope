
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information specific to 6LoWPAN.
 * 
 * <p>Java class for loWPAN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loWPAN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="octetsRx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="octetsTx" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="packetsRx" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="packetsTx" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="rxFragError" type="{http://zigbee.org/sep}UInt32"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loWPAN", propOrder = {
    "octetsRx",
    "octetsTx",
    "packetsRx",
    "packetsTx",
    "rxFragError"
})
public class LoWPAN {

    protected Long octetsRx;
    protected Long octetsTx;
    protected long packetsRx;
    protected long packetsTx;
    protected long rxFragError;

    /**
     * Gets the value of the octetsRx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOctetsRx() {
        return octetsRx;
    }

    /**
     * Sets the value of the octetsRx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOctetsRx(Long value) {
        this.octetsRx = value;
    }

    /**
     * Gets the value of the octetsTx property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOctetsTx() {
        return octetsTx;
    }

    /**
     * Sets the value of the octetsTx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOctetsTx(Long value) {
        this.octetsTx = value;
    }

    /**
     * Gets the value of the packetsRx property.
     * 
     */
    public long getPacketsRx() {
        return packetsRx;
    }

    /**
     * Sets the value of the packetsRx property.
     * 
     */
    public void setPacketsRx(long value) {
        this.packetsRx = value;
    }

    /**
     * Gets the value of the packetsTx property.
     * 
     */
    public long getPacketsTx() {
        return packetsTx;
    }

    /**
     * Sets the value of the packetsTx property.
     * 
     */
    public void setPacketsTx(long value) {
        this.packetsTx = value;
    }

    /**
     * Gets the value of the rxFragError property.
     * 
     */
    public long getRxFragError() {
        return rxFragError;
    }

    /**
     * Sets the value of the rxFragError property.
     * 
     */
    public void setRxFragError(long value) {
        this.rxFragError = value;
    }

}
