
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of IPAddr instances.
 * 
 * <p>Java class for IPAddrList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPAddrList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="IPAddr" type="{http://zigbee.org/sep}IPAddr" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPAddrList", propOrder = {
    "ipAddr"
})
public class IPAddrList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "IPAddr")
    protected java.util.List<IPAddr> ipAddr;

    /**
     * Gets the value of the ipAddr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipAddr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPAddr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IPAddr }
     * 
     * 
     */
    public java.util.List<IPAddr> getIPAddr() {
        if (ipAddr == null) {
            ipAddr = new ArrayList<IPAddr>();
        }
        return this.ipAddr;
    }

}
