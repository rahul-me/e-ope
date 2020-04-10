
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List or RPL source routes if the hosting device is the DODAGroot
 * 
 * <p>Java class for RPLSourceRoutesList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RPLSourceRoutesList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="RPLSourceRoutes" type="{http://zigbee.org/sep}RPLSourceRoutes" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPLSourceRoutesList", propOrder = {
    "rplSourceRoutes"
})
public class RPLSourceRoutesList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "RPLSourceRoutes")
    protected java.util.List<RPLSourceRoutes> rplSourceRoutes;

    /**
     * Gets the value of the rplSourceRoutes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rplSourceRoutes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRPLSourceRoutes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RPLSourceRoutes }
     * 
     * 
     */
    public java.util.List<RPLSourceRoutes> getRPLSourceRoutes() {
        if (rplSourceRoutes == null) {
            rplSourceRoutes = new ArrayList<RPLSourceRoutes>();
        }
        return this.rplSourceRoutes;
    }

}
