
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The server may modify the charging or discharging parameters and interval to provide a lower aggregated demand at the premises, or within a larger part of the distribution system.
 * 
 * <p>Java class for FlowReservationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlowReservationResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Event">
 *       &lt;sequence>
 *         &lt;element name="energyAvailable" type="{http://zigbee.org/sep}RealEnergy"/>
 *         &lt;element name="powerAvailable" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="subject" type="{http://zigbee.org/sep}mRIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlowReservationResponse", propOrder = {
    "energyAvailable",
    "powerAvailable",
    "subject"
})
public class FlowReservationResponse
    extends Event
{

    @XmlElement(required = true)
    protected RealEnergy energyAvailable;
    @XmlElement(required = true)
    protected ActivePower powerAvailable;
    @XmlElement(required = true)
    protected MRIDType subject;

    /**
     * Gets the value of the energyAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link RealEnergy }
     *     
     */
    public RealEnergy getEnergyAvailable() {
        return energyAvailable;
    }

    /**
     * Sets the value of the energyAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEnergy }
     *     
     */
    public void setEnergyAvailable(RealEnergy value) {
        this.energyAvailable = value;
    }

    /**
     * Gets the value of the powerAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getPowerAvailable() {
        return powerAvailable;
    }

    /**
     * Sets the value of the powerAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setPowerAvailable(ActivePower value) {
        this.powerAvailable = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link MRIDType }
     *     
     */
    public MRIDType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRIDType }
     *     
     */
    public void setSubject(MRIDType value) {
        this.subject = value;
    }

}
