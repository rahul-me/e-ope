
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of LLInterface instances.
 * 
 * <p>Java class for LLInterfaceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LLInterfaceList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="LLInterface" type="{http://zigbee.org/sep}LLInterface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LLInterfaceList", propOrder = {
    "llInterface"
})
public class LLInterfaceList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "LLInterface")
    protected java.util.List<LLInterface> llInterface;

    /**
     * Gets the value of the llInterface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the llInterface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLLInterface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LLInterface }
     * 
     * 
     */
    public java.util.List<LLInterface> getLLInterface() {
        if (llInterface == null) {
            llInterface = new ArrayList<LLInterface>();
        }
        return this.llInterface;
    }

}
