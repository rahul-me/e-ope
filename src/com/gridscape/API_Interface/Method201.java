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

public class Method201 extends Message{
	
	private MicroGridStatus micro_grid_status;

	public MicroGridStatus getMicro_grid_status() {
		return micro_grid_status;
	}

	public void setMicro_grid_status(MicroGridStatus micro_grid_status) {
		this.micro_grid_status = micro_grid_status;
	}

	@Override
	public String toString() {
		return "Method201 [micro_grid_status=" + micro_grid_status
				+ ", getMicro_grid_status()=" + getMicro_grid_status()
				+ ", getM()=" + getM() + ", getMicro_grid_id()="
				+ getMicro_grid_id() + ", getInit()=" + getInit()
				+ ", getRequest_id()=" + getRequest_id()
				+ ", getCurrent_time()=" + getCurrent_time() + "]";
	}
	
	
}

