
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Charges contain charges on a customer bill.  These could be items like taxes, levies, surcharges, rebates, or others.  This is meant to allow the HAN device to retrieve enough information to be able to reconstruct an estimate of what the total bill would look like. 
 * 
 * Providers can provide line item billing, including multiple charge kinds (e.g. taxes, surcharges) at whatever granularity desired, using as many Charges as desired during a billing period. There can also be any number of Charges associated with different ReadingTypes to distinguish between TOU tiers, consumption blocks, or demand charges.
 * 
 * <p>Java class for Charge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Charge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://zigbee.org/sep}String20" minOccurs="0"/>
 *         &lt;element name="kind" type="{http://zigbee.org/sep}ChargeKind" minOccurs="0"/>
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
@XmlType(name = "Charge", propOrder = {
    "description",
    "kind",
    "value"
})
public class Charge {

    protected String description;
    protected ChargeKind kind;
    protected int value;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeKind }
     *     
     */
    public ChargeKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeKind }
     *     
     */
    public void setKind(ChargeKind value) {
        this.kind = value;
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
