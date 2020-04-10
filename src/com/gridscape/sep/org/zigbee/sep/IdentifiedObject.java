
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * This is a root class to provide common naming attributes for all classes needing naming attributes
 * 
 * <p>Java class for IdentifiedObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentifiedObject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://zigbee.org/sep}mRIDType"/>
 *         &lt;element name="description" type="{http://zigbee.org/sep}String32" minOccurs="0"/>
 *         &lt;element name="version" type="{http://zigbee.org/sep}VersionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifiedObject", propOrder = {
    "mrid",
    "description",
    "version"
})
@XmlSeeAlso({
    FlowReservationRequest.class,
    RateComponent.class,
    CustomerAgreement.class,
    CreditRegister.class,
    ResponseSet.class,
    ServiceSupplier.class,
    UsagePointBase.class,
    DemandResponseProgram.class,
    ReadingSetBase.class,
    CustomerAccount.class,
    TariffProfile.class,
    MeterReadingBase.class,
    DERProgram.class,
    Prepayment.class,
    DERCurve.class
})
public class IdentifiedObject
    extends Resource
{

    @XmlElement(name = "mRID", required = true)
    protected MRIDType mrid;
    protected String description;
    protected VersionType version;

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

}
