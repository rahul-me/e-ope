
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold FlowReservationResponse objects.
 * 
 * <p>Java class for FlowReservationResponseList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlowReservationResponseList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="FlowReservationResponse" type="{http://zigbee.org/sep}FlowReservationResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlowReservationResponseList", propOrder = {
    "flowReservationResponse"
})
public class FlowReservationResponseList
    extends SubscribableList
{

    @XmlElement(name = "FlowReservationResponse")
    protected List<FlowReservationResponse> flowReservationResponse;

    /**
     * Gets the value of the flowReservationResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flowReservationResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlowReservationResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlowReservationResponse }
     * 
     * 
     */
    public List<FlowReservationResponse> getFlowReservationResponse() {
        if (flowReservationResponse == null) {
            flowReservationResponse = new ArrayList<FlowReservationResponse>();
        }
        return this.flowReservationResponse;
    }

}
