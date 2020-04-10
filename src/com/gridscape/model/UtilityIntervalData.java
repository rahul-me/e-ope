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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="utility_interval_data")
public class UtilityIntervalData extends BaseEntity{
	
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="account_no")
	private String account_no;
	@Column(name="service_no")
	private String service_no;
	@Column(name="u_type")
	private String type;
	@Column(name="date",columnDefinition="date")
	private Date date;
	@Column(name="start_time")
	private String start_time;
	@Column(name="end_time")
	private String end_time;
	@Column(name="u_usage")
	private String usage;
	@Column(name="units")
	private String units;
	@Column(name="cost")
	private String cost;
	@Column(name="notes")
	private String notes;
	@Column(name="unit_cost")
	private String unit_cost;
	@Column(name="cal_price")
	private Float cal_price;
	@Column(name="generation")
	private String generation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getService_no() {
		return service_no;
	}
	public void setService_no(String service_no) {
		this.service_no = service_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(String unit_cost) {
		this.unit_cost = unit_cost;
	}	
	public Float getCal_price() {
		return cal_price;
	}
	public void setCal_price(Float cal_price) {
		this.cal_price = cal_price;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	@Override
	public String toString() {
		return "UtilityIntervalData [name=" + name + ", address=" + address
				+ ", account_no=" + account_no + ", service_no=" + service_no
				+ ", type=" + type + ", date=" + date + ", start_time="
				+ start_time + ", end_time=" + end_time + ", usage=" + usage
				+ ", units=" + units + ", cost=" + cost + ", notes=" + notes
				+ ", unit_cost=" + unit_cost + ", cal_price=" + cal_price
				+ ", generation=" + generation + "]";
	}
		
}

