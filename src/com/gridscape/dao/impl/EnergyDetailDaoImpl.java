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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.API_Interface.MicroGridAPI;
import com.gridscape.dao.EnergyDetailDao;
import com.gridscape.helpers.TimeZone;
import com.gridscape.helpers.Utility;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.EnergyDetails;
import com.gridscape.service.MicroGridService;

@Component
public class EnergyDetailDaoImpl implements EnergyDetailDao{
	
	private static final Logger LOG = Logger.getLogger(EnergyDetailDaoImpl.class.getName());
	
	@Autowired
	SessionFactory sf;
	
	@Autowired
	MicroGridService microGridService;
	
	@Override
	public EnergyDetails save(EnergyDetails obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public EnergyDetails findByMicrogrid_Id(String microgrid_id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(EnergyDetails.class);
		ctr.add(Restrictions.eq("microgrid_id",microgrid_id));
		ctr.addOrder(Order.desc("id"));
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public EnergyDetails findByMicrogrid_IdAndPort_cfg(String microgrid_id,
			String port_cfg) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(EnergyDetails.class);
		ctr.add(Restrictions.eq("microgrid_id",microgrid_id));
		ctr.add(Restrictions.eq("port_cfg",port_cfg));
		ctr.addOrder(Order.desc("id"));
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfg(
			String microgrid_id, String port_cfg) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(EnergyDetails.class);
		ctr.add(Restrictions.eq("microgrid_id",microgrid_id));
		ctr.add(Restrictions.eq("port_cfg",port_cfg));
		ctr.addOrder(Order.asc("id"));
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForweek(
			String microgrid_id, String port_cfg,String state) {
		Session session = sf.openSession();
		String sql = "SELECT id,event_time,SUM(kwh) as kwh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' AND event_time >= ( CURDATE() - INTERVAL 7 DAY ) ";
		sql += "GROUP BY date(event_time) ORDER BY id DESC ";
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();				
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgWithGroupByDate(
			String microgrid_id, String port_cfg,String state) {
		Session session = sf.openSession();

		String sql = "SELECT id,DATE_FORMAT(event_time,'%Y-%m-%d') AS date_at,event_time,SUM(kwh) as kwh,MAX(wattage_w) as wattage_w FROM energy_details ";
		if(state.equals("battery")){
			sql = "SELECT id,DATE_FORMAT(event_time,'%Y-%m-%d') AS date_at,event_time,MAX(kwh) as kwh,MAX(soc) as soc FROM energy_details ";
		}
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' ";
		sql += "GROUP BY date_at";		
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForMonth(
			String microgrid_id, String port_cfg,String state) {
		Session session = sf.openSession();
		String sql = "SELECT id,DATE_FORMAT(event_time,'%Y-%m-%d') AS date_at,MAX(kwh) as kwh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' AND Month(event_time) = Month(now())";
		sql += "GROUP BY date_at";		
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}
	// change 24 hours to 12 hours
	@Override
	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForCurrentDate(
			String microgrid_id, String port_cfg,String state,int limit) {
		Session session = sf.openSession();
		String sql = "SELECT id,event_time,kwh,current_c,wattage_w FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' ";
		//sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d') order by event_time DESC";
		sql += "AND event_time >= date_sub(now(),interval 12 hour) ";
		sql += "AND event_time <= now() ";
		sql += "order by event_time DESC";
		if(limit!=0){
			sql += " limit "+limit;
		}
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(
			String microgrid_id, String port_cfg,String state) {
		Session session = sf.openSession();
		String sql = "SELECT id,event_time,kwh,current_c,wattage_w FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"'";
		sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d') and event_time >= date_sub(now(),interval 120 second) and event_time <= now() order by id DESC LIMIT 1";
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findBatteryListByMicrogrid_IdAndPort_cfgForCurrentDate(
			String microgrid_id, String port_cfg,String state) {
		Session session = sf.openSession();
		String sql = "SELECT id,event_time,current_c,soc FROM energy_details ";
		if(state!=null){
			sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"'";
		}else{
			sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"'";
		}		
		sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d')";
		sql += " GROUP BY HOUR(event_time) ORDER BY event_time ASC";
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> getSumOfKwhForCurrentMonth(String microgrid_id,
			String port_cfg, String state) {
			Session session = sf.openSession();
			String sql = "SELECT SUM(sumkwh) FROM (SELECT id,sum(kwh) as sumkwh ,date_at FROM ";
			sql += "(SELECT id,kwh,DATE_FORMAT(event_time,'%Y-%m-%d') AS date_at FROM energy_details";
			sql += " WHERE port_cfg ='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"'";
			sql += " ORDER BY id DESC) AS temp GROUP BY date_at DESC LIMIT 30) AS ted";		
			LOG.info(sql);
			Query query = session.createSQLQuery(sql);				
			@SuppressWarnings("unchecked")
			List<EnergyDetails> list = query.list();
			session.close();
			return list;
	}

	@Override
	public List<EnergyDetails> findEnergyDistributionData(String microgrid_id,
			String port_cfg,String state, int limit) {	
		String sql = "SELECT id,date_sub(event_time,interval minute(event_time) minute) as event_time,SUM(kwh),current_c,wattage_w FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"'";
		//sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d') ";
		sql += " AND event_time >= date_sub(now(),interval 24 hour)";
		sql += " AND event_time <= now()";
		sql += " group by day(event_time),hour(event_time)";
		if(limit!=0){
			sql += " limit "+limit;
		}
		LOG.info(sql);
		Session session = sf.openSession();
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findDailySolarData(String microgrid_id,
			String port_cfg, String state, int limit) {
		String sql = "SELECT id,date_sub(event_time,interval minute(event_time) minute) AS date_at,MAX(convert(wattage_w, decimal(10,5))) AS kwh FROM energy_details  ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"'";
		//sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') = DATE_FORMAT(now(),'%Y-%m-%d') "; 
		sql += " AND event_time >= date_sub(now(),interval 24 hour)";
		sql += " AND event_time <= now()";
		sql += " group by day(event_time),hour(event_time)";
		if(limit!=0){
			sql += " limit "+limit;
		}
		LOG.info(sql);
		Session session = sf.openSession();
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findListByMicrogridArr(Object[] obj) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(EnergyDetails.class);
		ctr.add(Restrictions.in("microgrid_id", obj));
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = ctr.list();
		session.close();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<EnergyDetails> findListByMicrogridArrAndPortCFGAndEventDate(
			String mgObj, String port_cfg, String event_date) {
		String sql = "SELECT * FROM energy_details ";				
		sql += "WHERE microgrid_id in ("+mgObj+")";
		if(port_cfg!=null && port_cfg.length()>0){
			sql += " AND port_cfg='"+port_cfg+"'";
		}
		if(event_date!=null && event_date.length()>0){
			sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d')='"+event_date+"'";
		}
		LOG.info(sql);
		Session session = sf.openSession();
		
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity(EnergyDetails.class);
		List list = q.list();		
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> getLast24CurrentVoltage(String microgrid_id,
			String port_cfg) {
		String sql = "SELECT id,event_time,voltage_v,state FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND MONTH(event_time)=MONTH(NOW()) AND DAY(event_time) = DAY(NOW()) ";
		sql += "GROUP BY HOUR(event_time) order by event_time ASC LIMIT 24";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public List<EnergyDetails> getLast24CurrentVoltageByHour(String microgrid_id,
			String port_cfg, int hourDiff) {
		String sql = "SELECT id,event_time,voltage_v,state FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND MONTH(event_time)=MONTH(NOW()) AND DAY(event_time) = DAY(NOW()) ";
		//sql += "GROUP BY HOUR(event_time) order by event_time ASC LIMIT 24";
		sql += "and hour(event_time) = hour(date_add(now(),interval "+hourDiff+" hour)) ";
		sql += "GROUP BY MINUTE(event_time) order by event_time";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> getLast30DaysSOH(String microgrid_id,
			String port_cfg) {
		String sql = "SELECT id,event_time,soh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' ";
		sql += "GROUP BY HOUR(event_time) LIMIT 30";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> getLast30DaysSOC(String microgrid_id,
			String port_cfg, String state) {
		String sql = "SELECT id,event_time,soc FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' ";
		sql += "GROUP BY HOUR(event_time) LIMIT 30";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> getSocByMonth(String microgrid_id,
			String port_cfg, int month) {
		String sql = "SELECT id,event_time,MAX(soc) as soc FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND YEAR(event_time)=YEAR(now()) AND MONTH(event_time) ="+month;
		sql += " GROUP BY DATE(event_time) order by event_time ASC";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Start_EndDate(
			String microgrid_id, String port_cfg, String state,
			String start_date, String end_date) {
		String sql = "SELECT id,event_time,MAX(wattage_w) as wattage_w, sum(kwh) as kwh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND state='"+state+"'";
		sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d') BETWEEN "+start_date+" AND "+end_date;
		sql += " GROUP BY DATE(event_time) order by event_time ASC";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Month(
			String microgrid_id, String port_cfg, String state, int month_no, int year) {
		String sql = "SELECT id,event_time,MAX(wattage_w) as wattage_w, sum(kwh) as kwh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND state='"+state+"'";
		sql += " AND MONTH(event_time)="+month_no;
		sql += " AND YEAR(event_time)="+year;
		sql += " GROUP BY DATE(event_time) order by event_time ASC";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;		
	}

	@Override
	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Year(
			String microgrid_id, String port_cfg, String state, int year_no) {
		String sql = "SELECT id,event_time,max(wattage_w) as wattage_w, sum(kwh) as kwh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND state='"+state+"'";
		sql += " AND YEAR(event_time)="+year_no;
		sql += " GROUP BY MONTH(event_time) order by event_time ASC";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;	
	}

	@Override
	public List<EnergyDetails> find_last_microgrid_id_and_port_cfg(
			String microgrid_id, String port_cfg) {		
		Session session = sf.openSession();
		String sql = "SELECT id,event_time,soc,soh,kwh,state FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"'";
		sql += " order by event_time desc limit 1";
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();		
		session.close();		
		return list;
	}

	@Override
	public List<EnergyDetails> getSohByMonth(String microgrid_id,
			String port_cfg, int month) {
		String sql = "SELECT id,event_time,MAX(soh) as soh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND YEAR(event_time)=YEAR(now()) AND MONTH(event_time) ="+month;
		sql += " GROUP BY DATE(event_time) order by event_time ASC";
		LOG.info(sql);
		Session session = sf.openSession();
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public List<EnergyDetails> getCurrentStatus(String microgrid_id,
			String port_cfg, String state) {
		String sql = "SELECT id,event_time, wattage_w as soh FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND microgrid_id='"+microgrid_id+"' AND state='"+state+"'";
		sql += " and event_time >= date_sub(now(), interval 2 minute) order by event_time desc limit 1";
		Session session = sf.openSession();
		LOG.info(sql);
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<EnergyDetails> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public String getTotalGenerationSpecificForMicroGridIdPortCfgAndState(String microgrid_id, String port_cfg, String state) {
		String response = new String();
		String sql = "select sum(kwh) as kwh from energy_details ";
		sql += "where microgrid_id='"+microgrid_id+"' and port_cfg='"+port_cfg+"' and state='"+state+"'";
		LOG.info(sql);
		Session session = sf.openSession();
		Query query = session.createSQLQuery(sql);
		Object object = query.uniqueResult();		
		response = (object != null) ? String.valueOf(new BigDecimal((Math.round(new BigDecimal((Double)object).floatValue() * 100.00)/100)).setScale(2)) : "0.00";			
		return response;
	}
	
	@Override
	public List<EnergyDetails> getCurrentState(String microgrid_id, String port_cfg){
		try {
			Session session = sf.openSession();		
			Query query = session.createSQLQuery("CALL getCurrentStatus(:microgrid_id, :port_cfg)").addEntity(EnergyDetails.class).setParameter("microgrid_id", microgrid_id).setParameter("port_cfg", port_cfg);
			@SuppressWarnings("unchecked")
			List<EnergyDetails> list = query.list();
			return list;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}		
		
	}

	@Override
	public String getLastSOCOfMicro(String microgrid_id) {
	    Session session = sf.openSession();
	    try{
	    	String sql = "select soc from energy_details where port_cfg='battery' and microgrid_id='"+microgrid_id+"' order by id desc limit 1";
	    	LOG.info(sql);
	    	Query query = session.createSQLQuery(sql);
	    	
			Object object = query.uniqueResult();
		    return (String)object;
	    } catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    } finally{
	    	session.flush();
	    	session.close();
	    }	
		
	}
	
	@Transactional
	public Object getREGenDataForPastThreeMonths(String mgc_id, String port_cfg){
		Session session = sf.openSession();
		try {
			Query query = session.createSQLQuery("CALL getREGenDataForPastThreeMonths(:mgc_id,:port_cfg_)");
			query.setParameter("mgc_id", mgc_id);
			query.setParameter("port_cfg_", port_cfg);
			Object reGenObject = query.uniqueResult();
			return reGenObject;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
		
	}
	
	@Transactional
	public List<Object[]> getRequiredREGenerationData(String mgc_id, String port_cfg, String year, byte month){
		Session session = sf.openSession();
		try {
			Query query = session.createSQLQuery("CALL getRequiredREGenerationData(:mgc_id,:port_cfg_, :year,:month)");			
			query.setParameter("mgc_id", mgc_id);
			query.setParameter("port_cfg_", port_cfg);
			query.setParameter("year", year);
			query.setParameter("month", month);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();			
			return list;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getBetweenStartEndDateHaving(String start_date, String end_date, String mgc_id,
			String port_cfg) {
		Session session = sf.openSession();
	    try{
	    	Query query = session.createSQLQuery("select event_time,kwh from micro_grid.energy_details where microgrid_id='"+mgc_id+"' and port_cfg='"+port_cfg+"' and date(event_time) >= '"+start_date+"' and date(event_time) <= '"+end_date+"'");		 		   				   
		    return query.list();
	    } catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    } finally{
	    	session.flush();
	    	session.close();
	    }		
	}
}
