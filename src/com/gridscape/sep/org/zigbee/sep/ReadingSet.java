
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A set of Readings of the ReadingType indicated by the parent MeterReading.
 * 
 * <p>Java class for ReadingSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}ReadingSetBase">
 *       &lt;sequence>
 *         &lt;element name="ReadingListLink" type="{http://zigbee.org/sep}ReadingListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingSet", propOrder = {
    "readingListLink"
})
public class ReadingSet
    extends ReadingSetBase
{

    @XmlElement(name = "ReadingListLink")
    protected ReadingListLink readingListLink;

    /**
     * Gets the value of the readingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingListLink }
     *     
     */
    public ReadingListLink getReadingListLink() {
        return readingListLink;
    }

    /**
     * Sets the value of the readingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingListLink }
     *     
     */
    public void setReadingListLink(ReadingListLink value) {
        this.readingListLink = value;
    }

}
