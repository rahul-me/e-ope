
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List of MirrorUsagePoint instances.
 * 
 * <p>Java class for MirrorUsagePointList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MirrorUsagePointList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="MirrorUsagePoint" type="{http://zigbee.org/sep}MirrorUsagePoint" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MirrorUsagePointList", propOrder = {
    "mirrorUsagePoint"
})
@XmlRootElement(name = "MirrorUsagePointList")
public class MirrorUsagePointList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "MirrorUsagePoint")
    protected java.util.List<MirrorUsagePoint> mirrorUsagePoint;

    /**
     * Gets the value of the mirrorUsagePoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mirrorUsagePoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMirrorUsagePoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MirrorUsagePoint }
     * 
     * 
     */
    public java.util.List<MirrorUsagePoint> getMirrorUsagePoint() {
        if (mirrorUsagePoint == null) {
            mirrorUsagePoint = new ArrayList<MirrorUsagePoint>();
        }
        return this.mirrorUsagePoint;
    }

}
