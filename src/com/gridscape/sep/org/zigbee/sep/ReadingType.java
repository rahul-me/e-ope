
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Type of data conveyed by a specific Reading. See IEC 61968 Part 9 Annex C for full definitions of these values.
 * 
 * <p>Java class for ReadingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="accumulationBehaviour" type="{http://zigbee.org/sep}AccumulationBehaviourType" minOccurs="0"/>
 *         &lt;element name="calorificValue" type="{http://zigbee.org/sep}UnitValueType" minOccurs="0"/>
 *         &lt;element name="commodity" type="{http://zigbee.org/sep}CommodityType" minOccurs="0"/>
 *         &lt;element name="conversionFactor" type="{http://zigbee.org/sep}UnitValueType" minOccurs="0"/>
 *         &lt;element name="dataQualifier" type="{http://zigbee.org/sep}DataQualifierType" minOccurs="0"/>
 *         &lt;element name="flowDirection" type="{http://zigbee.org/sep}FlowDirectionType" minOccurs="0"/>
 *         &lt;element name="intervalLength" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="kind" type="{http://zigbee.org/sep}KindType" minOccurs="0"/>
 *         &lt;element name="maxNumberOfIntervals" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="numberOfConsumptionBlocks" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="numberOfTouTiers" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="phase" type="{http://zigbee.org/sep}PhaseCode" minOccurs="0"/>
 *         &lt;element name="powerOfTenMultiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType" minOccurs="0"/>
 *         &lt;element name="subIntervalLength" type="{http://zigbee.org/sep}UInt32" minOccurs="0"/>
 *         &lt;element name="supplyLimit" type="{http://zigbee.org/sep}UInt48" minOccurs="0"/>
 *         &lt;element name="tieredConsumptionBlocks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="uom" type="{http://zigbee.org/sep}UomType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingType", propOrder = {
    "accumulationBehaviour",
    "calorificValue",
    "commodity",
    "conversionFactor",
    "dataQualifier",
    "flowDirection",
    "intervalLength",
    "kind",
    "maxNumberOfIntervals",
    "numberOfConsumptionBlocks",
    "numberOfTouTiers",
    "phase",
    "powerOfTenMultiplier",
    "subIntervalLength",
    "supplyLimit",
    "tieredConsumptionBlocks",
    "uom"
})
public class ReadingType
    extends Resource
{

    protected AccumulationBehaviourType accumulationBehaviour;
    protected UnitValueType calorificValue;
    protected CommodityType commodity;
    protected UnitValueType conversionFactor;
    protected DataQualifierType dataQualifier;
    protected FlowDirectionType flowDirection;
    protected Long intervalLength;
    protected KindType kind;
    protected Short maxNumberOfIntervals;
    protected Short numberOfConsumptionBlocks;
    protected Short numberOfTouTiers;
    protected PhaseCode phase;
    protected PowerOfTenMultiplierType powerOfTenMultiplier;
    protected Long subIntervalLength;
    protected Long supplyLimit;
    protected Boolean tieredConsumptionBlocks;
    protected UomType uom;

    /**
     * Gets the value of the accumulationBehaviour property.
     * 
     * @return
     *     possible object is
     *     {@link AccumulationBehaviourType }
     *     
     */
    public AccumulationBehaviourType getAccumulationBehaviour() {
        return accumulationBehaviour;
    }

    /**
     * Sets the value of the accumulationBehaviour property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccumulationBehaviourType }
     *     
     */
    public void setAccumulationBehaviour(AccumulationBehaviourType value) {
        this.accumulationBehaviour = value;
    }

    /**
     * Gets the value of the calorificValue property.
     * 
     * @return
     *     possible object is
     *     {@link UnitValueType }
     *     
     */
    public UnitValueType getCalorificValue() {
        return calorificValue;
    }

    /**
     * Sets the value of the calorificValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitValueType }
     *     
     */
    public void setCalorificValue(UnitValueType value) {
        this.calorificValue = value;
    }

    /**
     * Gets the value of the commodity property.
     * 
     * @return
     *     possible object is
     *     {@link CommodityType }
     *     
     */
    public CommodityType getCommodity() {
        return commodity;
    }

    /**
     * Sets the value of the commodity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommodityType }
     *     
     */
    public void setCommodity(CommodityType value) {
        this.commodity = value;
    }

    /**
     * Gets the value of the conversionFactor property.
     * 
     * @return
     *     possible object is
     *     {@link UnitValueType }
     *     
     */
    public UnitValueType getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Sets the value of the conversionFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitValueType }
     *     
     */
    public void setConversionFactor(UnitValueType value) {
        this.conversionFactor = value;
    }

    /**
     * Gets the value of the dataQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link DataQualifierType }
     *     
     */
    public DataQualifierType getDataQualifier() {
        return dataQualifier;
    }

    /**
     * Sets the value of the dataQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataQualifierType }
     *     
     */
    public void setDataQualifier(DataQualifierType value) {
        this.dataQualifier = value;
    }

    /**
     * Gets the value of the flowDirection property.
     * 
     * @return
     *     possible object is
     *     {@link FlowDirectionType }
     *     
     */
    public FlowDirectionType getFlowDirection() {
        return flowDirection;
    }

    /**
     * Sets the value of the flowDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowDirectionType }
     *     
     */
    public void setFlowDirection(FlowDirectionType value) {
        this.flowDirection = value;
    }

    /**
     * Gets the value of the intervalLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIntervalLength() {
        return intervalLength;
    }

    /**
     * Sets the value of the intervalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIntervalLength(Long value) {
        this.intervalLength = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link KindType }
     *     
     */
    public KindType getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link KindType }
     *     
     */
    public void setKind(KindType value) {
        this.kind = value;
    }

    /**
     * Gets the value of the maxNumberOfIntervals property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMaxNumberOfIntervals() {
        return maxNumberOfIntervals;
    }

    /**
     * Sets the value of the maxNumberOfIntervals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMaxNumberOfIntervals(Short value) {
        this.maxNumberOfIntervals = value;
    }

    /**
     * Gets the value of the numberOfConsumptionBlocks property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumberOfConsumptionBlocks() {
        return numberOfConsumptionBlocks;
    }

    /**
     * Sets the value of the numberOfConsumptionBlocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumberOfConsumptionBlocks(Short value) {
        this.numberOfConsumptionBlocks = value;
    }

    /**
     * Gets the value of the numberOfTouTiers property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumberOfTouTiers() {
        return numberOfTouTiers;
    }

    /**
     * Sets the value of the numberOfTouTiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumberOfTouTiers(Short value) {
        this.numberOfTouTiers = value;
    }

    /**
     * Gets the value of the phase property.
     * 
     * @return
     *     possible object is
     *     {@link PhaseCode }
     *     
     */
    public PhaseCode getPhase() {
        return phase;
    }

    /**
     * Sets the value of the phase property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhaseCode }
     *     
     */
    public void setPhase(PhaseCode value) {
        this.phase = value;
    }

    /**
     * Gets the value of the powerOfTenMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getPowerOfTenMultiplier() {
        return powerOfTenMultiplier;
    }

    /**
     * Sets the value of the powerOfTenMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setPowerOfTenMultiplier(PowerOfTenMultiplierType value) {
        this.powerOfTenMultiplier = value;
    }

    /**
     * Gets the value of the subIntervalLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubIntervalLength() {
        return subIntervalLength;
    }

    /**
     * Sets the value of the subIntervalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubIntervalLength(Long value) {
        this.subIntervalLength = value;
    }

    /**
     * Gets the value of the supplyLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSupplyLimit() {
        return supplyLimit;
    }

    /**
     * Sets the value of the supplyLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSupplyLimit(Long value) {
        this.supplyLimit = value;
    }

    /**
     * Gets the value of the tieredConsumptionBlocks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTieredConsumptionBlocks() {
        return tieredConsumptionBlocks;
    }

    /**
     * Sets the value of the tieredConsumptionBlocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTieredConsumptionBlocks(Boolean value) {
        this.tieredConsumptionBlocks = value;
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link UomType }
     *     
     */
    public UomType getUom() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link UomType }
     *     
     */
    public void setUom(UomType value) {
        this.uom = value;
    }

}
