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
@Table(name="solar_service")
public class SolarService extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="station_id")
	private String station_id;
	@Column(name="datetime",columnDefinition="datetime")
	private Date datetime;
	@Column(name="ghi")
	private String ghi;
	@Column(name="poa")
	private String poa;
	@Column(name="pwr")
	private String pwr;
	@Column(name="file_name")
	private String file_name;
	@Column(name="status")
	private String status;
	
	public String getStation_id() {
		return station_id;
	}
	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getGhi() {
		return ghi;
	}
	public void setGhi(String ghi) {
		this.ghi = ghi;
	}
	public String getPoa() {
		return poa;
	}
	public void setPoa(String poa) {
		this.poa = poa;
	}
	public String getPwr() {
		return pwr;
	}
	public void setPwr(String pwr) {
		this.pwr = pwr;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SolarService [station_id=" + station_id + ", datetime="
				+ datetime + ", ghi=" + ghi + ", poa=" + poa + ", pwr=" + pwr
				+ ", file_name=" + file_name + ", status=" + status + "]";
	}
	
	
	
}

