/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  

package com.gridscape.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "solar_output")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolarOutput extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String DeviceName;
	private String FGANumber;
	private String UniqueIDNumber;
	private String FirmwareVersion;
	private String MBAddr;
	private String Active;
	private String ChgEn;
	private String OpState;
	private String ChgSts;
	private String ActiveFlt;
	private String ActiveWrn;
	private String ChgModeSts;
	private String VdcIn;
	private String IdcIn;
	private String PdcIn;
	private String VdcOut;
	private String IdcOut;
	private String PdcOut;
	private String Tbatt;
	private String AuxTrigSts;
	private String AuxOnReason;
	private String AuxOffReason;
	private String CfgErrors;
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	public String getFGANumber() {
		return FGANumber;
	}
	public void setFGANumber(String fGANumber) {
		FGANumber = fGANumber;
	}
	public String getUniqueIDNumber() {
		return UniqueIDNumber;
	}
	public void setUniqueIDNumber(String uniqueIDNumber) {
		UniqueIDNumber = uniqueIDNumber;
	}
	public String getFirmwareVersion() {
		return FirmwareVersion;
	}
	public void setFirmwareVersion(String firmwareVersion) {
		FirmwareVersion = firmwareVersion;
	}
	public String getMBAddr() {
		return MBAddr;
	}
	public void setMBAddr(String mBAddr) {
		MBAddr = mBAddr;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getChgEn() {
		return ChgEn;
	}
	public void setChgEn(String chgEn) {
		ChgEn = chgEn;
	}
	public String getOpState() {
		return OpState;
	}
	public void setOpState(String opState) {
		OpState = opState;
	}
	public String getChgSts() {
		return ChgSts;
	}
	public void setChgSts(String chgSts) {
		ChgSts = chgSts;
	}
	public String getActiveFlt() {
		return ActiveFlt;
	}
	public void setActiveFlt(String activeFlt) {
		ActiveFlt = activeFlt;
	}
	public String getActiveWrn() {
		return ActiveWrn;
	}
	public void setActiveWrn(String activeWrn) {
		ActiveWrn = activeWrn;
	}
	public String getChgModeSts() {
		return ChgModeSts;
	}
	public void setChgModeSts(String chgModeSts) {
		ChgModeSts = chgModeSts;
	}
	public String getVdcIn() {
		return VdcIn;
	}
	public void setVdcIn(String vdcIn) {
		VdcIn = vdcIn;
	}
	public String getIdcIn() {
		return IdcIn;
	}
	public void setIdcIn(String idcIn) {
		IdcIn = idcIn;
	}
	public String getPdcIn() {
		return PdcIn;
	}
	public void setPdcIn(String pdcIn) {
		PdcIn = pdcIn;
	}
	public String getVdcOut() {
		return VdcOut;
	}
	public void setVdcOut(String vdcOut) {
		VdcOut = vdcOut;
	}
	public String getIdcOut() {
		return IdcOut;
	}
	public void setIdcOut(String idcOut) {
		IdcOut = idcOut;
	}
	public String getPdcOut() {
		return PdcOut;
	}
	public void setPdcOut(String pdcOut) {
		PdcOut = pdcOut;
	}
	public String getTbatt() {
		return Tbatt;
	}
	public void setTbatt(String tbatt) {
		Tbatt = tbatt;
	}
	public String getAuxTrigSts() {
		return AuxTrigSts;
	}
	public void setAuxTrigSts(String auxTrigSts) {
		AuxTrigSts = auxTrigSts;
	}
	public String getAuxOnReason() {
		return AuxOnReason;
	}
	public void setAuxOnReason(String auxOnReason) {
		AuxOnReason = auxOnReason;
	}
	public String getAuxOffReason() {
		return AuxOffReason;
	}
	public void setAuxOffReason(String auxOffReason) {
		AuxOffReason = auxOffReason;
	}
	public String getCfgErrors() {
		return CfgErrors;
	}
	public void setCfgErrors(String cfgErrors) {
		CfgErrors = cfgErrors;
	}	
}

