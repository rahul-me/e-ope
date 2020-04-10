package com.gridscape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.IntervalDataDao;
import com.gridscape.model.IntervalData;

@Service
public class IntervalDataService {

	@Autowired
	private IntervalDataDao intervalDataDao;

	public List<IntervalData> findAll() {
		return intervalDataDao.findAll();
	}

	public List<IntervalData> findAllByCustomerId(Long id) {
		return intervalDataDao.findAllByCustomerId(id);
	}

	public List<IntervalData> findAllByCustomerIdAndYear(Long id, int year) {
		return intervalDataDao.findAllByCustomerIdAndYear(id, year);
	}

	public List<IntervalData> findAllByCustomerIdAndYearAndMonth(Long id, int year, int month) {
		return intervalDataDao.findAllByCustomerIdAndYearAndMonth(id, year, month);
	}

	public void saveEntityListInBatch(Long customerId, List<IntervalData> intervalData) {
		// TODO Auto-generated method stub
		intervalDataDao.saveEntityListInBatch(customerId, intervalData);
	}

	public List<IntervalData> findAllByCustomerIdAndYearAndGroupByMonth(Long customerId, int year) {
		// TODO Auto-generated method stub
		return intervalDataDao.findAllByCustomerIdAndYearAndGroupByMonth(customerId, year);
	}

	public List<IntervalData> findAllByCustomerIdAndYearAndMonthAndGroupByDate(Long customerId, int year, int month) {
		// TODO Auto-generated method stub
		return intervalDataDao.findAllByCustomerIdAndYearAndMonthAndGroupByDate(customerId, year, month);
	}

	public List<IntervalData> findAllByCustomerIdAndStartDateAndEndDateWithGroupByDate(Long customerId, String start_date,
			String end_date) {
		// TODO Auto-generated method stub
		return intervalDataDao.findAllByCustomerIdAndStartDateAndEndDateWithGroupByDate(customerId,start_date,end_date);
	}
}
