package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.model.sep.CurveDataModal;
import com.gridscape.model.sep.DERControlModal;
import com.gridscape.model.sep.DERCurveModal;
import com.gridscape.sep.dao.CurveDataDao;
import com.gridscape.sep.org.zigbee.sep.CurveData;

@Service
public class CurveDataDaoImpl implements CurveDataDao {
	
	private static Logger log = Logger.getLogger(CurveDataDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(CurveDataModal curveDataModal) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(curveDataModal);
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
	public CurveDataModal getById(Long curveDataId) {
		Session session = sessionFactory.openSession();
		CurveDataModal curveDataModal = null;
		try {
			Serializable getById = curveDataId;
			curveDataModal = (CurveDataModal)session.get(CurveDataModal.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return curveDataModal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CurveDataModal> getByDerCurveId(Long derCurveId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from CurveDataModal where derCurveId= :derCurveId");
			query.setLong("derCurveId", derCurveId);
			return query.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();;
		}
	}
	
	@Transactional
	@Override
	public boolean deleteCurveData(Long id){
		Session session = sessionFactory.openSession();
		try {
			Serializable sid = id;
			Object persistenceObject = session.load(CurveDataModal.class, sid);
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

