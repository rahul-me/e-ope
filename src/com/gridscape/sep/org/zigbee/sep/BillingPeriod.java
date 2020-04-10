
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A Billing Period relates to the period of time on which a customer is billed.  As an example the billing period interval for a particular customer might be 31 days starting on July 1, 2011. The start date and interval can change on each billing period. There may also be multiple billing periods related to a customer agreement to support different tariff structures.
 * 
 * <p>Java class for BillingPeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingPeriod">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="billLastPeriod" type="{http://zigbee.org/sep}Int48" minOccurs="0"/>
 *         &lt;element name="billToDate" type="{http://zigbee.org/sep}Int48" minOccurs="0"/>
 *         &lt;element name="interval" type="{http://zigbee.org/sep}DateTimeInterval"/>
 *         &lt;element name="statusTimeStamp" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingPeriod", propOrder = {
    "billLastPeriod",
    "billToDate",
    "interval",
    "statusTimeStamp"
})
public class BillingPeriod
    extends Resource
{

    protected Long billLastPeriod;
    protected Long billToDate;
    @XmlElement(required = true)
    protected DateTimeInterval interval;
    protected TimeType statusTimeStamp;

    /**
     * Gets the value of the billLastPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillLastPeriod() {
        return billLastPeriod;
    }

    /**
     * Sets the value of the billLastPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillLastPeriod(Long value) {
        this.billLastPeriod = value;
    }

    /**
     * Gets the value of the billToDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBillToDate() {
        return billToDate;
    }

    /**
     * Sets the value of the billToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBillToDate(Long value) {
        this.billToDate = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setInterval(DateTimeInterval value) {
        this.interval = value;
    }

    /**
     * Gets the value of the statusTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getStatusTimeStamp() {
        return statusTimeStamp;
    }

    /**
     * Sets the value of the statusTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setStatusTimeStamp(TimeType value) {
        this.statusTimeStamp = value;
    }

}
