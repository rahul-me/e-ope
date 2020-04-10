package com.gridscape.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.SolarEnergyProductionDetailDao;
import com.gridscape.model.SolarEnergyProductionDetail;

@Service
public class SolarEnergyProductionDetailService {
	
	@Autowired
	private SolarEnergyProductionDetailDao solarEnergyProductionDetailDao;
	
	public byte saveOrUpdate(SolarEnergyProductionDetail solarEnergyProductionDetail){
		return solarEnergyProductionDetailDao.saveOrUpdate(solarEnergyProductionDetail);
	}
	
	public void save(List<SolarEnergyProductionDetail> list){
		solarEnergyProductionDetailDao.save(list);
	}
	
	public List<SolarEnergyProductionDetail> getBetween(Date startDate, Date endDate){
		return solarEnergyProductionDetailDao.getBetween(startDate, endDate);
	}
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAtrRespectively(){
		return solarEnergyProductionDetailDao.getBetweenAndHavingAtrRespectively();
	}
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id,String startDate, String endDate){
		return solarEnergyProductionDetailDao.getBetweenAndHavingAttrRespectively(detail_attr_id, startDate, endDate);
	}
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id, byte month){
		return solarEnergyProductionDetailDao.getBetweenAndHavingAttrRespectively(detail_attr_id, month);
	}
	
	public List<SolarEnergyProductionDetail> getBetweenAndHavingAttrRespectively(Long detail_attr_id){
		return solarEnergyProductionDetailDao.getBetweenAndHavingAttrRespectively(detail_attr_id);
	}
}

