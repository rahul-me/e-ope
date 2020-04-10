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
 
  
  
package com.gridscape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.EnergyDetailDao;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.EnergyDetails;

@Service
public class EnergyDetailService {
	
	@Autowired
	EnergyDetailDao edd;
	
	public EnergyDetails save(EnergyDetails obj){
		return edd.save(obj);
	}

	public EnergyDetails findByMicrogrid_Id(String microgrid_id) {
		return edd.findByMicrogrid_Id(microgrid_id);
	}

	public EnergyDetails findByMicrogrid_IdAndPort_cfg(String microgrid_id,
			String port_cfg) {
		return edd.findByMicrogrid_IdAndPort_cfg(microgrid_id,port_cfg);
	}

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfg(
			String microgrid_id, String port_cfg) {
		// TODO Auto-generated method stub
		return edd.findListByMicrogrid_IdAndPort_cfg(microgrid_id,port_cfg);
	}

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForweek(
			String microgrid_id, String port_cfg, String state) {
		// TODO Auto-generated method stub
		return edd.findListByMicrogrid_IdAndPort_cfgForweek(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgWithGroupByDate(
			String microgrid_id, String port_cfg, String state) {
		// TODO Auto-generated method stub
		return edd.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForMonth(
			String microgrid_id, String port_cfg, String state) {
		// TODO Auto-generated method stub
		return edd.findListByMicrogrid_IdAndPort_cfgForMonth(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> findListByMicrogrid_IdAndPort_cfgForCurrentDate(
			String microgrid_id, String port_cfg, String state,int limit) {
		// TODO Auto-generated method stub
		return edd.findListByMicrogrid_IdAndPort_cfgForCurrentDate(microgrid_id,port_cfg,state,limit);
	}

	public List<EnergyDetails> findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(
			String microgrid_id, String port_cfg, String state) {
		// TODO Auto-generated method stub
		return edd.findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> findBatteryListByMicrogrid_IdAndPort_cfgForCurrentDate(
			String microgrid_id, String port_cfg, String state) {
		return edd.findBatteryListByMicrogrid_IdAndPort_cfgForCurrentDate(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> getSumOfKwhForCurrentMonth(String microgrid_id,
			String port_cfg, String state) {
		return edd.getSumOfKwhForCurrentMonth(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> findEnergyDistributionData(String microgrid_id,
			String port_cfg, String state, int limit) {
		return edd.findEnergyDistributionData(microgrid_id,port_cfg,state,limit);
	}

	public List<EnergyDetails> findDailySolarData(String microgrid_id,
			String port_cfg, String state, int limit) {
		return edd.findDailySolarData(microgrid_id,port_cfg,state,limit);
	}

	public List<EnergyDetails> findListByMicrogridArr(Object obj[]) {
		return edd.findListByMicrogridArr(obj);
	}

	public List<EnergyDetails> findListByMicrogridArrAndPortCFGAndEventDate(
			String mgObj, String port_cfg, String event_date) {
		return edd.findListByMicrogridArrAndPortCFGAndEventDate(mgObj,port_cfg,event_date);
	}

	public List<EnergyDetails> getLast24CurrentVoltage(String microgrid_id,
			String port_cfg) {
		return edd.getLast24CurrentVoltage(microgrid_id,port_cfg);
	}
	
	public List<EnergyDetails> getLast24CurrentVoltageByHour(String microgrid_id,
			String port_cfg, int hourDiff) {
		return edd.getLast24CurrentVoltageByHour(microgrid_id,port_cfg, hourDiff);
	}

	public List<EnergyDetails> getLast30DaysSOH(String microgrid_id,
			String port_cfg) {
		
		return edd.getLast30DaysSOH(microgrid_id,port_cfg);
	}

	public List<EnergyDetails> getLast30DaysSOC(String microgrid_id,
			String port_cfg, String state) {
		// TODO Auto-generated method stub
		return edd.getLast30DaysSOC(microgrid_id,port_cfg,state);
	}

	public List<EnergyDetails> getSocByMonth(String microgrid_id,
			String port_cfg, int month) {
		return edd.getSocByMonth(microgrid_id,port_cfg,month);
	}

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Start_EndDate(
			String microgrid_id, String port_cfg,String state, String start_date,
			String end_date) {
		return edd.findByMicrogrid_Id_PortCfg_State_Start_EndDate(microgrid_id,port_cfg,state,start_date,end_date);
	}

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Month(
			String microgrid_id, String port_cfg, String state, int month_no, int year) {
		return edd.findByMicrogrid_Id_PortCfg_State_Month(microgrid_id,port_cfg,state,month_no, year);
	}

	public List<EnergyDetails> findByMicrogrid_Id_PortCfg_State_Year(
			String microgrid_id, String port_cfg, String state, int year_no) {
		return edd.findByMicrogrid_Id_PortCfg_State_Year(microgrid_id,port_cfg,state,year_no);
	}

	public List<EnergyDetails> find_last_microgrid_id_and_port_cfg(
			String microgrid_id, String port_cfg) {
		return edd.find_last_microgrid_id_and_port_cfg(microgrid_id,port_cfg);
	}

	public List<EnergyDetails> getSoHByMonth(String microgrid_id,
			String port_cfg, int month) {
		return edd.getSohByMonth(microgrid_id,port_cfg,month);
	}
	
	public List<EnergyDetails> getCurrentStatus(String microgrid_id, String port_cfg, String state) {
		return edd.getCurrentStatus(microgrid_id, port_cfg, state);
	}
	
	public String getTotalGenerationSpecificForMicroGridIdPortCfgAndState(String microgrid_id, String port_cfg,
			String state) {
		return edd.getTotalGenerationSpecificForMicroGridIdPortCfgAndState(microgrid_id, port_cfg, state);
	}
	
	public List<EnergyDetails> getCurrentState(String microgrid_id, String port_cfg){
		return edd.getCurrentState(microgrid_id, port_cfg);
	}
	
	public String getLastSOCOfBattry(String microgrid_id){
		return edd.getLastSOCOfMicro(microgrid_id);
	}
	
	public Object getREGenDataForPastThreeMonths(String mgc_id, String port_cfg){
		return edd.getREGenDataForPastThreeMonths(mgc_id, port_cfg);
	}
	
	public List<Object[]> getRequiredREGenerationData(String mgc_id, String port_cfg, String year, byte month){
		return edd.getRequiredREGenerationData(mgc_id, port_cfg, year, month);
	}
	
	public List<Object[]> getBetweenStartEndDateHaving(String start_date, String end_date, String mgc_id, String port_cfg){
		return edd.getBetweenStartEndDateHaving(start_date, end_date, mgc_id, port_cfg);
	}
	
	

}
