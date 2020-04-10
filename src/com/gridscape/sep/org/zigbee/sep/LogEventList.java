
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold LogEvent objects.
 * 
 * <p>Java class for LogEventList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogEventList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}SubscribableList">
 *       &lt;sequence>
 *         &lt;element name="LogEvent" type="{http://zigbee.org/sep}LogEvent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogEventList", propOrder = {
    "logEvent"
})
@XmlRootElement(name = "LogEventList")
public class LogEventList
    extends SubscribableList
{

    @XmlElement(name = "LogEvent")
    protected List<LogEvent> logEvent;

    /**
     * Gets the value of the logEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogEvent }
     * 
     * 
     */
    public List<LogEvent> getLogEvent() {
        if (logEvent == null) {
            logEvent = new ArrayList<LogEvent>();
        }
        return this.logEvent;
    }

}
