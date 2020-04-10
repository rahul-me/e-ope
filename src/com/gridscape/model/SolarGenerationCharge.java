package com.gridscape.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="solar_generation_charge")
public class SolarGenerationCharge extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String mgc_id;
	
	@Column
	private Float rate;
	
	@Column
	private String rate_unit;
	
	@Column
	private Integer year;
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getRate_unit_symb() {
		return rate_unit_symb;
	}

	public void setRate_unit_symb(String rate_unit_symb) {
		this.rate_unit_symb = rate_unit_symb;
	}

	@Column
	private String rate_unit_symb;
	
	public String getRateUnit() {
		return rate_unit;
	}

	public void setRateUnit(String rateUnit) {
		this.rate_unit = rateUnit;
	}

	@Column
	private Integer month_index;

	public String getMgc_id() {
		return mgc_id;
	}

	public void setMgc_id(String mgc_id) {
		this.mgc_id = mgc_id;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Integer getMonth() {
		return month_index;
	}

	public void setMonth(Integer month) {
		this.month_index = month;
	}
	
	
	
}

