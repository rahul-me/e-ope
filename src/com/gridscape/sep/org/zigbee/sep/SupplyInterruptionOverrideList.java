
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold SupplyInterruptionOverride objects.
 * 
 * <p>Java class for SupplyInterruptionOverrideList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupplyInterruptionOverrideList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="SupplyInterruptionOverride" type="{http://zigbee.org/sep}SupplyInterruptionOverride" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplyInterruptionOverrideList", propOrder = {
    "supplyInterruptionOverride"
})
public class SupplyInterruptionOverrideList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "SupplyInterruptionOverride")
    protected java.util.List<SupplyInterruptionOverride> supplyInterruptionOverride;

    /**
     * Gets the value of the supplyInterruptionOverride property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplyInterruptionOverride property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplyInterruptionOverride().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyInterruptionOverride }
     * 
     * 
     */
    public java.util.List<SupplyInterruptionOverride> getSupplyInterruptionOverride() {
        if (supplyInterruptionOverride == null) {
            supplyInterruptionOverride = new ArrayList<SupplyInterruptionOverride>();
        }
        return this.supplyInterruptionOverride;
    }

}
