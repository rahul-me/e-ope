
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Asset container that performs one or more end device functions. Contains information about individual devices in the network.
 * 
 * <p>Java class for EndDevice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}AbstractDevice">
 *       &lt;sequence>
 *         &lt;element name="FlowReservationRequestListLink" type="{http://zigbee.org/sep}FlowReservationRequestListLink" minOccurs="0"/>
 *         &lt;element name="FlowReservationResponseListLink" type="{http://zigbee.org/sep}FlowReservationResponseListLink" minOccurs="0"/>
 *         &lt;element name="FunctionSetAssignmentsListLink" type="{http://zigbee.org/sep}FunctionSetAssignmentsListLink" minOccurs="0"/>
 *         &lt;element name="RegistrationLink" type="{http://zigbee.org/sep}RegistrationLink" minOccurs="0"/>
 *         &lt;element name="SubscriptionListLink" type="{http://zigbee.org/sep}SubscriptionListLink" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndDevice", propOrder = {
    "flowReservationRequestListLink",
    "flowReservationResponseListLink",
    "functionSetAssignmentsListLink",
    "registrationLink",
    "subscriptionListLink"
})
@XmlRootElement(name = "EndDevice")
public class EndDevice
    extends AbstractDevice
{

    @XmlElement(name = "FlowReservationRequestListLink")
    protected FlowReservationRequestListLink flowReservationRequestListLink;
    @XmlElement(name = "FlowReservationResponseListLink")
    protected FlowReservationResponseListLink flowReservationResponseListLink;
    @XmlElement(name = "FunctionSetAssignmentsListLink")
    protected FunctionSetAssignmentsListLink functionSetAssignmentsListLink;
    @XmlElement(name = "RegistrationLink")
    protected RegistrationLink registrationLink;
    @XmlElement(name = "SubscriptionListLink")
    protected SubscriptionListLink subscriptionListLink;

    /**
     * Gets the value of the flowReservationRequestListLink property.
     * 
     * @return
     *     possible object is
     *     {@link FlowReservationRequestListLink }
     *     
     */
    public FlowReservationRequestListLink getFlowReservationRequestListLink() {
        return flowReservationRequestListLink;
    }

    /**
     * Sets the value of the flowReservationRequestListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowReservationRequestListLink }
     *     
     */
    public void setFlowReservationRequestListLink(FlowReservationRequestListLink value) {
        this.flowReservationRequestListLink = value;
    }

    /**
     * Gets the value of the flowReservationResponseListLink property.
     * 
     * @return
     *     possible object is
     *     {@link FlowReservationResponseListLink }
     *     
     */
    public FlowReservationResponseListLink getFlowReservationResponseListLink() {
        return flowReservationResponseListLink;
    }

    /**
     * Sets the value of the flowReservationResponseListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowReservationResponseListLink }
     *     
     */
    public void setFlowReservationResponseListLink(FlowReservationResponseListLink value) {
        this.flowReservationResponseListLink = value;
    }

    /**
     * Gets the value of the functionSetAssignmentsListLink property.
     * 
     * @return
     *     possible object is
     *     {@link FunctionSetAssignmentsListLink }
     *     
     */
    public FunctionSetAssignmentsListLink getFunctionSetAssignmentsListLink() {
        return functionSetAssignmentsListLink;
    }

    /**
     * Sets the value of the functionSetAssignmentsListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionSetAssignmentsListLink }
     *     
     */
    public void setFunctionSetAssignmentsListLink(FunctionSetAssignmentsListLink value) {
        this.functionSetAssignmentsListLink = value;
    }

    /**
     * Gets the value of the registrationLink property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationLink }
     *     
     */
    public RegistrationLink getRegistrationLink() {
        return registrationLink;
    }

    /**
     * Sets the value of the registrationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationLink }
     *     
     */
    public void setRegistrationLink(RegistrationLink value) {
        this.registrationLink = value;
    }

    /**
     * Gets the value of the subscriptionListLink property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionListLink }
     *     
     */
    public SubscriptionListLink getSubscriptionListLink() {
        return subscriptionListLink;
    }

    /**
     * Sets the value of the subscriptionListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionListLink }
     *     
     */
    public void setSubscriptionListLink(SubscriptionListLink value) {
        this.subscriptionListLink = value;
    }

}
