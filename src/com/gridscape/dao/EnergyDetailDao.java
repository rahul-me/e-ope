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

import java.util.List;
import java.util.Map;

import com.gridscape.model.BatteryStatus;
import com.gridscape.model.EnergyDetails;

public interface EnergyDetailDao {

	public EnergyDetails save(EnergyDetails obj);

	public EnergyDetails findByMicrogrid_Id(String microgrid_id);

	public EnergyDetails findByMicrogrid_IdAndPort_cfg(String microgrid_id, String port_cfg);

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfg(String microgrid_id, String port_cfg);

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForweek(String microgrid_id, String port_cfg,
			String state);

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgWithGroupByDate(String microgrid_id, String port_cfg,
			String state);

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForMonth(String microgrid_id, String port_cfg,
			String state);

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForCurrentDate(String microgrid_id, String port_cfg,
			String state, int limit);

	public List<EnergyDetails> findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(String microgrid_id,
			String port_cfg, String state);

	public List<EnergyDetails> findBatteryListByMicrogrid_IdAndPort_cfgForCurrentDate(String microgrid_id,
			String port_cfg, String state);

	public List<EnergyDetails> getSumOfKwhForCurrentMonth(String microgrid_id, String port_cfg, String state);

	public List<EnergyDetails> findEnergyDistributionData(String microgrid_id, String port_cfg, String state,
			int limit);

	public List<EnergyDetails> findDailySolarData(String microgrid_id, String port_cfg, String state, int limit);

	public List<EnergyDetails> findListByMicrogridArr(Object[] obj);

	public List<EnergyDetails> findListByMicrogridArrAndPortCFGAndEventDate(String mgObj, String port_cfg,
			String event_date);

	public List<EnergyDetails> getLast24CurrentVoltage(String microgrid_id, String port_cfg);

	public List<EnergyDetails> getLast30DaysSOH(String microgrid_id, String port_cfg);

	public List<EnergyDetails> getLast30DaysSOC(String microgrid_id, String port_cfg, String state);

	public List<EnergyDetails> getSocByMonth(String microgrid_id, String port_cfg, int month);

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Start_EndDate(String microgrid_id, String port_cfg,
			String state, String start_date, String end_date);

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Month(String microgrid_id, String port_cfg,
			String state, int month_no, int year);

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Year(String microgrid_id, String port_cfg, String state,
			int year_no);

	public List<EnergyDetails> find_last_microgrid_id_and_port_cfg(String microgrid_id, String port_cfg);

	public List<EnergyDetails> getSohByMonth(String microgrid_id, String port_cfg, int month);

	public List<EnergyDetails> getLast24CurrentVoltageByHour(String microgrid_id, String port_cfg, int hourDiff);

	public List<EnergyDetails> getCurrentStatus(String microgrid_id, String port_cfg, String state);

	public String getTotalGenerationSpecificForMicroGridIdPortCfgAndState(String microgrid_id, String port_cfg, String state);

	public List<EnergyDetails> getCurrentState(String microgrid_id, String port_cfg);
	
	public String getLastSOCOfMicro(String microgrid_id);
	
	public Object getREGenDataForPastThreeMonths(String mgc_id, String port_cfg);
	
	public List<Object[]> getRequiredREGenerationData(String mgc_id, String port_cfg, String year, byte month);
	
	public List<Object[]> getBetweenStartEndDateHaving(String start_date, String end_date, String mgc_id, String port_cfg);

	

}
