package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERCurveModal;
import com.gridscape.sep.dao.DERCurveDao;

@Service
public class DERCurveDaoImpl implements DERCurveDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveOrUpdate(DERCurveModal derCurveModal) {
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(derCurveModal);
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
	public DERCurveModal getById(Long dercId) {
		Session session = sessionFactory.openSession();
		DERCurveModal derCurveModal = null;
		try {
			Serializable getById = dercId;
			derCurveModal = (DERCurveModal)session.get(DERCurveModal.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return derCurveModal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DERCurveModal> getByDerpId(Long derpId) {
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERCurveModal where derpId= :derpId");
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

}

