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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "micro_controller")
@JsonIgnoreProperties(ignoreUnknown = true)	
public class MicroController extends Address implements Serializable{
	
	@Column(name="microgrid_id")
	private String microgrid_id;
	@Column(name="microgrid_name")
	private String microgrid_name;
	@Column(name="owner_manager_name")
	private String owner_manager_name;
	@Column(name="owner_manager_contact")
	private String owner_manager_contact;
	@Column(name="maintenance_manager_name")
	private String maintenance_manager_name;
	@Column(name="maintenance_manager_contact")
	private String maintenance_manager_contact;
	@Column(name="user_id")
	private String user_id;	
	@Column(name="pic_url")
	private String pic_url;	
	@Column(name="profile_img")
	private String profile_img;
	@Column(name="about")
	private String about;
	@Column(name="active", columnDefinition = "tinyint default false")
	private boolean active;
	@Column(name="utility_id")
	private String utilityId;
	@Column(name="utility_name")
	private String utility_name;
	@Column(name="total_size")
	private String total_size;
	@Column(name="station_id")
	private String station_id;
	@Column(name="solar_pic")
	private String solar_pic;
	@Column(name="no_of_solar_panel")
	private Integer no_of_solar_panel;
	@Column(name="solar_panel_description",columnDefinition="text")
	private String solar_panel_description;
	@Column(name="time_zone")
	private String time_zone;
	@Column(name="deleted", columnDefinition = "tinyint default false")
	private boolean deleted;
	@Column(name="max_meter_value", columnDefinition="int default 100")
	private Integer max_meter_value;
	@Column(name="solar_generation_charge", columnDefinition="float default -1")
	private Float solar_generation_charge;
	@Column(name="solar_generation_charge_unit_symb")
	private String solar_generation_charge_unit_symb;
	
	
	public String getSolar_generation_charge_unit_symb() {
		return solar_generation_charge_unit_symb;
	}
	public void setSolar_generation_charge_unit_symb(String solar_generation_charge_unit_symb) {
		this.solar_generation_charge_unit_symb = solar_generation_charge_unit_symb;
	}
	public Float getSolar_generation_charge() {
		return solar_generation_charge;
	}
	public void setSolar_generation_charge(Float solar_generation_charge) {
		this.solar_generation_charge = solar_generation_charge;
	}
	public Integer getMax_meter_value() {
		return max_meter_value;
	}
	public void setMax_meter_value(Integer max_meter_value) {
		this.max_meter_value = max_meter_value;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUtilityId() {
		return utilityId;
	}
	public void setUtilityId(String utilityId) {
		this.utilityId = utilityId;
	}
	
	public String getUtility_name() {
		return utility_name;
	}
	
	public void setUtility_name(String utility_name) {
		this.utility_name = utility_name;
	}
		
	public String getOwner_manager_name() {
		return owner_manager_name;
	}
	public void setOwner_manager_name(String owner_manager_name) {
		this.owner_manager_name = owner_manager_name;
	}
	public String getOwner_manager_contact() {
		return owner_manager_contact;
	}
	public void setOwner_manager_contact(String owner_manager_contact) {
		this.owner_manager_contact = owner_manager_contact;
	}
	public String getMaintenance_manager_name() {
		return maintenance_manager_name;
	}
	public void setMaintenance_manager_name(String maintenance_manager_name) {
		this.maintenance_manager_name = maintenance_manager_name;
	}
	public String getMaintenance_manager_contact() {
		return maintenance_manager_contact;
	}
	public void setMaintenance_manager_contact(String maintenance_manager_contact) {
		this.maintenance_manager_contact = maintenance_manager_contact;
	}	
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getTotal_size() {
		return total_size;
	}
	public void setTotal_size(String totla_size) {
		this.total_size = totla_size;
	}
	public String getSolar_pic() {
		return solar_pic;
	}
	public void setSolar_pic(String solar_pic) {
		this.solar_pic = solar_pic;
	}
	public Integer getNo_of_solar_panel() {
		return no_of_solar_panel;
	}
	public void setNo_of_solar_panel(Integer no_of_solar_panel) {
		this.no_of_solar_panel = no_of_solar_panel;
	}
	public String getSolar_panel_description() {
		return solar_panel_description;
	}
	public void setSolar_panel_description(String solar_panel_description) {
		this.solar_panel_description = solar_panel_description;
	}
	
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	
	public String getStation_id() {
		return station_id;
	}
	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}
	@Override
	public String toString() {
		return "MicroController [microgrid_id=" + microgrid_id
				+ ", microgrid_name=" + microgrid_name + ", user_id=" + user_id
				+ ", pic_url=" + pic_url + ", about=" + about + ", active="
				+ active + ", utilityId=" + utilityId + ", utility_name="
				+ utility_name + ", getMicrogrid_id()=" + getMicrogrid_id()
				+ ", getMicrogrid_name()=" + getMicrogrid_name()
				+ ", getUser_id()=" + getUser_id() + ", getPic_url()="
				+ getPic_url() + ", getAbout()=" + getAbout() + ", isActive()="
				+ isActive() + ", getUtilityId()=" + getUtilityId()
				+ ", getUtility_name()=" + getUtility_name()
				+ ", getAddress_line_1()=" + getAddress_line_1()
				+ ", getAddress_line_2()=" + getAddress_line_2()
				+ ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getCountry()=" + getCountry() + ", getZip_code()="
				+ getZip_code() + ", getLatitude()=" + getLatitude()
				+ ", getLongitude()=" + getLongitude() + ", toString()="
				+ super.toString() + ", getId()=" + getId()
				+ ", getCreated_at()=" + getCreated_at() + ", getUpdated_at()="
				+ getUpdated_at() + ", getUpdated_by()=" + getUpdated_by()
				+ ", getStation_id()="+ getStation_id()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
	
}
