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
package com.gridscape.helpers;

import java.util.StringTokenizer;

public class TimeZone {
	private String time;
	private String zone;
	
	
	
	public String getTime() {
		return time;
	}

	

	public String getZone() {
		return zone;
	}

	

	public TimeZone(){
		
	}
	
	public TimeZone(String timeZone){
		StringTokenizer st = new StringTokenizer(timeZone, "#");
		this.time = st.nextToken();
		this.zone = st.nextToken();		
	}			
}

