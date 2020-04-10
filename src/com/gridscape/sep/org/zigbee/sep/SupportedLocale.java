
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a locale that is supported
 * 
 * <p>Java class for SupportedLocale complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupportedLocale">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="locale" type="{http://zigbee.org/sep}LocaleType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportedLocale", propOrder = {
    "locale"
})
public class SupportedLocale
    extends Resource
{

    @XmlElement(required = true)
    protected LocaleType locale;

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

}
