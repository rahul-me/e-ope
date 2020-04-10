
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold TextMessage objects.
 * 
 * <p>Java class for TextMessageList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextMessageList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="TextMessage" type="{http://zigbee.org/sep}TextMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextMessageList", propOrder = {
    "textMessage"
})
public class TextMessageList
    extends SubscribableList
{

    @XmlElement(name = "TextMessage")
    protected List<TextMessage> textMessage;

    /**
     * Gets the value of the textMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMessage }
     * 
     * 
     */
    public List<TextMessage> getTextMessage() {
        if (textMessage == null) {
            textMessage = new ArrayList<TextMessage>();
        }
        return this.textMessage;
    }

}
