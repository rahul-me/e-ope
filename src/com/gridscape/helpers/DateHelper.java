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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	public static Date convertStringToDate(String str_date,String date_format){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(date_format);
		try{
	        date = df.parse(str_date);	        
	    }
	    catch ( Exception ex ){
	        System.out.println(ex);
	    }
		return date;
	}
	
	public static String generateDateStringHavingGivenFormatFromMillies(long millis, String dateFormat){
		SimpleDateFormat dateFormattor = new SimpleDateFormat(Constant.DATE_TIME_FORMAT_FULLDATE);
		return dateFormattor.format(new Date(millis));
	}
	
	
}

