
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * SHALL contain a Link to an instance of DERProgram.  If present, this is the DERProgram containing the currently active DERControl.
 * 
 * <p>Java class for CurrentDERProgramLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentDERProgramLink">
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
@XmlType(name = "CurrentDERProgramLink")
public class CurrentDERProgramLink
    extends Link
{


}
