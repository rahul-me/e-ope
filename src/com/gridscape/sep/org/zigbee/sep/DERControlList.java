
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold DERControl objects.
 * 
 * <p>Java class for DERControlList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERControlList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="DERControl" type="{http://zigbee.org/sep}DERControl" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERControlList", propOrder = {
    "derControl"
})
@XmlRootElement(name = "DERControlList")
public class DERControlList
    extends SubscribableList
{

    @XmlElement(name = "DERControl")
    protected List<DERControl> derControl;

    /**
     * Gets the value of the derControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDERControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DERControl }
     * 
     * 
     */
    public List<DERControl> getDERControl() {
        if (derControl == null) {
            derControl = new ArrayList<DERControl>();
        }
        return this.derControl;
    }

}
