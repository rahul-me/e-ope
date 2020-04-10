
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Agreement between the customer and the service supplier to pay for service at a specific service location. It records certain billing information about the type of service provided at the service location and is used during charge creation to determine the type of service.
 * 
 * <p>Java class for CustomerAgreement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAgreement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ActiveBillingPeriodListLink" type="{http://zigbee.org/sep}ActiveBillingPeriodListLink" minOccurs="0"/>
 *         &lt;element name="ActiveProjectionReadingListLink" type="{http://zigbee.org/sep}ActiveProjectionReadingListLink" minOccurs="0"/>
 *         &lt;element name="ActiveTargetReadingListLink" type="{http://zigbee.org/sep}ActiveTargetReadingListLink" minOccurs="0"/>
 *         &lt;element name="BillingPeriodListLink" type="{http://zigbee.org/sep}BillingPeriodListLink" minOccurs="0"/>
 *         &lt;element name="HistoricalReadingListLink" type="{http://zigbee.org/sep}HistoricalReadingListLink" minOccurs="0"/>
 *         &lt;element name="PrepaymentLink" type="{http://zigbee.org/sep}PrepaymentLink" minOccurs="0"/>
 *         &lt;element name="ProjectionReadingListLink" type="{http://zigbee.org/sep}ProjectionReadingListLink" minOccurs="0"/>
 *         &lt;element name="serviceAccount" type="{http://zigbee.org/sep}String42" minOccurs="0"/>
 *         &lt;element name="serviceLocation" type="{http://zigbee.org/sep}String42" minOccurs="0"/>
 *         &lt;element name="TargetReadingListLink" type="{http://zigbee.org/sep}TargetReadingListLink" minOccurs="0"/>
 *         &lt;element name="TariffProfileLink" type="{http://zigbee.org/sep}TariffProfileLink" minOccurs="0"/>
 *         &lt;element name="UsagePointLink" type="{http://zigbee.org/sep}UsagePointLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAgreement", propOrder = {
    "activeBillingPeriodListLink",
    "activeProjectionReadingListLink",
    "activeTargetReadingListLink",
    "billingPeriodListLink",
    "historicalReadingListLink",
    "prepaymentLink",
    "projectionReadingListLink",
    "serviceAccount",
    "serviceLocation",
    "targetReadingListLink",
    "tariffProfileLink",
    "usagePointLink"
})
public class CustomerAgreement
    extends IdentifiedObject
{

    @XmlElement(name = "ActiveBillingPeriodListLink")
    protected ActiveBillingPeriodListLink activeBillingPeriodListLink;
    @XmlElement(name = "ActiveProjectionReadingListLink")
    protected ActiveProjectionReadingListLink activeProjectionReadingListLink;
    @XmlElement(name = "ActiveTargetReadingListLink")
    protected ActiveTargetReadingListLink activeTargetReadingListLink;
    @XmlElement(name = "BillingPeriodListLink")
    protected BillingPeriodListLink billingPeriodListLink;
    @XmlElement(name = "HistoricalReadingListLink")
    protected HistoricalReadingListLink historicalReadingListLink;
    @XmlElement(name = "PrepaymentLink")
    protected PrepaymentLink prepaymentLink;
    @XmlElement(name = "ProjectionReadingListLink")
    protected ProjectionReadingListLink projectionReadingListLink;
    protected String serviceAccount;
    protected String serviceLocation;
    @XmlElement(name = "TargetReadingListLink")
    protected TargetReadingListLink targetReadingListLink;
    @XmlElement(name = "TariffProfileLink")
    protected TariffProfileLink tariffProfileLink;
    @XmlElement(name = "UsagePointLink")
    protected UsagePointLink usagePointLink;

    /**
     * Gets the value of the activeBillingPeriodListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveBillingPeriodListLink }
     *     
     */
    public ActiveBillingPeriodListLink getActiveBillingPeriodListLink() {
        return activeBillingPeriodListLink;
    }

    /**
     * Sets the value of the activeBillingPeriodListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveBillingPeriodListLink }
     *     
     */
    public void setActiveBillingPeriodListLink(ActiveBillingPeriodListLink value) {
        this.activeBillingPeriodListLink = value;
    }

    /**
     * Gets the value of the activeProjectionReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveProjectionReadingListLink }
     *     
     */
    public ActiveProjectionReadingListLink getActiveProjectionReadingListLink() {
        return activeProjectionReadingListLink;
    }

    /**
     * Sets the value of the activeProjectionReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveProjectionReadingListLink }
     *     
     */
    public void setActiveProjectionReadingListLink(ActiveProjectionReadingListLink value) {
        this.activeProjectionReadingListLink = value;
    }

    /**
     * Gets the value of the activeTargetReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveTargetReadingListLink }
     *     
     */
    public ActiveTargetReadingListLink getActiveTargetReadingListLink() {
        return activeTargetReadingListLink;
    }

    /**
     * Sets the value of the activeTargetReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveTargetReadingListLink }
     *     
     */
    public void setActiveTargetReadingListLink(ActiveTargetReadingListLink value) {
        this.activeTargetReadingListLink = value;
    }

    /**
     * Gets the value of the billingPeriodListLink property.
     * 
     * @return
     *     possible object is
     *     {@link BillingPeriodListLink }
     *     
     */
    public BillingPeriodListLink getBillingPeriodListLink() {
        return billingPeriodListLink;
    }

    /**
     * Sets the value of the billingPeriodListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingPeriodListLink }
     *     
     */
    public void setBillingPeriodListLink(BillingPeriodListLink value) {
        this.billingPeriodListLink = value;
    }

    /**
     * Gets the value of the historicalReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link HistoricalReadingListLink }
     *     
     */
    public HistoricalReadingListLink getHistoricalReadingListLink() {
        return historicalReadingListLink;
    }

    /**
     * Sets the value of the historicalReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoricalReadingListLink }
     *     
     */
    public void setHistoricalReadingListLink(HistoricalReadingListLink value) {
        this.historicalReadingListLink = value;
    }

    /**
     * Gets the value of the prepaymentLink property.
     * 
     * @return
     *     possible object is
     *     {@link PrepaymentLink }
     *     
     */
    public PrepaymentLink getPrepaymentLink() {
        return prepaymentLink;
    }

    /**
     * Sets the value of the prepaymentLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaymentLink }
     *     
     */
    public void setPrepaymentLink(PrepaymentLink value) {
        this.prepaymentLink = value;
    }

    /**
     * Gets the value of the projectionReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectionReadingListLink }
     *     
     */
    public ProjectionReadingListLink getProjectionReadingListLink() {
        return projectionReadingListLink;
    }

    /**
     * Sets the value of the projectionReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectionReadingListLink }
     *     
     */
    public void setProjectionReadingListLink(ProjectionReadingListLink value) {
        this.projectionReadingListLink = value;
    }

    /**
     * Gets the value of the serviceAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAccount() {
        return serviceAccount;
    }

    /**
     * Sets the value of the serviceAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAccount(String value) {
        this.serviceAccount = value;
    }

    /**
     * Gets the value of the serviceLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceLocation() {
        return serviceLocation;
    }

    /**
     * Sets the value of the serviceLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceLocation(String value) {
        this.serviceLocation = value;
    }

    /**
     * Gets the value of the targetReadingListLink property.
     * 
     * @return
     *     possible object is
     *     {@link TargetReadingListLink }
     *     
     */
    public TargetReadingListLink getTargetReadingListLink() {
        return targetReadingListLink;
    }

    /**
     * Sets the value of the targetReadingListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetReadingListLink }
     *     
     */
    public void setTargetReadingListLink(TargetReadingListLink value) {
        this.targetReadingListLink = value;
    }

    /**
     * Gets the value of the tariffProfileLink property.
     * 
     * @return
     *     possible object is
     *     {@link TariffProfileLink }
     *     
     */
    public TariffProfileLink getTariffProfileLink() {
        return tariffProfileLink;
    }

    /**
     * Sets the value of the tariffProfileLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffProfileLink }
     *     
     */
    public void setTariffProfileLink(TariffProfileLink value) {
        this.tariffProfileLink = value;
    }

    /**
     * Gets the value of the usagePointLink property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePointLink }
     *     
     */
    public UsagePointLink getUsagePointLink() {
        return usagePointLink;
    }

    /**
     * Sets the value of the usagePointLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePointLink }
     *     
     */
    public void setUsagePointLink(UsagePointLink value) {
        this.usagePointLink = value;
    }

}
