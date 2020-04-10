package com.gridscape.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.CustomerDao;
import com.gridscape.model.Customers;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customers save(Customers entity) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(entity);
			session.flush();
			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customers findOneCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria ctr  = session.createCriteria(Customers.class);
			ctr.add(Restrictions.eq("email",email));
			List<Customers> list = ctr.list();
			if(list.size()>0){
				return list.get(0);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}
		return null;
	}

}
