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
 
  

package com.gridscape.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.SolarDao;

@Service
public class SolarService {

	@Autowired
	SolarDao sDao;
	
	public List<com.gridscape.model.SolarService> list(){
		return sDao.list();
	}

	public com.gridscape.model.SolarService save(com.gridscape.model.SolarService ss) {
		return sDao.save(ss);
	}
	
	public List<com.gridscape.model.SolarService> findSolarServiceByStartAndEndDate(String stationId, String startDate, String endDate){
		return sDao.findSolarServiceByStartAndEndDate(stationId, startDate, endDate);
	}
	
	public List<com.gridscape.model.SolarService> findSolarServiceSpecificForMonth(String stationId, int month_no, int year){
		return sDao.findSolarServiceSpecificForMonth(stationId, month_no, year);
	}
	
	public List<com.gridscape.model.SolarService> findSolarServiceSpecificForYear(String stationId, int year_no){
		return sDao.findSolarServiceSpecificForYear(stationId, year_no);
	}

	public com.gridscape.model.SolarService findBySolarServiceByStationIdAndDateTime(String stationId,
			Date date) {
		return sDao.findBySolarServiceByStationIdAndDateTime(stationId,date);
	}

	public void saveSolarServiceList(List<com.gridscape.model.SolarService> ssList) {
		sDao.saveSolarServiceList(ssList);
	}
}

