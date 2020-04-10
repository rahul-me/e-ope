/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
package com.gridscape.dao;

import java.util.Date;
import java.util.List;

import com.gridscape.model.SolarEstimateCustomer;
import com.gridscape.model.Utility;
import com.gridscape.model.UtilityBreakDown;
import com.gridscape.model.UtilityIntervalData;
import com.gridscape.model.UtilityProvider;
import com.gridscape.model.UtilityRate;

public interface UtilityDao {

	public List<Utility> getList();

	public Utility findById(long id);

	public Utility save(Utility obj);

	public void delete(Long id);

	public List<Utility> findListByUserId(Long id);

	public UtilityIntervalData saveUtilityIntervalData(List<UtilityIntervalData> uid);

	public List<UtilityIntervalData> getIntervalData();

	public List<Object[]> getIntervalDataUsingAccountNoAndStartDateAndEndDate(String energy_cost_on,String account_no,
			String start_date, String end_date);

	public List<Object[]> getIntervalDataUsingAccountNoAndMonthAndYear(String energy_cost_on,
			String account_no, int month_no, int year_no);

	public List<Object[]> getIntervalDataUsingAccountNoAndYear(String energy_cost_on,String account_no,int year_no);

	public List<UtilityProvider> getUtilityProvider();

	public List<UtilityIntervalData> getPlainIntervalDataUsingAccountNoAndStartDateAndEndDate(
			String account_no, Date start_date_obj, Date end_date_obj);

	public Utility findUtilityByAccountNo(String account_no);

	public List<UtilityBreakDown> findUtilityBreakDownUsingMonthNoAndUtilityProviderId(
			int start_month, String utility_provider_id);

	public List<UtilityBreakDown> findUtilityBreakDownUsingUtilityProviderId(
			String utility_provider_id);

	public List<UtilityBreakDown> listUtilityBreakDown();

	public List<UtilityRate> listUtilityRate();

	public UtilityProvider findUtilityProviderById(Long utility_provider_id);

	public UtilityBreakDown saveUtilityBreakDown(UtilityBreakDown obj);

	public UtilityBreakDown findBreakDownById(Long id);

	public void deleteBreakDown(Long id);

	public UtilityProvider saveUtilityProvider(UtilityProvider obj);

	public void deleteUtilityProviderById(Long id);

	public List<UtilityBreakDown> findBreakDownByUtilityProviderId(Long id);

	public UtilityRate saveUtilityRate(UtilityRate obj);

	public UtilityRate findUtilityRateById(Long id);

	public void deleteUtilityRate(Long id);

	public float findMinRate();

	public SolarEstimateCustomer saveSolarEstimateCustomer(
			SolarEstimateCustomer sec);

	public List<UtilityIntervalData> getIntervalDataList();

	public List<Object> getAccountNoListFromIntervalData();
	
	public boolean saveUtilityIntervalDataInBatch(List<UtilityIntervalData> list, int batchSize);
	
	public List<UtilityRate> getHaving(Long utilityBreakDownId);
	
}
