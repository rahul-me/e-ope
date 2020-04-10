
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold ReadingSet objects.
 * 
 * <p>Java class for ReadingSetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingSetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="ReadingSet" type="{http://zigbee.org/sep}ReadingSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingSetList", propOrder = {
    "readingSet"
})
public class ReadingSetList
    extends SubscribableList
{

    @XmlElement(name = "ReadingSet")
    protected List<ReadingSet> readingSet;

    /**
     * Gets the value of the readingSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readingSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadingSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReadingSet }
     * 
     * 
     */
    public List<ReadingSet> getReadingSet() {
        if (readingSet == null) {
            readingSet = new ArrayList<ReadingSet>();
        }
        return this.readingSet;
    }

}
