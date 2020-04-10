
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Unit for accounting; use either 'energyUnit' or 'currencyUnit' to specify the unit for 'value'.
 * 
 * <p>Java class for AccountingUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountingUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="energyUnit" type="{http://zigbee.org/sep}RealEnergy" minOccurs="0"/>
 *         &lt;element name="monetaryUnit" type="{http://zigbee.org/sep}CurrencyCode"/>
 *         &lt;element name="multiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *         &lt;element name="value" type="{http://zigbee.org/sep}Int32"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountingUnit", propOrder = {
    "energyUnit",
    "monetaryUnit",
    "multiplier",
    "value"
})
public class AccountingUnit {

    protected RealEnergy energyUnit;
    @XmlElement(required = true)
    protected CurrencyCode monetaryUnit;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType multiplier;
    protected int value;

    /**
     * Gets the value of the energyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link RealEnergy }
     *     
     */
    public RealEnergy getEnergyUnit() {
        return energyUnit;
    }

    /**
     * Sets the value of the energyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealEnergy }
     *     
     */
    public void setEnergyUnit(RealEnergy value) {
        this.energyUnit = value;
    }

    /**
     * Gets the value of the monetaryUnit property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getMonetaryUnit() {
        return monetaryUnit;
    }

    /**
     * Sets the value of the monetaryUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setMonetaryUnit(CurrencyCode value) {
        this.monetaryUnit = value;
    }

    /**
     * Gets the value of the multiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setMultiplier(PowerOfTenMultiplierType value) {
        this.multiplier = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
