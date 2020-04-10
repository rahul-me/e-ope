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
@Table(name="utility_provider")
public class UtilityProvider extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="utility_name")
	private String utilityName;
	
	@Column(name="meter_fees_per_day")
	private Float meter_fees_per_day;

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public Float getMeter_fees_per_day() {
		return meter_fees_per_day;
	}

	public void setMeter_fees_per_day(Float meter_fees_per_day) {
		this.meter_fees_per_day = meter_fees_per_day;
	}

	@Override
	public String toString() {
		return "UtilityProvider [utilityName=" + utilityName
				+ ", meter_fees_per_day=" + meter_fees_per_day + "]";
	}	
	
	
}

