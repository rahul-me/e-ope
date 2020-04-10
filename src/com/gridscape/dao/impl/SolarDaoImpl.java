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
package com.gridscape.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.SolarDao;
import com.gridscape.model.SolarService;
import com.gridscape.model.UtilityIntervalData;

@Component
public class SolarDaoImpl implements SolarDao {

	@Autowired
	SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<SolarService> list() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(SolarService.class);
		List<SolarService> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public SolarService save(SolarService ss) {
		Session session = sf.openSession();
		session.saveOrUpdate(ss);
		session.flush();
		session.close();
		return ss;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SolarService> findSolarServiceByStartAndEndDate(String stationId, String startDate, String endDate){				
		Session session = sf.openSession();						
		String sql = "SELECT id, datetime , SUM(pwr) from solar_service ";
		sql += "WHERE station_id = '"+stationId+"' AND datetime between "+startDate+" AND "+endDate+" ";
		sql += "GROUP BY DATE(datetime) order by datetime ASC";		
		Query query = session.createSQLQuery(sql);	
		List<SolarService> list = query.list();		
		session.close();
		return list;						
	}
	
	@Override
	public List<SolarService> findSolarServiceSpecificForMonth(String stationId, int month_no, int year){
		if(stationId == null){
			return new ArrayList<SolarService>();
		}
		Session session = sf.openSession();
		String sql = "SELECT id, datetime, MAX(pwr) from solar_service WHERE station_id = '"+stationId+"' AND MONTH(datetime)="+month_no+" AND YEAR(datetime)="+year;
		sql += " GROUP BY DATE(datetime) order by datetime ASC";
		Query query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<SolarService> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public List<SolarService> findSolarServiceSpecificForYear(String stationId, int year_no){
		if(stationId == null){
			return new ArrayList<SolarService>();
		}
		Session session = sf.openSession();
		String sql = "SELECT id, datetime, MAX(pwr) as pwr from solar_service WHERE station_id = '"+stationId+"' AND YEAR(datetime)="+year_no;
		sql += " GROUP BY MONTH(datetime) order by datetime ASC";
		Query query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<SolarService> list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SolarService findBySolarServiceByStationIdAndDateTime(
			String stationId, Date date) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(SolarService.class);
		ctr.add(Restrictions.eq("station_id",stationId));
		ctr.add(Restrictions.eq("datetime", date));
		List<SolarService> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveSolarServiceList(List<SolarService> ssList) {
		Session session = sf.openSession();
		int index = 0;
		Transaction tx = session.beginTransaction();
		for(SolarService ss:ssList){
			index++;
			session.saveOrUpdate(ss);
			if(index%200==0){
				session.flush();
	            session.clear();
			}
		}
		tx.commit();
		session.close();
	}
}

