
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A parallel to UsagePoint to support mirroring
 * 
 * <p>Java class for MirrorUsagePoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MirrorUsagePoint">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}UsagePointBase">
 *       &lt;sequence>
 *         &lt;element name="deviceLFDI" type="{http://zigbee.org/sep}HexBinary160"/>
 *         &lt;element name="MirrorMeterReading" type="{http://zigbee.org/sep}MirrorMeterReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MirrorUsagePoint", propOrder = {
    "deviceLFDI",
    "mirrorMeterReading"
})
@XmlRootElement(name = "MirrorUsagePoint")
public class MirrorUsagePoint
    extends UsagePointBase
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] deviceLFDI;
    @XmlElement(name = "MirrorMeterReading")
    protected List<MirrorMeterReading> mirrorMeterReading;

    /**
     * Gets the value of the deviceLFDI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDeviceLFDI() {
        return deviceLFDI;
    }

    /**
     * Sets the value of the deviceLFDI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceLFDI(byte[] value) {
        this.deviceLFDI = value;
    }

    /**
     * Gets the value of the mirrorMeterReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mirrorMeterReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMirrorMeterReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MirrorMeterReading }
     * 
     * 
     */
    public List<MirrorMeterReading> getMirrorMeterReading() {
        if (mirrorMeterReading == null) {
            mirrorMeterReading = new ArrayList<MirrorMeterReading>();
        }
        return this.mirrorMeterReading;
    }

}
