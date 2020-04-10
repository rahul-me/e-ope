
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of IPInterface instances.
 * 
 * <p>Java class for IPInterfaceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPInterfaceList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="IPInterface" type="{http://zigbee.org/sep}IPInterface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPInterfaceList", propOrder = {
    "ipInterface"
})
public class IPInterfaceList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "IPInterface")
    protected java.util.List<IPInterface> ipInterface;

    /**
     * Gets the value of the ipInterface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipInterface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPInterface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IPInterface }
     * 
     * 
     */
    public java.util.List<IPInterface> getIPInterface() {
        if (ipInterface == null) {
            ipInterface = new ArrayList<IPInterface>();
        }
        return this.ipInterface;
    }

}
