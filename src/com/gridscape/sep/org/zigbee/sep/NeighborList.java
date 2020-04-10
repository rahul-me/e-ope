
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of 15.4 neighbors.
 * 
 * <p>Java class for NeighborList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NeighborList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="Neighbor" type="{http://zigbee.org/sep}Neighbor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NeighborList", propOrder = {
    "neighbor"
})
public class NeighborList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "Neighbor")
    protected java.util.List<Neighbor> neighbor;

    /**
     * Gets the value of the neighbor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the neighbor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNeighbor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Neighbor }
     * 
     * 
     */
    public java.util.List<Neighbor> getNeighbor() {
        if (neighbor == null) {
            neighbor = new ArrayList<Neighbor>();
        }
        return this.neighbor;
    }

}
