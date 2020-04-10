
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold CreditRegister objects.
 * 
 * <p>Java class for CreditRegisterList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditRegisterList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="CreditRegister" type="{http://zigbee.org/sep}CreditRegister" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditRegisterList", propOrder = {
    "creditRegister"
})
public class CreditRegisterList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "CreditRegister")
    protected java.util.List<CreditRegister> creditRegister;

    /**
     * Gets the value of the creditRegister property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditRegister property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditRegister().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditRegister }
     * 
     * 
     */
    public java.util.List<CreditRegister> getCreditRegister() {
        if (creditRegister == null) {
            creditRegister = new ArrayList<CreditRegister>();
        }
        return this.creditRegister;
    }

}
