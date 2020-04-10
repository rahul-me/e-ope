package com.gridscape.dao;

import java.util.List;

import com.gridscape.model.IntervalData;

public interface IntervalDataDao {
	public List<IntervalData> findAll();

	public List<IntervalData> findAllByCustomerId(Long id);

	public List<IntervalData> findAllByCustomerIdAndYear(Long id, int year);
	
	public List<IntervalData> findAllByCustomerIdAndYearAndMonth(Long id, int year,int month);

	public void saveEntityListInBatch(Long customerId, List<IntervalData> intervalData);

	public List<IntervalData> findAllByCustomerIdAndYearAndGroupByMonth(Long customerId, int year);
	
	public List<IntervalData> findAllByCustomerIdAndYearAndMonthAndGroupByDate(Long id, int year,int month);

	public List<IntervalData> findAllByCustomerIdAndStartDateAndEndDateWithGroupByDate(Long customerId, String start_date,
			String end_date);

}
