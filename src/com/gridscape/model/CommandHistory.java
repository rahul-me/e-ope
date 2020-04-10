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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "command_history")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommandHistory extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="micro_grid_id")
	private String micro_grid_id ;
	@Column(name="request_id")
	private String 	request_id ;
	@Column(name="command_name")
	private String command_name ;
	@Column(name="method_number")
	private String method_number;
	@Column(name="init")
	private String init;
	@Column(name="state")
	private String state ;
	@Column(name="message",columnDefinition="text")
	private String  message ;
	@Column(name="status_code")
	private String status_code;
	@Column(name="status_details")	
	private String status_details;
	@Column(name="request_time")
	private String request_time;
	@Column(name="response_time")
	private String response_time;
	@Column(name="response_id")
	private String 	response_id ;
	public String getMicro_grid_id() {
		return micro_grid_id;
	}
	public void setMicro_grid_id(String micro_grid_id) {
		this.micro_grid_id = micro_grid_id;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getCommand_name() {
		return command_name;
	}
	public void setCommand_name(String command_name) {
		this.command_name = command_name;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}
	public String getResponse_time() {
		return response_time;
	}
	public void setResponse_time(String response_time) {
		this.response_time = response_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getStatus_details() {
		return status_details;
	}
	public void setStatus_details(String status_details) {
		this.status_details = status_details;
	}
	public String getResponse_id() {
		return response_id;
	}
	public void setResponse_id(String response_id) {
		this.response_id = response_id;
	}
	
	public String getMethod_number() {
		return method_number;
	}
	public void setMethod_number(String method_number) {
		this.method_number = method_number;
	}
	
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	@Override
	public String toString() {
		return "CommandHistory [micro_grid_id=" + micro_grid_id
				+ ", request_id=" + request_id + ", command_name="
				+ command_name + ", method_number=" + method_number
				+ ", state=" + state + ", message=" + message
				+ ", status_code=" + status_code + ", status_details="
				+ status_details + ", request_time=" + request_time
				+ ", response_time=" + response_time + ", response_id="
				+ response_id + "]";
	}
		
}
