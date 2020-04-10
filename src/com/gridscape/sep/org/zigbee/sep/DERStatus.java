
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * DER status information.
 * 
 * <p>Java class for DERStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="genConnectStatus" type="{http://zigbee.org/sep}ConnectStatusType" minOccurs="0"/>
 *         &lt;element name="inverterStatus" type="{http://zigbee.org/sep}InverterStatusType" minOccurs="0"/>
 *         &lt;element name="localControlModeStatus" type="{http://zigbee.org/sep}LocalControlModeStatusType" minOccurs="0"/>
 *         &lt;element name="manufacturerStatus" type="{http://zigbee.org/sep}ManufacturerStatusType" minOccurs="0"/>
 *         &lt;element name="operationalModeStatus" type="{http://zigbee.org/sep}OperationalModeStatusType" minOccurs="0"/>
 *         &lt;element name="readingTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="stateOfChargeStatus" type="{http://zigbee.org/sep}StateOfChargeStatusType" minOccurs="0"/>
 *         &lt;element name="storageModeStatus" type="{http://zigbee.org/sep}StorageModeStatusType" minOccurs="0"/>
 *         &lt;element name="storConnectStatus" type="{http://zigbee.org/sep}ConnectStatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERStatus", propOrder = {
    "genConnectStatus",
    "inverterStatus",
    "localControlModeStatus",
    "manufacturerStatus",
    "operationalModeStatus",
    "readingTime",
    "stateOfChargeStatus",
    "storageModeStatus",
    "storConnectStatus"
})
@XmlRootElement(name = "DERStatus")
public class DERStatus
    extends SubscribableResource
{

    protected ConnectStatusType genConnectStatus;
    protected InverterStatusType inverterStatus;
    protected LocalControlModeStatusType localControlModeStatus;
    protected ManufacturerStatusType manufacturerStatus;
    protected OperationalModeStatusType operationalModeStatus;
    @XmlElement(required = true)
    protected TimeType readingTime;
    protected StateOfChargeStatusType stateOfChargeStatus;
    protected StorageModeStatusType storageModeStatus;
    protected ConnectStatusType storConnectStatus;

    /**
     * Gets the value of the genConnectStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectStatusType }
     *     
     */
    public ConnectStatusType getGenConnectStatus() {
        return genConnectStatus;
    }

    /**
     * Sets the value of the genConnectStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectStatusType }
     *     
     */
    public void setGenConnectStatus(ConnectStatusType value) {
        this.genConnectStatus = value;
    }

    /**
     * Gets the value of the inverterStatus property.
     * 
     * @return
     *     possible object is
     *     {@link InverterStatusType }
     *     
     */
    public InverterStatusType getInverterStatus() {
        return inverterStatus;
    }

    /**
     * Sets the value of the inverterStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link InverterStatusType }
     *     
     */
    public void setInverterStatus(InverterStatusType value) {
        this.inverterStatus = value;
    }

    /**
     * Gets the value of the localControlModeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LocalControlModeStatusType }
     *     
     */
    public LocalControlModeStatusType getLocalControlModeStatus() {
        return localControlModeStatus;
    }

    /**
     * Sets the value of the localControlModeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalControlModeStatusType }
     *     
     */
    public void setLocalControlModeStatus(LocalControlModeStatusType value) {
        this.localControlModeStatus = value;
    }

    /**
     * Gets the value of the manufacturerStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ManufacturerStatusType }
     *     
     */
    public ManufacturerStatusType getManufacturerStatus() {
        return manufacturerStatus;
    }

    /**
     * Sets the value of the manufacturerStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManufacturerStatusType }
     *     
     */
    public void setManufacturerStatus(ManufacturerStatusType value) {
        this.manufacturerStatus = value;
    }

    /**
     * Gets the value of the operationalModeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OperationalModeStatusType }
     *     
     */
    public OperationalModeStatusType getOperationalModeStatus() {
        return operationalModeStatus;
    }

    /**
     * Sets the value of the operationalModeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalModeStatusType }
     *     
     */
    public void setOperationalModeStatus(OperationalModeStatusType value) {
        this.operationalModeStatus = value;
    }

    /**
     * Gets the value of the readingTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getReadingTime() {
        return readingTime;
    }

    /**
     * Sets the value of the readingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setReadingTime(TimeType value) {
        this.readingTime = value;
    }

    /**
     * Gets the value of the stateOfChargeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StateOfChargeStatusType }
     *     
     */
    public StateOfChargeStatusType getStateOfChargeStatus() {
        return stateOfChargeStatus;
    }

    /**
     * Sets the value of the stateOfChargeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateOfChargeStatusType }
     *     
     */
    public void setStateOfChargeStatus(StateOfChargeStatusType value) {
        this.stateOfChargeStatus = value;
    }

    /**
     * Gets the value of the storageModeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StorageModeStatusType }
     *     
     */
    public StorageModeStatusType getStorageModeStatus() {
        return storageModeStatus;
    }

    /**
     * Sets the value of the storageModeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageModeStatusType }
     *     
     */
    public void setStorageModeStatus(StorageModeStatusType value) {
        this.storageModeStatus = value;
    }

    /**
     * Gets the value of the storConnectStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectStatusType }
     *     
     */
    public ConnectStatusType getStorConnectStatus() {
        return storConnectStatus;
    }

    /**
     * Sets the value of the storConnectStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectStatusType }
     *     
     */
    public void setStorConnectStatus(ConnectStatusType value) {
        this.storConnectStatus = value;
    }

}
