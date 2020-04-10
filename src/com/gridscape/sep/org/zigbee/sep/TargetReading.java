
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains readings that specify a target or goal, such as a consumption target, to which billing incentives or other contractual ramifications may be associated.
 * 
 * <p>Java class for TargetReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetReading">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}BillingMeterReadingBase">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetReading")
public class TargetReading
    extends BillingMeterReadingBase
{


}
