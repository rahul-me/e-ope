
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A RPL source routes object.
 * 
 * <p>Java class for RPLSourceRoutes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RPLSourceRoutes">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="DestAddress" type="{http://zigbee.org/sep}HexBinary128"/>
 *         &lt;element name="SourceRoute" type="{http://zigbee.org/sep}HexBinary128"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPLSourceRoutes", propOrder = {
    "destAddress",
    "sourceRoute"
})
public class RPLSourceRoutes
    extends Resource
{

    @XmlElement(name = "DestAddress", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] destAddress;
    @XmlElement(name = "SourceRoute", required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] sourceRoute;

    /**
     * Gets the value of the destAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDestAddress() {
        return destAddress;
    }

    /**
     * Sets the value of the destAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestAddress(byte[] value) {
        this.destAddress = value;
    }

    /**
     * Gets the value of the sourceRoute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getSourceRoute() {
        return sourceRoute;
    }

    /**
     * Sets the value of the sourceRoute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRoute(byte[] value) {
        this.sourceRoute = value;
    }

}
