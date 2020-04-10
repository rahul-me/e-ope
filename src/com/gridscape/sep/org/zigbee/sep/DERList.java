
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold DER objects.
 * 
 * <p>Java class for DERList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="DER" type="{http://zigbee.org/sep}DER" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERList", propOrder = {
    "der"
})
@XmlRootElement(name = "DERList")
public class DERList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "DER")
    protected java.util.List<DER> der;

    /**
     * Gets the value of the der property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the der property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DER }
     * 
     * 
     */
    public java.util.List<DER> getDER() {
        if (der == null) {
            der = new ArrayList<DER>();
        }
        return this.der;
    }

}
