package com.gridscape.dao;


import com.gridscape.model.SolarGenerationCharge;

public interface SolarGenerationChargeDao {
	
	public int saveOrUpdate(SolarGenerationCharge solarGenerationCharge);
	
	public SolarGenerationCharge getById(Long id);
	
	public SolarGenerationCharge getHavingMgcIdAndMonth(String mgc_id, Integer month_index, Integer year);
}

