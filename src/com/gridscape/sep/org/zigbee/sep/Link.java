
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Links provide a reference, via URI, to another resource.
 * 
 * <p>Java class for Link complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Link">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Link")
@XmlSeeAlso({
    AccountBalanceLink.class,
    DeviceInformationLink.class,
    AssociatedUsagePointLink.class,
    DERStatusLink.class,
    TimeLink.class,
    PrepayOperationStatusLink.class,
    PrepaymentLink.class,
    PowerStatusLink.class,
    ReadingTypeLink.class,
    EndDeviceLink.class,
    RegistrationLink.class,
    DeviceCapabilityLink.class,
    TariffProfileLink.class,
    MeterReadingLink.class,
    RateComponentLink.class,
    UsagePointLink.class,
    CustomerAccountLink.class,
    FileStatusLink.class,
    DERProgramLink.class,
    DERSettingsLink.class,
    DERCapabilityLink.class,
    ConfigurationLink.class,
    DemandResponseProgramLink.class,
    DERAvailabilityLink.class,
    SelfDeviceLink.class,
    DERCurveLink.class,
    FileLink.class,
    DefaultDERControlLink.class,
    LoadShedAvailabilityLink.class,
    ServiceSupplierLink.class,
    CurrentDERProgramLink.class,
    ReadingLink.class,
    DERLink.class,
    ListLink.class,
    DeviceStatusLink.class
})
public class Link {

    @XmlAttribute(name = "href", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String href;

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

}
