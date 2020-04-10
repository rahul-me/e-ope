
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information about the nature of an error if a request could not be completed successfully.
 * 
 * <p>Java class for Error complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Error">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maxRetryDuration" type="{http://zigbee.org/sep}UInt16" minOccurs="0"/>
 *         &lt;element name="reasonCode" type="{http://zigbee.org/sep}UInt16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Error", propOrder = {
    "maxRetryDuration",
    "reasonCode"
})
public class Error {

    protected Integer maxRetryDuration;
    protected int reasonCode;

    /**
     * Gets the value of the maxRetryDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRetryDuration() {
        return maxRetryDuration;
    }

    /**
     * Sets the value of the maxRetryDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRetryDuration(Integer value) {
        this.maxRetryDuration = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     */
    public int getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     */
    public void setReasonCode(int value) {
        this.reasonCode = value;
    }

}
