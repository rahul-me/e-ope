
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold FunctionSetAssignments objects.
 * 
 * <p>Java class for FunctionSetAssignmentsList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionSetAssignmentsList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="FunctionSetAssignments" type="{http://zigbee.org/sep}FunctionSetAssignments" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionSetAssignmentsList", propOrder = {
    "functionSetAssignments"
})
@XmlRootElement(name = "FunctionSetAssignmentsList")
public class FunctionSetAssignmentsList
    extends SubscribableList
{

    @XmlElement(name = "FunctionSetAssignments")
    protected List<FunctionSetAssignments> functionSetAssignments;

    /**
     * Gets the value of the functionSetAssignments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functionSetAssignments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctionSetAssignments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FunctionSetAssignments }
     * 
     * 
     */
    public List<FunctionSetAssignments> getFunctionSetAssignments() {
        if (functionSetAssignments == null) {
            functionSetAssignments = new ArrayList<FunctionSetAssignments>();
        }
        return this.functionSetAssignments;
    }

}
