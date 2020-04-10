
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * DER related curves such as Volt-VAr mode curves. Relationship between an independent variable (X-axis) and one or two dependent variables (Y-axis and excitation).
 * 
 * <p>Java class for DERCurve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DERCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="creationTime" type="{http://zigbee.org/sep}TimeType"/>
 *         &lt;element name="CurveData" type="{http://zigbee.org/sep}CurveData" maxOccurs="10"/>
 *         &lt;element name="curveType" type="{http://zigbee.org/sep}DERCurveType"/>
 *         &lt;element name="rampDecTms" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="rampIncTms" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="rampPT1Tms" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="xMultiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *         &lt;element name="yMultiplier" type="{http://zigbee.org/sep}PowerOfTenMultiplierType"/>
 *         &lt;element name="yRefType" type="{http://zigbee.org/sep}DERUnitRefType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DERCurve", propOrder = {
    "creationTime",
    "curveData",
    "curveType",
    "rampDecTms",
    "rampIncTms",
    "rampPT1Tms",
    "xMultiplier",
    "yMultiplier",
    "yRefType"
})
@XmlRootElement(name = "DERCurve")
public class DERCurve
    extends IdentifiedObject
{

    @XmlElement(required = true)
    protected TimeType creationTime;
    @XmlElement(name = "CurveData", required = true)
    protected List<CurveData> curveData;
    @XmlElement(required = true)
    protected DERCurveType curveType;
    protected Integer rampDecTms;
    protected Integer rampIncTms;
    protected Integer rampPT1Tms;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType xMultiplier;
    @XmlElement(required = true)
    protected PowerOfTenMultiplierType yMultiplier;
    @XmlElement(required = true)
    protected DERUnitRefType yRefType;

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreationTime(TimeType value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the curveData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the curveData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurveData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurveData }
     * 
     * 
     */
    public List<CurveData> getCurveData() {
        if (curveData == null) {
            curveData = new ArrayList<CurveData>();
        }
        return this.curveData;
    }

    /**
     * Gets the value of the curveType property.
     * 
     * @return
     *     possible object is
     *     {@link DERCurveType }
     *     
     */
    public DERCurveType getCurveType() {
        return curveType;
    }

    /**
     * Sets the value of the curveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERCurveType }
     *     
     */
    public void setCurveType(DERCurveType value) {
        this.curveType = value;
    }

    /**
     * Gets the value of the rampDecTms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRampDecTms() {
        return rampDecTms;
    }

    /**
     * Sets the value of the rampDecTms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRampDecTms(Integer value) {
        this.rampDecTms = value;
    }

    /**
     * Gets the value of the rampIncTms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRampIncTms() {
        return rampIncTms;
    }

    /**
     * Sets the value of the rampIncTms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRampIncTms(Integer value) {
        this.rampIncTms = value;
    }

    /**
     * Gets the value of the rampPT1Tms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRampPT1Tms() {
        return rampPT1Tms;
    }

    /**
     * Sets the value of the rampPT1Tms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRampPT1Tms(Integer value) {
        this.rampPT1Tms = value;
    }

    /**
     * Gets the value of the xMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getXMultiplier() {
        return xMultiplier;
    }

    /**
     * Sets the value of the xMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setXMultiplier(PowerOfTenMultiplierType value) {
        this.xMultiplier = value;
    }

    /**
     * Gets the value of the yMultiplier property.
     * 
     * @return
     *     possible object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public PowerOfTenMultiplierType getYMultiplier() {
        return yMultiplier;
    }

    /**
     * Sets the value of the yMultiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowerOfTenMultiplierType }
     *     
     */
    public void setYMultiplier(PowerOfTenMultiplierType value) {
        this.yMultiplier = value;
    }

    /**
     * Gets the value of the yRefType property.
     * 
     * @return
     *     possible object is
     *     {@link DERUnitRefType }
     *     
     */
    public DERUnitRefType getYRefType() {
        return yRefType;
    }

    /**
     * Sets the value of the yRefType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DERUnitRefType }
     *     
     */
    public void setYRefType(DERUnitRefType value) {
        this.yRefType = value;
    }

}
