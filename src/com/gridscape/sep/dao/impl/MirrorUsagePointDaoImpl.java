package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.MirrorUsagePointModel;
import com.gridscape.sep.dao.MirrorUsagePointDao;

@Service
public class MirrorUsagePointDaoImpl implements MirrorUsagePointDao {

	private static Logger log = Logger.getLogger(MirrorUsagePointDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveOrUpdate(MirrorUsagePointModel mirrorUsagePointModel) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(mirrorUsagePointModel);
		} catch(Exception e){
			log.error(e);
			e.printStackTrace();
			return -1;
		} finally{
			session.flush();
			session.close();
		}		
		return 1;
	}

	@Override
	public MirrorUsagePointModel getById(Long id) {
		Session session = sessionFactory.openSession();
		MirrorUsagePointModel mirrorUsagePointModel = null;
		try {
			Serializable getById = id;
			mirrorUsagePointModel = (MirrorUsagePointModel)session.get(MirrorUsagePointModel.class, getById);
		} catch(Exception e){
			log.error(e);
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return mirrorUsagePointModel;
	}

	@Override
	public int deleteById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = id;
			Object persistenceObject = session.load(MirrorUsagePointModel.class, sid);
			session.delete(persistenceObject);
		} catch(Exception e){
			log.error(e);
			return -1;
		} finally {
			session.flush();
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MirrorUsagePointModel> getAll() {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from MirrorUsagePointModel");			
			return query.list();
		} catch(Exception e){
			log.error(e);
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}

}
