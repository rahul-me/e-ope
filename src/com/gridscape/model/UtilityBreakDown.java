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

@Entity
@Table(name="utility_break_down")
public class UtilityBreakDown extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5351712069987984070L;
	
	@Column(name="season")
	private String season;
	@Column(name="start_date",columnDefinition="date")
	private Date start_date;
	@Column(name="end_date",columnDefinition="date")
	private Date end_date;
	@Column(name="utility_provider_id")
	private Long utility_provider_id;
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Long getUtility_provider_id() {
		return utility_provider_id;
	}
	public void setUtility_provider_id(Long utility_provider_id) {
		this.utility_provider_id = utility_provider_id;
	}
	@Override
	public String toString() {
		return "UtilityBreakDown [season=" + season + ", start_date="
				+ start_date + ", end_date=" + end_date
				+ ", utility_provider_id=" + utility_provider_id + "]";
	}
	
	
}
