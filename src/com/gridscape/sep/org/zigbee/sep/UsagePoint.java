
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logical point on a network at which consumption or production is either physically measured (e.g. metered) or estimated (e.g. unmetered street lights).
 * 
 * <p>Java class for UsagePoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsagePoint">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}UsagePointBase">
 *       &lt;sequence>
 *         &lt;element name="MeterReadingListLink" type="{http://zigbee.org/sep}MeterReadingListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePoint", propOrder = {
    "meterReadingListLink"
})
public class UsagePoint
    extends UsagePointBase
{

    @XmlElement(name = "MeterReadingListLink")
    protected MeterReadingListLink meterReadingListLink;

    /**
     * Gets the value of the meterReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReadingListLink }
     *     
     */
    public MeterReadingListLink getMeterReadingListLink() {
        return meterReadingListLink;
    }

    /**
     * Sets the value of the meterReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReadingListLink }
     *     
     */
    public void setMeterReadingListLink(MeterReadingListLink value) {
        this.meterReadingListLink = value;
    }

}
