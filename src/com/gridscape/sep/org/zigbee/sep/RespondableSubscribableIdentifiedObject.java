
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An IdentifiedObject to which a Response can be requested.
 * 
 * <p>Java class for RespondableSubscribableIdentifiedObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespondableSubscribableIdentifiedObject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}RespondableResource">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://zigbee.org/sep}mRIDType"/>
 *         &lt;element name="description" type="{http://zigbee.org/sep}String32" minOccurs="0"/>
 *         &lt;element name="version" type="{http://zigbee.org/sep}VersionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="subscribable" type="{http://zigbee.org/sep}SubscribableType" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespondableSubscribableIdentifiedObject", propOrder = {
    "mrid",
    "description",
    "version"
})
@XmlSeeAlso({
    Event.class
})
public class RespondableSubscribableIdentifiedObject
    extends RespondableResource
{

    @XmlElement(name = "mRID", required = true)
    protected MRIDType mrid;
    protected String description;
    protected VersionType version;
    @XmlAttribute(name = "subscribable")
    protected Short subscribable;

    /**
     * Gets the value of the mrid property.
     * 
     * @return
     *     possible object is
     *     {@link MRIDType }
     *     
     */
    public MRIDType getMRID() {
        return mrid;
    }

    /**
     * Sets the value of the mrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRIDType }
     *     
     */
    public void setMRID(MRIDType value) {
        this.mrid = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link VersionType }
     *     
     */
    public VersionType getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionType }
     *     
     */
    public void setVersion(VersionType value) {
        this.version = value;
    }

    /**
     * Gets the value of the subscribable property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getSubscribable() {
        if (subscribable == null) {
            return ((short) 0);
        } else {
            return subscribable;
        }
    }

    /**
     * Sets the value of the subscribable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSubscribable(Short value) {
        this.subscribable = value;
    }

}
