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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.dao.UserRollDao;
import com.gridscape.model.UserRole;

@Component
public class UserRollDaoImpl implements UserRollDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public UserRole save(UserRole obj) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public List<UserRole> UserRollList() {
		Session session = sessionFactory.openSession();
		String sql = "SELECT id,role from UserRole";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> userRollList = q.list();
		session.close();
		if(userRollList.size()>0){
			List<UserRole> urList = new ArrayList<UserRole>();
			UserRole temp = null;
			for(Object obj[]:userRollList){
				temp = new UserRole();
				temp.setId(Long.parseLong(obj[0].toString()));
				temp.setRole(obj[1].toString());
				urList.add(temp);
			}
			return urList;
		}
		return null;
	}

	@Override
	public UserRole findById(Long id) {
		Session session = sessionFactory.openSession();
		String sql = "from UserRole WHERE id = "+id;
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<UserRole> userRollList = q.list();
		session.close();
		if(userRollList.size()>0){
			System.out.println(userRollList.get(0));
			return userRollList.get(0);
		}
		return null;
	}
	
	public UserRole findByRoleName(String name){
		Session session = sessionFactory.openSession();
		String sql = "from UserRole WHERE role = '"+name+"'";
		Query query = session.createQuery(sql);
		UserRole userRole = (UserRole)query.uniqueResult();
		return userRole;
	}

}
