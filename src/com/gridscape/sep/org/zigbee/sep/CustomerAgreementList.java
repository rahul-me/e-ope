
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold CustomerAgreement objects.
 * 
 * <p>Java class for CustomerAgreementList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAgreementList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="CustomerAgreement" type="{http://zigbee.org/sep}CustomerAgreement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAgreementList", propOrder = {
    "customerAgreement"
})
public class CustomerAgreementList
    extends SubscribableList
{

    @XmlElement(name = "CustomerAgreement")
    protected List<CustomerAgreement> customerAgreement;

    /**
     * Gets the value of the customerAgreement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerAgreement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerAgreement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerAgreement }
     * 
     * 
     */
    public List<CustomerAgreement> getCustomerAgreement() {
        if (customerAgreement == null) {
            customerAgreement = new ArrayList<CustomerAgreement>();
        }
        return this.customerAgreement;
    }

}
