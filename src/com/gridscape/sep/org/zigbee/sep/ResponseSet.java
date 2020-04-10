
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A container for a ResponseList.
 * 
 * <p>Java class for ResponseSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ResponseListLink" type="{http://zigbee.org/sep}ResponseListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseSet", propOrder = {
    "responseListLink"
})
public class ResponseSet
    extends IdentifiedObject
{

    @XmlElement(name = "ResponseListLink")
    protected ResponseListLink responseListLink;

    /**
     * Gets the value of the responseListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseListLink }
     *     
     */
    public ResponseListLink getResponseListLink() {
        return responseListLink;
    }

    /**
     * Sets the value of the responseListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseListLink }
     *     
     */
    public void setResponseListLink(ResponseListLink value) {
        this.responseListLink = value;
    }

}
