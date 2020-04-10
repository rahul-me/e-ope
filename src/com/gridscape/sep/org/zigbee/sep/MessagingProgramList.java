
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold MessagingProgram objects.
 * 
 * <p>Java class for MessagingProgramList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessagingProgramList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="MessagingProgram" type="{http://zigbee.org/sep}MessagingProgram" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessagingProgramList", propOrder = {
    "messagingProgram"
})
public class MessagingProgramList
    extends SubscribableList
{

    @XmlElement(name = "MessagingProgram")
    protected List<MessagingProgram> messagingProgram;

    /**
     * Gets the value of the messagingProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messagingProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessagingProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessagingProgram }
     * 
     * 
     */
    public List<MessagingProgram> getMessagingProgram() {
        if (messagingProgram == null) {
            messagingProgram = new ArrayList<MessagingProgram>();
        }
        return this.messagingProgram;
    }

}
