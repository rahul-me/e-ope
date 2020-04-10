
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold RateComponent objects.
 * 
 * <p>Java class for RateComponentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RateComponentList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="RateComponent" type="{http://zigbee.org/sep}RateComponent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateComponentList", propOrder = {
    "rateComponent"
})
public class RateComponentList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "RateComponent")
    protected java.util.List<RateComponent> rateComponent;

    /**
     * Gets the value of the rateComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rateComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRateComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RateComponent }
     * 
     * 
     */
    public java.util.List<RateComponent> getRateComponent() {
        if (rateComponent == null) {
            rateComponent = new ArrayList<RateComponent>();
        }
        return this.rateComponent;
    }

}
