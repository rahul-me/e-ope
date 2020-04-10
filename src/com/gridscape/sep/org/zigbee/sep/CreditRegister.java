
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * CreditRegister instances define a credit-modifying transaction. Typically this would be a credit-adding transaction, but may be a subtracting transaction (perhaps in response to an out-of-band debt signal).
 * 
 * <p>Java class for CreditRegister complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditRegister">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="creditAmount" type="{http://zigbee.org/sep}AccountingUnit"/>
 *         &lt;element name="creditType" type="{http://zigbee.org/sep}CreditTypeType" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="token" type="{http://zigbee.org/sep}String32"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditRegister", propOrder = {
    "creditAmount",
    "creditType",
    "effectiveTime",
    "token"
})
public class CreditRegister
    extends IdentifiedObject
{

    @XmlElement(required = true)
    protected AccountingUnit creditAmount;
    protected CreditTypeType creditType;
    @XmlElement(required = true)
    protected TimeType effectiveTime;
    @XmlElement(required = true)
    protected String token;

    /**
     * Gets the value of the creditAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AccountingUnit }
     *     
     */
    public AccountingUnit getCreditAmount() {
        return creditAmount;
    }

    /**
     * Sets the value of the creditAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingUnit }
     *     
     */
    public void setCreditAmount(AccountingUnit value) {
        this.creditAmount = value;
    }

    /**
     * Gets the value of the creditType property.
     * 
     * @return
     *     possible object is
     *     {@link CreditTypeType }
     *     
     */
    public CreditTypeType getCreditType() {
        return creditType;
    }

    /**
     * Sets the value of the creditType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTypeType }
     *     
     */
    public void setCreditType(CreditTypeType value) {
        this.creditType = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setEffectiveTime(TimeType value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
