
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Holds the information related to a client subscription to receive updates to a resource automatically. The actual resources may be passed in the Notification by specifying a specific xsi:type for the Resource and passing the full representation.
 * 
 * <p>Java class for SubscriptionBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="subscribedResource" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionBase", propOrder = {
    "subscribedResource"
})
@XmlSeeAlso({
    Subscription.class,
    Notification.class
})
public class SubscriptionBase
    extends Resource
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscribedResource;

    /**
     * Gets the value of the subscribedResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscribedResource() {
        return subscribedResource;
    }

    /**
     * Sets the value of the subscribedResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscribedResource(String value) {
        this.subscribedResource = value;
    }

}
