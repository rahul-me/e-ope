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

public class WhetherParameter {
	private static String host;
	private static int port; 
	private static String userName;
	private static String password;
	private static String ftp_file_path;
	private static String destination_path;
	public static String getHost() {
		return host;
	}
	public static void setHost(String host) {
		WhetherParameter.host = host;
	}
	public static int getPort() {
		return port;
	}
	public static void setPort(int port) {
		WhetherParameter.port = port;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		WhetherParameter.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		WhetherParameter.password = password;
	}
	public static String getFtp_file_path() {
		return ftp_file_path;
	}
	public static void setFtp_file_path(String ftp_file_path) {
		WhetherParameter.ftp_file_path = ftp_file_path;
	}
	public static String getDestination_path() {
		return destination_path;
	}
	public static void setDestination_path(String destination_path) {
		WhetherParameter.destination_path = destination_path;
	}	
}
