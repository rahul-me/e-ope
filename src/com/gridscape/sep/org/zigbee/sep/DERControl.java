
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Distributed Energy Resource (DER) time/event-based control.
 * 
 * <p>Java class for DERControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERControl">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}RandomizableEvent">
 *       &lt;sequence>
 *         &lt;element name="DERControlBase" type="{http://zigbee.org/sep}DERControlBase"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERControl", propOrder = {
    "derControlBase"
})
@XmlRootElement(name = "DERControl")
public class DERControl
    extends RandomizableEvent
{

    @XmlElement(name = "DERControlBase", required = true)
    protected DERControlBase derControlBase;

    /**
     * Gets the value of the derControlBase property.
     * 
     * @return
     *     possible object is
     *     {@link DERControlBase }
     *     
     */
    public DERControlBase getDERControlBase() {
        return derControlBase;
    }

    /**
     * Sets the value of the derControlBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERControlBase }
     *     
     */
    public void setDERControlBase(DERControlBase value) {
        this.derControlBase = value;
    }

}
