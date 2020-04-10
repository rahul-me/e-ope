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

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.dao.UserDao;
import com.gridscape.model.User;
import com.gridscape.model.UserLogin;
import com.gridscape.model.UserRole;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public User save(User obj) {		
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public User findById(Long id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setPassword(user.getPassword());
			u.setEmail(user.getEmail());
			u.setActive(user.isActive());
			u.setPassword(user.getPassword());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setDynamicToken(user.getDynamicToken());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setSepAccess(user.isSepAccess());
			u.setSepOnly(user.isSepOnly());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				u.setUserRole(ur);
			}
		}
		session.close();
		return u;
	}

	@Override
	@Transactional
	public List<User> userList() {
		Session session = sessionFactory.openSession();
		String sql = "from User";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		session.close();
		List<User> tempUserList = new ArrayList<User>();
		if(userList.size()>0){
			User u = null;
			UserRole ur = null;
			for(User user:userList){
				u = new User();
				u.setId(user.getId());
				u.setFullname(user.getFullname());
				u.setEmail(user.getEmail());
				u.setActive(user.isActive());
				u.setUserName(user.getUserName());
				if(user.getUserRole()!=null){
					ur = new UserRole();
					ur.setId(user.getUserRole().getId());
					ur.setRole(user.getUserRole().getRole());
					u.setUserRole(ur);
				}
				tempUserList.add(u);
			}
		}
		return tempUserList;
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		Session session = sessionFactory.openSession();
		String sql = "Delete FROM User where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("userName", userName));
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
		}
		session.close();
		return u;
	}

	@Override
	@Transactional
	public User findByEmail(String email) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("email", email));
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = null;
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setSepAccess(user.isSepAccess());
			u.setSepOnly(user.isSepOnly());
			u.setAnalysisAccess(user.isAnalysisAccess());
			u.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
			if(user.getUserRole()!=null){
				ur = new UserRole();
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
		}
		session.close();
		return u;
	}

	@Override
	@Transactional
	public List<User> getUserListByLimit(Integer start, Integer len,String search) {
		Session session = sessionFactory.openSession();
		String sql = "from User WHERE isDelete=false";
		if(search!=null){
			if(search.length()>0){
				sql += " fullname LIKE '%"+search+"%' OR email LIKE '%"+search+"%' OR userName LIKE '%"+search+"%'";
			}
		}
		Query q = session.createQuery(sql);
		q.setFirstResult(start);
		q.setMaxResults(len);
		@SuppressWarnings("unchecked")
		List<User> userList = q.list();
		session.close();
		List<User> tempUserList = new ArrayList<User>();
		if(userList.size()>0){
			User u = null;
			UserRole ur = null;
			for(User user:userList){
				u = new User();
				u.setId(user.getId());
				u.setFullname(user.getFullname());
				u.setEmail(user.getEmail());
				u.setDynamicToken(user.getDynamicToken());
				u.setPassword(user.getPassword());
				u.setActive(user.isActive());
				u.setUserName(user.getUserName());
				u.setAddress_line_1(user.getAddress_line_1());
				u.setAddress_line_2(user.getAddress_line_2());
				u.setCity(user.getCity());
				u.setState(user.getState());
				u.setCountry(user.getCountry());
				u.setZip_code(user.getZip_code());
				u.setImage(user.getImage());
				u.setMobile(user.getMobile());
				u.setLatitude(user.getLatitude());
				u.setLongitude(user.getLongitude());
				if(user.getUserRole()!=null){
					ur = new UserRole();
					ur.setId(user.getUserRole().getId());
					ur.setRole(user.getUserRole().getRole());
					u.setUserRole(ur);
				}
				tempUserList.add(u);
			}
		}
		return tempUserList;
	}

	@Override
	@Transactional
	public User findByToken(String dynamicToken) {
		System.out.println("token ==== "+dynamicToken);
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("dynamicToken", dynamicToken));
		
		System.out.println("size = "+ctr.list().size());
		@SuppressWarnings("unchecked")
		
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		System.out.println("size = "+userList.size());
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setSepAccess(user.isSepAccess());
			u.setSepOnly(user.isSepOnly());
			u.setAnalysisAccess(user.isAnalysisAccess());
			u.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
		}
		session.close();
		return u;
	}

	@Override
	@Transactional
	public List<User> getCustomerAdminList() {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.createAlias("userRole", "ur");
		ctr.add(Restrictions.eq("ur.role","customer-admin"));
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		List<User> uList = new ArrayList<User>();
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setAnalysisAccess(user.isAnalysisAccess());
			u.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
			uList.add(u);
		}
		session.close();
		return uList;
	}

	@Override
	public List<User> getListByOperatorArr(Object[] obj) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		
		
		ctr.add(Restrictions.in("id", obj));
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		System.out.println("size ==== "+userList.size());
		List<User> uList = new ArrayList<User>();
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setAnalysisAccess(user.isAnalysisAccess());
			u.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
			uList.add(u);
		}
		session.close();
		return uList;
	}

	@Override
	public List<User> getListByOperatorArrWithLimit(Object[] obj,
			Integer start, Integer len) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.in("id", obj));
		ctr.setFirstResult(start);
		ctr.setMaxResults(len);
		@SuppressWarnings("unchecked")
		List<User> userList = ctr.list();
		User u = null;
		UserRole ur = new UserRole();
		System.out.println("size ==== "+userList.size());
		List<User> uList = new ArrayList<User>();
		for(User user:userList){
			u = new User();
			u.setId(user.getId());
			u.setFullname(user.getFullname());
			u.setEmail(user.getEmail());
			u.setDynamicToken(user.getDynamicToken());
			u.setPassword(user.getPassword());
			u.setActive(user.isActive());
			u.setUserName(user.getUserName());
			u.setAddress_line_1(user.getAddress_line_1());
			u.setAddress_line_2(user.getAddress_line_2());
			u.setCity(user.getCity());
			u.setState(user.getState());
			u.setCountry(user.getCountry());
			u.setZip_code(user.getZip_code());
			u.setImage(user.getImage());
			u.setMobile(user.getMobile());
			u.setLatitude(user.getLatitude());
			u.setLongitude(user.getLongitude());
			u.setAnalysisAccess(user.isAnalysisAccess());
			u.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
			if(user.getUserRole()!=null){
				ur.setId(user.getUserRole().getId());
				ur.setRole(user.getUserRole().getRole());
				u.setUserRole(ur);
			}
			uList.add(u);
		}
		session.close();
		return uList;
	}

	@Override
	public void createLoginToken(String token, String userId,String email) {
		Session session = sessionFactory.openSession();
		UserLogin userLogin =  new UserLogin();
		userLogin.setLogin_token(token);
		userLogin.setUserId(userId);
		userLogin.setUser_email(email);
		session.save(userLogin);
		session.flush();
		session.close();
	}
	@Override
	public void deleteLoginToken(String token) {
		Session session = sessionFactory.openSession();
		UserLogin userLogin = findUserByLoginToken(token);
		if(userLogin != null){
			session.delete(userLogin);
		}		
		session.flush();
		session.close();
	}
	@Override
	public UserLogin findUserByLoginToken(String token) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(UserLogin.class);
		ctr.add(Restrictions.eq("login_token", token));
		@SuppressWarnings("unchecked")
		List<UserLogin> userList = ctr.list();
		if(userList != null & !userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}
	
	
	
}
