
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This object provides status of device file load and activation operations.
 * 
 * <p>Java class for FileStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="activateTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="FileLink" type="{http://zigbee.org/sep}FileLink" minOccurs="0"/>
 *         &lt;element name="loadPercent" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="nextRequestAttempt" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="request503Count" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="requestFailCount" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="status" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="statusTime" type="{http://zigbee.org/sep}TimeType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileStatus", propOrder = {
    "activateTime",
    "fileLink",
    "loadPercent",
    "nextRequestAttempt",
    "request503Count",
    "requestFailCount",
    "status",
    "statusTime"
})
public class FileStatus
    extends Resource
{

    protected TimeType activateTime;
    @XmlElement(name = "FileLink")
    protected FileLink fileLink;
    protected short loadPercent;
    @XmlElement(required = true)
    protected TimeType nextRequestAttempt;
    protected int request503Count;
    protected int requestFailCount;
    protected short status;
    @XmlElement(required = true)
    protected TimeType statusTime;

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
     * Gets the value of the fileLink property.
     * 
     * @return
     *     possible object is
     *     {@link FileLink }
     *     
     */
    public FileLink getFileLink() {
        return fileLink;
    }

    /**
     * Sets the value of the fileLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileLink }
     *     
     */
    public void setFileLink(FileLink value) {
        this.fileLink = value;
    }

    /**
     * Gets the value of the loadPercent property.
     * 
     */
    public short getLoadPercent() {
        return loadPercent;
    }

    /**
     * Sets the value of the loadPercent property.
     * 
     */
    public void setLoadPercent(short value) {
        this.loadPercent = value;
    }

    /**
     * Gets the value of the nextRequestAttempt property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getNextRequestAttempt() {
        return nextRequestAttempt;
    }

    /**
     * Sets the value of the nextRequestAttempt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setNextRequestAttempt(TimeType value) {
        this.nextRequestAttempt = value;
    }

    /**
     * Gets the value of the request503Count property.
     * 
     */
    public int getRequest503Count() {
        return request503Count;
    }

    /**
     * Sets the value of the request503Count property.
     * 
     */
    public void setRequest503Count(int value) {
        this.request503Count = value;
    }

    /**
     * Gets the value of the requestFailCount property.
     * 
     */
    public int getRequestFailCount() {
        return requestFailCount;
    }

    /**
     * Sets the value of the requestFailCount property.
     * 
     */
    public void setRequestFailCount(int value) {
        this.requestFailCount = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(short value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getStatusTime() {
        return statusTime;
    }

    /**
     * Sets the value of the statusTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setStatusTime(TimeType value) {
        this.statusTime = value;
    }

}
