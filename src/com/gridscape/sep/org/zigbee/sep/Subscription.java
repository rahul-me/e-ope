
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Holds the information related to a client subscription to receive updates to a resource automatically.
 * 
 * <p>Java class for Subscription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subscription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscriptionBase">
 *       &lt;sequence>
 *         &lt;element name="Condition" type="{http://zigbee.org/sep}Condition" minOccurs="0"/>
 *         &lt;element name="encoding" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="level" type="{http://zigbee.org/sep}String16"/>
 *         &lt;element name="limit" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="notificationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription", propOrder = {
    "condition",
    "encoding",
    "level",
    "limit",
    "notificationURI"
})
@XmlRootElement(name="Subscription")
public class Subscription
    extends SubscriptionBase
{

    @XmlElement(name = "Condition")
    protected Condition condition;
    protected short encoding;
    @XmlElement(required = true)
    protected String level;
    protected int limit;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String notificationURI;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link Condition }
     *     
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Condition }
     *     
     */
    public void setCondition(Condition value) {
        this.condition = value;
    }

    /**
     * Gets the value of the encoding property.
     * 
     */
    public short getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     */
    public void setEncoding(short value) {
        this.encoding = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevel(String value) {
        this.level = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(int value) {
        this.limit = value;
    }

    /**
     * Gets the value of the notificationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationURI() {
        return notificationURI;
    }

    /**
     * Sets the value of the notificationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationURI(String value) {
        this.notificationURI = value;
    }

}
