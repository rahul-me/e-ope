package com.gridscape.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.SolarEnergyProductionDao;
import com.gridscape.model.SolarEnergyProduction;

@Component
public class SolarEnergyProductionDaoImpl implements SolarEnergyProductionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public int saveOrUpdate(SolarEnergyProduction solarEnergyProduction){
		Session session = sessionFactory.openSession();
		try {			
			session.saveOrUpdate(solarEnergyProduction);
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally{
			session.flush();
			session.close();
		}		
		return 1;
	}
	
	public SolarEnergyProduction getById(Long id){
		Session session = sessionFactory.openSession();
		SolarEnergyProduction solarEnergyProduction = null;
		try {
			Serializable getById = id;
			solarEnergyProduction = (SolarEnergyProduction)session.get(SolarEnergyProduction.class, getById);
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return solarEnergyProduction;
	}
	
	public List<SolarEnergyProduction> getByLatLonSysCap(Float lat, Float lon, Float sys_cap){
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SolarEnergyProduction.class);
			criteria.add(Restrictions.eq("lattitude", lat));
			criteria.add(Restrictions.eq("longitude", lon));
			criteria.add(Restrictions.eq("system_capacity", sys_cap));
			@SuppressWarnings("unchecked")
			List<SolarEnergyProduction> list = criteria.list();
			return list;
		} catch(Exception e){
			e.printStackTrace();			
		} finally{
			session.flush();
			session.close();
		}
		return null;
	}
	
	public short deleteById(Long id){
		Session session = sessionFactory.openSession();
		try {
			Serializable deleteId = id;
			Object persistentObject = session.load(SolarEnergyProduction.class, deleteId);
			session.delete(persistentObject);
		} catch(Exception e){
			
		}
		return 0;
	}
	
	public SolarEnergyProduction getHaving(Float lat, Float lon, Float sys_cap, Float azimuth, Float tilt){
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SolarEnergyProduction.class);
			criteria.add(Restrictions.eq("lattitude", lat));
			criteria.add(Restrictions.eq("longitude", lon));
			criteria.add(Restrictions.eq("system_capacity", sys_cap));
			criteria.add(Restrictions.eq("azimuth", azimuth));
			criteria.add(Restrictions.eq("tilt", tilt));
			return (SolarEnergyProduction)criteria.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();			
		}
		return null;
	}
}

