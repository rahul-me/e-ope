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
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name="utility")
@DynamicUpdate(value=true)
@SelectBeforeUpdate
public class Utility extends BaseEntity {

	@Column(name="utility_provider_id")
	private String utility_provider_id;
	@Column(name="name")
	private String name;
	@Column(name="user_id")
	private Long user_id;
	@Column(name="account_no")
	private String account_no;
	@Column(name="service")
	private String service;
	@Column(name="tariff_plan")
	private String tariff_plan;
	@Column(name="emergency_contact")
	private String emergency_contact;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTariff_plan() {
		return tariff_plan;
	}
	public void setTariff_plan(String tariff_plan) {
		this.tariff_plan = tariff_plan;
	}
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	public String getUtility_provider_id() {
		return utility_provider_id;
	}
	public void setUtility_provider_id(String utility_provider_id) {
		this.utility_provider_id = utility_provider_id;
	}
	@Override
	public String toString() {
		return "Utility [utility_provider_id=" + utility_provider_id
				+ ", name=" + name + ", user_id=" + user_id + ", account_no="
				+ account_no + ", service=" + service + ", tariff_plan="
				+ tariff_plan + ", emergency_contact=" + emergency_contact
				+ "]";
	}
		
}
