
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of values obtained from the meter.
 * 
 * <p>Java class for MeterReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeterReading">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}MeterReadingBase">
 *       &lt;sequence>
 *         &lt;element name="RateComponentListLink" type="{http://zigbee.org/sep}RateComponentListLink" minOccurs="0"/>
 *         &lt;element name="ReadingLink" type="{http://zigbee.org/sep}ReadingLink" minOccurs="0"/>
 *         &lt;element name="ReadingSetListLink" type="{http://zigbee.org/sep}ReadingSetListLink" minOccurs="0"/>
 *         &lt;element name="ReadingTypeLink" type="{http://zigbee.org/sep}ReadingTypeLink"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReading", propOrder = {
    "rateComponentListLink",
    "readingLink",
    "readingSetListLink",
    "readingTypeLink"
})
@XmlRootElement(name = "MeterReading")
public class MeterReading
    extends MeterReadingBase
{

    @XmlElement(name = "RateComponentListLink")
    protected RateComponentListLink rateComponentListLink;
    @XmlElement(name = "ReadingLink")
    protected ReadingLink readingLink;
    @XmlElement(name = "ReadingSetListLink")
    protected ReadingSetListLink readingSetListLink;
    @XmlElement(name = "ReadingTypeLink", required = true)
    protected ReadingTypeLink readingTypeLink;

    /**
     * Gets the value of the rateComponentListLink property.
     * 
     * @return
     *     possible object is
     *     {@link RateComponentListLink }
     *     
     */
    public RateComponentListLink getRateComponentListLink() {
        return rateComponentListLink;
    }

    /**
     * Sets the value of the rateComponentListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateComponentListLink }
     *     
     */
    public void setRateComponentListLink(RateComponentListLink value) {
        this.rateComponentListLink = value;
    }

    /**
     * Gets the value of the readingLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingLink }
     *     
     */
    public ReadingLink getReadingLink() {
        return readingLink;
    }

    /**
     * Sets the value of the readingLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingLink }
     *     
     */
    public void setReadingLink(ReadingLink value) {
        this.readingLink = value;
    }

    /**
     * Gets the value of the readingSetListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingSetListLink }
     *     
     */
    public ReadingSetListLink getReadingSetListLink() {
        return readingSetListLink;
    }

    /**
     * Sets the value of the readingSetListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingSetListLink }
     *     
     */
    public void setReadingSetListLink(ReadingSetListLink value) {
        this.readingSetListLink = value;
    }

    /**
     * Gets the value of the readingTypeLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingTypeLink }
     *     
     */
    public ReadingTypeLink getReadingTypeLink() {
        return readingTypeLink;
    }

    /**
     * Sets the value of the readingTypeLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingTypeLink }
     *     
     */
    public void setReadingTypeLink(ReadingTypeLink value) {
        this.readingTypeLink = value;
    }

}
