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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "error_detils")
@JsonIgnoreProperties(ignoreUnknown = true)	
public class ErrorDetails  extends BaseEntity implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="micro_grid_id")
	private String  micro_grid_id;	
	@Column(name="event_time")
	private String  event_time;	
	@Column(name="error_code")
	private String  error_code;
	@Column(name="error_details")
	private String  error_details;
	@Column(name="init_by")
	private String  init_by;
	@Column(name="ref_request_id")
	private String  ref_request_id;
	@Column(name="request_id")
	private String  request_id;
	@Column(name="status", columnDefinition="varchar(255) default 'open'")
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMicro_grid_id() {
		return micro_grid_id;
	}
	public void setMicro_grid_id(String micro_grid_id) {
		this.micro_grid_id = micro_grid_id;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getError_details() {
		return error_details;
	}
	public void setError_details(String error_details) {
		this.error_details = error_details;
	}
	public String getInit_by() {
		return init_by;
	}
	public void setInit_by(String init_by) {
		this.init_by = init_by;
	}
	public String getRef_request_id() {
		return ref_request_id;
	}
	public void setRef_request_id(String ref_request_id) {
		this.ref_request_id = ref_request_id;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}	
}
