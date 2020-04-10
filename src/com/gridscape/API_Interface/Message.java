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
package com.gridscape.API_Interface;

import java.util.Date;

public class Message {
	private String m;
	private String micro_grid_id;
	private String init;
	private String request_id;
	private Date current_time;

	
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getMicro_grid_id() {
		return micro_grid_id;
	}
	public void setMicro_grid_id(String micro_grid_id) {
		this.micro_grid_id = micro_grid_id;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public Date getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(Date current_time) {
		this.current_time = current_time;
	}
	
}

