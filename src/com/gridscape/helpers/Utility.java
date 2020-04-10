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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Utility {
	
	static final String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static ObjectMapper objectMapper;
	
	public static synchronized ObjectMapper getObjectMapperInsatnce(){
		if(objectMapper!= null){
			return objectMapper;
		} else {
			objectMapper = new ObjectMapper();
			return objectMapper;
		}
	}
		
	public static TimeZone getTimeZoneObject(String timeZone){
		return new TimeZone(timeZone);
	}
	
	public static String getTokenByCookie(HttpServletRequest req){
		Cookie cookies[] = req.getCookies();
		if(cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				if(c.getName().equals("token")){
					return c.getValue();
				}
			}
		}
		return null;
	}
	public static String getLoginTokenByCookie(HttpServletRequest req){
		Cookie cookies[] = req.getCookies();
		if(cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				if(c.getName().equals("logintoken")){
					return c.getValue();
				}
			}
		}
		return null;
	}
	public static String getMicrogrid_idByCookie(HttpServletRequest req) {
		Cookie cookies[] = req.getCookies();
		if(cookies.length>0){
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				if(c.getName().equals("microgrid_id")){
					return c.getValue();
				}
			}
		}
		return null;
	}
	
	public static long getDateDiffInMin(Date startDate,Date endDate){
		long duration  = endDate.getTime() - startDate.getTime();
		//long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		//long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
		return diffInMinutes;
	}
	
	public static String getRandomMicroGridId(){
		Random random = new Random();				
		StringBuilder sb = new StringBuilder(8);
		for( int i = 0;i<8;i++ ){ 
		   sb.append(randomString.charAt(random.nextInt(randomString.length())));
		}
		return sb.toString();
	}
	
	public static byte[] getMRIDValue(long uniqueID, int IANANumber){
		byte[] mridBytes;
		byte[] ianaBytes = ByteBuffer.allocate(4).putInt(IANANumber).array();
		byte[] uniqueIdBytes = ByteBuffer.allocate(8).putLong(uniqueID).array();
		
		System.out.println("Unique id Hex:  ");
		for(byte val : uniqueIdBytes){
			System.out.print(String.format("%02X", val));
		}
		System.out.println();
		int count = 4;
		int zerocount = 0;
		for(byte byteVal : uniqueIdBytes){
			if(byteVal == 0){
				zerocount++;
			} else {
				break;
			}
		}
		count = count + (8-zerocount);
		mridBytes = new byte[count];
		
		for(int i = 0, j = zerocount ; j < uniqueIdBytes.length ; i++, j++){
			mridBytes[i] = uniqueIdBytes[j];
		}
		// fill IANA number bytes at last
		for(int i = (mridBytes.length-4), j = 0; i<mridBytes.length ; i++, j++){
			mridBytes[i] = ianaBytes[j];
		}
		return mridBytes;
	}
	
	public static int getNonLeapYear(int year){
		return ((year % 4) == 0) ? year-1 : year;
	}
	
	public static Calendar getFirstDayOfNonLeapYear(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar;
	}
	
	public static Calendar setHourMinuteSecondsToZero(Calendar calendar){		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);		
		return calendar;
	}
	
	public static String getStringFromByteArray(byte[] vals){
		StringBuilder stringBuilder = new StringBuilder();
		for(byte val : vals){
			stringBuilder.append(String.format("%02X", val));
		}
		return stringBuilder.toString();
	}
	
	public static String convertToJsonString(Object object){
		String jsonStr = null;
		ObjectMapper objectMapper = getObjectMapperInsatnce();
		try {
			jsonStr = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	@SuppressWarnings("unchecked")
	public static Object getObjectFromJSONString(String jsonStrObj, Class classObj){
		ObjectMapper objectMapper = getObjectMapperInsatnce();
		Object responseObject = null;
		try {
			responseObject = objectMapper.readValue(jsonStrObj, classObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	
	
}
