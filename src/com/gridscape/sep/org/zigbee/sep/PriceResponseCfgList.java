
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold PriceResponseCfg objects.
 * 
 * <p>Java class for PriceResponseCfgList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceResponseCfgList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="PriceResponseCfg" type="{http://zigbee.org/sep}PriceResponseCfg" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceResponseCfgList", propOrder = {
    "priceResponseCfg"
})
public class PriceResponseCfgList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "PriceResponseCfg")
    protected java.util.List<PriceResponseCfg> priceResponseCfg;

    /**
     * Gets the value of the priceResponseCfg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceResponseCfg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceResponseCfg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceResponseCfg }
     * 
     * 
     */
    public java.util.List<PriceResponseCfg> getPriceResponseCfg() {
        if (priceResponseCfg == null) {
            priceResponseCfg = new ArrayList<PriceResponseCfg>();
        }
        return this.priceResponseCfg;
    }

}
