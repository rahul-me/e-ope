
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold HistoricalReading objects.
 * 
 * <p>Java class for HistoricalReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoricalReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="HistoricalReading" type="{http://zigbee.org/sep}HistoricalReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoricalReadingList", propOrder = {
    "historicalReading"
})
public class HistoricalReadingList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "HistoricalReading")
    protected java.util.List<HistoricalReading> historicalReading;

    /**
     * Gets the value of the historicalReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the historicalReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHistoricalReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HistoricalReading }
     * 
     * 
     */
    public java.util.List<HistoricalReading> getHistoricalReading() {
        if (historicalReading == null) {
            historicalReading = new ArrayList<HistoricalReading>();
        }
        return this.historicalReading;
    }

}
