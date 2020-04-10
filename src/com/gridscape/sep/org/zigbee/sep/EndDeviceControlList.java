
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold EndDeviceControl objects.
 * 
 * <p>Java class for EndDeviceControlList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndDeviceControlList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="EndDeviceControl" type="{http://zigbee.org/sep}EndDeviceControl" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndDeviceControlList", propOrder = {
    "endDeviceControl"
})
public class EndDeviceControlList
    extends SubscribableList
{

    @XmlElement(name = "EndDeviceControl")
    protected List<EndDeviceControl> endDeviceControl;

    /**
     * Gets the value of the endDeviceControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endDeviceControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndDeviceControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndDeviceControl }
     * 
     * 
     */
    public List<EndDeviceControl> getEndDeviceControl() {
        if (endDeviceControl == null) {
            endDeviceControl = new ArrayList<EndDeviceControl>();
        }
        return this.endDeviceControl;
    }

}
