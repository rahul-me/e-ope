package com.gridscape.dao;

import java.util.Date;
import java.util.List;

import com.gridscape.model.SolarEnergyProductionDetail;

public interface SolarEnergyProductionDetailDao {
	public byte saveOrUpdate(SolarEnergyProductionDetail solarEnergyProductionDetail);
	
	public void save(List<SolarEnergyProductionDetail> list);
	
	public List<SolarEnergyProductionDetail> getBetween(Date startDate, Date endDate);
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAtrRespectively();
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id,String startDate, String endDate);
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id, byte month);
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id);
	
}

