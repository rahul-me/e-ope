
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold BillingReading objects.
 * 
 * <p>Java class for BillingReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="BillingReading" type="{http://zigbee.org/sep}BillingReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingReadingList", propOrder = {
    "billingReading"
})
public class BillingReadingList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "BillingReading")
    protected java.util.List<BillingReading> billingReading;

    /**
     * Gets the value of the billingReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReading }
     * 
     * 
     */
    public java.util.List<BillingReading> getBillingReading() {
        if (billingReading == null) {
            billingReading = new ArrayList<BillingReading>();
        }
        return this.billingReading;
    }

}
