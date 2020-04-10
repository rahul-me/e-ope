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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.CommandHistoryDao;
import com.gridscape.model.CommandHistory;
@SuppressWarnings("unchecked")
@Component
public class CommandHistoryDaoImpl implements  CommandHistoryDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public CommandHistory findById(String id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(CommandHistory.class);
		ctr.add(Restrictions.eq("id", id));		
		List<CommandHistory> micro_c = ctr.list();
		session.close();
		return micro_c.get(0);
	}

	@Override
	public CommandHistory findByRequestId(String requestId) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(CommandHistory.class);
		ctr.add(Restrictions.eq("request_id", requestId));
		List<CommandHistory> micro_c = ctr.list();
		session.close();
		if(micro_c.size() > 0){
			return micro_c.get(0);	
		}else{
			return null;
		}
		
	}

	@Override
	public List<CommandHistory> findAllbyMicroGridId(String microGridId) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(CommandHistory.class);
		ctr.add(Restrictions.eq("micro_grid_id", microGridId));
		ctr.addOrder(Order.desc("id"));
		List<CommandHistory> micro_c = ctr.list();
		session.close();
		return micro_c;
	}

	@Override
	public CommandHistory Save(CommandHistory ch) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(ch);
		session.flush();
		session.close();
		return ch;
	}

	@Override
	public CommandHistory update(CommandHistory ch) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(ch);
		session.flush();
		session.close();
		return ch;
	}

}
