
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold BillingReadingSet objects.
 * 
 * <p>Java class for BillingReadingSetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingReadingSetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="BillingReadingSet" type="{http://zigbee.org/sep}BillingReadingSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingReadingSetList", propOrder = {
    "billingReadingSet"
})
public class BillingReadingSetList
    extends SubscribableList
{

    @XmlElement(name = "BillingReadingSet")
    protected List<BillingReadingSet> billingReadingSet;

    /**
     * Gets the value of the billingReadingSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingReadingSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingReadingSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReadingSet }
     * 
     * 
     */
    public List<BillingReadingSet> getBillingReadingSet() {
        if (billingReadingSet == null) {
            billingReadingSet = new ArrayList<BillingReadingSet>();
        }
        return this.billingReadingSet;
    }

}
