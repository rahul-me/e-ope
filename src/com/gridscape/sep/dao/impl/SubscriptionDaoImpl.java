package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.SolarGenerationCharge;
import com.gridscape.model.sep.SubscriptionModal;
import com.gridscape.sep.dao.SubscriptionDao;
import com.gridscape.sep.org.zigbee.sep.Subscription;

@Service
public class SubscriptionDaoImpl implements SubscriptionDao  {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(SubscriptionModal subscriptionModal) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(subscriptionModal);
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally{
			session.flush();
			session.close();
		}		
		return 1;
	}

	@Override
	public SubscriptionModal getById(Long subscriptionId) {
		Session session = sessionFactory.openSession();
		SubscriptionModal subscriptionModal = null;
		try {
			Serializable getById = subscriptionId;
			subscriptionModal = (SubscriptionModal)session.get(SubscriptionModal.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return subscriptionModal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionModal> getListByDeviceId(Long deviceId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from SubscriptionModal where deviceId= :deviceId");
			query.setLong("deviceId", deviceId);
			return query.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SubscriptionModal> getListByDeviceIdHavingSubscriptionLike(Long deviceId, String subscription){
		List<SubscriptionModal> subscriptionModals = new ArrayList<SubscriptionModal>();
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from SubscriptionModal where deviceId= :deviceId and subscribedResource like :resource");
			query.setLong("deviceId", deviceId);
			query.setString("resource", "%"+subscription+"%");
			List<SubscriptionModal> tempList =  query.list();
			if(!tempList.isEmpty())subscriptionModals = tempList;
			return subscriptionModals;
		} catch(Exception e){
			e.printStackTrace();
			return subscriptionModals;
		}finally{
			session.flush();
			session.close();;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SubscriptionModal getByDeviceIdHavingSubscribedResource(Long deviceId, String subscribedResource){
		SubscriptionModal subscriptionModalResult = null;
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from SubscriptionModal where deviceId= :deviceId and subscribedResource= :resource");
			query.setLong("deviceId", deviceId);
			query.setString("resource", subscribedResource);
			SubscriptionModal subscriptionModal  =  (SubscriptionModal)query.uniqueResult();
			if(subscriptionModal != null)subscriptionModalResult = subscriptionModal;
			return subscriptionModalResult;
		} catch(Exception e){
			e.printStackTrace();
			return subscriptionModalResult;
		}finally{
			session.flush();
			session.close();;
		}
	}

	@Override
	public int deleteById(Long subscriptionId) {
		Session session = sessionFactory.openSession();
		int result = -1;
		try {
			String sql = "Delete FROM SubscriptionModal where id = :subscriptionId";
			result = session.createQuery(sql).setLong("subscriptionId", subscriptionId).executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}		
		session.close();
		return result;
	}

}

