
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * AccountBalance contains the regular credit and emergency credit balance for this given service or commodity prepay instance. It may also contain status information concerning the balance data.
 * 
 * <p>Java class for AccountBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountBalance">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="availableCredit" type="{http://zigbee.org/sep}AccountingUnit"/>
 *         &lt;element name="creditStatus" type="{http://zigbee.org/sep}CreditStatusType" minOccurs="0"/>
 *         &lt;element name="emergencyCredit" type="{http://zigbee.org/sep}AccountingUnit" minOccurs="0"/>
 *         &lt;element name="emergencyCreditStatus" type="{http://zigbee.org/sep}CreditStatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountBalance", propOrder = {
    "availableCredit",
    "creditStatus",
    "emergencyCredit",
    "emergencyCreditStatus"
})
public class AccountBalance
    extends Resource
{

    @XmlElement(required = true)
    protected AccountingUnit availableCredit;
    protected CreditStatusType creditStatus;
    protected AccountingUnit emergencyCredit;
    protected CreditStatusType emergencyCreditStatus;

    /**
     * Gets the value of the availableCredit property.
     * 
     * @return
     *     possible object is
     *     {@link AccountingUnit }
     *     
     */
    public AccountingUnit getAvailableCredit() {
        return availableCredit;
    }

    /**
     * Sets the value of the availableCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingUnit }
     *     
     */
    public void setAvailableCredit(AccountingUnit value) {
        this.availableCredit = value;
    }

    /**
     * Gets the value of the creditStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CreditStatusType }
     *     
     */
    public CreditStatusType getCreditStatus() {
        return creditStatus;
    }

    /**
     * Sets the value of the creditStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditStatusType }
     *     
     */
    public void setCreditStatus(CreditStatusType value) {
        this.creditStatus = value;
    }

    /**
     * Gets the value of the emergencyCredit property.
     * 
     * @return
     *     possible object is
     *     {@link AccountingUnit }
     *     
     */
    public AccountingUnit getEmergencyCredit() {
        return emergencyCredit;
    }

    /**
     * Sets the value of the emergencyCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingUnit }
     *     
     */
    public void setEmergencyCredit(AccountingUnit value) {
        this.emergencyCredit = value;
    }

    /**
     * Gets the value of the emergencyCreditStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CreditStatusType }
     *     
     */
    public CreditStatusType getEmergencyCreditStatus() {
        return emergencyCreditStatus;
    }

    /**
     * Sets the value of the emergencyCreditStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditStatusType }
     *     
     */
    public void setEmergencyCreditStatus(CreditStatusType value) {
        this.emergencyCreditStatus = value;
    }

}
