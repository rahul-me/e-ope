
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the time-differentiated portion of the RateComponent, if applicable, and provides the ability to specify multiple time intervals, each with its own consumption-based components and other attributes.
 * 
 * <p>Java class for TimeTariffInterval complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeTariffInterval">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}RandomizableEvent">
 *       &lt;sequence>
 *         &lt;element name="ConsumptionTariffIntervalListLink" type="{http://zigbee.org/sep}ConsumptionTariffIntervalListLink" minOccurs="0"/>
 *         &lt;element name="touTier" type="{http://zigbee.org/sep}TOUType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeTariffInterval", propOrder = {
    "consumptionTariffIntervalListLink",
    "touTier"
})
public class TimeTariffInterval
    extends RandomizableEvent
{

    @XmlElement(name = "ConsumptionTariffIntervalListLink")
    protected ConsumptionTariffIntervalListLink consumptionTariffIntervalListLink;
    @XmlElement(required = true)
    protected TOUType touTier;

    /**
     * Gets the value of the consumptionTariffIntervalListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTariffIntervalListLink }
     *     
     */
    public ConsumptionTariffIntervalListLink getConsumptionTariffIntervalListLink() {
        return consumptionTariffIntervalListLink;
    }

    /**
     * Sets the value of the consumptionTariffIntervalListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTariffIntervalListLink }
     *     
     */
    public void setConsumptionTariffIntervalListLink(ConsumptionTariffIntervalListLink value) {
        this.consumptionTariffIntervalListLink = value;
    }

    /**
     * Gets the value of the touTier property.
     * 
     * @return
     *     possible object is
     *     {@link TOUType }
     *     
     */
    public TOUType getTouTier() {
        return touTier;
    }

    /**
     * Sets the value of the touTier property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOUType }
     *     
     */
    public void setTouTier(TOUType value) {
        this.touTier = value;
    }

}
