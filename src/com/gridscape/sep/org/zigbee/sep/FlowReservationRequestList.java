
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold FlowReservationRequest objects.
 * 
 * <p>Java class for FlowReservationRequestList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlowReservationRequestList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="FlowReservationRequest" type="{http://zigbee.org/sep}FlowReservationRequest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlowReservationRequestList", propOrder = {
    "flowReservationRequest"
})
public class FlowReservationRequestList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "FlowReservationRequest")
    protected java.util.List<FlowReservationRequest> flowReservationRequest;

    /**
     * Gets the value of the flowReservationRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flowReservationRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlowReservationRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlowReservationRequest }
     * 
     * 
     */
    public java.util.List<FlowReservationRequest> getFlowReservationRequest() {
        if (flowReservationRequest == null) {
            flowReservationRequest = new ArrayList<FlowReservationRequest>();
        }
        return this.flowReservationRequest;
    }

}
