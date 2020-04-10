
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List of MirrorMeterReading instances.
 * 
 * <p>Java class for MirrorMeterReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MirrorMeterReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="MirrorMeterReading" type="{http://zigbee.org/sep}MirrorMeterReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MirrorMeterReadingList", propOrder = {
    "mirrorMeterReading"
})
@XmlRootElement(name = "MirrorMeterReadingList")
public class MirrorMeterReadingList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "MirrorMeterReading")
    protected java.util.List<MirrorMeterReading> mirrorMeterReading;

    /**
     * Gets the value of the mirrorMeterReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mirrorMeterReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMirrorMeterReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MirrorMeterReading }
     * 
     * 
     */
    public java.util.List<MirrorMeterReading> getMirrorMeterReading() {
        if (mirrorMeterReading == null) {
            mirrorMeterReading = new ArrayList<MirrorMeterReading>();
        }
        return this.mirrorMeterReading;
    }

}
