
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold DERCurve objects.
 * 
 * <p>Java class for DERCurveList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERCurveList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="DERCurve" type="{http://zigbee.org/sep}DERCurve" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERCurveList", propOrder = {
    "derCurve"
})
@XmlRootElement(name = "DERCurveList")
public class DERCurveList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "DERCurve")
    protected java.util.List<DERCurve> derCurve;

    /**
     * Gets the value of the derCurve property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derCurve property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDERCurve().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DERCurve }
     * 
     * 
     */
    public java.util.List<DERCurve> getDERCurve() {
        if (derCurve == null) {
            derCurve = new ArrayList<DERCurve>();
        }
        return this.derCurve;
    }

}
