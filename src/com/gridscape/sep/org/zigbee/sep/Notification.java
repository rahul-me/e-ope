
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Holds the information related to a client subscription to receive updates to a resource automatically. The actual resources may be passed in the Notification by specifying a specific xsi:type for the Resource and passing the full representation.
 * 
 * <p>Java class for Notification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Notification">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscriptionBase">
 *       &lt;sequence>
 *         &lt;element name="newResourceURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="Resource" type="{http://zigbee.org/sep}Resource" minOccurs="0"/>
 *         &lt;element name="status" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="subscriptionURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Notification", propOrder = {
    "newResourceURI",
    "resource",
    "status",
    "subscriptionURI"
})
@XmlRootElement(name="Notification")
public class Notification
    extends SubscriptionBase
{

    @XmlSchemaType(name = "anyURI")
    protected String newResourceURI;
    @XmlElement(name = "Resource")
    protected Resource resource;
    protected short status;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String subscriptionURI;

    /**
     * Gets the value of the newResourceURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewResourceURI() {
        return newResourceURI;
    }

    /**
     * Sets the value of the newResourceURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewResourceURI(String value) {
        this.newResourceURI = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(short value) {
        this.status = value;
    }

    /**
     * Gets the value of the subscriptionURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionURI() {
        return subscriptionURI;
    }

    /**
     * Sets the value of the subscriptionURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionURI(String value) {
        this.subscriptionURI = value;
    }

}
