
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A List to which a Subscription can be requested.
 * 
 * <p>Java class for SubscribableList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscribableList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableResource">
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
@XmlType(name = "SubscribableList")
@XmlSeeAlso({
    UsagePointList.class,
    EndDeviceControlList.class,
    ReadingList.class,
    CustomerAgreementList.class,
    MessagingProgramList.class,
    TimeTariffIntervalList.class,
    ReadingSetList.class,
    BillingReadingSetList.class,
    EndDeviceList.class,
    FlowReservationResponseList.class,
    PrepaymentList.class,
    MeterReadingList.class,
    CustomerAccountList.class,
    TariffProfileList.class,
    FunctionSetAssignmentsList.class,
    LogEventList.class,
    DemandResponseProgramList.class,
    DERControlList.class,
    TextMessageList.class,
    BillingPeriodList.class
})
public class SubscribableList
    extends SubscribableResource
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
