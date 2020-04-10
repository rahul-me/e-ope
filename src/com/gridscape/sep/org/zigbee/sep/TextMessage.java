
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Text message such as a notification.
 * 
 * <p>Java class for TextMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Event">
 *       &lt;sequence>
 *         &lt;element name="originator" type="{http://zigbee.org/sep}String20" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://zigbee.org/sep}PriorityType"/>
 *         &lt;element name="textMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextMessage", propOrder = {
    "originator",
    "priority",
    "textMessage"
})
public class TextMessage
    extends Event
{

    protected String originator;
    @XmlElement(required = true)
    protected PriorityType priority;
    @XmlElement(required = true)
    protected String textMessage;

    /**
     * Gets the value of the originator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the value of the originator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link PriorityType }
     *     
     */
    public PriorityType getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityType }
     *     
     */
    public void setPriority(PriorityType value) {
        this.priority = value;
    }

    /**
     * Gets the value of the textMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * Sets the value of the textMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextMessage(String value) {
        this.textMessage = value;
    }

}
