
package com.gridscape.sep.org.zigbee.sep;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A List element to hold ResponseSet objects.
 * 
 * <p>Java class for ResponseSetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseSetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}List">
 *       &lt;sequence>
 *         &lt;element name="ResponseSet" type="{http://zigbee.org/sep}ResponseSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseSetList", propOrder = {
    "responseSet"
})
public class ResponseSetList
    extends com.gridscape.sep.org.zigbee.sep.List
{

    @XmlElement(name = "ResponseSet")
    protected java.util.List<ResponseSet> responseSet;

    /**
     * Gets the value of the responseSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responseSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponseSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseSet }
     * 
     * 
     */
    public java.util.List<ResponseSet> getResponseSet() {
        if (responseSet == null) {
            responseSet = new ArrayList<ResponseSet>();
        }
        return this.responseSet;
    }

}
