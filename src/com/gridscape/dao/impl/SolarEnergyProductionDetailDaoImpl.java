package com.gridscape.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.SolarEnergyProductionDetailDao;
import com.gridscape.model.SolarEnergyProductionDetail;

@Component
public class SolarEnergyProductionDetailDaoImpl implements SolarEnergyProductionDetailDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public byte saveOrUpdate(SolarEnergyProductionDetail solarEnergyProductionDetail){
		Session session = sessionFactory.openSession();
		try {
			session.saveOrUpdate(solarEnergyProductionDetail);			
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			session.flush();
			session.close();
		}
		return 1;
	}
	
	public void save(List<SolarEnergyProductionDetail> list){
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		try {
			for(int i = 0 ; i< list.size() ; i++){
				session.save(list.get(i));
				if((i % 100) == 0 ){
					session.flush();
					session.clear();
				}
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			transaction.commit();
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SolarEnergyProductionDetail> getBetween(Date startDate, Date endDate){
		List<SolarEnergyProductionDetail> list = null;
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SolarEnergyProductionDetail.class);
			criteria.add(Restrictions.ge("date", startDate));
			criteria.add(Restrictions.lt("date", endDate));
			criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("date").as("date")).add(Projections.property("ac_output").as("ac_output")));
			criteria.setResultTransformer(Transformers.aliasToBean(SolarEnergyProductionDetail.class));
			list = criteria.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAtrRespectively() {
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SolarEnergyProductionDetail.class);
			criteria.setProjection(Projections.projectionList().add(Projections.sqlGroupProjection("day(date_time) as date_time", "date_time", new String[] {"date_time"}, new Type[] {StandardBasicTypes.DATE})));
			criteria.setResultTransformer(Transformers.aliasToBean(SolarEnergyProductionDetail.class));
			criteria.list();
			return null;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.close();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id,String startDate, String endDate){
		List<SolarEnergyProductionDetail> list = new ArrayList<SolarEnergyProductionDetail>();
		Session session = sessionFactory.openSession();
		try {
			list = session.createSQLQuery("select date,sum(ac_output) as ac_output,start_time from micro_grid.solar_energy_production_detail where solar_energy_production_attr_id ="+detail_attr_id+" and date between '"+startDate+"' and '"+endDate+"' group by day(date)").list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id,byte month){
		List<SolarEnergyProductionDetail> list = new ArrayList<SolarEnergyProductionDetail>();
		Session session = sessionFactory.openSession();
		try {
			list = session.createSQLQuery("select date,sum(ac_output) as ac_output,start_time from micro_grid.solar_energy_production_detail where solar_energy_production_attr_id ="+detail_attr_id+" and month(date) = "+month+" group by day(date)").list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id){
		List<SolarEnergyProductionDetail> list = new ArrayList<SolarEnergyProductionDetail>();
		Session session = sessionFactory.openSession();
		try {
			list = session.createSQLQuery("select date,sum(ac_output) as ac_output,start_time from micro_grid.solar_energy_production_detail where solar_energy_production_attr_id ="+detail_attr_id+" group by month(date)").list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
}

