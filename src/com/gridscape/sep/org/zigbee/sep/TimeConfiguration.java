
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains attributes related to the configuration of the time service.
 * 
 * <p>Java class for TimeConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dstEndRule" type="{http://zigbee.org/sep}DstRuleType"/>
 *         &lt;element name="dstOffset" type="{http://zigbee.org/sep}TimeOffsetType"/>
 *         &lt;element name="dstStartRule" type="{http://zigbee.org/sep}DstRuleType"/>
 *         &lt;element name="tzOffset" type="{http://zigbee.org/sep}TimeOffsetType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeConfiguration", propOrder = {
    "dstEndRule",
    "dstOffset",
    "dstStartRule",
    "tzOffset"
})
public class TimeConfiguration {

    @XmlElement(required = true)
    protected DstRuleType dstEndRule;
    @XmlElement(required = true)
    protected TimeOffsetType dstOffset;
    @XmlElement(required = true)
    protected DstRuleType dstStartRule;
    @XmlElement(required = true)
    protected TimeOffsetType tzOffset;

    /**
     * Gets the value of the dstEndRule property.
     * 
     * @return
     *     possible object is
     *     {@link DstRuleType }
     *     
     */
    public DstRuleType getDstEndRule() {
        return dstEndRule;
    }

    /**
     * Sets the value of the dstEndRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link DstRuleType }
     *     
     */
    public void setDstEndRule(DstRuleType value) {
        this.dstEndRule = value;
    }

    /**
     * Gets the value of the dstOffset property.
     * 
     * @return
     *     possible object is
     *     {@link TimeOffsetType }
     *     
     */
    public TimeOffsetType getDstOffset() {
        return dstOffset;
    }

    /**
     * Sets the value of the dstOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeOffsetType }
     *     
     */
    public void setDstOffset(TimeOffsetType value) {
        this.dstOffset = value;
    }

    /**
     * Gets the value of the dstStartRule property.
     * 
     * @return
     *     possible object is
     *     {@link DstRuleType }
     *     
     */
    public DstRuleType getDstStartRule() {
        return dstStartRule;
    }

    /**
     * Sets the value of the dstStartRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link DstRuleType }
     *     
     */
    public void setDstStartRule(DstRuleType value) {
        this.dstStartRule = value;
    }

    /**
     * Gets the value of the tzOffset property.
     * 
     * @return
     *     possible object is
     *     {@link TimeOffsetType }
     *     
     */
    public TimeOffsetType getTzOffset() {
        return tzOffset;
    }

    /**
     * Sets the value of the tzOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeOffsetType }
     *     
     */
    public void setTzOffset(TimeOffsetType value) {
        this.tzOffset = value;
    }

}
