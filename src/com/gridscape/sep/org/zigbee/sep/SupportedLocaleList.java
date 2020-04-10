
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold SupportedLocale objects.
 * 
 * <p>Java class for SupportedLocaleList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupportedLocaleList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="SupportedLocale" type="{http://zigbee.org/sep}SupportedLocale" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupportedLocaleList", propOrder = {
    "supportedLocale"
})
public class SupportedLocaleList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "SupportedLocale")
    protected java.util.List<SupportedLocale> supportedLocale;

    /**
     * Gets the value of the supportedLocale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedLocale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedLocale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportedLocale }
     * 
     * 
     */
    public java.util.List<SupportedLocale> getSupportedLocale() {
        if (supportedLocale == null) {
            supportedLocale = new ArrayList<SupportedLocale>();
        }
        return this.supportedLocale;
    }

}
