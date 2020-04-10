
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines a collection of function set instances that are to be used by one or more devices as indicated by the EndDevice object(s) of the server.
 * 
 * <p>Java class for FunctionSetAssignmentsBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionSetAssignmentsBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="CustomerAccountListLink" type="{http://zigbee.org/sep}CustomerAccountListLink" minOccurs="0"/>
 *         &lt;element name="DemandResponseProgramListLink" type="{http://zigbee.org/sep}DemandResponseProgramListLink" minOccurs="0"/>
 *         &lt;element name="DERProgramListLink" type="{http://zigbee.org/sep}DERProgramListLink" minOccurs="0"/>
 *         &lt;element name="FileListLink" type="{http://zigbee.org/sep}FileListLink" minOccurs="0"/>
 *         &lt;element name="MessagingProgramListLink" type="{http://zigbee.org/sep}MessagingProgramListLink" minOccurs="0"/>
 *         &lt;element name="PrepaymentListLink" type="{http://zigbee.org/sep}PrepaymentListLink" minOccurs="0"/>
 *         &lt;element name="ResponseSetListLink" type="{http://zigbee.org/sep}ResponseSetListLink" minOccurs="0"/>
 *         &lt;element name="TariffProfileListLink" type="{http://zigbee.org/sep}TariffProfileListLink" minOccurs="0"/>
 *         &lt;element name="TimeLink" type="{http://zigbee.org/sep}TimeLink" minOccurs="0"/>
 *         &lt;element name="UsagePointListLink" type="{http://zigbee.org/sep}UsagePointListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionSetAssignmentsBase", propOrder = {
    "customerAccountListLink",
    "demandResponseProgramListLink",
    "derProgramListLink",
    "fileListLink",
    "messagingProgramListLink",
    "prepaymentListLink",
    "responseSetListLink",
    "tariffProfileListLink",
    "timeLink",
    "usagePointListLink"
})
@XmlSeeAlso({
    DeviceCapability.class,
    FunctionSetAssignments.class
})
public class FunctionSetAssignmentsBase
    extends Resource
{

    @XmlElement(name = "CustomerAccountListLink")
    protected CustomerAccountListLink customerAccountListLink;
    @XmlElement(name = "DemandResponseProgramListLink")
    protected DemandResponseProgramListLink demandResponseProgramListLink;
    @XmlElement(name = "DERProgramListLink")
    protected DERProgramListLink derProgramListLink;
    @XmlElement(name = "FileListLink")
    protected FileListLink fileListLink;
    @XmlElement(name = "MessagingProgramListLink")
    protected MessagingProgramListLink messagingProgramListLink;
    @XmlElement(name = "PrepaymentListLink")
    protected PrepaymentListLink prepaymentListLink;
    @XmlElement(name = "ResponseSetListLink")
    protected ResponseSetListLink responseSetListLink;
    @XmlElement(name = "TariffProfileListLink")
    protected TariffProfileListLink tariffProfileListLink;
    @XmlElement(name = "TimeLink")
    protected TimeLink timeLink;
    @XmlElement(name = "UsagePointListLink")
    protected UsagePointListLink usagePointListLink;

    /**
     * Gets the value of the customerAccountListLink property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountListLink }
     *     
     */
    public CustomerAccountListLink getCustomerAccountListLink() {
        return customerAccountListLink;
    }

    /**
     * Sets the value of the customerAccountListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountListLink }
     *     
     */
    public void setCustomerAccountListLink(CustomerAccountListLink value) {
        this.customerAccountListLink = value;
    }

    /**
     * Gets the value of the demandResponseProgramListLink property.
     * 
     * @return
     *     possible object is
     *     {@link DemandResponseProgramListLink }
     *     
     */
    public DemandResponseProgramListLink getDemandResponseProgramListLink() {
        return demandResponseProgramListLink;
    }

    /**
     * Sets the value of the demandResponseProgramListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DemandResponseProgramListLink }
     *     
     */
    public void setDemandResponseProgramListLink(DemandResponseProgramListLink value) {
        this.demandResponseProgramListLink = value;
    }

    /**
     * Gets the value of the derProgramListLink property.
     * 
     * @return
     *     possible object is
     *     {@link DERProgramListLink }
     *     
     */
    public DERProgramListLink getDERProgramListLink() {
        return derProgramListLink;
    }

    /**
     * Sets the value of the derProgramListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERProgramListLink }
     *     
     */
    public void setDERProgramListLink(DERProgramListLink value) {
        this.derProgramListLink = value;
    }

    /**
     * Gets the value of the fileListLink property.
     * 
     * @return
     *     possible object is
     *     {@link FileListLink }
     *     
     */
    public FileListLink getFileListLink() {
        return fileListLink;
    }

    /**
     * Sets the value of the fileListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileListLink }
     *     
     */
    public void setFileListLink(FileListLink value) {
        this.fileListLink = value;
    }

    /**
     * Gets the value of the messagingProgramListLink property.
     * 
     * @return
     *     possible object is
     *     {@link MessagingProgramListLink }
     *     
     */
    public MessagingProgramListLink getMessagingProgramListLink() {
        return messagingProgramListLink;
    }

    /**
     * Sets the value of the messagingProgramListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessagingProgramListLink }
     *     
     */
    public void setMessagingProgramListLink(MessagingProgramListLink value) {
        this.messagingProgramListLink = value;
    }

    /**
     * Gets the value of the prepaymentListLink property.
     * 
     * @return
     *     possible object is
     *     {@link PrepaymentListLink }
     *     
     */
    public PrepaymentListLink getPrepaymentListLink() {
        return prepaymentListLink;
    }

    /**
     * Sets the value of the prepaymentListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaymentListLink }
     *     
     */
    public void setPrepaymentListLink(PrepaymentListLink value) {
        this.prepaymentListLink = value;
    }

    /**
     * Gets the value of the responseSetListLink property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseSetListLink }
     *     
     */
    public ResponseSetListLink getResponseSetListLink() {
        return responseSetListLink;
    }

    /**
     * Sets the value of the responseSetListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseSetListLink }
     *     
     */
    public void setResponseSetListLink(ResponseSetListLink value) {
        this.responseSetListLink = value;
    }

    /**
     * Gets the value of the tariffProfileListLink property.
     * 
     * @return
     *     possible object is
     *     {@link TariffProfileListLink }
     *     
     */
    public TariffProfileListLink getTariffProfileListLink() {
        return tariffProfileListLink;
    }

    /**
     * Sets the value of the tariffProfileListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffProfileListLink }
     *     
     */
    public void setTariffProfileListLink(TariffProfileListLink value) {
        this.tariffProfileListLink = value;
    }

    /**
     * Gets the value of the timeLink property.
     * 
     * @return
     *     possible object is
     *     {@link TimeLink }
     *     
     */
    public TimeLink getTimeLink() {
        return timeLink;
    }

    /**
     * Sets the value of the timeLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeLink }
     *     
     */
    public void setTimeLink(TimeLink value) {
        this.timeLink = value;
    }

    /**
     * Gets the value of the usagePointListLink property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePointListLink }
     *     
     */
    public UsagePointListLink getUsagePointListLink() {
        return usagePointListLink;
    }

    /**
     * Sets the value of the usagePointListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePointListLink }
     *     
     */
    public void setUsagePointListLink(UsagePointListLink value) {
        this.usagePointListLink = value;
    }

}
