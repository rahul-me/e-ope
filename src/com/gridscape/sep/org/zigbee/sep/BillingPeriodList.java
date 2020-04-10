
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold BillingPeriod objects.
 * 
 * <p>Java class for BillingPeriodList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingPeriodList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="BillingPeriod" type="{http://zigbee.org/sep}BillingPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingPeriodList", propOrder = {
    "billingPeriod"
})
public class BillingPeriodList
    extends SubscribableList
{

    @XmlElement(name = "BillingPeriod")
    protected List<BillingPeriod> billingPeriod;

    /**
     * Gets the value of the billingPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingPeriod }
     * 
     * 
     */
    public List<BillingPeriod> getBillingPeriod() {
        if (billingPeriod == null) {
            billingPeriod = new ArrayList<BillingPeriod>();
        }
        return this.billingPeriod;
    }

}
