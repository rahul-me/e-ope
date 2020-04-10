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

import com.gridscape.dao.MicroControllerStatusDao;
import com.gridscape.model.MicroControllerStatus;
@SuppressWarnings("unchecked")
@Component
public class MicroControllerStatusDaoImpl implements MicroControllerStatusDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public MicroControllerStatus findById(String id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroControllerStatus.class);
		ctr.add(Restrictions.eq("id", id));
		List<MicroControllerStatus> micro_c = ctr.list();
		session.close();
		return micro_c.get(0);
	}

	@Override
	public MicroControllerStatus findByRequestId(String requestId) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroControllerStatus.class);
		ctr.add(Restrictions.eq("request_id", requestId));
		List<MicroControllerStatus> micro_c = ctr.list();
		session.close();
		return micro_c.get(0);
	}

	@Override
	public List<MicroControllerStatus> findAllbyMicroGridId(String microGridId) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroControllerStatus.class);
		ctr.add(Restrictions.eq("micro_grid_id", microGridId));
		List<MicroControllerStatus> micro_c = ctr.list();
		session.close();
		return micro_c;
	}

	@Override
	public MicroControllerStatus Save(MicroControllerStatus mcs) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(mcs);
		session.flush();
		session.close();
		return mcs;
	}

	@Override
	public MicroControllerStatus update(MicroControllerStatus mcs) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(mcs);
		session.flush();
		session.close();
		return mcs;
	}
	
	@Override
	public MicroControllerStatus getMCStatus(String micro_id){
		try{
			Session session = sessionFactory.openSession();
			Query query = session.createSQLQuery("CALL getMCStatus(:micro_id)").addEntity(MicroControllerStatus.class).setParameter("micro_id", micro_id);
			MicroControllerStatus microControllerStatus = (MicroControllerStatus)query.uniqueResult();
			return microControllerStatus;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
