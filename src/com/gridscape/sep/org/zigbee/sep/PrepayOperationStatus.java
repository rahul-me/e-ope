
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * PrepayOperationStatus describes the status of the service or commodity being conditionally controlled by the Prepayment function set.
 * 
 * <p>Java class for PrepayOperationStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepayOperationStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="creditTypeChange" type="{http://zigbee.org/sep}CreditTypeChange" minOccurs="0"/>
 *         &lt;element name="creditTypeInUse" type="{http://zigbee.org/sep}CreditTypeType" minOccurs="0"/>
 *         &lt;element name="serviceChange" type="{http://zigbee.org/sep}ServiceChange" minOccurs="0"/>
 *         &lt;element name="serviceStatus" type="{http://zigbee.org/sep}ServiceStatusType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepayOperationStatus", propOrder = {
    "creditTypeChange",
    "creditTypeInUse",
    "serviceChange",
    "serviceStatus"
})
public class PrepayOperationStatus
    extends Resource
{

    protected CreditTypeChange creditTypeChange;
    protected CreditTypeType creditTypeInUse;
    protected ServiceChange serviceChange;
    @XmlElement(required = true)
    protected ServiceStatusType serviceStatus;

    /**
     * Gets the value of the creditTypeChange property.
     * 
     * @return
     *     possible object is
     *     {@link CreditTypeChange }
     *     
     */
    public CreditTypeChange getCreditTypeChange() {
        return creditTypeChange;
    }

    /**
     * Sets the value of the creditTypeChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTypeChange }
     *     
     */
    public void setCreditTypeChange(CreditTypeChange value) {
        this.creditTypeChange = value;
    }

    /**
     * Gets the value of the creditTypeInUse property.
     * 
     * @return
     *     possible object is
     *     {@link CreditTypeType }
     *     
     */
    public CreditTypeType getCreditTypeInUse() {
        return creditTypeInUse;
    }

    /**
     * Sets the value of the creditTypeInUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTypeType }
     *     
     */
    public void setCreditTypeInUse(CreditTypeType value) {
        this.creditTypeInUse = value;
    }

    /**
     * Gets the value of the serviceChange property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceChange }
     *     
     */
    public ServiceChange getServiceChange() {
        return serviceChange;
    }

    /**
     * Sets the value of the serviceChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceChange }
     *     
     */
    public void setServiceChange(ServiceChange value) {
        this.serviceChange = value;
    }

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusType }
     *     
     */
    public ServiceStatusType getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusType }
     *     
     */
    public void setServiceStatus(ServiceStatusType value) {
        this.serviceStatus = value;
    }

}
