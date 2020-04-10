
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Logical point on a network at which consumption or production is either physically measured (e.g. metered) or estimated (e.g. unmetered street lights). A container for associating ReadingType, Readings and ReadingSets.
 * 
 * <p>Java class for UsagePointBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsagePointBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="roleFlags" type="{http://zigbee.org/sep}RoleFlagsType"/>
 *         &lt;element name="serviceCategoryKind" type="{http://zigbee.org/sep}ServiceKind"/>
 *         &lt;element name="status" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePointBase", propOrder = {
    "roleFlags",
    "serviceCategoryKind",
    "status"
})
@XmlSeeAlso({
    UsagePoint.class,
    MirrorUsagePoint.class
})
public class UsagePointBase
    extends IdentifiedObject
{

    @XmlElement(required = true)
    protected RoleFlagsType roleFlags;
    @XmlElement(required = true)
    protected ServiceKind serviceCategoryKind;
    protected short status;

    /**
     * Gets the value of the roleFlags property.
     * 
     * @return
     *     possible object is
     *     {@link RoleFlagsType }
     *     
     */
    public RoleFlagsType getRoleFlags() {
        return roleFlags;
    }

    /**
     * Sets the value of the roleFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleFlagsType }
     *     
     */
    public void setRoleFlags(RoleFlagsType value) {
        this.roleFlags = value;
    }

    /**
     * Gets the value of the serviceCategoryKind property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceKind }
     *     
     */
    public ServiceKind getServiceCategoryKind() {
        return serviceCategoryKind;
    }

    /**
     * Sets the value of the serviceCategoryKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceKind }
     *     
     */
    public void setServiceCategoryKind(ServiceKind value) {
        this.serviceCategoryKind = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(short value) {
        this.status = value;
    }

}
