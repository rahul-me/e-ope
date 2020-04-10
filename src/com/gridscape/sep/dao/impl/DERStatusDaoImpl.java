package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERModel;
import com.gridscape.model.sep.DERStatusModel;
import com.gridscape.sep.dao.DERStatusDao;

@Service
public class DERStatusDaoImpl implements DERStatusDao {
	
	private static Logger log = Logger.getLogger(DERStatusDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(DERStatusModel derStatusModel) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(derStatusModel);
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
	public DERStatusModel getById(Long id) {
		Session session = sessionFactory.openSession();
		DERStatusModel derStatusModel = null;
		try {
			Serializable getById = id;
			derStatusModel = (DERStatusModel)session.get(DERStatusModel.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return derStatusModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DERStatusModel> getListByDERId(Long id) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERStatusModel where der_id= :der_id");
			query.setLong("der_id", id);
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
	public int deleteById(Long id) {
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = id;
			Object persistenceObject = session.load(DERStatusModel.class, sid);
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

}

