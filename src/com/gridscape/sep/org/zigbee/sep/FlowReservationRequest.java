
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Used to request flow transactions. Client EndDevices submit a request for charging or discharging from the server. The server creates an associated FlowReservationResponse containing the charging parameters and interval to provide a lower aggregated demand at the premises, or within a larger part of the distribution system.
 * 
 * <p>Java class for FlowReservationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlowReservationRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="creationTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="durationRequested" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="energyRequested" type="{http://zigbee.org/sep}SignedRealEnergy"/>
 *         &lt;element name="intervalRequested" type="{http://zigbee.org/sep}DateTimeInterval"/>
 *         &lt;element name="powerRequested" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="RequestStatus" type="{http://zigbee.org/sep}RequestStatus"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlowReservationRequest", propOrder = {
    "creationTime",
    "durationRequested",
    "energyRequested",
    "intervalRequested",
    "powerRequested",
    "requestStatus"
})
public class FlowReservationRequest
    extends IdentifiedObject
{

    @XmlElement(required = true)
    protected TimeType creationTime;
    protected Integer durationRequested;
    @XmlElement(required = true)
    protected SignedRealEnergy energyRequested;
    @XmlElement(required = true)
    protected DateTimeInterval intervalRequested;
    @XmlElement(required = true)
    protected ActivePower powerRequested;
    @XmlElement(name = "RequestStatus", required = true)
    protected RequestStatus requestStatus;

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreationTime(TimeType value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the durationRequested property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDurationRequested() {
        return durationRequested;
    }

    /**
     * Sets the value of the durationRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDurationRequested(Integer value) {
        this.durationRequested = value;
    }

    /**
     * Gets the value of the energyRequested property.
     * 
     * @return
     *     possible object is
     *     {@link SignedRealEnergy }
     *     
     */
    public SignedRealEnergy getEnergyRequested() {
        return energyRequested;
    }

    /**
     * Sets the value of the energyRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedRealEnergy }
     *     
     */
    public void setEnergyRequested(SignedRealEnergy value) {
        this.energyRequested = value;
    }

    /**
     * Gets the value of the intervalRequested property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getIntervalRequested() {
        return intervalRequested;
    }

    /**
     * Sets the value of the intervalRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setIntervalRequested(DateTimeInterval value) {
        this.intervalRequested = value;
    }

    /**
     * Gets the value of the powerRequested property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getPowerRequested() {
        return powerRequested;
    }

    /**
     * Sets the value of the powerRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setPowerRequested(ActivePower value) {
        this.powerRequested = value;
    }

    /**
     * Gets the value of the requestStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the value of the requestStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setRequestStatus(RequestStatus value) {
        this.requestStatus = value;
    }

}
