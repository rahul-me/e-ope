
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold DemandResponseProgram objects.
 * 
 * <p>Java class for DemandResponseProgramList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DemandResponseProgramList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="DemandResponseProgram" type="{http://zigbee.org/sep}DemandResponseProgram" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DemandResponseProgramList", propOrder = {
    "demandResponseProgram"
})
public class DemandResponseProgramList
    extends SubscribableList
{

    @XmlElement(name = "DemandResponseProgram")
    protected List<DemandResponseProgram> demandResponseProgram;

    /**
     * Gets the value of the demandResponseProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the demandResponseProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDemandResponseProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DemandResponseProgram }
     * 
     * 
     */
    public List<DemandResponseProgram> getDemandResponseProgram() {
        if (demandResponseProgram == null) {
            demandResponseProgram = new ArrayList<DemandResponseProgram>();
        }
        return this.demandResponseProgram;
    }

}
