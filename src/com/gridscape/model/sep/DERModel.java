package com.gridscape.model.sep;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_der")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DERModel extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232730302762888635L;
	
	@Column(name = "der_programs")
	private String derPrograms;
	
	@Column(name = "current_der_program")
	private Long currentDerProgram;
	
	@Column(name = "end_device_id")
	private Long endDeviceId;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "derModel", cascade = CascadeType.ALL)
	private DERStatusModel derStatusModel;
	
	@Column(name = "der_capability", columnDefinition="MEDIUMTEXT")
	private String derCapability;
	
	@Column(name = "der_settings", columnDefinition = "mediumtext")
	private String derSettings;
	
	public String getDerPrograms() {
		return derPrograms;
	}

	public DERStatusModel getDerStatusModel() {
		return derStatusModel;
	}

	public void setDerStatusModel(DERStatusModel derStatusModel) {
		this.derStatusModel = derStatusModel;
	}

	public void setDerPrograms(String derPrograms) {
		this.derPrograms = derPrograms;
	}

	public Long getCurrentDerProgram() {
		return currentDerProgram;
	}

	public void setCurrentDerProgram(Long currentDerProgram) {
		this.currentDerProgram = currentDerProgram;
	}

	public Long getEndDeviceId() {
		return endDeviceId;
	}

	public void setEndDeviceId(Long endDeviceId) {
		this.endDeviceId = endDeviceId;
	}

	public String getDerCapability() {
		return derCapability;
	}

	public void setDerCapability(String derCapability) {
		this.derCapability = derCapability;
	}

	public String getDerSettings() {
		return derSettings;
	}

	public void setDerSettings(String derSettings) {
		this.derSettings = derSettings;
	}
}

