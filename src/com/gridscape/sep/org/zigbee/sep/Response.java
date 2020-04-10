
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The Response object is the generic response data repository for functions which do not have additional specific data (e.g. DRLC has additional data fields (SetPoint) where Price and Text event do not).
 * 
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="createdDateTime" type="{http://zigbee.org/sep}TimeType" minOccurs="0"/>
 *         &lt;element name="endDeviceLFDI" type="{http://zigbee.org/sep}HexBinary160"/>
 *         &lt;element name="status" type="{http://zigbee.org/sep}UInt8" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://zigbee.org/sep}mRIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "createdDateTime",
    "endDeviceLFDI",
    "status",
    "subject"
})
@XmlSeeAlso({
    PriceResponse.class,
    DrResponse.class,
    TextResponse.class
})
public class Response
    extends Resource
{

    protected TimeType createdDateTime;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] endDeviceLFDI;
    protected Short status;
    @XmlElement(required = true)
    protected MRIDType subject;

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setCreatedDateTime(TimeType value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the endDeviceLFDI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getEndDeviceLFDI() {
        return endDeviceLFDI;
    }

    /**
     * Sets the value of the endDeviceLFDI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDeviceLFDI(byte[] value) {
        this.endDeviceLFDI = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setStatus(Short value) {
        this.status = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link MRIDType }
     *     
     */
    public MRIDType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link MRIDType }
     *     
     */
    public void setSubject(MRIDType value) {
        this.subject = value;
    }

}
