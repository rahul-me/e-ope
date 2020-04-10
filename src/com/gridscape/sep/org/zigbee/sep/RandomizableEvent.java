
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An Event that can indicate time ranges over which the start time and duration SHALL be randomized.
 * 
 * <p>Java class for RandomizableEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RandomizableEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Event">
 *       &lt;sequence>
 *         &lt;element name="randomizeDuration" type="{http://zigbee.org/sep}OneHourRangeType" minOccurs="0"/>
 *         &lt;element name="randomizeStart" type="{http://zigbee.org/sep}OneHourRangeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RandomizableEvent", propOrder = {
    "randomizeDuration",
    "randomizeStart"
})
@XmlSeeAlso({
    EndDeviceControl.class,
    TimeTariffInterval.class,
    DERControl.class
})
public class RandomizableEvent
    extends Event
{

    protected OneHourRangeType randomizeDuration;
    protected OneHourRangeType randomizeStart;

    /**
     * Gets the value of the randomizeDuration property.
     * 
     * @return
     *     possible object is
     *     {@link OneHourRangeType }
     *     
     */
    public OneHourRangeType getRandomizeDuration() {
        return randomizeDuration;
    }

    /**
     * Sets the value of the randomizeDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneHourRangeType }
     *     
     */
    public void setRandomizeDuration(OneHourRangeType value) {
        this.randomizeDuration = value;
    }

    /**
     * Gets the value of the randomizeStart property.
     * 
     * @return
     *     possible object is
     *     {@link OneHourRangeType }
     *     
     */
    public OneHourRangeType getRandomizeStart() {
        return randomizeStart;
    }

    /**
     * Sets the value of the randomizeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneHourRangeType }
     *     
     */
    public void setRandomizeStart(OneHourRangeType value) {
        this.randomizeStart = value;
    }

}
