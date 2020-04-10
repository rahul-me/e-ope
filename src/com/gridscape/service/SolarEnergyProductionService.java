package com.gridscape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.SolarEnergyProductionDao;
import com.gridscape.model.SolarEnergyProduction;

@Service
public class SolarEnergyProductionService {
	
	@Autowired
	private SolarEnergyProductionDao solarEnergyProductionDao;
	
	public int saveOrUpdate(SolarEnergyProduction solarEnergyProduction){
		return solarEnergyProductionDao.saveOrUpdate(solarEnergyProduction);
	}
	
	public SolarEnergyProduction saveSolarProduction(Float lat, Float lon, Float sys_cap, Float azimuth, Float tilt){
		SolarEnergyProduction solarEnergyProduction = new SolarEnergyProduction();
		solarEnergyProduction.setLattitude(lat);
		solarEnergyProduction.setLongitude(lon);
		solarEnergyProduction.setArray_type((byte)1);
		solarEnergyProduction.setModule_type((byte)0);
		solarEnergyProduction.setAzimuth(azimuth);
		solarEnergyProduction.setTilt(tilt);
		solarEnergyProduction.setSystem_capacity(sys_cap);		
		saveOrUpdate(solarEnergyProduction);
		return solarEnergyProduction;
	}
	
	public SolarEnergyProduction getById(Long id){
		return solarEnergyProductionDao.getById(id);
	}
	
	public List<SolarEnergyProduction> getByLatLonSysCap(Float lat, Float lon, Float sys_cap){
		return solarEnergyProductionDao.getByLatLonSysCap(lat, lon, sys_cap);
	}
	
	public short deleteById(Long id){
		return solarEnergyProductionDao.deleteById(id);
	}
	
	public SolarEnergyProduction getHaving(Float lat, Float lon, Float sys_cap, Float azimuth, Float tilt){
		return solarEnergyProductionDao.getHaving(lat, lon, sys_cap, azimuth, tilt);
	}
}

