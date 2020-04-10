
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * ListLinks provide a reference, via URI, to a List.
 * 
 * <p>Java class for ListLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListLink">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Link">
 *       &lt;attribute name="all" use="required" type="{http://zigbee.org/sep}UInt16" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListLink")
@XmlSeeAlso({
    TariffProfileListLink.class,
    SubscriptionListLink.class,
    SupportedLocaleListLink.class,
    ActiveSupplyInterruptionOverrideListLink.class,
    TimeTariffIntervalListLink.class,
    EndDeviceListLink.class,
    LogEventListLink.class,
    ProjectionReadingListLink.class,
    ActiveProjectionReadingListLink.class,
    SupplyInterruptionOverrideListLink.class,
    RPLInstanceListLink.class,
    NeighborListLink.class,
    MirrorUsagePointListLink.class,
    NotificationListLink.class,
    ActiveFlowReservationListLink.class,
    AssociatedDERProgramListLink.class,
    FlowReservationResponseListLink.class,
    UsagePointListLink.class,
    ConsumptionTariffIntervalListLink.class,
    MessagingProgramListLink.class,
    ResponseListLink.class,
    DERCurveListLink.class,
    TargetReadingListLink.class,
    FlowReservationRequestListLink.class,
    RPLSourceRoutesListLink.class,
    CustomerAgreementListLink.class,
    HistoricalReadingListLink.class,
    CreditRegisterListLink.class,
    ActiveDERControlListLink.class,
    EndDeviceControlListLink.class,
    IPInterfaceListLink.class,
    DemandResponseProgramListLink.class,
    CustomerAccountListLink.class,
    BillingReadingListLink.class,
    PriceResponseCfgListLink.class,
    DERControlListLink.class,
    TextMessageListLink.class,
    DERListLink.class,
    BillingReadingSetListLink.class,
    ActiveBillingPeriodListLink.class,
    ActiveTargetReadingListLink.class,
    DERProgramListLink.class,
    ReadingSetListLink.class,
    IPAddrListLink.class,
    BillingPeriodListLink.class,
    ActiveCreditRegisterListLink.class,
    LLInterfaceListLink.class,
    ReadingListLink.class,
    FileListLink.class,
    FunctionSetAssignmentsListLink.class,
    ResponseSetListLink.class,
    ActiveTimeTariffIntervalListLink.class,
    ActiveTextMessageListLink.class,
    PrepaymentListLink.class,
    RateComponentListLink.class,
    MeterReadingListLink.class,
    ActiveEndDeviceControlListLink.class
})
public class ListLink
    extends Link
{

    @XmlAttribute(name = "all", required = true)
    protected int all;

    /**
     * Gets the value of the all property.
     * 
     */
    public int getAll() {
        return all;
    }

    /**
     * Sets the value of the all property.
     * 
     */
    public void setAll(int value) {
        this.all = value;
    }

}
