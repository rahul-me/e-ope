
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * One of a sequence of thresholds defined in terms of consumption quantity of a service such as electricity, water, gas, etc. It defines the steps or blocks in a step tariff structure, where startValue simultaneously defines the entry value of this step and the closing value of the previous step. Where consumption is greater than startValue, it falls within this block and where consumption is less than or equal to startValue, it falls within one of the previous blocks.
 * 
 * <p>Java class for ConsumptionTariffInterval complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionTariffInterval">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="consumptionBlock" type="{http://zigbee.org/sep}ConsumptionBlockType"/>
 *         &lt;element name="EnvironmentalCost" type="{http://zigbee.org/sep}EnvironmentalCost" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="price" type="{http://zigbee.org/sep}Int32" minOccurs="0"/>
 *         &lt;element name="startValue" type="{http://zigbee.org/sep}UInt48"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionTariffInterval", propOrder = {
    "consumptionBlock",
    "environmentalCost",
    "price",
    "startValue"
})
public class ConsumptionTariffInterval
    extends Resource
{

    @XmlElement(required = true)
    protected ConsumptionBlockType consumptionBlock;
    @XmlElement(name = "EnvironmentalCost")
    protected List<EnvironmentalCost> environmentalCost;
    protected Integer price;
    protected long startValue;

    /**
     * Gets the value of the consumptionBlock property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionBlockType }
     *     
     */
    public ConsumptionBlockType getConsumptionBlock() {
        return consumptionBlock;
    }

    /**
     * Sets the value of the consumptionBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionBlockType }
     *     
     */
    public void setConsumptionBlock(ConsumptionBlockType value) {
        this.consumptionBlock = value;
    }

    /**
     * Gets the value of the environmentalCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the environmentalCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvironmentalCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvironmentalCost }
     * 
     * 
     */
    public List<EnvironmentalCost> getEnvironmentalCost() {
        if (environmentalCost == null) {
            environmentalCost = new ArrayList<EnvironmentalCost>();
        }
        return this.environmentalCost;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrice(Integer value) {
        this.price = value;
    }

    /**
     * Gets the value of the startValue property.
     * 
     */
    public long getStartValue() {
        return startValue;
    }

    /**
     * Sets the value of the startValue property.
     * 
     */
    public void setStartValue(long value) {
        this.startValue = value;
    }

}
