
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A schedule of charges; structure that allows the definition of tariff structures such as step (block) and time of use (tier) when used in conjunction with TimeTariffInterval and ConsumptionTariffInterval.
 * 
 * <p>Java class for TariffProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TariffProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://zigbee.org/sep}CurrencyCode" minOccurs="0"/>
 *         &lt;element name="pricePowerOfTenMultiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType" minOccurs="0"/>
 *         &lt;element name="primacy" type="{http://zigbee.org/sep}PrimacyType"/>
 *         &lt;element name="rateCode" type="{http://zigbee.org/sep}String20" minOccurs="0"/>
 *         &lt;element name="RateComponentListLink" type="{http://zigbee.org/sep}RateComponentListLink" minOccurs="0"/>
 *         &lt;element name="serviceCategoryKind" type="{http://zigbee.org/sep}ServiceKind"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TariffProfile", propOrder = {
    "currency",
    "pricePowerOfTenMultiplier",
    "primacy",
    "rateCode",
    "rateComponentListLink",
    "serviceCategoryKind"
})
public class TariffProfile
    extends IdentifiedObject
{

    protected CurrencyCode currency;
    protected PowerOfTenMultiplierType pricePowerOfTenMultiplier;
    @XmlElement(required = true)
    protected PrimacyType primacy;
    protected String rateCode;
    @XmlElement(name = "RateComponentListLink")
    protected RateComponentListLink rateComponentListLink;
    @XmlElement(required = true)
    protected ServiceKind serviceCategoryKind;

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrency(CurrencyCode value) {
        this.currency = value;
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
     * Gets the value of the primacy property.
     * 
     * @return
     *     possible object is
     *     {@link PrimacyType }
     *     
     */
    public PrimacyType getPrimacy() {
        return primacy;
    }

    /**
     * Sets the value of the primacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimacyType }
     *     
     */
    public void setPrimacy(PrimacyType value) {
        this.primacy = value;
    }

    /**
     * Gets the value of the rateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateCode() {
        return rateCode;
    }

    /**
     * Sets the value of the rateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateCode(String value) {
        this.rateCode = value;
    }

    /**
     * Gets the value of the rateComponentListLink property.
     * 
     * @return
     *     possible object is
     *     {@link RateComponentListLink }
     *     
     */
    public RateComponentListLink getRateComponentListLink() {
        return rateComponentListLink;
    }

    /**
     * Sets the value of the rateComponentListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateComponentListLink }
     *     
     */
    public void setRateComponentListLink(RateComponentListLink value) {
        this.rateComponentListLink = value;
    }

    /**
     * Gets the value of the serviceCategoryKind property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceKind }
     *     
     */
    public ServiceKind getServiceCategoryKind() {
        return serviceCategoryKind;
    }

    /**
     * Sets the value of the serviceCategoryKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceKind }
     *     
     */
    public void setServiceCategoryKind(ServiceKind value) {
        this.serviceCategoryKind = value;
    }

}
