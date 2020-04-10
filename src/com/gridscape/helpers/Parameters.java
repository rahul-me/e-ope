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


public class Parameters {
	
	private static String mailEmailAddress;
	private static String mailUserName;
	private static String mailPassword;
	private static int sessionTimeOut;
		
	public static int getSessionTimeOut() {
		return sessionTimeOut;
	}

	public static void setSessionTimeOut(int sessionTimeOut) {
		Parameters.sessionTimeOut = sessionTimeOut;
	}

	public static String getMailEmailAddress() {
		return mailEmailAddress;
	}

	public void setMailEmailAddress(String mailEmailAddress) {
		Parameters.mailEmailAddress = mailEmailAddress;
	}

	public static String getMailUserName() {
		return mailUserName;
	}

	public void setMailUserName(String mailUserName) {
		Parameters.mailUserName = mailUserName;
	}

	public static String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		Parameters.mailPassword = mailPassword;
	}

}

