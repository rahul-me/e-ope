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

@Entity
@Table(name="utility_rate")
public class UtilityRate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="generation")
	private String generation;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="end_time")
	private String end_time;
	
	@Column(name="rate")
	private Float rate;
	
	@Column(name="utility_break_down_id")
	private Long utility_break_down_id;

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

	@Override
	public String toString() {
		return "UtilityRate [generation=" + generation + ", startTime="
				+ startTime + ", end_time=" + end_time + ", rate=" + rate
				+ ", utility_break_down_id=" + utility_break_down_id + "]";
	}		
}

