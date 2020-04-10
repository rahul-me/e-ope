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

import com.gridscape.model.sep.DERControlModal;
import com.gridscape.model.sep.DERModel;
import com.gridscape.sep.dao.DERControlDao;

@Component
public class DERControlDaoImpl implements DERControlDao {
	
	private static Logger log = Logger.getLogger(DERControlDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveOrUpdate(DERControlModal derControlModal) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(derControlModal);
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
	public DERControlModal getById(Long dercId) {
		Session session = sessionFactory.openSession();
		DERControlModal derControlModal = null;
		try {
			Serializable getById = dercId;
			derControlModal = (DERControlModal)session.get(DERControlModal.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return derControlModal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DERControlModal> getByDerpId(Long derpId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERControlModal where derpId= :derpId");
			query.setLong("derpId", derpId);
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
	public boolean deleteDERControl(Long id){
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = id;
			Object persistenceObject = session.load(DERControlModal.class, sid);
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

	@Override
	public DERControlModal getDefaultTypeDERControl(Long derpId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERControlModal where derpId= :derpId and defaultDERControl= :defaultDERControl");
			query.setLong("derpId", derpId);
			query.setBoolean("defaultDERControl", Boolean.TRUE);
			return (DERControlModal) query.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}	

	@SuppressWarnings("unchecked")
	@Override
	public List<DERControlModal> getNormalTypeDERControl(Long derpId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERControlModal where derpId= :derpId and defaultDERControl= :defaultDERControl");
			query.setLong("derpId", derpId);
			query.setBoolean("defaultDERControl", Boolean.FALSE);
			return query.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}
	
	

}

