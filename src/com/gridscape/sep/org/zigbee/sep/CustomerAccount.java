
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Assignment of a group of products and services purchased by the Customer through a CustomerAgreement, used as a mechanism for customer billing and payment. It contains common information from the various types of CustomerAgreements to create billings (invoices) for a Customer and receive payment.
 * 
 * <p>Java class for CustomerAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="customerAccount" type="{http://zigbee.org/sep}String42" minOccurs="0"/>
 *         &lt;element name="CustomerAgreementListLink" type="{http://zigbee.org/sep}CustomerAgreementListLink" minOccurs="0"/>
 *         &lt;element name="customerName" type="{http://zigbee.org/sep}String42" minOccurs="0"/>
 *         &lt;element name="pricePowerOfTenMultiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *         &lt;element name="ServiceSupplierLink" type="{http://zigbee.org/sep}ServiceSupplierLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAccount", propOrder = {
    "currency",
    "customerAccount",
    "customerAgreementListLink",
    "customerName",
    "pricePowerOfTenMultiplier",
    "serviceSupplierLink"
})
public class CustomerAccount
    extends IdentifiedObject
{

    protected int currency;
    protected String customerAccount;
    @XmlElement(name = "CustomerAgreementListLink")
    protected CustomerAgreementListLink customerAgreementListLink;
    protected String customerName;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType pricePowerOfTenMultiplier;
    @XmlElement(name = "ServiceSupplierLink")
    protected ServiceSupplierLink serviceSupplierLink;

    /**
     * Gets the value of the currency property.
     * 
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     */
    public void setCurrency(int value) {
        this.currency = value;
    }

    /**
     * Gets the value of the customerAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Sets the value of the customerAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerAccount(String value) {
        this.customerAccount = value;
    }

    /**
     * Gets the value of the customerAgreementListLink property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAgreementListLink }
     *     
     */
    public CustomerAgreementListLink getCustomerAgreementListLink() {
        return customerAgreementListLink;
    }

    /**
     * Sets the value of the customerAgreementListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAgreementListLink }
     *     
     */
    public void setCustomerAgreementListLink(CustomerAgreementListLink value) {
        this.customerAgreementListLink = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the pricePowerOfTenMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getPricePowerOfTenMultiplier() {
        return pricePowerOfTenMultiplier;
    }

    /**
     * Sets the value of the pricePowerOfTenMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setPricePowerOfTenMultiplier(PowerOfTenMultiplierType value) {
        this.pricePowerOfTenMultiplier = value;
    }

    /**
     * Gets the value of the serviceSupplierLink property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSupplierLink }
     *     
     */
    public ServiceSupplierLink getServiceSupplierLink() {
        return serviceSupplierLink;
    }

    /**
     * Sets the value of the serviceSupplierLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSupplierLink }
     *     
     */
    public void setServiceSupplierLink(ServiceSupplierLink value) {
        this.serviceSupplierLink = value;
    }

}
