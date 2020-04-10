
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * To be used to present readings that have been processed and possibly corrected (as allowed, due to missing or incorrect data) by backend systems. This includes quality codes valid, verified, estimated, and derived / corrected.
 * 
 * <p>Java class for HistoricalReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoricalReading">
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
@XmlType(name = "HistoricalReading")
public class HistoricalReading
    extends BillingMeterReadingBase
{


}
