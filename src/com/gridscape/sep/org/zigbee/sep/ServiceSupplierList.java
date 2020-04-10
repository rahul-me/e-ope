
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold ServiceSupplier objects.
 * 
 * <p>Java class for ServiceSupplierList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceSupplierList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="ServiceSupplier" type="{http://zigbee.org/sep}ServiceSupplier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceSupplierList", propOrder = {
    "serviceSupplier"
})
public class ServiceSupplierList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "ServiceSupplier")
    protected java.util.List<ServiceSupplier> serviceSupplier;

    /**
     * Gets the value of the serviceSupplier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceSupplier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceSupplier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceSupplier }
     * 
     * 
     */
    public java.util.List<ServiceSupplier> getServiceSupplier() {
        if (serviceSupplier == null) {
            serviceSupplier = new ArrayList<ServiceSupplier>();
        }
        return this.serviceSupplier;
    }

}
