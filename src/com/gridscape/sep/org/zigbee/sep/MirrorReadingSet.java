
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A set of Readings of the ReadingType indicated by the parent MeterReading.
 * 
 * <p>Java class for MirrorReadingSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MirrorReadingSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}ReadingSetBase">
 *       &lt;sequence>
 *         &lt;element name="Reading" type="{http://zigbee.org/sep}Reading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MirrorReadingSet", propOrder = {
    "reading"
})
public class MirrorReadingSet
    extends ReadingSetBase
{

    @XmlElement(name = "Reading")
    protected List<Reading> reading;

    /**
     * Gets the value of the reading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reading }
     * 
     * 
     */
    public List<Reading> getReading() {
        if (reading == null) {
            reading = new ArrayList<Reading>();
        }
        return this.reading;
    }

}
