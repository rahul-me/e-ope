package com.gridscape.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.SolarGenerationChargeDao;
import com.gridscape.model.MicroController;
import com.gridscape.model.SolarGenerationCharge;

@Service
public class SolarGenerationChargeService {

	@Autowired
	private SolarGenerationChargeDao solarGenerationChargeDao;

	@Autowired
	private MicroGridService microGridService;

	public int saveOrUpdate(SolarGenerationCharge solarGenerationCharge) {
		return solarGenerationChargeDao.saveOrUpdate(solarGenerationCharge);
	}

	public SolarGenerationCharge getById(Long id) {
		return solarGenerationChargeDao.getById(id);
	}

	public SolarGenerationCharge getHavingMgcIdAndMonth(String mgc_id, Integer month_index, Integer year) {
		return solarGenerationChargeDao.getHavingMgcIdAndMonth(mgc_id, month_index, year);
	}

	public void generateSolarGenerationChargeUsing(String mgc_id, float rate, int month_index, int year) {
		
		BigDecimal bigDecimal = new BigDecimal(rate);
				
		SolarGenerationCharge solarGenerationCharge = new SolarGenerationCharge();
		solarGenerationCharge.setMgc_id(mgc_id);
		solarGenerationCharge.setMonth(month_index);
		solarGenerationCharge.setRate(bigDecimal.setScale(3,RoundingMode.HALF_UP).floatValue());
		//solarGenerationCharge.setRateUnit("$");
		solarGenerationCharge.setRate_unit_symb("$");
		solarGenerationCharge.setYear(year);
		saveOrUpdate(solarGenerationCharge);
	}

	public void saveSolarGenerationChargeUsing(long mgc_id, float rate, String type, boolean to_current) {
		MicroController microController = microGridService.findById(mgc_id);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if (type.equalsIgnoreCase("non-initialized")) {
			generateSolarGenerationChargeUsing(microController.getMicrogrid_id(), rate,
					Calendar.getInstance().get(Calendar.MONTH) + 1,year);
			microController.setSolar_generation_charge(rate);
			microController.setSolar_generation_charge_unit_symb("$");
			microGridService.save(microController);
		} else {
			int month_index = (to_current) ? Calendar.getInstance().get(Calendar.MONTH) + 1
					: Calendar.getInstance().get(Calendar.MONTH) + 2;

			SolarGenerationCharge solarGenerationCharge = getHavingMgcIdAndMonth(microController.getMicrogrid_id(),
					month_index, year);
			if (solarGenerationCharge != null) {
				if (solarGenerationCharge.getRate() != rate) {
					solarGenerationCharge.setRate(rate);
					saveOrUpdate(solarGenerationCharge);
				}
			} else {
				generateSolarGenerationChargeUsing(microController.getMicrogrid_id(), rate,
						Calendar.getInstance().get(Calendar.MONTH) + 2, year);
			}
			
			if(to_current){
				microController.setSolar_generation_charge(rate);
				microController.setSolar_generation_charge_unit_symb("$");
				microGridService.save(microController);
			}

		}		
	}
	
	public SolarGenerationCharge getHavingMgcIdAndMonthGenerateIfNotExists(String mgc_id, Integer month_index, Integer year) {
		 SolarGenerationCharge solarGenerationCharge = solarGenerationChargeDao.getHavingMgcIdAndMonth(mgc_id, month_index, year);
		 if(solarGenerationCharge == null){
			 MicroController microController = microGridService.findByMicrogrid_Id(mgc_id);
			 float rate = microController.getSolar_generation_charge();
			 float solarGenerationRatePerKwh = (rate > 0) ? rate : 0.00f;
			 generateSolarGenerationChargeUsing(mgc_id, solarGenerationRatePerKwh, month_index, year);
			 solarGenerationCharge = getHavingMgcIdAndMonth(mgc_id, month_index, year);
		 }
		 return solarGenerationCharge;
	}
	
	public SolarGenerationCharge getHavingMgcIdAndMonthGenerateIfNotExists(MicroController microController, Integer month_index, Integer year) {
		String mgc_id = microController.getMicrogrid_id();
		 SolarGenerationCharge solarGenerationCharge = solarGenerationChargeDao.getHavingMgcIdAndMonth(mgc_id, month_index, year);
		 if(solarGenerationCharge == null){			 
			 float rate = microController.getSolar_generation_charge();
			 float solarGenerationRatePerKwh = (rate > 0) ? rate : 0.00f;
			 generateSolarGenerationChargeUsing(mgc_id, solarGenerationRatePerKwh, month_index, year);
			 solarGenerationCharge = getHavingMgcIdAndMonth(mgc_id, month_index, year);
		 }
		 return solarGenerationCharge;
	}
}
