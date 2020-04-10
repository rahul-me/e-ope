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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class TestData {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:mysql://localhost/micro_grid";
		System.out.println(new Date());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection  conn = DriverManager.getConnection(DB_URL,"root","");
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM energy_details WHERE microgrid_id IN ('MGC001') AND DATE_FORMAT(event_time,'%Y-%m-%d')='2015-11-07'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         int id  = rs.getInt("id");
		         System.out.println("ID: " + id);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println(new Date());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
