
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specific IPInterface resource.  This resource may be thought of as network status information for a specific network (IP) layer interface.
 * 
 * <p>Java class for IPInterface complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPInterface">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="ifDescr" type="{http://zigbee.org/sep}String192" minOccurs="0"/>
 *         &lt;element name="ifHighSpeed" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInBroadcastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifIndex" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInDiscards" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInErrors" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInMulticastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInOctets" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInUcastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifInUnknownProtos" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifMtu" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifName" type="{http://zigbee.org/sep}String16" minOccurs="0"/>
 *         &lt;element name="ifOperStatus" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="ifOutBroadcastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifOutDiscards" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifOutErrors" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifOutMulticastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifOutOctets" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifOutUcastPkts" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifPromiscuousMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ifSpeed" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="ifType" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="IPAddrListLink" type="{http://zigbee.org/sep}IPAddrListLink" minOccurs="0"/>
 *         &lt;element name="lastResetTime" type="{http://zigbee.org/sep}Int64" minOccurs="0"/>
 *         &lt;element name="lastUpdatedTime" type="{http://zigbee.org/sep}Int64" minOccurs="0"/>
 *         &lt;element name="LLInterfaceListLink" type="{http://zigbee.org/sep}LLInterfaceListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPInterface", propOrder = {
    "ifDescr",
    "ifHighSpeed",
    "ifInBroadcastPkts",
    "ifIndex",
    "ifInDiscards",
    "ifInErrors",
    "ifInMulticastPkts",
    "ifInOctets",
    "ifInUcastPkts",
    "ifInUnknownProtos",
    "ifMtu",
    "ifName",
    "ifOperStatus",
    "ifOutBroadcastPkts",
    "ifOutDiscards",
    "ifOutErrors",
    "ifOutMulticastPkts",
    "ifOutOctets",
    "ifOutUcastPkts",
    "ifPromiscuousMode",
    "ifSpeed",
    "ifType",
    "ipAddrListLink",
    "lastResetTime",
    "lastUpdatedTime",
    "llInterfaceListLink"
})
public class IPInterface
    extends Resource
{

    protected String ifDescr;
    protected Long ifHighSpeed;
    protected Long ifInBroadcastPkts;
    protected Long ifIndex;
    protected Long ifInDiscards;
    protected Long ifInErrors;
    protected Long ifInMulticastPkts;
    protected Long ifInOctets;
    protected Long ifInUcastPkts;
    protected Long ifInUnknownProtos;
    protected Long ifMtu;
    protected String ifName;
    protected Short ifOperStatus;
    protected Long ifOutBroadcastPkts;
    protected Long ifOutDiscards;
    protected Long ifOutErrors;
    protected Long ifOutMulticastPkts;
    protected Long ifOutOctets;
    protected Long ifOutUcastPkts;
    protected Boolean ifPromiscuousMode;
    protected Long ifSpeed;
    protected Integer ifType;
    @XmlElement(name = "IPAddrListLink")
    protected IPAddrListLink ipAddrListLink;
    protected Long lastResetTime;
    protected Long lastUpdatedTime;
    @XmlElement(name = "LLInterfaceListLink")
    protected LLInterfaceListLink llInterfaceListLink;

    /**
     * Gets the value of the ifDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfDescr() {
        return ifDescr;
    }

    /**
     * Sets the value of the ifDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfDescr(String value) {
        this.ifDescr = value;
    }

    /**
     * Gets the value of the ifHighSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfHighSpeed() {
        return ifHighSpeed;
    }

    /**
     * Sets the value of the ifHighSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfHighSpeed(Long value) {
        this.ifHighSpeed = value;
    }

    /**
     * Gets the value of the ifInBroadcastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInBroadcastPkts() {
        return ifInBroadcastPkts;
    }

    /**
     * Sets the value of the ifInBroadcastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInBroadcastPkts(Long value) {
        this.ifInBroadcastPkts = value;
    }

    /**
     * Gets the value of the ifIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfIndex() {
        return ifIndex;
    }

    /**
     * Sets the value of the ifIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfIndex(Long value) {
        this.ifIndex = value;
    }

    /**
     * Gets the value of the ifInDiscards property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInDiscards() {
        return ifInDiscards;
    }

    /**
     * Sets the value of the ifInDiscards property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInDiscards(Long value) {
        this.ifInDiscards = value;
    }

    /**
     * Gets the value of the ifInErrors property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInErrors() {
        return ifInErrors;
    }

    /**
     * Sets the value of the ifInErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInErrors(Long value) {
        this.ifInErrors = value;
    }

    /**
     * Gets the value of the ifInMulticastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInMulticastPkts() {
        return ifInMulticastPkts;
    }

    /**
     * Sets the value of the ifInMulticastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInMulticastPkts(Long value) {
        this.ifInMulticastPkts = value;
    }

    /**
     * Gets the value of the ifInOctets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInOctets() {
        return ifInOctets;
    }

    /**
     * Sets the value of the ifInOctets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInOctets(Long value) {
        this.ifInOctets = value;
    }

    /**
     * Gets the value of the ifInUcastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInUcastPkts() {
        return ifInUcastPkts;
    }

    /**
     * Sets the value of the ifInUcastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInUcastPkts(Long value) {
        this.ifInUcastPkts = value;
    }

    /**
     * Gets the value of the ifInUnknownProtos property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfInUnknownProtos() {
        return ifInUnknownProtos;
    }

    /**
     * Sets the value of the ifInUnknownProtos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfInUnknownProtos(Long value) {
        this.ifInUnknownProtos = value;
    }

    /**
     * Gets the value of the ifMtu property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfMtu() {
        return ifMtu;
    }

    /**
     * Sets the value of the ifMtu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfMtu(Long value) {
        this.ifMtu = value;
    }

    /**
     * Gets the value of the ifName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfName() {
        return ifName;
    }

    /**
     * Sets the value of the ifName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfName(String value) {
        this.ifName = value;
    }

    /**
     * Gets the value of the ifOperStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIfOperStatus() {
        return ifOperStatus;
    }

    /**
     * Sets the value of the ifOperStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIfOperStatus(Short value) {
        this.ifOperStatus = value;
    }

    /**
     * Gets the value of the ifOutBroadcastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutBroadcastPkts() {
        return ifOutBroadcastPkts;
    }

    /**
     * Sets the value of the ifOutBroadcastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutBroadcastPkts(Long value) {
        this.ifOutBroadcastPkts = value;
    }

    /**
     * Gets the value of the ifOutDiscards property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutDiscards() {
        return ifOutDiscards;
    }

    /**
     * Sets the value of the ifOutDiscards property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutDiscards(Long value) {
        this.ifOutDiscards = value;
    }

    /**
     * Gets the value of the ifOutErrors property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutErrors() {
        return ifOutErrors;
    }

    /**
     * Sets the value of the ifOutErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutErrors(Long value) {
        this.ifOutErrors = value;
    }

    /**
     * Gets the value of the ifOutMulticastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutMulticastPkts() {
        return ifOutMulticastPkts;
    }

    /**
     * Sets the value of the ifOutMulticastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutMulticastPkts(Long value) {
        this.ifOutMulticastPkts = value;
    }

    /**
     * Gets the value of the ifOutOctets property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutOctets() {
        return ifOutOctets;
    }

    /**
     * Sets the value of the ifOutOctets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutOctets(Long value) {
        this.ifOutOctets = value;
    }

    /**
     * Gets the value of the ifOutUcastPkts property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfOutUcastPkts() {
        return ifOutUcastPkts;
    }

    /**
     * Sets the value of the ifOutUcastPkts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfOutUcastPkts(Long value) {
        this.ifOutUcastPkts = value;
    }

    /**
     * Gets the value of the ifPromiscuousMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIfPromiscuousMode() {
        return ifPromiscuousMode;
    }

    /**
     * Sets the value of the ifPromiscuousMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIfPromiscuousMode(Boolean value) {
        this.ifPromiscuousMode = value;
    }

    /**
     * Gets the value of the ifSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIfSpeed() {
        return ifSpeed;
    }

    /**
     * Sets the value of the ifSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIfSpeed(Long value) {
        this.ifSpeed = value;
    }

    /**
     * Gets the value of the ifType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIfType() {
        return ifType;
    }

    /**
     * Sets the value of the ifType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIfType(Integer value) {
        this.ifType = value;
    }

    /**
     * Gets the value of the ipAddrListLink property.
     * 
     * @return
     *     possible object is
     *     {@link IPAddrListLink }
     *     
     */
    public IPAddrListLink getIPAddrListLink() {
        return ipAddrListLink;
    }

    /**
     * Sets the value of the ipAddrListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPAddrListLink }
     *     
     */
    public void setIPAddrListLink(IPAddrListLink value) {
        this.ipAddrListLink = value;
    }

    /**
     * Gets the value of the lastResetTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastResetTime() {
        return lastResetTime;
    }

    /**
     * Sets the value of the lastResetTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastResetTime(Long value) {
        this.lastResetTime = value;
    }

    /**
     * Gets the value of the lastUpdatedTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * Sets the value of the lastUpdatedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastUpdatedTime(Long value) {
        this.lastUpdatedTime = value;
    }

    /**
     * Gets the value of the llInterfaceListLink property.
     * 
     * @return
     *     possible object is
     *     {@link LLInterfaceListLink }
     *     
     */
    public LLInterfaceListLink getLLInterfaceListLink() {
        return llInterfaceListLink;
    }

    /**
     * Sets the value of the llInterfaceListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link LLInterfaceListLink }
     *     
     */
    public void setLLInterfaceListLink(LLInterfaceListLink value) {
        this.llInterfaceListLink = value;
    }

}
