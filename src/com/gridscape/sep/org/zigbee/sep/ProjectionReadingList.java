
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold ProjectionReading objects.
 * 
 * <p>Java class for ProjectionReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectionReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="ProjectionReading" type="{http://zigbee.org/sep}ProjectionReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProjectionReadingList", propOrder = {
    "projectionReading"
})
public class ProjectionReadingList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "ProjectionReading")
    protected java.util.List<ProjectionReading> projectionReading;

    /**
     * Gets the value of the projectionReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the projectionReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProjectionReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProjectionReading }
     * 
     * 
     */
    public java.util.List<ProjectionReading> getProjectionReading() {
        if (projectionReading == null) {
            projectionReading = new ArrayList<ProjectionReading>();
        }
        return this.projectionReading;
    }

}
