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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.BatteryDao;
import com.gridscape.model.BatteryStatus;

@Component
public class BatteryDaoImpl implements BatteryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public long addBattery(BatteryStatus battery) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(battery);
		session.flush();
		session.close();
		return battery.getId();
	}
	
	@Override
	public BatteryStatus save(BatteryStatus obj) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public BatteryStatus findByMicrogridId(String id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(BatteryStatus.class);
		ctr.add(Restrictions.eq("microgrid_id", id));
		@SuppressWarnings("unchecked")
		List<BatteryStatus> list = ctr.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public BatteryStatus findById(Long id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(BatteryStatus.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<BatteryStatus> list = ctr.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<BatteryStatus> findListByMicrogrid_id_arr(Object[] mIds) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(BatteryStatus.class);
		ctr.add(Restrictions.in("microgrid_id", mIds));
		//ctr.add(Restrictions.eq("active", true));
		@SuppressWarnings("unchecked")
		List<BatteryStatus> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public void deleteBattery(Long id) {
		Session session = sessionFactory.openSession();
		String sql = "Delete FROM BatteryStatus where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();		
	}

	@Override
	public List<BatteryStatus> getLast30DaysSOC(String microgrid_id,
			String port_cfg, String state) {
		String sql = "SELECT id,event_time,soc FROM energy_details ";
		sql += "WHERE port_cfg='"+port_cfg+"' AND state='"+state+"' AND microgrid_id='"+microgrid_id+"' ";
		sql += "GROUP BY HOUR(event_time) LIMIT 24";
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery(sql);				
		@SuppressWarnings("unchecked")
		List<BatteryStatus> list = query.list();
		session.close();
		return list;
	}

	@Override
	public BatteryStatus getLatestCurrentVoltage(String microgrid_id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(BatteryStatus.class);
		ctr.add(Restrictions.eq("microgrid_id",microgrid_id));		
		ctr.addOrder(Order.desc("id"));
		ctr.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<BatteryStatus> bsList = ctr.list();
		session.close();
		if(bsList.size()>0){
			return bsList.get(0);
		}
		return null;
	}

}
