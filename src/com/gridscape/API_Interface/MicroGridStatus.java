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
package com.gridscape.API_Interface;

public class MicroGridStatus {
	private String grid_status;
	private String solar_out_source;
	private String battery_in_source;
	private String battery_out_source;
	private String grid_state;
	private String solar_state;
	private String battery_state;
	public String getGrid_status() {
		return grid_status;
	}
	public void setGrid_status(String grid_status) {
		this.grid_status = grid_status;
	}
	public String getSolar_out_source() {
		return solar_out_source;
	}
	public void setSolar_out_source(String solar_out_source) {
		this.solar_out_source = solar_out_source;
	}
	public String getBattery_in_source() {
		return battery_in_source;
	}
	public void setBattery_in_source(String battery_in_source) {
		this.battery_in_source = battery_in_source;
	}
	public String getBattery_out_source() {
		return battery_out_source;
	}
	public void setBattery_out_source(String battery_out_source) {
		this.battery_out_source = battery_out_source;
	}
	public String getGrid_state() {
		return grid_state;
	}
	public void setGrid_state(String grid_state) {
		this.grid_state = grid_state;
	}
	public String getSolar_state() {
		return solar_state;
	}
	public void setSolar_state(String solar_state) {
		this.solar_state = solar_state;
	}
	public String getBattery_state() {
		return battery_state;
	}
	public void setBattery_state(String battery_state) {
		this.battery_state = battery_state;
	}
	@Override
	public String toString() {
		return "MicroGridStatus [grid_status=" + grid_status
				+ ", solar_out_source=" + solar_out_source
				+ ", battery_in_source=" + battery_in_source
				+ ", battery_out_source=" + battery_out_source
				+ ", grid_state=" + grid_state + ", solar_state=" + solar_state
				+ ", battery_state=" + battery_state + "]";
	}
	
	
}

