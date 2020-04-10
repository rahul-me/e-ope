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
		

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="energy_details",indexes={
	@Index(columnList = "port_cfg",name="port_cfg_index"),
	@Index(columnList = "microgrid_id",name="microgrid_id_index"),
	@Index(columnList = "event_time",name="event_time_index")
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class EnergyDetails extends EnergyAtributes	{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EnergyDetails(){
		super();
	}

	@Column(name="soc")
	private String soc;	
	
	@Column(name="soh")
	private String soh;
	
	@Column(name="temperature")	
	private String temperature;
	
	@Column(name="level")	
	private String level;
	
	@Column(name="json_string" ,length=500)
	private String json_string;

	public String getJson_string() {
		return json_string;
	}

	public void setJson_string(String json_string) {
		this.json_string = json_string;
	}

	public String getSoc() {
		return soc;
	}

	public void setSoc(String soc) {
		this.soc = soc;
	}

	public String getSoh() {
		return soh;
	}

	public void setSoh(String soh) {
		this.soh = soh;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temprature) {
		this.temperature = temprature;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "EnergyDetails [soc=" + soc + ", soh=" + soh + ", temperature="
				+ temperature + ", level=" + level + ", getMicrogrid_id()="
				+ getMicrogrid_id() + ", getPort_cfg()=" + getPort_cfg()
				+ ", getState()=" + getState() + ", getVoltage_v()="
				+ getVoltage_v() + ", getCurrent_c()=" + getCurrent_c()
				+ ", getWattage_w()=" + getWattage_w() + ", getKwh()="
				+ getKwh() + ", getEvent_time()=" + getEvent_time()
				+ ", getCumulative_kwh()=" + getCumulative_kwh() + ", getId()="
				+ getId() + ", getCreated_at()=" + getCreated_at()
				+ ", getUpdated_at()=" + getUpdated_at() + ", getUpdated_by()="
				+ getUpdated_by() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	
	
}
