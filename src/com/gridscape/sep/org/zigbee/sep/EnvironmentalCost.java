
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides alternative or secondary price information for the relevant RateComponent. Supports jurisdictions that seek to convey the environmental price per unit of the specified commodity not expressed in currency.
 * 
 * Implementers and consumers can use this attribute to prioritize operations of their HAN devices (e.g., PEV charging during times of high availability of renewable electricity resources).
 * 
 * <p>Java class for EnvironmentalCost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnvironmentalCost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://zigbee.org/sep}UInt32"/>
 *         &lt;element name="costKind" type="{http://zigbee.org/sep}CostKindType"/>
 *         &lt;element name="costLevel" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="numCostLevels" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvironmentalCost", propOrder = {
    "amount",
    "costKind",
    "costLevel",
    "numCostLevels"
})
public class EnvironmentalCost {

    protected long amount;
    @XmlElement(required = true)
    protected CostKindType costKind;
    protected short costLevel;
    protected short numCostLevels;

    /**
     * Gets the value of the amount property.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * Gets the value of the costKind property.
     * 
     * @return
     *     possible object is
     *     {@link CostKindType }
     *     
     */
    public CostKindType getCostKind() {
        return costKind;
    }

    /**
     * Sets the value of the costKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostKindType }
     *     
     */
    public void setCostKind(CostKindType value) {
        this.costKind = value;
    }

    /**
     * Gets the value of the costLevel property.
     * 
     */
    public short getCostLevel() {
        return costLevel;
    }

    /**
     * Sets the value of the costLevel property.
     * 
     */
    public void setCostLevel(short value) {
        this.costLevel = value;
    }

    /**
     * Gets the value of the numCostLevels property.
     * 
     */
    public short getNumCostLevels() {
        return numCostLevels;
    }

    /**
     * Sets the value of the numCostLevels property.
     * 
     */
    public void setNumCostLevels(short value) {
        this.numCostLevels = value;
    }

}
