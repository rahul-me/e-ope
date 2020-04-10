
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Contains information about the static capabilities of the device, to allow service providers to know what types of functions are supported, what the normal operating ranges and limits are, and other similar information, in order to provide better suggestions of applicable programs to receive the maximum benefit.
 * 
 * <p>Java class for DRLCCapabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DRLCCapabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="averageEnergy" type="{http://zigbee.org/sep}RealEnergy"/>
 *         &lt;element name="maxDemand" type="{http://zigbee.org/sep}ActivePower"/>
 *         &lt;element name="optionsImplemented" type="{http://zigbee.org/sep}HexBinary32"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DRLCCapabilities", propOrder = {
    "averageEnergy",
    "maxDemand",
    "optionsImplemented"
})
public class DRLCCapabilities {

    @XmlElement(required = true)
    protected RealEnergy averageEnergy;
    @XmlElement(required = true)
    protected ActivePower maxDemand;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] optionsImplemented;

    /**
     * Gets the value of the averageEnergy property.
     * 
     * @return
     *     possible object is
     *     {@link RealEnergy }
     *     
     */
    public RealEnergy getAverageEnergy() {
        return averageEnergy;
    }

    /**
     * Sets the value of the averageEnergy property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEnergy }
     *     
     */
    public void setAverageEnergy(RealEnergy value) {
        this.averageEnergy = value;
    }

    /**
     * Gets the value of the maxDemand property.
     * 
     * @return
     *     possible object is
     *     {@link ActivePower }
     *     
     */
    public ActivePower getMaxDemand() {
        return maxDemand;
    }

    /**
     * Sets the value of the maxDemand property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivePower }
     *     
     */
    public void setMaxDemand(ActivePower value) {
        this.maxDemand = value;
    }

    /**
     * Gets the value of the optionsImplemented property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getOptionsImplemented() {
        return optionsImplemented;
    }

    /**
     * Sets the value of the optionsImplemented property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionsImplemented(byte[] value) {
        this.optionsImplemented = value;
    }

}
