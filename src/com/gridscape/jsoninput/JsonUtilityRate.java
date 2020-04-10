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

public class JsonUtilityRate {
	private Long id;
	private String generation;
	private String startTime;	
	private String end_time;	
	private Float rate;	
	private Long utility_break_down_id;
	private String utility_break_down_season;
	private String utility_provider;
	private Long utility_provider_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Long getUtility_break_down_id() {
		return utility_break_down_id;
	}
	public void setUtility_break_down_id(Long utility_break_down_id) {
		this.utility_break_down_id = utility_break_down_id;
	}
	public String getUtility_break_down_season() {
		return utility_break_down_season;
	}
	public void setUtility_break_down_season(String utility_break_down_season) {
		this.utility_break_down_season = utility_break_down_season;
	}
	public String getUtility_provider() {
		return utility_provider;
	}
	public void setUtility_provider(String utility_provider) {
		this.utility_provider = utility_provider;
	}
	public Long getUtility_provider_id() {
		return utility_provider_id;
	}
	public void setUtility_provider_id(Long utility_provider_id) {
		this.utility_provider_id = utility_provider_id;
	}		
}

