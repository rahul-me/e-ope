
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold TargetReading objects.
 * 
 * <p>Java class for TargetReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="TargetReading" type="{http://zigbee.org/sep}TargetReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetReadingList", propOrder = {
    "targetReading"
})
public class TargetReadingList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "TargetReading")
    protected java.util.List<TargetReading> targetReading;

    /**
     * Gets the value of the targetReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetReading }
     * 
     * 
     */
    public java.util.List<TargetReading> getTargetReading() {
        if (targetReading == null) {
            targetReading = new ArrayList<TargetReading>();
        }
        return this.targetReading;
    }

}
