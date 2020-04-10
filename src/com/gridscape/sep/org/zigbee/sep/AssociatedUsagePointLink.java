
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * SHALL contain a Link to an instance of UsagePoint.  If present, this is the submeter that monitors the DER output.
 * 
 * <p>Java class for AssociatedUsagePointLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociatedUsagePointLink">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Link">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociatedUsagePointLink")
public class AssociatedUsagePointLink
    extends Link
{


}
