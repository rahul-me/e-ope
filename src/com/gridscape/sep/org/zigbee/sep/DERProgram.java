
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Distributed Energy Resource program.
 * 
 * <p>Java class for DERProgram complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERProgram">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="ActiveDERControlListLink" type="{http://zigbee.org/sep}ActiveDERControlListLink" minOccurs="0"/>
 *         &lt;element name="DefaultDERControlLink" type="{http://zigbee.org/sep}DefaultDERControlLink" minOccurs="0"/>
 *         &lt;element name="DERControlListLink" type="{http://zigbee.org/sep}DERControlListLink" minOccurs="0"/>
 *         &lt;element name="DERCurveListLink" type="{http://zigbee.org/sep}DERCurveListLink" minOccurs="0"/>
 *         &lt;element name="primacy" type="{http://zigbee.org/sep}PrimacyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERProgram", propOrder = {
    "activeDERControlListLink",
    "defaultDERControlLink",
    "derControlListLink",
    "derCurveListLink",
    "primacy"
})
@XmlRootElement(name="DERProgram")
public class DERProgram
    extends IdentifiedObject
{

    @XmlElement(name = "ActiveDERControlListLink")
    protected ActiveDERControlListLink activeDERControlListLink;
    @XmlElement(name = "DefaultDERControlLink")
    protected DefaultDERControlLink defaultDERControlLink;
    @XmlElement(name = "DERControlListLink")
    protected DERControlListLink derControlListLink;
    @XmlElement(name = "DERCurveListLink")
    protected DERCurveListLink derCurveListLink;
    @XmlElement(required = true)
    protected PrimacyType primacy;

    /**
     * Gets the value of the activeDERControlListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveDERControlListLink }
     *     
     */
    public ActiveDERControlListLink getActiveDERControlListLink() {
        return activeDERControlListLink;
    }

    /**
     * Sets the value of the activeDERControlListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveDERControlListLink }
     *     
     */
    public void setActiveDERControlListLink(ActiveDERControlListLink value) {
        this.activeDERControlListLink = value;
    }

    /**
     * Gets the value of the defaultDERControlLink property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultDERControlLink }
     *     
     */
    public DefaultDERControlLink getDefaultDERControlLink() {
        return defaultDERControlLink;
    }

    /**
     * Sets the value of the defaultDERControlLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultDERControlLink }
     *     
     */
    public void setDefaultDERControlLink(DefaultDERControlLink value) {
        this.defaultDERControlLink = value;
    }

    /**
     * Gets the value of the derControlListLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERControlListLink }
     *     
     */
    public DERControlListLink getDERControlListLink() {
        return derControlListLink;
    }

    /**
     * Sets the value of the derControlListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERControlListLink }
     *     
     */
    public void setDERControlListLink(DERControlListLink value) {
        this.derControlListLink = value;
    }

    /**
     * Gets the value of the derCurveListLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveListLink }
     *     
     */
    public DERCurveListLink getDERCurveListLink() {
        return derCurveListLink;
    }

    /**
     * Sets the value of the derCurveListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveListLink }
     *     
     */
    public void setDERCurveListLink(DERCurveListLink value) {
        this.derCurveListLink = value;
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

}
