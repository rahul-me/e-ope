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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "battery_status")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatteryStatus extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="state_of_helth")
	private String stateOfHelth;
	
	@Column(name="state_of_current")
	private String stateOfCurrent;
	
	@Column(name="no_of_rack")
	private String no_of_rack;
	
	@Column(name="rack_description")
	private String rack_description;
	
	@Column(name="total_size")
	private String total_size;
	
	@Column(name="temperature")
	private String temperature;
	
	@Column(name="state")
	private String state;
	
	@Column(name = "voltage_v", length = 50)
	private String voltage_v;
	
	@Column(name = "current_c")
	private String current_c;

	@Column(name = "wattage_w", length = 50)
	private String wattage_w;
	
	@Column(name="manufacture")
	private String manufacture;
	
	@Column(name = "micro_grid_id", length = 50)
	private String microgrid_id;
	
	@Column(name="battery_pic")
	private String batteryPic;
	
	@Column(name="technology")
	private String technology;
	
	@Column(name="status")
	private String status;
	
	@Column(name="level")
	private String level;
	
	@Column(name="kwh")
	private String kwh;

	public String getStateOfHelth() {
		return stateOfHelth;
	}

	public void setStateOfHelth(String stateOfHelth) {
		this.stateOfHelth = stateOfHelth;
	}

	public String getStateOfCurrent() {
		return stateOfCurrent;
	}

	public void setStateOfCurrent(String stateOfCurrent) {
		this.stateOfCurrent = stateOfCurrent;
	}

	public String getNo_of_rack() {
		return no_of_rack;
	}

	public void setNo_of_rack(String no_of_rack) {
		this.no_of_rack = no_of_rack;
	}

	public String getRack_description() {
		return rack_description;
	}

	public void setRack_description(String rack_description) {
		this.rack_description = rack_description;
	}

	public String getTotal_size() {
		return total_size;
	}

	public void setTotal_size(String total_size) {
		this.total_size = total_size;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVoltage_v() {
		return voltage_v;
	}

	public void setVoltage_v(String voltage_v) {
		this.voltage_v = voltage_v;
	}

	public String getCurrent_c() {
		return current_c;
	}

	public void setCurrent_c(String current_c) {
		this.current_c = current_c;
	}

	public String getWattage_w() {
		return wattage_w;
	}

	public void setWattage_w(String wattage_w) {
		this.wattage_w = wattage_w;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getMicrogrid_id() {
		return microgrid_id;
	}

	public void setMicrogrid_id(String microgrid_id) {
		this.microgrid_id = microgrid_id;
	}

	public String getBatteryPic() {
		return batteryPic;
	}

	public void setBatteryPic(String batteryPic) {
		this.batteryPic = batteryPic;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getKwh() {
		return kwh;
	}

	public void setKwh(String kwh) {
		this.kwh = kwh;
	}

	@Override
	public String toString() {
		return "BatteryStatus [stateOfHelth=" + stateOfHelth
				+ ", stateOfCurrent=" + stateOfCurrent + ", no_of_rack="
				+ no_of_rack + ", rack_description=" + rack_description
				+ ", total_size=" + total_size + ", temperature=" + temperature
				+ ", state=" + state + ", voltage_v=" + voltage_v
				+ ", current_c=" + current_c + ", wattage_w=" + wattage_w
				+ ", manufacture=" + manufacture + ", microgrid_id="
				+ microgrid_id + ", batteryPic=" + batteryPic + ", technology="
				+ technology + ", status=" + status + ", level=" + level
				+ ", kwh=" + kwh + "]";
	}
	
	
}
