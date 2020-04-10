package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERStatusModel;
import com.gridscape.model.sep.LogEventModel;
import com.gridscape.sep.dao.LogEventDao;

@Service
public class LogEventDaoImpl implements LogEventDao {
	
	private static Logger log = Logger.getLogger(LogEventDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(LogEventModel logEventModel) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(logEventModel);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<LogEventModel> getAll() {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from LogEventModel");			
			return query.list();
		} catch(Exception e){
			log.error(e);
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogEventModel> getByEndDeviceId(Long edevId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from LogEventModel where edev_id= :edevId");
			query.setLong("edevId", edevId);
			return query.list();
		} catch(Exception e){
			log.error(e);
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}

	@Override
	public int delete(Long leId) {
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = leId;
			Object persistenceObject = session.load(LogEventModel.class, sid);
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
	
	

	@Override
	public LogEventModel getById(Long leId) {
		Session session = sessionFactory.openSession();
		LogEventModel logEventModel = null;
		try {
			Serializable getById = leId;
			logEventModel = (LogEventModel)session.get(LogEventModel.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return logEventModel;
	}

	@Override
	public int delete(LogEventModel logEventModel) {
		Session session = sessionFactory.openSession();
		try {			
			session.delete(logEventModel);
		} catch(Exception e){
			log.error(e);
			return -1;
		} finally {
			session.flush();
			session.close();
		}
		return 0;
	}

}

