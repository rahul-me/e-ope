
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Time sequence of readings of the same reading type.
 * 
 * <p>Java class for BillingReadingSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingReadingSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}ReadingSetBase">
 *       &lt;sequence>
 *         &lt;element name="BillingReadingListLink" type="{http://zigbee.org/sep}BillingReadingListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingReadingSet", propOrder = {
    "billingReadingListLink"
})
public class BillingReadingSet
    extends ReadingSetBase
{

    @XmlElement(name = "BillingReadingListLink")
    protected BillingReadingListLink billingReadingListLink;

    /**
     * Gets the value of the billingReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link BillingReadingListLink }
     *     
     */
    public BillingReadingListLink getBillingReadingListLink() {
        return billingReadingListLink;
    }

    /**
     * Sets the value of the billingReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingReadingListLink }
     *     
     */
    public void setBillingReadingListLink(BillingReadingListLink value) {
        this.billingReadingListLink = value;
    }

}
