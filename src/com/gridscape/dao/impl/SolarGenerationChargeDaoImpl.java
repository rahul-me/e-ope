package com.gridscape.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.SolarGenerationChargeDao;
import com.gridscape.model.SolarEnergyProduction;
import com.gridscape.model.SolarGenerationCharge;

@Component
public class SolarGenerationChargeDaoImpl implements SolarGenerationChargeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int saveOrUpdate(SolarGenerationCharge solarGenerationCharge){
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(solarGenerationCharge);
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally{
			session.flush();
			session.close();
		}		
		return 1;
	}
	
	public SolarGenerationCharge getById(Long id){
		Session session = sessionFactory.openSession();
		SolarGenerationCharge solarGenerationCharge = null;
		try {
			Serializable getById = id;
			solarGenerationCharge = (SolarGenerationCharge)session.get(SolarGenerationCharge.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return solarGenerationCharge;
	}
	
	public SolarGenerationCharge getHavingMgcIdAndMonth(String mgc_id, Integer month_index, Integer year){
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SolarGenerationCharge.class);
			criteria.add(Restrictions.eq("mgc_id", mgc_id));
			criteria.add(Restrictions.eq("month_index", month_index));
			criteria.add(Restrictions.eq("year", year));
			SolarGenerationCharge solarGenerationCharge = (SolarGenerationCharge)criteria.uniqueResult();
			return solarGenerationCharge;
		} catch(Exception e){
			e.printStackTrace();			
		} finally{
			session.flush();
			session.close();
		}
		return null;
	}

}

