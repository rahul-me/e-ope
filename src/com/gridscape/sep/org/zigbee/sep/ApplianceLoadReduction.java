
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The ApplianceLoadReduction object is used by a Demand Response service provider to provide signals for ENERGY STAR compliant appliances. See the definition of ApplianceLoadReductionType for more information.
 * 
 * <p>Java class for ApplianceLoadReduction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplianceLoadReduction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://zigbee.org/sep}ApplianceLoadReductionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplianceLoadReduction", propOrder = {
    "type"
})
public class ApplianceLoadReduction {

    @XmlElement(required = true)
    protected ApplianceLoadReductionType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ApplianceLoadReductionType }
     *     
     */
    public ApplianceLoadReductionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplianceLoadReductionType }
     *     
     */
    public void setType(ApplianceLoadReductionType value) {
        this.type = value;
    }

}
