
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Specific value measured by a meter or other asset. ReadingBase is abstract, used to define the elements common to Reading and IntervalReading.
 * 
 * <p>Java class for ReadingBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="consumptionBlock" type="{http://zigbee.org/sep}ConsumptionBlockType" minOccurs="0"/>
 *         &lt;element name="qualityFlags" type="{http://zigbee.org/sep}HexBinary16" minOccurs="0"/>
 *         &lt;element name="timePeriod" type="{http://zigbee.org/sep}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="touTier" type="{http://zigbee.org/sep}TOUType" minOccurs="0"/>
 *         &lt;element name="value" type="{http://zigbee.org/sep}Int48" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingBase", propOrder = {
    "consumptionBlock",
    "qualityFlags",
    "timePeriod",
    "touTier",
    "value"
})
@XmlSeeAlso({
    Reading.class,
    BillingReading.class
})
public class ReadingBase
    extends Resource
{

    protected ConsumptionBlockType consumptionBlock;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] qualityFlags;
    protected DateTimeInterval timePeriod;
    protected TOUType touTier;
    protected Long value;

    /**
     * Gets the value of the consumptionBlock property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionBlockType }
     *     
     */
    public ConsumptionBlockType getConsumptionBlock() {
        return consumptionBlock;
    }

    /**
     * Sets the value of the consumptionBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionBlockType }
     *     
     */
    public void setConsumptionBlock(ConsumptionBlockType value) {
        this.consumptionBlock = value;
    }

    /**
     * Gets the value of the qualityFlags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getQualityFlags() {
        return qualityFlags;
    }

    /**
     * Sets the value of the qualityFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualityFlags(byte[] value) {
        this.qualityFlags = value;
    }

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

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValue(Long value) {
        this.value = value;
    }

}
