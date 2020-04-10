package com.gridscape.model.sep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_mirror_usage_point")
public class MirrorUsagePointModel extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 85624743868993095L;

	@Column(name = "device_lfdi")
	private byte[] deviceLFDI;
	
	@Column(name = "mirror_meter_reading_list", columnDefinition = "MEDIUMTEXT")
	private String mirrorMeterReadingList;
	
	@Column(name = "role_flags")
	private byte[] roleFlags;
	
	@Column(name = "service_cat_kind")
	private Short serviceCategoryKind;
	
	@Column
	private Short status;
	
	public byte[] getDeviceLFDI() {
		return deviceLFDI;
	}

	public void setDeviceLFDI(byte[] deviceLFDI) {
		this.deviceLFDI = deviceLFDI;
	}

	public String getMirrorMeterReadingList() {
		return mirrorMeterReadingList;
	}

	public void setMirrorMeterReadingList(String mirrorMeterReadingList) {
		this.mirrorMeterReadingList = mirrorMeterReadingList;
	}

	public byte[] getRoleFlags() {
		return roleFlags;
	}

	public void setRoleFlags(byte[] roleFlags) {
		this.roleFlags = roleFlags;
	}

	public Short getServiceCategoryKind() {
		return serviceCategoryKind;
	}

	public void setServiceCategoryKind(Short serviceCategoryKind) {
		this.serviceCategoryKind = serviceCategoryKind;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public byte[] getMrid() {
		return mrid;
	}

	public void setMrid(byte[] mrid) {
		this.mrid = mrid;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	private byte[] mrid;
	
	@Column(columnDefinition = "int default 0")
	private int version;
	
	@Column
	private String description;
	
	
}

