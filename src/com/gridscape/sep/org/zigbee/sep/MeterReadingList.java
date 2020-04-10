
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold MeterReading objects.
 * 
 * <p>Java class for MeterReadingList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeterReadingList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="MeterReading" type="{http://zigbee.org/sep}MeterReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReadingList", propOrder = {
    "meterReading"
})
public class MeterReadingList
    extends SubscribableList
{

    @XmlElement(name = "MeterReading")
    protected List<MeterReading> meterReading;

    /**
     * Gets the value of the meterReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReading }
     * 
     * 
     */
    public List<MeterReading> getMeterReading() {
        if (meterReading == null) {
            meterReading = new ArrayList<MeterReading>();
        }
        return this.meterReading;
    }

}