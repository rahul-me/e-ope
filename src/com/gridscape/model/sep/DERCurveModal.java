package com.gridscape.model.sep;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_der_curve")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DERCurveModal extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6860061103142203203L;	
	
	@Column(name = "creation_time")
	private Long creationTime;
	
	@Column(name = "der_curve_type")
	private Short derCurveType;
	
	@Column(name = "ramp_dec_tms")
	private Integer rampDecTms;
	
	@Column(name = "ramp_inc_tms")
	private Integer rampIncTms;
	
	@Column(name = "ramp_pt1_tms")
	private Integer rampPT1Tms;
	
	@Column(name = "x_multiplier")
	private Byte xMultiplier;
	
	@Column(name = "y_multiplier")
	private Byte yMultiplier;
	
	@Column(name = "der_unit_ref_type")
	private Short derUnitRefType;
	
	@Column(name = "derpId")
	private Long derpId;	
	
	@Column
	private String description;
	
	@Column
	private String mrid;
	
	@Column
	private Integer version;
	
	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Short getDerCurveType() {
		return derCurveType;
	}

	public void setDerCurveType(Short derCurveType) {
		this.derCurveType = derCurveType;
	}

	public Integer getRampDecTms() {
		return rampDecTms;
	}

	public void setRampDecTms(Integer rampDecTms) {
		this.rampDecTms = rampDecTms;
	}

	public Integer getRampIncTms() {
		return rampIncTms;
	}

	public void setRampIncTms(Integer rampIncTms) {
		this.rampIncTms = rampIncTms;
	}

	public Integer getRampPT1Tms() {
		return rampPT1Tms;
	}

	public void setRampPT1Tms(Integer rampPT1Tms) {
		this.rampPT1Tms = rampPT1Tms;
	}

	public Byte getxMultiplier() {
		return xMultiplier;
	}

	public void setxMultiplier(Byte xMultiplier) {
		this.xMultiplier = xMultiplier;
	}

	public Byte getyMultiplier() {
		return yMultiplier;
	}

	public void setyMultiplier(Byte yMultiplier) {
		this.yMultiplier = yMultiplier;
	}

	public Short getDerUnitRefType() {
		return derUnitRefType;
	}

	public void setDerUnitRefType(Short derUnitRefType) {
		this.derUnitRefType = derUnitRefType;
	}

	public Long getDerpId() {
		return derpId;
	}

	public void setDerpId(Long derpId) {
		this.derpId = derpId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMrid() {
		return mrid;
	}

	public void setMrid(String mrid) {
		this.mrid = mrid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	} 
	
	
}

