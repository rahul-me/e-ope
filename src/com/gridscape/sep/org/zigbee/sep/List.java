
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Container to hold a collection of object instances or references. See [ZB 11-0167] Design Patterns section for additional details.
 * 
 * <p>Java class for List complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="List">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;attribute name="all" use="required" type="{http://zigbee.org/sep}UInt16" />
 *       &lt;attribute name="results" use="required" type="{http://zigbee.org/sep}UInt8" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "List")
@XmlSeeAlso({
    TargetReadingList.class,
    NeighborList.class,
    DERCurveList.class,
    FlowReservationRequestList.class,
    DERList.class,
    HistoricalReadingList.class,
    CreditRegisterList.class,
    ConsumptionTariffIntervalList.class,
    PriceResponseCfgList.class,
    SupportedLocaleList.class,
    MirrorUsagePointList.class,
    IPInterfaceList.class,
    SubscriptionList.class,
    ResponseSetList.class,
    RPLInstanceList.class,
    IPAddrList.class,
    ResponseList.class,
    MirrorMeterReadingList.class,
    RPLSourceRoutesList.class,
    LLInterfaceList.class,
    ServiceSupplierList.class,
    NotificationList.class,
    ProjectionReadingList.class,
    RateComponentList.class,
    DERProgramList.class,
    BillingReadingList.class,
    SupplyInterruptionOverrideList.class,
    FileList.class
})
public class List
    extends Resource
{

    @XmlAttribute(name = "all", required = true)
    protected int all;
    @XmlAttribute(name = "results", required = true)
    protected short results;

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

    /**
     * Gets the value of the results property.
     * 
     */
    public short getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     */
    public void setResults(short value) {
        this.results = value;
    }

}
