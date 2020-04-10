
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Configuration data that specifies how price responsive devices SHOULD respond to price changes while acting upon a given RateComponent.
 * 
 * <p>Java class for PriceResponseCfg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceResponseCfg">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="consumeThreshold" type="{http://zigbee.org/sep}Int32"/>
 *         &lt;element name="maxReductionThreshold" type="{http://zigbee.org/sep}Int32"/>
 *         &lt;element name="RateComponentLink" type="{http://zigbee.org/sep}RateComponentLink"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceResponseCfg", propOrder = {
    "consumeThreshold",
    "maxReductionThreshold",
    "rateComponentLink"
})
public class PriceResponseCfg
    extends Resource
{

    protected int consumeThreshold;
    protected int maxReductionThreshold;
    @XmlElement(name = "RateComponentLink", required = true)
    protected RateComponentLink rateComponentLink;

    /**
     * Gets the value of the consumeThreshold property.
     * 
     */
    public int getConsumeThreshold() {
        return consumeThreshold;
    }

    /**
     * Sets the value of the consumeThreshold property.
     * 
     */
    public void setConsumeThreshold(int value) {
        this.consumeThreshold = value;
    }

    /**
     * Gets the value of the maxReductionThreshold property.
     * 
     */
    public int getMaxReductionThreshold() {
        return maxReductionThreshold;
    }

    /**
     * Sets the value of the maxReductionThreshold property.
     * 
     */
    public void setMaxReductionThreshold(int value) {
        this.maxReductionThreshold = value;
    }

    /**
     * Gets the value of the rateComponentLink property.
     * 
     * @return
     *     possible object is
     *     {@link RateComponentLink }
     *     
     */
    public RateComponentLink getRateComponentLink() {
        return rateComponentLink;
    }

    /**
     * Sets the value of the rateComponentLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateComponentLink }
     *     
     */
    public void setRateComponentLink(RateComponentLink value) {
        this.rateComponentLink = value;
    }

}
