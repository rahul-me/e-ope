package com.gridscape.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solar_energy_production_detail")
public class SolarEnergyProductionDetail extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date start_time;
	
	@Temporal(TemporalType.TIME)
	private Date end_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_time;
	
	@Column
	private Float ac_output;
	
	@Column
	private Float dc_output;
	
	@Column
	private String ac_output_unit;
	
	@Column
	private Double cost;
	
	@Column
	private String cost_unit;
	
	public String getAc_output_unit() {
		return ac_output_unit;
	}

	public void setAc_output_unit(String ac_output_unit) {
		this.ac_output_unit = ac_output_unit;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCost_unit() {
		return cost_unit;
	}

	public void setCost_unit(String cost_unit) {
		this.cost_unit = cost_unit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="solar_energy_production_attr_id", nullable = false)
	private SolarEnergyProduction solarEnergyProduction;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public Float getAc_output() {
		return ac_output;
	}

	public void setAc_output(Float ac_output) {
		this.ac_output = ac_output;
	}

	public Float getDc_output() {
		return dc_output;
	}

	public void setDc_output(Float dc_output) {
		this.dc_output = dc_output;
	}

	public SolarEnergyProduction getSolarEnergyProduction() {
		return solarEnergyProduction;
	}

	public void setSolarEnergyProduction(SolarEnergyProduction solarEnergyProduction) {
		this.solarEnergyProduction = solarEnergyProduction;
	}

	
}

