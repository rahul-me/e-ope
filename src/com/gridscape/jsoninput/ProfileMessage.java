package com.gridscape.jsoninput;

public class ProfileMessage {
	
	private String start_time;
	private String end_time;
	private String battery_low_threshold;
	private String critical_situation;
	private String solar_low;
	private String standard_situation;
	private String battery_low;
	private String battery_charge_source;
	
	
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

	public String getBattery_low_threshold() {
		return battery_low_threshold;
	}

	public void setBattery_low_threshold(String battery_low_threshold) {
		this.battery_low_threshold = battery_low_threshold;
	}

	public String getCritical_situation() {
		return critical_situation;
	}

	public void setCritical_situation(String critical_situation) {
		this.critical_situation = critical_situation;
	}

	public String getSolar_low() {
		return solar_low;
	}

	public void setSolar_low(String solar_low) {
		this.solar_low = solar_low;
	}

	public String getStandard_situation() {
		return standard_situation;
	}

	public void setStandard_situation(String standard_situation) {
		this.standard_situation = standard_situation;
	}

	public String getBattery_low() {
		return battery_low;
	}

	public void setBattery_low(String battery_low) {
		this.battery_low = battery_low;
	}

	public String getBattery_charge_source() {
		return battery_charge_source;
	}

	public void setBattery_charge_source(String battery_charge_source) {
		this.battery_charge_source = battery_charge_source;
	}	

}
