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
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.API_Interface.MicroGridAPI;
import com.gridscape.dao.MicroGridDao;
import com.gridscape.model.MicroController;
import com.gridscape.model.User;

@Component	
public class MicroGridDaoImpl  implements MicroGridDao	{
	private static final Logger logger = Logger.getLogger(MicroGridAPI.class.getName());
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public MicroController save(MicroController obj) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Transactional
	public MicroController findById(Long id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("id", id));
		//ctr.add(Restrictions.eq("active", true));
		@SuppressWarnings("unchecked")
		List<MicroController> micro_c = ctr.list();
		session.close();
		return micro_c.get(0);
	}

	@Transactional
	public List<MicroController> GetList(){
		Session session = sessionFactory.openSession();
		String sql = "from MicroController";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<MicroController> microControllerList = q.list();
		session.close();
		return microControllerList;
	}

	@Override
	public MicroController findByMicroGridID(String id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("microgrid_id", id));
		//ctr.add(Restrictions.eq("active", true));
		@SuppressWarnings("unchecked")
		List<MicroController> micro_c = ctr.list();
		session.close();
		return micro_c.get(0);
	}

	@Override
	public List<MicroController> listMicroByUserId(Long id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("user_id", id.toString()));
		//ctr.add(Restrictions.eq("active", true));
		ctr.add(Restrictions.eq("deleted", false));
		@SuppressWarnings("unchecked")
		List<MicroController> microList = ctr.list();
		session.close();
		return microList;
	}

	@Override
	@Transactional
	public List<MicroController> findListByUserIdArr(Object[] obj) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.in("user_id", obj));
		//ctr.add(Restrictions.eq("active", true));
		ctr.add(Restrictions.eq("deleted", false));
		@SuppressWarnings("unchecked")
		List<MicroController> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public MicroController findByMicrogrid_Id(String id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("microgrid_id", id));
		//ctr.add(Restrictions.eq("active", true));
		@SuppressWarnings("unchecked")
		List<MicroController> list = ctr.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<MicroController> findListByUserId(Long id) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("user_id", id.toString()));
		@SuppressWarnings("unchecked")
		List<MicroController> list = ctr.list();		
		return list;
	}

	@Override
	public List<MicroController> findAllByMicroGridActiveStatus(boolean activeStatus) {
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(MicroController.class);
		ctr.add(Restrictions.eq("active", activeStatus));
		@SuppressWarnings("unchecked")
		List<MicroController> list = ctr.list();
		return list;
	}
	
	@Transactional
	public List<User> findAllMicrogridControllerWithUserDetails(boolean uniqueUsers){
		Session session = sessionFactory.openSession();
		String hql = null;
		if(uniqueUsers){
			 hql = "from MicroController as mc, User as u where mc.user_id = u.id group by mc.user_id";
		}else{
			 hql = "from MicroController as mc, User as u where mc.user_id = u.id";
		}
		Query query = session.createQuery(hql);
		List<User> userList = new ArrayList<User>();
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();		
		User user =null;
		for(Object[] objarr: list){											
			user= (User)objarr[1];
			userList.add(user);
		}								
		return userList;
	}
	
		
	@Transactional
	@Override
	public List<Object[]> findMicroControllerByFilter(HashMap<String,String> queryMap){
		Session session = sessionFactory.openSession();
		String hql = "from MicroController as mc, User as u where user_id = u.id AND";
		Set<String> keys = queryMap.keySet();
		int i =0;
		for(String key: keys){
			if (!key.equalsIgnoreCase("microgrid_name")) {
				hql += " " + key + "='" + queryMap.get(key) + "'";				
			}else{
				hql += " " + key + " like '%"+queryMap.get(key)+"%'";
			}
			if ((queryMap.size() - 1) != i) {
				hql += " AND";
			}
			i++;
		}
		logger.info(hql);
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> lists = query.list();
		List<MicroController> microList = new ArrayList<MicroController>();
		List<User> userList = new ArrayList<User>();
		for(Object[] list: lists){
			MicroController micro = (MicroController)list[0];
			User user = (User) list[1];
			microList.add(micro);
			userList.add(user);
		}
		return lists;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<MicroController> findUniqueCitiesAssociateWithMicroController(){
		Session session = sessionFactory.openSession();
		String hql = "from MicroController group by city";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	
	@Transactional
	@Override
	public List<Object> findMicroControllerIdAssociationWithUser(String microgrid_id, long user_id){
		Session session = sessionFactory.openSession();
		String sql = "select mc.microgrid_id from micro_controller mc join users u on mc.user_id = u.id where mc.microgrid_id ='"+microgrid_id+"' and u.id="+user_id+"";
		Query query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		return list;
	}
	
	@Transactional
	@Override
	public List<Object> findMicroControllerIdAssociationWithUser(String microgrid_id, String user_token){
		Session session = sessionFactory.openSession();
		String sql = "select mc.microgrid_id from micro_controller mc join users u on mc.user_id = u.id where mc.microgrid_id ='"+microgrid_id+"' and u.dynamicToken='"+user_token+"'";
		Query query = session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		return list;
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<MicroController> getListByMGCIdArr(List<Long> mgcIds){
		List<MicroController> mcList = new ArrayList<MicroController>();
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(MicroController.class);
			criteria.add(Restrictions.in("id", mgcIds));
			mcList =  criteria.list();
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return mcList;
	}
}
