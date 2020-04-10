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
package com.gridscape.jsoninput;

public class JsonMicrGridProfile {

	private Long id;
	private String microgrid_id;
	private String microgrid_name;
	private String start_time;
	private String end_time;
	private Long lng_start_time;
	private Long lng_end_time;
	private String battery_low_threshold;
	private String battery_charge_source;
	private String standard_situation;
	private String critical_situation;
	private String battery_low;
	private String solar_low;
	private boolean solar_present;
	private boolean solar_gr_load;
	private int battery_soc;
	
	
	public boolean isSolar_present() {
		return solar_present;
	}
	public void setSolar_present(boolean solar_present) {
		this.solar_present = solar_present;
	}
	public boolean isSolar_gr_load() {
		return solar_gr_load;
	}
	public void setSolar_gr_load(boolean solar_gr_load) {
		this.solar_gr_load = solar_gr_load;
	}
	public int getBattery_soc() {
		return battery_soc;
	}
	public void setBattery_soc(int battery_soc) {
		this.battery_soc = battery_soc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMicrogrid_id() {
		return microgrid_id;
	}
	public void setMicrogrid_id(String microgrid_id) {
		this.microgrid_id = microgrid_id;
	}
	public String getMicrogrid_name() {
		return microgrid_name;
	}
	public void setMicrogrid_name(String microgrid_name) {
		this.microgrid_name = microgrid_name;
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
	public Long getLng_start_time() {
		return lng_start_time;
	}
	public void setLng_start_time(Long lng_start_time) {
		this.lng_start_time = lng_start_time;
	}
	public Long getLng_end_time() {
		return lng_end_time;
	}
	public void setLng_end_time(Long lng_end_time) {
		this.lng_end_time = lng_end_time;
	}
	public String getBattery_low_threshold() {
		return battery_low_threshold;
	}
	public void setBattery_low_threshold(String battery_low_threshold) {
		this.battery_low_threshold = battery_low_threshold;
	}
	public String getBattery_charge_source() {
		return battery_charge_source;
	}
	public void setBattery_charge_source(String battery_charge_source) {
		this.battery_charge_source = battery_charge_source;
	}
	public String getStandard_situation() {
		return standard_situation;
	}
	public void setStandard_situation(String standard_situation) {
		this.standard_situation = standard_situation;
	}
	public String getCritical_situation() {
		return critical_situation;
	}
	public void setCritical_situation(String critical_situation) {
		this.critical_situation = critical_situation;
	}
	public String getBattery_low() {
		return battery_low;
	}
	public void setBattery_low(String battery_low) {
		this.battery_low = battery_low;
	}
	public String getSolar_low() {
		return solar_low;
	}
	public void setSolar_low(String solar_low) {
		this.solar_low = solar_low;
	}
	
}

