
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Indicates current consumption status and ability to shed load.
 * 
 * <p>Java class for LoadShedAvailability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadShedAvailability">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="availabilityDuration" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="DemandResponseProgramLink" type="{http://zigbee.org/sep}DemandResponseProgramLink" minOccurs="0"/>
 *         &lt;element name="sheddablePercent" type="{http://zigbee.org/sep}PerCent" minOccurs="0"/>
 *         &lt;element name="sheddablePower" type="{http://zigbee.org/sep}ActivePower" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadShedAvailability", propOrder = {
    "availabilityDuration",
    "demandResponseProgramLink",
    "sheddablePercent",
    "sheddablePower"
})
public class LoadShedAvailability
    extends Resource
{

    protected Long availabilityDuration;
    @XmlElement(name = "DemandResponseProgramLink")
    protected DemandResponseProgramLink demandResponseProgramLink;
    protected PerCent sheddablePercent;
    protected ActivePower sheddablePower;

    /**
     * Gets the value of the availabilityDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailabilityDuration() {
        return availabilityDuration;
    }

    /**
     * Sets the value of the availabilityDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailabilityDuration(Long value) {
        this.availabilityDuration = value;
    }

    /**
     * Gets the value of the demandResponseProgramLink property.
     * 
     * @return
     *     possible object is
     *     {@link DemandResponseProgramLink }
     *     
     */
    public DemandResponseProgramLink getDemandResponseProgramLink() {
        return demandResponseProgramLink;
    }

    /**
     * Sets the value of the demandResponseProgramLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DemandResponseProgramLink }
     *     
     */
    public void setDemandResponseProgramLink(DemandResponseProgramLink value) {
        this.demandResponseProgramLink = value;
    }

    /**
     * Gets the value of the sheddablePercent property.
     * 
     * @return
     *     possible object is
     *     {@link PerCent }
     *     
     */
    public PerCent getSheddablePercent() {
        return sheddablePercent;
    }

    /**
     * Sets the value of the sheddablePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerCent }
     *     
     */
    public void setSheddablePercent(PerCent value) {
        this.sheddablePercent = value;
    }

    /**
     * Gets the value of the sheddablePower property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getSheddablePower() {
        return sheddablePower;
    }

    /**
     * Sets the value of the sheddablePower property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setSheddablePower(ActivePower value) {
        this.sheddablePower = value;
    }

}
