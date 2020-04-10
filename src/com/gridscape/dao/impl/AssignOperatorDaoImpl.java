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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.dao.AssignOperatorDao;
import com.gridscape.model.AssignOperator;

@Component
public class AssignOperatorDaoImpl implements AssignOperatorDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	@Transactional
	public AssignOperator save(AssignOperator obj) {
		Session session = sf.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AssignOperator> listByParentId(Long id) {
		Session session = sf.openSession();
 		Criteria ctr =session.createCriteria(AssignOperator.class);
 		ctr.add(Restrictions.eq("parentId", id));
		return ctr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public AssignOperator findByParentIdAndOperatorId(Long parentId, Long operatorId) {
		Session session = sf.openSession();
		Criteria ctr =session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("parentId", parentId));
		ctr.add(Restrictions.eq("operatorId",operatorId));
		List<AssignOperator> aoList = ctr.list();
		if(aoList.size()>0){
			return aoList.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteByParentIdAndOperatorId(Long parentId, Long operatorId) {
		Session session = sf.openSession();
		String sql = "Delete FROM AssignOperator where parentId = :parentId AND operatorId = :operatorId";
		session.createQuery(sql).setLong("parentId", parentId).setLong("operatorId",operatorId).executeUpdate();
		session.close();	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AssignOperator> listByParentIdWithLimit(Long id, Integer start,Integer len) {
		Session session = sf.openSession();
		Criteria ctr =session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("parentId",id));
		ctr.setFirstResult(start);
		ctr.setMaxResults(len);
		List<AssignOperator> list = ctr.list();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public int getTotalRecordByParentId(Long id) {
		Session session = sf.openSession();
		Criteria ctr =session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("parentId",id));
		int count = ctr.list().size();
		session.close();
		return count;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public AssignOperator findById(Long id) {
		Session session = sf.openSession();
		Criteria ctr =session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("id",id));
		List<AssignOperator> list = ctr.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Session session = sf.openSession();
		String sql = "Delete FROM AssignOperator where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();	
	}

	@Override
	public List<AssignOperator> findListByOperatorId(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("operatorId",id));
		List<AssignOperator> list = ctr.list();
		session.close();
		return list;
	}
	
	@Override
	public AssignOperator findListByOperatorIdUnique(Long id) {
		Session session = sf.openSession();
		Criteria ctr = session.createCriteria(AssignOperator.class);
		ctr.add(Restrictions.eq("operatorId",id));
		AssignOperator assignOperator = (AssignOperator)ctr.uniqueResult();
		session.close();
		return assignOperator;
	}

}
