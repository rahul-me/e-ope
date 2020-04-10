
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Mimic of MeterReading used for managing mirrors.
 * 
 * <p>Java class for MirrorMeterReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MirrorMeterReading">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}MeterReadingBase">
 *       &lt;sequence>
 *         &lt;element name="lastUpdateTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="MirrorReadingSet" type="{http://zigbee.org/sep}MirrorReadingSet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nextUpdateTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="Reading" type="{http://zigbee.org/sep}Reading" minOccurs="0"/>
 *         &lt;element name="ReadingType" type="{http://zigbee.org/sep}ReadingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MirrorMeterReading", propOrder = {
    "lastUpdateTime",
    "mirrorReadingSet",
    "nextUpdateTime",
    "reading",
    "readingType"
})
@XmlRootElement(name = "MirrorMeterReading")
public class MirrorMeterReading
    extends MeterReadingBase
{

    protected TimeType lastUpdateTime;
    @XmlElement(name = "MirrorReadingSet")
    protected List<MirrorReadingSet> mirrorReadingSet;
    protected TimeType nextUpdateTime;
    @XmlElement(name = "Reading")
    protected Reading reading;
    @XmlElement(name = "ReadingType")
    protected ReadingType readingType;

    /**
     * Gets the value of the lastUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * Sets the value of the lastUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setLastUpdateTime(TimeType value) {
        this.lastUpdateTime = value;
    }

    /**
     * Gets the value of the mirrorReadingSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mirrorReadingSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMirrorReadingSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MirrorReadingSet }
     * 
     * 
     */
    public List<MirrorReadingSet> getMirrorReadingSet() {
        if (mirrorReadingSet == null) {
            mirrorReadingSet = new ArrayList<MirrorReadingSet>();
        }
        return this.mirrorReadingSet;
    }

    /**
     * Gets the value of the nextUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getNextUpdateTime() {
        return nextUpdateTime;
    }

    /**
     * Sets the value of the nextUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setNextUpdateTime(TimeType value) {
        this.nextUpdateTime = value;
    }

    /**
     * Gets the value of the reading property.
     * 
     * @return
     *     possible object is
     *     {@link Reading }
     *     
     */
    public Reading getReading() {
        return reading;
    }

    /**
     * Sets the value of the reading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reading }
     *     
     */
    public void setReading(Reading value) {
        this.reading = value;
    }

    /**
     * Gets the value of the readingType property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingType }
     *     
     */
    public ReadingType getReadingType() {
        return readingType;
    }

    /**
     * Sets the value of the readingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingType }
     *     
     */
    public void setReadingType(ReadingType value) {
        this.readingType = value;
    }

}
