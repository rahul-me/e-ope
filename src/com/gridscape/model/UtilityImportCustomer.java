package com.gridscape.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "utility_impport_customer")
public class UtilityImportCustomer extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "report_date")
	private String reportDate;
	
	@Column(name = "report_span")
	private String reportSpan;
	
	@Column(name = "total_days")
	private String totalDays;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "interval_length")
	private String intervalLength;
	
	@Column(name = "time_zone")
	private String timeZone;
	
	@Column(name = "meter")
	private String meter;
	
	@Column(name = "said")
	private String said;
	
	@Column(name = "spid")
	private String spid;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "utility_import_customer_id")
	@JsonBackReference	
	private List<IntervalData> intervalData;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "customer_id")
	private Customers customer;
	
	public UtilityImportCustomer(){}
	
	public UtilityImportCustomer(Long id,String customerName) {
		super(id);
		this.customerName = customerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportSpan() {
		return reportSpan;
	}

	public void setReportSpan(String reportSpan) {
		this.reportSpan = reportSpan;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
		this.totalDays = totalDays;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIntervalLength() {
		return intervalLength;
	}

	public void setIntervalLength(String intervalLength) {
		this.intervalLength = intervalLength;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	public String getSaid() {
		return said;
	}

	public void setSaid(String said) {
		this.said = said;
	}

	public String getSpid() {
		return spid;
	}

	public void setSpid(String spid) {
		this.spid = spid;
	}

	public List<IntervalData> getIntervalData() {
		return intervalData;
	}

	public void setIntervalData(List<IntervalData> intervalData) {
		this.intervalData = intervalData;
	}
	
	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UtilityImportCustomer [title=" + title + ", reportDate=" + reportDate + ", reportSpan=" + reportSpan
				+ ", totalDays=" + totalDays + ", customerName=" + customerName + ", intervalLength=" + intervalLength
				+ ", timeZone=" + timeZone + ", meter=" + meter + ", said=" + said + ", spid=" + spid
				+ ", intervalData=" + intervalData + "]";
	}
}
