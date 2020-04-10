
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold TariffProfile objects.
 * 
 * <p>Java class for TariffProfileList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TariffProfileList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="TariffProfile" type="{http://zigbee.org/sep}TariffProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TariffProfileList", propOrder = {
    "tariffProfile"
})
public class TariffProfileList
    extends SubscribableList
{

    @XmlElement(name = "TariffProfile")
    protected List<TariffProfile> tariffProfile;

    /**
     * Gets the value of the tariffProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffProfile }
     * 
     * 
     */
    public List<TariffProfile> getTariffProfile() {
        if (tariffProfile == null) {
            tariffProfile = new ArrayList<TariffProfile>();
        }
        return this.tariffProfile;
    }

}
