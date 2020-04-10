
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains links to DER resources.
 * 
 * <p>Java class for DER complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DER">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
 *       &lt;sequence>
 *         &lt;element name="AssociatedDERProgramListLink" type="{http://zigbee.org/sep}AssociatedDERProgramListLink" minOccurs="0"/>
 *         &lt;element name="AssociatedUsagePointLink" type="{http://zigbee.org/sep}AssociatedUsagePointLink" minOccurs="0"/>
 *         &lt;element name="CurrentDERProgramLink" type="{http://zigbee.org/sep}CurrentDERProgramLink" minOccurs="0"/>
 *         &lt;element name="DERAvailabilityLink" type="{http://zigbee.org/sep}DERAvailabilityLink" minOccurs="0"/>
 *         &lt;element name="DERCapabilityLink" type="{http://zigbee.org/sep}DERCapabilityLink" minOccurs="0"/>
 *         &lt;element name="DERSettingsLink" type="{http://zigbee.org/sep}DERSettingsLink" minOccurs="0"/>
 *         &lt;element name="DERStatusLink" type="{http://zigbee.org/sep}DERStatusLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DER", propOrder = {
    "associatedDERProgramListLink",
    "associatedUsagePointLink",
    "currentDERProgramLink",
    "derAvailabilityLink",
    "derCapabilityLink",
    "derSettingsLink",
    "derStatusLink"
})
@XmlRootElement(name = "DER")
public class DER
    extends SubscribableResource
{

    @XmlElement(name = "AssociatedDERProgramListLink")
    protected AssociatedDERProgramListLink associatedDERProgramListLink;
    @XmlElement(name = "AssociatedUsagePointLink")
    protected AssociatedUsagePointLink associatedUsagePointLink;
    @XmlElement(name = "CurrentDERProgramLink")
    protected CurrentDERProgramLink currentDERProgramLink;
    @XmlElement(name = "DERAvailabilityLink")
    protected DERAvailabilityLink derAvailabilityLink;
    @XmlElement(name = "DERCapabilityLink")
    protected DERCapabilityLink derCapabilityLink;
    @XmlElement(name = "DERSettingsLink")
    protected DERSettingsLink derSettingsLink;
    @XmlElement(name = "DERStatusLink")
    protected DERStatusLink derStatusLink;

    /**
     * Gets the value of the associatedDERProgramListLink property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedDERProgramListLink }
     *     
     */
    public AssociatedDERProgramListLink getAssociatedDERProgramListLink() {
        return associatedDERProgramListLink;
    }

    /**
     * Sets the value of the associatedDERProgramListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedDERProgramListLink }
     *     
     */
    public void setAssociatedDERProgramListLink(AssociatedDERProgramListLink value) {
        this.associatedDERProgramListLink = value;
    }

    /**
     * Gets the value of the associatedUsagePointLink property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedUsagePointLink }
     *     
     */
    public AssociatedUsagePointLink getAssociatedUsagePointLink() {
        return associatedUsagePointLink;
    }

    /**
     * Sets the value of the associatedUsagePointLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedUsagePointLink }
     *     
     */
    public void setAssociatedUsagePointLink(AssociatedUsagePointLink value) {
        this.associatedUsagePointLink = value;
    }

    /**
     * Gets the value of the currentDERProgramLink property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentDERProgramLink }
     *     
     */
    public CurrentDERProgramLink getCurrentDERProgramLink() {
        return currentDERProgramLink;
    }

    /**
     * Sets the value of the currentDERProgramLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentDERProgramLink }
     *     
     */
    public void setCurrentDERProgramLink(CurrentDERProgramLink value) {
        this.currentDERProgramLink = value;
    }

    /**
     * Gets the value of the derAvailabilityLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERAvailabilityLink }
     *     
     */
    public DERAvailabilityLink getDERAvailabilityLink() {
        return derAvailabilityLink;
    }

    /**
     * Sets the value of the derAvailabilityLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERAvailabilityLink }
     *     
     */
    public void setDERAvailabilityLink(DERAvailabilityLink value) {
        this.derAvailabilityLink = value;
    }

    /**
     * Gets the value of the derCapabilityLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERCapabilityLink }
     *     
     */
    public DERCapabilityLink getDERCapabilityLink() {
        return derCapabilityLink;
    }

    /**
     * Sets the value of the derCapabilityLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCapabilityLink }
     *     
     */
    public void setDERCapabilityLink(DERCapabilityLink value) {
        this.derCapabilityLink = value;
    }

    /**
     * Gets the value of the derSettingsLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERSettingsLink }
     *     
     */
    public DERSettingsLink getDERSettingsLink() {
        return derSettingsLink;
    }

    /**
     * Sets the value of the derSettingsLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERSettingsLink }
     *     
     */
    public void setDERSettingsLink(DERSettingsLink value) {
        this.derSettingsLink = value;
    }

    /**
     * Gets the value of the derStatusLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERStatusLink }
     *     
     */
    public DERStatusLink getDERStatusLink() {
        return derStatusLink;
    }

    /**
     * Sets the value of the derStatusLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERStatusLink }
     *     
     */
    public void setDERStatusLink(DERStatusLink value) {
        this.derStatusLink = value;
    }

}
