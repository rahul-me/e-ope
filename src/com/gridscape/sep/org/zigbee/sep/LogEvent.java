
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A time stamped instance of a significant event detected by the device.
 * 
 * <p>Java class for LogEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="createdDateTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="extendedData" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="functionSet" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="logEventCode" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="logEventID" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="logEventPEN" type="{http://zigbee.org/sep}PENType"/>
 *         &lt;element name="profileID" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogEvent", propOrder = {
    "createdDateTime",
    "extendedData",
    "functionSet",
    "logEventCode",
    "logEventID",
    "logEventPEN",
    "profileID"
})
@XmlRootElement(name = "LogEvent")
public class LogEvent
    extends Resource
{

    @XmlElement(required = true)
    protected TimeType createdDateTime;
    protected Long extendedData;
    protected short functionSet;
    protected short logEventCode;
    protected int logEventID;
    @XmlElement(required = true)
    protected PENType logEventPEN;
    protected short profileID;

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreatedDateTime(TimeType value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the extendedData property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExtendedData() {
        return extendedData;
    }

    /**
     * Sets the value of the extendedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExtendedData(Long value) {
        this.extendedData = value;
    }

    /**
     * Gets the value of the functionSet property.
     * 
     */
    public short getFunctionSet() {
        return functionSet;
    }

    /**
     * Sets the value of the functionSet property.
     * 
     */
    public void setFunctionSet(short value) {
        this.functionSet = value;
    }

    /**
     * Gets the value of the logEventCode property.
     * 
     */
    public short getLogEventCode() {
        return logEventCode;
    }

    /**
     * Sets the value of the logEventCode property.
     * 
     */
    public void setLogEventCode(short value) {
        this.logEventCode = value;
    }

    /**
     * Gets the value of the logEventID property.
     * 
     */
    public int getLogEventID() {
        return logEventID;
    }

    /**
     * Sets the value of the logEventID property.
     * 
     */
    public void setLogEventID(int value) {
        this.logEventID = value;
    }

    /**
     * Gets the value of the logEventPEN property.
     * 
     * @return
     *     possible object is
     *     {@link PENType }
     *     
     */
    public PENType getLogEventPEN() {
        return logEventPEN;
    }

    /**
     * Sets the value of the logEventPEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link PENType }
     *     
     */
    public void setLogEventPEN(PENType value) {
        this.logEventPEN = value;
    }

    /**
     * Gets the value of the profileID property.
     * 
     */
    public short getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     */
    public void setProfileID(short value) {
        this.profileID = value;
    }

}
