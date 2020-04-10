
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A set of Readings of the ReadingType indicated by the parent MeterReading. ReadingBase is abstract, used to define the elements common to ReadingSet and IntervalBlock.
 * 
 * <p>Java class for ReadingSetBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingSetBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="timePeriod" type="{http://zigbee.org/sep}DateTimeInterval"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingSetBase", propOrder = {
    "timePeriod"
})
@XmlSeeAlso({
    ReadingSet.class,
    BillingReadingSet.class,
    MirrorReadingSet.class
})
public class ReadingSetBase
    extends IdentifiedObject
{

    @XmlElement(required = true)
    protected DateTimeInterval timePeriod;

    /**
     * Gets the value of the timePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getTimePeriod() {
        return timePeriod;
    }

    /**
     * Sets the value of the timePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setTimePeriod(DateTimeInterval value) {
        this.timePeriod = value;
    }

}
