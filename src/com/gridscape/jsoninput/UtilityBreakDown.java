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
import java.util.Date;

public class UtilityBreakDown {
	
	private Long id;	
	private String season;	
	private Date start_date;	
	private Date end_date;	
	private Long utility_provider_id;	
	private String utility_provider_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getUtility_provider_name() {
		return utility_provider_name;
	}
	public void setUtility_provider_name(String utility_provider_name) {
		this.utility_provider_name = utility_provider_name;
	}
}

