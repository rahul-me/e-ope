package com.gridscape.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "interval_data")
public class IntervalData extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "time_stamp")
	private Timestamp timeStamp;
	@Column(name = "usage_val")
	private Float usageVal;
	@Column(name = "units")
	private String units;
	@Column(name = "usage_amount")
	private Float usageAmount;
	@ManyToOne
	@JoinColumn(name = "utility_import_customer_id")
	@JsonManagedReference
	private UtilityImportCustomer utilityImportCustomer;

	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Float getUsageVal() {
		return usageVal;
	}

	public void setUsageVal(Float usageVal) {
		this.usageVal = usageVal;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Float getUsageAmount() {
		return usageAmount;
	}

	public void setUsageAmount(Float usageAmount) {
		this.usageAmount = usageAmount;
	}

	public UtilityImportCustomer getUtilityImportCustomer() {
		return utilityImportCustomer;
	}

	public void setUtilityImportCustomer(UtilityImportCustomer utilityImportCustomer) {
		this.utilityImportCustomer = utilityImportCustomer;
	}

}
