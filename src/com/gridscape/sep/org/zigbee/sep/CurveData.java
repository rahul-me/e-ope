
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Data point values for defining a curve or schedule
 * 
 * <p>Java class for CurveData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurveData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="excitation" type="{http://zigbee.org/sep}Int8" minOccurs="0"/>
 *         &lt;element name="xvalue" type="{http://zigbee.org/sep}Int32"/>
 *         &lt;element name="yvalue" type="{http://zigbee.org/sep}Int32"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurveData", propOrder = {
    "excitation",
    "xvalue",
    "yvalue"
})
public class CurveData {

    protected Byte excitation;
    protected int xvalue;
    protected int yvalue;

    /**
     * Gets the value of the excitation property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getExcitation() {
        return excitation;
    }

    /**
     * Sets the value of the excitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setExcitation(Byte value) {
        this.excitation = value;
    }

    /**
     * Gets the value of the xvalue property.
     * 
     */
    public int getXvalue() {
        return xvalue;
    }

    /**
     * Sets the value of the xvalue property.
     * 
     */
    public void setXvalue(int value) {
        this.xvalue = value;
    }

    /**
     * Gets the value of the yvalue property.
     * 
     */
    public int getYvalue() {
        return yvalue;
    }

    /**
     * Sets the value of the yvalue property.
     * 
     */
    public void setYvalue(int value) {
        this.yvalue = value;
    }

}
