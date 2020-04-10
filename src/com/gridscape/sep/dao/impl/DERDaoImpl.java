package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.model.sep.DERModel;
import com.gridscape.sep.dao.DERDao;

@Component
public class DERDaoImpl implements DERDao {
	
	private static Logger log = Logger.getLogger(DERDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(DERModel derModel) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(derModel);
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
	public DERModel getById(Long derId) {
		Session session = sessionFactory.openSession();
		DERModel derModel = null;
		try {
			Serializable getById = derId;
			derModel = (DERModel)session.get(DERModel.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return derModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DERModel> getListByEndDeviceId(Long endDeviceId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERModel where endDeviceId= :endDeviceId");
			query.setLong("endDeviceId", endDeviceId);
			return query.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}
	
	@Transactional
	@Override
	public boolean deleteDER(Long id){
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = id;
			Object persistenceObject = session.load(DERModel.class, sid);
			session.delete(persistenceObject);
		} catch(Exception e){
			log.error(e);
			return false;
		} finally {
			session.flush();
			session.close();
		}
		return true;
	}

}

