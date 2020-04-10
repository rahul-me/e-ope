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

import java.util.ArrayList;
import java.util.List;

public class UtilityHelper {

	public static List<Integer> getMonthArray(int start_month,int end_month){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=start_month;i!=(end_month+1);i++){
			list.add(i);
			if(i==12){
				i=0;
			}				
		}
		return list;
	}
	
	public static List<Integer> getTimeArr(int start_time,int end_time){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=start_time;i!=(end_time);){
			list.add(i);
			if(i==2400){
				i=-5;
			}				
			i=i+5;
		}
		return list;
	}
}

