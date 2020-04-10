
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains values that forecast a future reading for the time or interval specified.
 * 
 * <p>Java class for ProjectionReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectionReading">
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
@XmlType(name = "ProjectionReading")
public class ProjectionReading
    extends BillingMeterReadingBase
{


}
