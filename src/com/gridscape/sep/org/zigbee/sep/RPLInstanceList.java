
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of RPLInstances associated with the IPinterface.
 * 
 * <p>Java class for RPLInstanceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RPLInstanceList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="RPLInstance" type="{http://zigbee.org/sep}RPLInstance" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPLInstanceList", propOrder = {
    "rplInstance"
})
public class RPLInstanceList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "RPLInstance")
    protected java.util.List<RPLInstance> rplInstance;

    /**
     * Gets the value of the rplInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rplInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRPLInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RPLInstance }
     * 
     * 
     */
    public java.util.List<RPLInstance> getRPLInstance() {
        if (rplInstance == null) {
            rplInstance = new ArrayList<RPLInstance>();
        }
        return this.rplInstance;
    }

}
