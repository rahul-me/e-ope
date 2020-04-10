
package com.gridscape.sep.org.zigbee.sep;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specific RPLInstance resource.  This resource may be thought of as network status information for a specific RPL instance associated with IPInterface.
 * 
 * <p>Java class for RPLInstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RPLInstance">
 *   &lt;complexContent>
 *     &lt;extension base="{http://zigbee.org/sep}Resource">
 *       &lt;sequence>
 *         &lt;element name="DODAGid" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="DODAGroot" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flags" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="groundedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MOP" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="PRF" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="rank" type="{http://zigbee.org/sep}UInt16"/>
 *         &lt;element name="RPLInstanceID" type="{http://zigbee.org/sep}UInt8"/>
 *         &lt;element name="RPLSourceRoutesListLink" type="{http://zigbee.org/sep}RPLSourceRoutesListLink" minOccurs="0"/>
 *         &lt;element name="versionNumber" type="{http://zigbee.org/sep}UInt8"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RPLInstance", propOrder = {
    "dodaGid",
    "dodaGroot",
    "flags",
    "groundedFlag",
    "mop",
    "prf",
    "rank",
    "rplInstanceID",
    "rplSourceRoutesListLink",
    "versionNumber"
})
public class RPLInstance
    extends Resource
{

    @XmlElement(name = "DODAGid")
    protected short dodaGid;
    @XmlElement(name = "DODAGroot")
    protected boolean dodaGroot;
    protected short flags;
    protected boolean groundedFlag;
    @XmlElement(name = "MOP")
    protected short mop;
    @XmlElement(name = "PRF")
    protected short prf;
    protected int rank;
    @XmlElement(name = "RPLInstanceID")
    protected short rplInstanceID;
    @XmlElement(name = "RPLSourceRoutesListLink")
    protected RPLSourceRoutesListLink rplSourceRoutesListLink;
    protected short versionNumber;

    /**
     * Gets the value of the dodaGid property.
     * 
     */
    public short getDODAGid() {
        return dodaGid;
    }

    /**
     * Sets the value of the dodaGid property.
     * 
     */
    public void setDODAGid(short value) {
        this.dodaGid = value;
    }

    /**
     * Gets the value of the dodaGroot property.
     * 
     */
    public boolean isDODAGroot() {
        return dodaGroot;
    }

    /**
     * Sets the value of the dodaGroot property.
     * 
     */
    public void setDODAGroot(boolean value) {
        this.dodaGroot = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     */
    public short getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     */
    public void setFlags(short value) {
        this.flags = value;
    }

    /**
     * Gets the value of the groundedFlag property.
     * 
     */
    public boolean isGroundedFlag() {
        return groundedFlag;
    }

    /**
     * Sets the value of the groundedFlag property.
     * 
     */
    public void setGroundedFlag(boolean value) {
        this.groundedFlag = value;
    }

    /**
     * Gets the value of the mop property.
     * 
     */
    public short getMOP() {
        return mop;
    }

    /**
     * Sets the value of the mop property.
     * 
     */
    public void setMOP(short value) {
        this.mop = value;
    }

    /**
     * Gets the value of the prf property.
     * 
     */
    public short getPRF() {
        return prf;
    }

    /**
     * Sets the value of the prf property.
     * 
     */
    public void setPRF(short value) {
        this.prf = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     */
    public void setRank(int value) {
        this.rank = value;
    }

    /**
     * Gets the value of the rplInstanceID property.
     * 
     */
    public short getRPLInstanceID() {
        return rplInstanceID;
    }

    /**
     * Sets the value of the rplInstanceID property.
     * 
     */
    public void setRPLInstanceID(short value) {
        this.rplInstanceID = value;
    }

    /**
     * Gets the value of the rplSourceRoutesListLink property.
     * 
     * @return
     *     possible object is
     *     {@link RPLSourceRoutesListLink }
     *     
     */
    public RPLSourceRoutesListLink getRPLSourceRoutesListLink() {
        return rplSourceRoutesListLink;
    }

    /**
     * Sets the value of the rplSourceRoutesListLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link RPLSourceRoutesListLink }
     *     
     */
    public void setRPLSourceRoutesListLink(RPLSourceRoutesListLink value) {
        this.rplSourceRoutesListLink = value;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     */
    public short getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     */
    public void setVersionNumber(short value) {
        this.versionNumber = value;
    }

}
