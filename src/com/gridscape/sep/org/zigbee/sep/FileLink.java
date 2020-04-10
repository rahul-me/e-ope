
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * This element MUST be set to the URI of the most recent File being loaded/activated by the LD. In the case of file status 0, this element MUST be omitted.
 * 
 * <p>Java class for FileLink complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileLink">
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
@XmlType(name = "FileLink")
public class FileLink
    extends Link
{


}
