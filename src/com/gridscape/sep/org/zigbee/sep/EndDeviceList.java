
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold EndDevice objects.
 * 
 * <p>Java class for EndDeviceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndDeviceList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="EndDevice" type="{http://zigbee.org/sep}EndDevice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndDeviceList", propOrder = {
    "endDevice"
})
@XmlRootElement(name = "EndDeviceList")
public class EndDeviceList
    extends SubscribableList
{

    @XmlElement(name = "EndDevice")
    protected List<EndDevice> endDevice;

    /**
     * Gets the value of the endDevice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endDevice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndDevice }
     * 
     * 
     */
    public List<EndDevice> getEndDevice() {
        if (endDevice == null) {
            endDevice = new ArrayList<EndDevice>();
        }
        return this.endDevice;
    }

}
