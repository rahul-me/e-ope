package com.gridscape.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "solar_energy_production_attr" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolarEnergyProduction extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Float lattitude;
	
	@Column
	private Float longitude;
	
	@Column
	private Float system_capacity;
	
	@Column
	private Float azimuth;
	
	@Column
	private Float tilt;
	
	@Column
	private Byte array_type;
	
	@Column
	private Byte module_type;
	
	@Column
	private Float losses;
	
	@Column
	private String dataset;
	
	@Column
	private String time_frame;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "solarEnergyProduction")
	private Set<SolarEnergyProductionDetail> solarEnergyProductionDetail;

	public Float getLattitude() {
		return lattitude;
	}

	public void setLattitude(Float lattitude) {
		this.lattitude = lattitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getSystem_capacity() {
		return system_capacity;
	}

	public void setSystem_capacity(Float system_capacity) {
		this.system_capacity = system_capacity;
	}

	public Float getAzimuth() {
		return azimuth;
	}

	public void setAzimuth(Float azimuth) {
		this.azimuth = azimuth;
	}

	public Float getTilt() {
		return tilt;
	}

	public void setTilt(Float tilt) {
		this.tilt = tilt;
	}

	public Byte getArray_type() {
		return array_type;
	}

	public void setArray_type(Byte array_type) {
		this.array_type = array_type;
	}

	public Byte getModule_type() {
		return module_type;
	}

	public void setModule_type(Byte module_type) {
		this.module_type = module_type;
	}

	public Float getLosses() {
		return losses;
	}

	public void setLosses(Float losses) {
		this.losses = losses;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String getTime_frame() {
		return time_frame;
	}

	public void setTime_frame(String time_frame) {
		this.time_frame = time_frame;
	}

	public Set<SolarEnergyProductionDetail> getSolarEnergyProductionDetail() {
		return solarEnergyProductionDetail;
	}

	public void setSolarEnergyProductionDetail(Set<SolarEnergyProductionDetail> solarEnergyProductionDetail) {
		this.solarEnergyProductionDetail = solarEnergyProductionDetail;
	}

	
}

