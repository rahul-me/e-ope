
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides a container for collections of text messages.
 * 
 * <p>Java class for MessagingProgram complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessagingProgram">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableIdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ActiveTextMessageListLink" type="{http://zigbee.org/sep}ActiveTextMessageListLink" minOccurs="0"/>
 *         &lt;element name="locale" type="{http://zigbee.org/sep}LocaleType"/>
 *         &lt;element name="primacy" type="{http://zigbee.org/sep}PrimacyType"/>
 *         &lt;element name="TextMessageListLink" type="{http://zigbee.org/sep}TextMessageListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessagingProgram", propOrder = {
    "activeTextMessageListLink",
    "locale",
    "primacy",
    "textMessageListLink"
})
public class MessagingProgram
    extends SubscribableIdentifiedObject
{

    @XmlElement(name = "ActiveTextMessageListLink")
    protected ActiveTextMessageListLink activeTextMessageListLink;
    @XmlElement(required = true)
    protected LocaleType locale;
    @XmlElement(required = true)
    protected PrimacyType primacy;
    @XmlElement(name = "TextMessageListLink")
    protected TextMessageListLink textMessageListLink;

    /**
     * Gets the value of the activeTextMessageListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveTextMessageListLink }
     *     
     */
    public ActiveTextMessageListLink getActiveTextMessageListLink() {
        return activeTextMessageListLink;
    }

    /**
     * Sets the value of the activeTextMessageListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveTextMessageListLink }
     *     
     */
    public void setActiveTextMessageListLink(ActiveTextMessageListLink value) {
        this.activeTextMessageListLink = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link LocaleType }
     *     
     */
    public LocaleType getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocaleType }
     *     
     */
    public void setLocale(LocaleType value) {
        this.locale = value;
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
     * Gets the value of the textMessageListLink property.
     * 
     * @return
     *     possible object is
     *     {@link TextMessageListLink }
     *     
     */
    public TextMessageListLink getTextMessageListLink() {
        return textMessageListLink;
    }

    /**
     * Sets the value of the textMessageListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextMessageListLink }
     *     
     */
    public void setTextMessageListLink(TextMessageListLink value) {
        this.textMessageListLink = value;
    }

}
