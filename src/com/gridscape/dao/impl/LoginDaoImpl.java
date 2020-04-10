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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.dao.LoginDao;
import com.gridscape.model.Organization;
import com.gridscape.model.User;
import com.gridscape.model.UserRole;

@Component
public class LoginDaoImpl implements LoginDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveOrg(Organization org) {
		Session session = sessionFactory.openSession();
		session.save(org);
		session.flush();
		session.close();
	}
	
	@Override
	@Transactional
	public void saveUserRoll(UserRole userRoll) {
		Session session = sessionFactory.openSession();
		session.save(userRoll);
		session.flush();
		session.close();
	}
	
	@Override
	@Transactional
	public List<Organization> getAllOrg() {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("SELECT id,orgId,orgName,orgDetail FROM Organization");
		@SuppressWarnings("unchecked")
		List<Organization> list = q.list();
		return list;
	}
	
	@Override
	@Transactional
	public List<UserRole> getAllUserRoll() {
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("SELECT id,userRollId,userRollType,userRollDetail FROM UserRoll");
		@SuppressWarnings("unchecked")
		List<UserRole> list = q.list();
		return list;
	}
	
	@Override
	@Transactional
	public List<User> getAllUser() {
		
		Session session = sessionFactory.openSession();
		String sql = "from User";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		session.close();
		return userList;
		
	}
	
	@Override
	public long addUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.flush();
		session.close();
		return user.getId();
	}
	@Override
	public long updateUser(User user) {
		Session session = sessionFactory.openSession();
		session.update(user);
		session.flush();
		session.close();
		return user.getId();
	}
	@Override
	@Transactional
	public List<User> getUser(String username){
		Session session = sessionFactory.openSession();
		String sql = "from User u where u.userName = :userName";
		Query q = session.createQuery(sql);
		q.setParameter("userName", username);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		session.close();
		return userList;
	}
	
	@Override
	@Transactional
	public Map<Long, String> getOrgForSelect() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT id,orgName FROM Organization");
		@SuppressWarnings({ "rawtypes" })
		List orgList = q.list();
		Map<Long, String> map = new HashMap<Long, String>();
		for (@SuppressWarnings("rawtypes")
		Iterator it = orgList.iterator(); it.hasNext(); ) {
             Object[] myResult = (Object[]) it.next();
             Long id = Long.parseLong(myResult[0].toString());
             String orgName = (String) myResult[1];
             map.put(id,orgName);
        }
		session.close();
		return map;
	}
	
	@Override
	@Transactional
	public Map<Long, String> getUserRollForSelect() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT id,userRollType FROM UserRoll");
		@SuppressWarnings({ "rawtypes" })
		List orgList = q.list();
		Map<Long, String> map = new HashMap<Long, String>();
		for (@SuppressWarnings("rawtypes")
		Iterator it = orgList.iterator(); it.hasNext(); ) {
             Object[] myResult = (Object[]) it.next();
             Long id = Long.parseLong(myResult[0].toString());
             String orgName = (String) myResult[1];
             map.put(id,orgName);
        }
		System.out.println("map : "+map);
		session.close();
		return map;
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	@Transactional
	public List<Map<String, Object>> getUserRollById(int id) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session
				.createSQLQuery("SELECT id,userRollType,userRollDetail FROM userroll_info WHERE id = :id");
		query.setParameter("id", Long.parseLong(id + ""));
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list= query.list();
		System.out.println("size : "+list.get(0));
		session.close();
		return list;
	}
}
