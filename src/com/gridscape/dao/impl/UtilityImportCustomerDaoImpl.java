package com.gridscape.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.UtilityImportCustomerDao;
import com.gridscape.model.IntervalData;
import com.gridscape.model.UtilityImportCustomer;

@Component
public class UtilityImportCustomerDaoImpl implements UtilityImportCustomerDao {

	private static Logger logger = Logger.getLogger(UtilityImportCustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UtilityImportCustomer save(UtilityImportCustomer entity) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(entity);
			session.flush();
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtilityImportCustomer> findAll() {
		// TODO Auto-generated method stub
		Session session = null;
		List<UtilityImportCustomer> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria ctr = session.createCriteria(UtilityImportCustomer.class, "customer");
			ctr.setProjection(Projections.projectionList().add(Projections.property("customer.id"))
					.add(Projections.property("customer.customerName")));
			list = ctr.list();
			System.out.println("size of list = " + list.size());
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void saveAllEntityInBatch(UtilityImportCustomer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			List<IntervalData> list = customer.getIntervalData();
			customer.setIntervalData(null);
			session.save(customer);
			session.flush();
			Long customerId = customer.getId();
			String sql = "INSERT INTO interval_data(time_stamp,usage_val,utility_import_customer_id) values";
			int index = 1;
			for (IntervalData interval : list) {
				sql += "('" + interval.getTimeStamp() + "'," + interval.getUsageVal() + "," + customerId + ")";
				sql += ",";
				if (index % 1000 == 0) {
					sql = sql.substring(0, sql.length() - 1);
					Query query = session.createSQLQuery(sql);
					query.executeUpdate();
					sql = "INSERT INTO interval_data(time_stamp,usage_val,utility_import_customer_id) values";
					index = 0;
				}
				index++;
			}
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UtilityImportCustomer findOneByMeterName(String meterName) {
		// TODO Auto-generated method stub
		Session session = null;
		List<UtilityImportCustomer> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria ctr = session.createCriteria(UtilityImportCustomer.class, "customer");
			ctr.add(Restrictions.eq("customer.meter", meterName));
			ctr.addOrder(Order.desc("id"));
			list = ctr.list();
			System.out.println("size of list = " + list.size());
			if (list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
