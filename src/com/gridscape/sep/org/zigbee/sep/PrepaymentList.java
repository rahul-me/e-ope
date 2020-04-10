
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold Prepayment objects.
 * 
 * <p>Java class for PrepaymentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepaymentList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="Prepayment" type="{http://zigbee.org/sep}Prepayment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepaymentList", propOrder = {
    "prepayment"
})
public class PrepaymentList
    extends SubscribableList
{

    @XmlElement(name = "Prepayment")
    protected List<Prepayment> prepayment;

    /**
     * Gets the value of the prepayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prepayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrepayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Prepayment }
     * 
     * 
     */
    public List<Prepayment> getPrepayment() {
        if (prepayment == null) {
            prepayment = new ArrayList<Prepayment>();
        }
        return this.prepayment;
    }

}
