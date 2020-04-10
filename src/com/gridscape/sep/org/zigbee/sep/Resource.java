
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A resource is an addressable unit of information, either a collection (List) or instance of an object (identifiedObject, or simply, Resource)
 * 
 * <p>Java class for Resource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Resource">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resource")
@XmlSeeAlso({
    RPLInstance.class,
    ConsumptionTariffInterval.class,
    AccountBalance.class,
    SupportedLocale.class,
    LoadShedAvailability.class,
    BillingPeriod.class,
    PrepayOperationStatus.class,
    DeviceStatus.class,
    Registration.class,
    ReadingType.class,
    PriceResponseCfg.class,
    Response.class,
    IPAddr.class,
    Neighbor.class,
    LLInterface.class,
    DERCapability.class,
    Time.class,
    IPInterface.class,
    ReadingBase.class,
    LogEvent.class,
    PowerStatus.class,
    FunctionSetAssignmentsBase.class,
    SupplyInterruptionOverride.class,
    SubscriptionBase.class,
    FileStatus.class,
    RPLSourceRoutes.class,
    RespondableResource.class,
    List.class,
    File.class,
    IdentifiedObject.class,
    SubscribableResource.class,
    DeviceInformation.class
})
public class Resource {

    @XmlAttribute(name = "href")
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
