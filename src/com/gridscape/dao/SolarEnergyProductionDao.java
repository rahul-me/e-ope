package com.gridscape.dao;

import java.util.List;

import com.gridscape.model.SolarEnergyProduction;

public interface SolarEnergyProductionDao {
	
	public int saveOrUpdate(SolarEnergyProduction solarEnergyProduction);
	
	public SolarEnergyProduction getById(Long id);
	
	public List<SolarEnergyProduction> getByLatLonSysCap(Float lat, Float lon, Float sys_cap);
	
	public short deleteById(Long id);
	
	public SolarEnergyProduction getHaving(Float lat, Float lon, Float sys_cap, Float azimuth, Float tilt);
}

