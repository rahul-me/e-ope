
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A Resource to which a Subscription can be requested.
 * 
 * <p>Java class for SubscribableResource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscribableResource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;attribute name="subscribable" type="{http://zigbee.org/sep}SubscribableType" default="0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscribableResource")
@XmlSeeAlso({
    DERSettings.class,
    DERAvailability.class,
    Configuration.class,
    SubscribableIdentifiedObject.class,
    AbstractDevice.class,
    DER.class,
    DERStatus.class,
    SubscribableList.class
})
public class SubscribableResource
    extends Resource
{

    @XmlAttribute(name = "subscribable")
    protected Short subscribable;

    /**
     * Gets the value of the subscribable property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getSubscribable() {
        if (subscribable == null) {
            return ((short) 0);
        } else {
            return subscribable;
        }
    }

    /**
     * Sets the value of the subscribable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSubscribable(Short value) {
        this.subscribable = value;
    }

}
