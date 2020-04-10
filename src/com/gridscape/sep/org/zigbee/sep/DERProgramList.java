
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold DERProgram objects.
 * 
 * <p>Java class for DERProgramList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERProgramList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="DERProgram" type="{http://zigbee.org/sep}DERProgram" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERProgramList", propOrder = {
    "derProgram"
})

@XmlRootElement(name="DERProgramList")
public class DERProgramList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "DERProgram")
    protected java.util.List<DERProgram> derProgram;

    /**
     * Gets the value of the derProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDERProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DERProgram }
     * 
     * 
     */
    public java.util.List<DERProgram> getDERProgram() {
        if (derProgram == null) {
            derProgram = new ArrayList<DERProgram>();
        }
        return this.derProgram;
    }

}
