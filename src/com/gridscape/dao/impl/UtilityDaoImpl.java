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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.UtilityDao;
import com.gridscape.model.SolarEstimateCustomer;
import com.gridscape.model.Utility;
import com.gridscape.model.UtilityBreakDown;
import com.gridscape.model.UtilityIntervalData;
import com.gridscape.model.UtilityProvider;
import com.gridscape.model.UtilityRate;

@Component
public class UtilityDaoImpl implements UtilityDao {
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public Utility save(Utility obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utility> getList() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(Utility.class);
		List<Utility> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public Utility findById(long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(Utility.class);
		ctr.add(Restrictions.eq("id",id));
		@SuppressWarnings("unchecked")
		List<Utility> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM Utility where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@Override
	public List<Utility> findListByUserId(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(Utility.class);
		ctr.add(Restrictions.eq("user_id",id));
		@SuppressWarnings("unchecked")
		List<Utility> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public UtilityIntervalData saveUtilityIntervalData(List<UtilityIntervalData> obj) {
		Session session = sf.openSession();
		int index = 0;
		Transaction tx = session.beginTransaction();
		int insertcount = 0;
		for(UtilityIntervalData u:obj){
			index++;
			session.saveOrUpdate(u);
			++insertcount;
			if(index%50==0){
				session.flush();
	            session.clear();
			}
		}
		System.out.println("Number of Insert: "+insertcount);
		tx.commit();
		return null;
	}

	@Override
	public List<UtilityIntervalData> getIntervalData() {
		Session session = sf.openSession();
		String sql = "SELECT id,DATE,SUM(cost) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		sql += "WHERE YEAR(DATE) = 2013 GROUP BY MONTH(DATE)";		
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<UtilityIntervalData> list = query.list();	
		session.close();
		return list;
	}

	@Override
	public List<Object[]> getIntervalDataUsingAccountNoAndStartDateAndEndDate(String energy_cost_on,String account_no,
			String start_date, String end_date) {
		Session session = sf.openSession();
		String sql = "";
		if(energy_cost_on.equals("predefined")){
			sql = "SELECT id,DATE,SUM(cost) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}else{
			sql = "SELECT id,DATE,SUM(cal_price) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}
		
		sql += "WHERE account_no='"+account_no+"' AND date BETWEEN "+start_date+" AND "+end_date+"";
		sql += " GROUP BY DAY(DATE)";
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();	
		session.close();
		return list;
	}

	@Override
	public List<Object[]> getIntervalDataUsingAccountNoAndMonthAndYear(String energy_cost_on,
			String account_no, int month_no, int year_no) {
		Session session = sf.openSession();		
		String sql = "";
		if(energy_cost_on.equals("predefined")){
			sql = "SELECT id,DATE,SUM(cost) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}else{
			sql = "SELECT id,DATE,SUM(cal_price) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}
		sql += "WHERE account_no='"+account_no+"' and MONTH(DATE)="+month_no+" and YEAR(DATE)="+year_no;
		sql += " GROUP BY DAY(DATE)";
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();	
		session.close();
		return list;
	}

	@Override
	public List<Object[]> getIntervalDataUsingAccountNoAndYear(String energy_cost_on,String account_no,int year_no) {
		Session session = sf.openSession();
		String sql = "";
		if(energy_cost_on.equals("predefined")){
			sql = "SELECT id,DATE,SUM(cost) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}else{
			sql = "SELECT id,DATE,SUM(cal_price) AS cost,SUM(u_usage) AS u_usage FROM utility_interval_data ";
		}		
		sql += "WHERE account_no='"+account_no+"' and YEAR(DATE)="+year_no;
		sql += " GROUP BY MONTH(DATE)";
		Query query = session.createSQLQuery(sql);			
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtilityProvider> getUtilityProvider() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityProvider.class);
		List<UtilityProvider> list = ctr.list();		
		session.close();
		return list;
	}

	@Override
	public List<UtilityIntervalData> getPlainIntervalDataUsingAccountNoAndStartDateAndEndDate(
			String account_no, Date start_date_obj, Date end_date_obj) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityIntervalData.class);
		ctr.add(Restrictions.between("date",start_date_obj, end_date_obj));
		ctr.add(Restrictions.eq("account_no",account_no));
		ctr.addOrder(Order.asc("date"));
		@SuppressWarnings("unchecked")
		List<UtilityIntervalData> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public Utility findUtilityByAccountNo(String account_no) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(Utility.class);
		ctr.add(Restrictions.eq("account_no",account_no));
		@SuppressWarnings("unchecked")
		List<Utility> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<UtilityBreakDown> findUtilityBreakDownUsingMonthNoAndUtilityProviderId(
			int start_month, String utility_provider_id) {
		Session session = sf.openSession();
		String sql = "FROM UtilityBreakDown WHERE MONTH(start_date)="+start_month+" AND utility_provider_id="+utility_provider_id;
		Query query = session.createQuery(sql);		
		@SuppressWarnings("unchecked")
		List<UtilityBreakDown> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<UtilityBreakDown> findUtilityBreakDownUsingUtilityProviderId(
			String utility_provider_id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityBreakDown.class);
		ctr.add(Restrictions.eq("utility_provider_id",utility_provider_id));
		@SuppressWarnings("unchecked")
		List<UtilityBreakDown> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public List<UtilityBreakDown> listUtilityBreakDown() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityBreakDown.class);
		@SuppressWarnings("unchecked")
		List<UtilityBreakDown> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public List<UtilityRate> listUtilityRate() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityRate.class);
		@SuppressWarnings("unchecked")
		List<UtilityRate> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public UtilityProvider findUtilityProviderById(Long utility_provider_id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityProvider.class);
		ctr.add(Restrictions.eq("id",utility_provider_id));
		@SuppressWarnings("unchecked")
		List<UtilityProvider> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public UtilityBreakDown saveUtilityBreakDown(UtilityBreakDown obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public UtilityBreakDown findBreakDownById(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityBreakDown.class);
		ctr.add(Restrictions.eq("id",id));
		@SuppressWarnings("unchecked")
		List<UtilityBreakDown> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteBreakDown(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM UtilityBreakDown where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@Override
	public UtilityProvider saveUtilityProvider(UtilityProvider obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public void deleteUtilityProviderById(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM UtilityProvider where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@Override
	public List<UtilityBreakDown> findBreakDownByUtilityProviderId(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityBreakDown.class);
		ctr.add(Restrictions.eq("utility_provider_id",id));
		@SuppressWarnings("unchecked")
		List<UtilityBreakDown> list = ctr.list();	
		session.close();
		return list;
	}

	@Override
	public UtilityRate saveUtilityRate(UtilityRate obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public UtilityRate findUtilityRateById(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityRate.class);
		ctr.add(Restrictions.eq("id",id));
		@SuppressWarnings("unchecked")
		List<UtilityRate> list = ctr.list();
		session.close();		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteUtilityRate(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM UtilityRate where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@Override
	public float findMinRate() {
		Session session = sf.openSession();
		String sql = "SELECT MIN(rate) FROM utility_rate";		
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();	
		session.close();
		float rate = 0.0f; 
		for(Object obj:list){			
			rate = Float.parseFloat(obj.toString());
		}	
		return rate;
	}

	@Override
	public SolarEstimateCustomer saveSolarEstimateCustomer(
			SolarEstimateCustomer obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public List<UtilityIntervalData> getIntervalDataList() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(UtilityIntervalData.class);
		@SuppressWarnings("unchecked")
		List<UtilityIntervalData> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public List<Object> getAccountNoListFromIntervalData() {
		Session session = sf.openSession();
		String sql = "SELECT account_no FROM utility_interval_data group by account_no";		
		Query query = session.createSQLQuery(sql);	
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		session.close();
		return list;
	}
	
	@Override
	public boolean saveUtilityIntervalDataInBatch(List<UtilityIntervalData> list, int batchSize) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean status = false;
		boolean endOfBatch = false;
		int startIndex = 0;
		int endIndex = batchSize - 1;
		int listSize = list.size();
		if (listSize > 0) {
			int insertcount = 0;
			while (!endOfBatch) {
				String sql = "insert into micro_grid.utility_interval_data (account_no, address, cal_price, cost, date, end_time, generation, name, notes, service_no, start_time, u_type, unit_cost, units, u_usage) values ";
				if (listSize - 1 <= endIndex) {
					endIndex = listSize - 1;
					endOfBatch = true;
				}
				for (int i = startIndex; i <= endIndex; i++) {
					UtilityIntervalData u_interval_data = list.get(i);
					sql += "('" + u_interval_data.getAccount_no() + "','" + u_interval_data.getAddress() + "',"
							+ u_interval_data.getCal_price() + ",'" + u_interval_data.getCost() + "','"
							+ new SimpleDateFormat("yyyy-MM-dd").format(u_interval_data.getDate()) + "','" + u_interval_data.getEnd_time() + "','"
							+ u_interval_data.getGeneration() + "','" + u_interval_data.getName() + "','"
							+ u_interval_data.getNotes() + "','" + u_interval_data.getService_no() + "','"
							+ u_interval_data.getStart_time() + "','" + u_interval_data.getType() + "','"
							+ u_interval_data.getUnit_cost() + "','" + u_interval_data.getUnits() + "','"
							+ u_interval_data.getUsage() + "')";
					if (i != endIndex) {
						sql += ", ";
					}					
				}
				startIndex = endIndex + 1;
				endIndex = startIndex + (batchSize - 1);
				session.createSQLQuery(sql).executeUpdate();
				++insertcount;
			}
			System.out.println("Number of insert: "+insertcount);
			session.flush();
			session.clear();
			tx.commit();
		}
		return status = true;
	}
	
	
	public List<UtilityRate> getHaving(Long utilityBreakDownId){
		List<UtilityRate> list = new ArrayList<UtilityRate>();
		Session session = sf.openSession();
		try {			
			Criteria criteria = session.createCriteria(UtilityRate.class);
			criteria.add(Restrictions.eq("utility_break_down_id", utilityBreakDownId));
			@SuppressWarnings("unchecked")
			List<UtilityRate> utilityRateList = criteria.list();
			return (utilityRateList.size() > 0 ? list = utilityRateList : list);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return list;
	}
	
	
	
	

}
