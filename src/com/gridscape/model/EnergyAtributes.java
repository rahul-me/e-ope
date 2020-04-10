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
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EnergyAtributes extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EnergyAtributes(){
		
	}

	@Column(name="microgrid_id")
	private String microgrid_id;

	@Column(name="port_cfg")
	private String port_cfg;
	
	@Column(name="state")
	private String state;
	
	@Column(name="voltage_v")
	private String voltage_v;
	
	@Column(name="current_c")
	private String current_c;
	
	@Column(name="wattage_w")
	private String wattage_w;
	
	@Column(name="kwh")
	private String kwh;
	
	@Column(name="kwh_in")
	private String kwh_in;
	
	@Column(name="kwh_out")
	private String kwh_out;
	
	@Column(name="cumulative_kwh")
	private String cumulative_kwh;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_time")
	private Date event_time;
	
	
	public String getKwh_in() {
		return kwh_in;
	}

	public void setKwh_in(String kwh_in) {
		this.kwh_in = kwh_in;
	}

	public String getKwh_out() {
		return kwh_out;
	}

	public void setKwh_out(String kwh_out) {
		this.kwh_out = kwh_out;
	}

	public String getMicrogrid_id() {
		return microgrid_id;
	}

	public void setMicrogrid_id(String microgrid_id) {
		this.microgrid_id = microgrid_id;
	}

	public String getPort_cfg() {
		return port_cfg;
	}

	public void setPort_cfg(String port_cfg) {
		this.port_cfg = port_cfg;
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

	public String getKwh() {
		return kwh;
	}

	public void setKwh(String kwh) {
		this.kwh = kwh;
	}

	public Date getEvent_time() {
		return event_time;
	}

	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}

	public String getCumulative_kwh() {
		return cumulative_kwh;
	}

	public void setCumulative_kwh(String cumulative_kwh) {
		this.cumulative_kwh = cumulative_kwh;
	}

}
