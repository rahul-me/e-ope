
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Status of device
 * 
 * <p>Java class for DeviceStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="changedTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="onCount" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="opState" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="opTime" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://zigbee.org/sep}Temperature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TimeLink" type="{http://zigbee.org/sep}TimeLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceStatus", propOrder = {
    "changedTime",
    "onCount",
    "opState",
    "opTime",
    "temperature",
    "timeLink"
})
public class DeviceStatus
    extends Resource
{

    @XmlElement(required = true)
    protected TimeType changedTime;
    protected Integer onCount;
    protected Short opState;
    protected Long opTime;
    @XmlElement(name = "Temperature")
    protected List<Temperature> temperature;
    @XmlElement(name = "TimeLink")
    protected TimeLink timeLink;

    /**
     * Gets the value of the changedTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getChangedTime() {
        return changedTime;
    }

    /**
     * Sets the value of the changedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setChangedTime(TimeType value) {
        this.changedTime = value;
    }

    /**
     * Gets the value of the onCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOnCount() {
        return onCount;
    }

    /**
     * Sets the value of the onCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOnCount(Integer value) {
        this.onCount = value;
    }

    /**
     * Gets the value of the opState property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getOpState() {
        return opState;
    }

    /**
     * Sets the value of the opState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setOpState(Short value) {
        this.opState = value;
    }

    /**
     * Gets the value of the opTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOpTime() {
        return opTime;
    }

    /**
     * Sets the value of the opTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOpTime(Long value) {
        this.opTime = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temperature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemperature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Temperature }
     * 
     * 
     */
    public List<Temperature> getTemperature() {
        if (temperature == null) {
            temperature = new ArrayList<Temperature>();
        }
        return this.temperature;
    }

    /**
     * Gets the value of the timeLink property.
     * 
     * @return
     *     possible object is
     *     {@link TimeLink }
     *     
     */
    public TimeLink getTimeLink() {
        return timeLink;
    }

    /**
     * Sets the value of the timeLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeLink }
     *     
     */
    public void setTimeLink(TimeLink value) {
        this.timeLink = value;
    }

}
