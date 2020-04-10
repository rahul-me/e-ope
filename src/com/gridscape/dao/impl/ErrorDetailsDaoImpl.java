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

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.ErrorDetailsDao;
import com.gridscape.model.ErrorDetails;

@Component
public class ErrorDetailsDaoImpl implements ErrorDetailsDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	public ErrorDetails findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorDetails findByRequestId(String requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ErrorDetails> findAllbyMicroGridId(String microGridId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorDetails update(ErrorDetails ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorDetails> findListByMicrogrid_idAndEventDate(
			String microgrid_id, String eventDate) {
		Session session = sf.openSession();
		String sql = "SELECT * FROM error_detils";
		sql += " WHERE micro_grid_id in ("+microgrid_id+")";
		if(eventDate!=null && eventDate.length()>0){
			sql += " AND DATE_FORMAT(event_time,'%Y-%m-%d')='"+eventDate+"'";
		}
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity(ErrorDetails.class);
		List<ErrorDetails> list = q.list();
		session.close();
		return list;
	}

	@Override
	public ErrorDetails save(ErrorDetails error_obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(error_obj);
		session.flush();
		session.close();
		return error_obj;
	}
	
	@Override
	public List<ErrorDetails> findListByErrorCodeAndMicroControllerId(String error_code, String m_id, int limit){
		Session session = sf.openSession();		
		String hql = "from ErrorDetails where error_code='"+error_code+"' and micro_grid_id='"+m_id+"' order by id desc";
		Query query = session.createQuery(hql);
		query.setMaxResults(limit);
		@SuppressWarnings("unchecked")
		List<ErrorDetails> list = query.list();
		return list;
	}
	
	public ErrorDetails findByErrorCodeAndRequestId(String error_code, String request_id){
		Session session = sf.openSession();
		String hql = "from ErrorDetails where error_code='"+error_code+"' and request_id='"+request_id+"'";
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list.size() > 0){
			return (ErrorDetails)list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public List<ErrorDetails> getOpenErrorDetails(String microgrid_id){
		Session session = sf.openSession();
		String hql = "from ErrorDetails where micro_grid_id = '"+microgrid_id+"' and status='open'";
		Query query = session.createQuery(hql);
		List<ErrorDetails> list = query.list();
		return list;
	}
	
	@Override
	public List<ErrorDetails> getResolvedErrorDetails(String micro_grid_id){
		Session session = sf.openSession();
		String hql = "from ErrorDetails where micro_grid_id='"+micro_grid_id+"' and status='resolved'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ErrorDetails> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ErrorDetails> getTotalErrorOccurred(String microgrid_id){
		Session session = sf.openSession();
		String hql = "from ErrorDetails where micro_grid_id='"+microgrid_id+"'";
		Query query = session.createQuery(hql);
		return query.list();
	}

}
