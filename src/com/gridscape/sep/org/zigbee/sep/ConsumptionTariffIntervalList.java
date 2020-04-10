
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold ConsumptionTariffInterval objects.
 * 
 * <p>Java class for ConsumptionTariffIntervalList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionTariffIntervalList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="ConsumptionTariffInterval" type="{http://zigbee.org/sep}ConsumptionTariffInterval" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionTariffIntervalList", propOrder = {
    "consumptionTariffInterval"
})
public class ConsumptionTariffIntervalList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "ConsumptionTariffInterval", required = true)
    protected java.util.List<ConsumptionTariffInterval> consumptionTariffInterval;

    /**
     * Gets the value of the consumptionTariffInterval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionTariffInterval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionTariffInterval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionTariffInterval }
     * 
     * 
     */
    public java.util.List<ConsumptionTariffInterval> getConsumptionTariffInterval() {
        if (consumptionTariffInterval == null) {
            consumptionTariffInterval = new ArrayList<ConsumptionTariffInterval>();
        }
        return this.consumptionTariffInterval;
    }

}
