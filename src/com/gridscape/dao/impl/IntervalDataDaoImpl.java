package com.gridscape.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.IntervalDataDao;
import com.gridscape.model.IntervalData;

@Component
public class IntervalDataDaoImpl implements IntervalDataDao {

	private static Logger logger = Logger.getLogger(IntervalDataDaoImpl.class);

	@Autowired
	private SessionFactory sessionFacotry;

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAll() {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			Criteria ctr = session.createCriteria(IntervalData.class);
			intervalDataList = ctr.list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerId(Long id) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			Criteria ctr = session.createCriteria(IntervalData.class);
			ctr.createAlias("utilityImportCustomer", "utility_customer");
			ctr.add(Restrictions.eq("utility_customer.utilityImportCustomer", id));
			intervalDataList = ctr.list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerIdAndYear(Long id, int year) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			String sql = "SELECT id,time_stamp,usage_val FROM interval_data ";
			sql += "WHERE YEAR(time_stamp)=" + year + " AND utility_import_customer_id=" + id;
			Query query = session.createSQLQuery(sql);
			intervalDataList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerIdAndYearAndMonth(Long id, int year, int month) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			Criteria ctr = session.createCriteria(IntervalData.class);
			ctr.createAlias("utilityImportCustomer", "utility_customer");
			ctr.add(Restrictions.eq("utility_customer.utilityImportCustomer", id));
			ctr.add(Restrictions.sqlRestriction("year(timeStamp) = ? ", year, IntegerType.INSTANCE));
			ctr.add(Restrictions.sqlRestriction("month(timeStamp) = ? ", month, IntegerType.INSTANCE));
			intervalDataList = ctr.list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@Override
	public void saveEntityListInBatch(Long customerId, List<IntervalData> intervalDataList) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFacotry.openSession();
			String sql = "INSERT INTO interval_data(time_stamp,usage_val,utility_import_customer_id) values";
			int index = 1;
			for (IntervalData interval : intervalDataList) {
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
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerIdAndYearAndGroupByMonth(Long customerId, int year) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			String sql = "SELECT id,time_stamp,SUM(usage_val) FROM interval_data ";
			sql += "WHERE YEAR(time_stamp)=" + year + " AND utility_import_customer_id=" + customerId;
			sql += " group by MONTH(time_stamp)";
			Query query = session.createSQLQuery(sql);
			intervalDataList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerIdAndYearAndMonthAndGroupByDate(Long id, int year, int month) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			String sql = "SELECT id,time_stamp,SUM(usage_val) FROM interval_data ";
			sql += "WHERE YEAR(time_stamp)=" + year;
			sql += " AND MONTH(time_stamp)=" + month;
			sql += " AND utility_import_customer_id=" + id;
			sql += " group by DATE(time_stamp)";
			Query query = session.createSQLQuery(sql);
			intervalDataList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntervalData> findAllByCustomerIdAndStartDateAndEndDateWithGroupByDate(Long customerId, String start_date,
			String end_date) {
		// TODO Auto-generated method stub
		Session session = null;
		List<IntervalData> intervalDataList = null;
		try {
			session = sessionFacotry.openSession();
			String sql = "SELECT id,time_stamp,SUM(usage_val) FROM interval_data ";
			sql += "WHERE DATE(time_stamp) >=" + start_date;
			sql += " AND DATE(time_stamp) <= " + end_date ;
			sql += " AND utility_import_customer_id=" + customerId;
			sql += " GROUP BY DATE(time_stamp)";
			Query query = session.createSQLQuery(sql);
			intervalDataList = query.list();			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			session.close();
		}
		return intervalDataList;
	}

}
