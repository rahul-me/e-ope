
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains historical, target, and projection readings of various types, possibly associated with charges.
 * 
 * <p>Java class for BillingMeterReadingBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingMeterReadingBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}MeterReadingBase">
 *       &lt;sequence>
 *         &lt;element name="BillingReadingSetListLink" type="{http://zigbee.org/sep}BillingReadingSetListLink" minOccurs="0"/>
 *         &lt;element name="ReadingTypeLink" type="{http://zigbee.org/sep}ReadingTypeLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingMeterReadingBase", propOrder = {
    "billingReadingSetListLink",
    "readingTypeLink"
})
@XmlSeeAlso({
    HistoricalReading.class,
    TargetReading.class,
    ProjectionReading.class
})
public class BillingMeterReadingBase
    extends MeterReadingBase
{

    @XmlElement(name = "BillingReadingSetListLink")
    protected BillingReadingSetListLink billingReadingSetListLink;
    @XmlElement(name = "ReadingTypeLink")
    protected ReadingTypeLink readingTypeLink;

    /**
     * Gets the value of the billingReadingSetListLink property.
     * 
     * @return
     *     possible object is
     *     {@link BillingReadingSetListLink }
     *     
     */
    public BillingReadingSetListLink getBillingReadingSetListLink() {
        return billingReadingSetListLink;
    }

    /**
     * Sets the value of the billingReadingSetListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReadingSetListLink }
     *     
     */
    public void setBillingReadingSetListLink(BillingReadingSetListLink value) {
        this.billingReadingSetListLink = value;
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
