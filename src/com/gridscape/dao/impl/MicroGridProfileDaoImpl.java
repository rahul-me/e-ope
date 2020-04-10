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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.MicroGridProfileDao;
import com.gridscape.model.MicroGridDefaultProfile;
import com.gridscape.model.MicroGridProfile;

@Component
public class MicroGridProfileDaoImpl implements MicroGridProfileDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	public MicroGridProfile save(MicroGridProfile obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MicroGridProfile> list() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridProfile.class);
		List<MicroGridProfile> list = ctr.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MicroGridProfile> findByMicrogrid__id_arr(Object[] mIds) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridProfile.class);
		if(mIds.length>0){
			ctr.add(Restrictions.in("microgrid_id", mIds));
		}
		List<MicroGridProfile> list = ctr.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MicroGridProfile findById(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridProfile.class);
		ctr.add(Restrictions.eq("id", id));
		List<MicroGridProfile> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete_profile(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM MicroGridProfile where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MicroGridProfile> find_list_between_start_emd_time(
			Long lng_start_date, Long lng_end_date) {
		Session session = sf.openSession();
		String sql = "FROM MicroGridProfile where "+lng_start_date+">=lng_start_time AND "+lng_end_date+"<lng_end_time";
		Query q = session.createQuery(sql);
		List<MicroGridProfile> list = q.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MicroGridProfile> find_list_by_microgrid_id_and__between_start_emd_time(
			String microgrid_id, Long lng_start_date, Long lng_end_date) {
		Session session = sf.openSession();
		String sql = "FROM MicroGridProfile where "+lng_start_date+">=lng_start_time AND "+lng_end_date+"<lng_end_time and microgrid_id='"+microgrid_id+"'";
		Query q = session.createQuery(sql);
		List<MicroGridProfile> list = q.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MicroGridProfile> find_list_by_microgrid_id(String microgrid_id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridProfile.class);
		ctr.add(Restrictions.eq("microgrid_id", microgrid_id));
		List<MicroGridProfile> list = ctr.list();
		return list;
	}

	@Override
	public void delete_by_microgrid_id(String microgrid_id) {
		Session session = sf.openSession();
		String sql = "Delete FROM MicroGridProfile where microgrid_id = :microgrid_id";
		session.createQuery(sql).setString("microgrid_id", microgrid_id).executeUpdate();
		session.close();
	}

	@Override
	public MicroGridDefaultProfile saveMicrogridDefaultProfile(
			MicroGridDefaultProfile obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	public void deleteAllMicroGridDefaultProfile() {
		Session session = sf.openSession();
		String sql = "Delete FROM MicroGridDefaultProfile";
		session.createQuery(sql).executeUpdate();
		session.close();
	}

	@Override
	public List<MicroGridDefaultProfile> listMicrogridDefaultProfile() {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridDefaultProfile.class);
		@SuppressWarnings("unchecked")
		List<MicroGridDefaultProfile> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	public MicroGridDefaultProfile findDefaultProfileById(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(MicroGridDefaultProfile.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<MicroGridDefaultProfile> list = ctr.list();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findStandardProfile(String start_time,
			String end_time) {
		Session session = sf.openSession();
		String sql = "SELECT * FROM microgrid_default_profile WHERE TIME_FORMAT(start_time,'%H:%i:%s') <= TIME_FORMAT('"+start_time+"','%H:%i:%s')";
		sql += " AND TIME_FORMAT(end_time,'%H:%i:%s') >= TIME_FORMAT('"+end_time+"','%H:%i:%s')";
		Query q = session.createSQLQuery(sql);		
		List<Object[]> list = q.list();
		if(list.isEmpty()){
			sql = "SELECT * FROM microgrid_default_profile WHERE TIME_FORMAT(start_time,'%H:%i:%s') <= TIME_FORMAT('"+start_time+"','%H:%i:%s')";			
			q = session.createSQLQuery(sql);			
			list = q.list();
		}
		session.close();
		return list;
	}

}
