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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridscape.dao.UtilityDao;
import com.gridscape.helpers.CheckTime;
import com.gridscape.helpers.DateHelper;
import com.gridscape.helpers.GeneratedCheckTime;
import com.gridscape.helpers.NrelPVWatt;
import com.gridscape.helpers.ReadProperties;
import com.gridscape.helpers.Time;
import com.gridscape.helpers.UtilityHelper;
import com.gridscape.jsoninput.JsonUtilityRate;
import com.gridscape.model.SolarEnergyProduction;
import com.gridscape.model.SolarEnergyProductionDetail;
import com.gridscape.model.SolarEstimateCustomer;
import com.gridscape.model.Utility;
import com.gridscape.model.UtilityBreakDown;
import com.gridscape.model.UtilityIntervalData;
import com.gridscape.model.UtilityProvider;
import com.gridscape.model.UtilityRate;

@Service
public class UtilityService {

	@Autowired
	UtilityDao uDao;

	@Autowired
	private NrelPVWatt nrelPVWatt;

	@Autowired
	private SolarEnergyProductionService solarEnergyProductionService;

	@Autowired
	private SolarEnergyProductionDetailService solarEnergyProductionDetailService;
	

	public List<Utility> getList() {
		return uDao.getList();
	}

	public Utility findById(long id) {
		return uDao.findById(id);
	}

	public Utility save(Utility obj) {
		/*
		 * if(obj.getId()!=null && obj.getId().toString().length()>0){ Utility u
		 * = uDao.findById(obj.getId()); if(u!=null){ u.setName(obj.getName());
		 * u.setAccount_no(obj.getAccount_no()); u.setService(obj.getService());
		 * u.setEmergency_contact(obj.getEmergency_contact());
		 * u.setTariff_plan(obj.getTariff_plan());
		 * u.setUser_id(obj.getUser_id());
		 * u.setUtility_provider_id(obj.getUtility_provider_id()); return
		 * uDao.save(u); }else{ return null; } }else{ return uDao.save(obj); }
		 */
		return uDao.save(obj);
	}

	public void delete(Long id) {
		uDao.delete(id);
	}

	public List<Utility> findListByUserId(Long id) {
		return uDao.findListByUserId(id);
	}

	public UtilityIntervalData saveUtilityIntervalData(List<UtilityIntervalData> uId) {
		return uDao.saveUtilityIntervalData(uId);
	}

	public boolean saveUtilityIntervalDataInBatch(List<UtilityIntervalData> uId, int batchSize) {
		return uDao.saveUtilityIntervalDataInBatch(uId, batchSize);
	}

	public boolean saveUtilityIntervalDataInBatch(List<UtilityIntervalData> uId) {
		return uDao.saveUtilityIntervalDataInBatch(uId, 50);
	}

	public List<UtilityIntervalData> getIntervalData() {
		return uDao.getIntervalData();
	}

	public List<Object[]> getIntervalDataUsingAccountNoAndStartDateAndEndDate(String energy_cost_on, String account_no,
			String start_date, String end_date, float solar_avaliable_time, float solar_panel_size) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndStartDateAndEndDate(energy_cost_on, account_no,
				start_date, end_date);
		List<Object[]> data = intervalDataWithSolarCost(list, solar_panel_size, solar_avaliable_time);
		return data;
	}
	
	public List<Object[]> getIntervalDataUsingAccountNoAndStartDateAndEndDateApi(String energy_cost_on, String account_no,
			String start_date, String end_date) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndStartDateAndEndDate(energy_cost_on, account_no,
				start_date, end_date);
		return list;
	}

	public List<Object[]> getIntervalDataUsingAccountNoAndMonthAndYear(String energy_cost_on, String account_no,
			int month_no, int year_no, float solar_avaliable_time, float solar_panel_size) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndMonthAndYear(energy_cost_on, account_no, month_no,
				year_no);
		List<Object[]> data = intervalDataWithSolarCost(list, solar_panel_size, solar_avaliable_time);
		return data;
	}
	
	public List<Object[]> getIntervalDataUsingAccountNoAndMonthAndYearApi(String energy_cost_on, String account_no,
			int month_no, int year_no) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndMonthAndYear(energy_cost_on, account_no, month_no,
				year_no);
		return list;
	}

	public List<Object[]> getIntervalDataUsingAccountNoAndYear(String energy_cost_on, String account_no, int year_no,
			float solar_avaliable_time, float solar_panel_size) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndYear(energy_cost_on, account_no, year_no);
		List<Object[]> data = intervalDataWithSolarCost(list, solar_panel_size, solar_avaliable_time);
		return data;
	}
	
	public List<Object[]> getIntervalDataUsingAccountNoAndYearApi(String energy_cost_on, String account_no, int year_no) {
		List<Object[]> list = uDao.getIntervalDataUsingAccountNoAndYear(energy_cost_on, account_no, year_no);
		return list;
	}

	private List<Object[]> intervalDataWithSolarCost(List<Object[]> list, float solar_panel_size,
			float solar_avaliable_time) {
		ReadProperties reader = new ReadProperties();
		Map<String, Object> solarParameter = reader.read("solar.properties");
		float solar_cost = Float.parseFloat(solarParameter.get("solarcost").toString());
		float solar_panel_output = Float.parseFloat(solarParameter.get("solaroutput").toString());
		float total_solar_output = solar_panel_output * solar_panel_size * solar_avaliable_time * 30;
		float grid_price = this.findMinRate();
		System.out.println("grid price = " + grid_price);
		List<Object[]> data = new ArrayList<Object[]>();
		for (Object obj[] : list) {
			Object _with_solar_cost[] = new Object[obj.length + 1];
			_with_solar_cost[0] = obj[0];
			_with_solar_cost[1] = obj[1];
			_with_solar_cost[2] = obj[2];
			float usage = Float.parseFloat(obj[3].toString());
			_with_solar_cost[3] = obj[3];
			System.out.println("usage = " + usage);
			System.out.println("total_solar_output = " + total_solar_output);
			float grid = usage - (total_solar_output);
			if (grid < 0) {
				grid = 1;
			}
			System.out.println("Total Grid = " + grid);
			System.out.println("solar cost = " + solar_cost);
			_with_solar_cost[4] = (grid * grid_price) + (total_solar_output * solar_cost);
			System.out.println("total cost = " + _with_solar_cost[4]);
			data.add(_with_solar_cost);
		}
		return data;
	}

	@SuppressWarnings("unused")
	private List<Object[]> intervalDataWithSolarCostUsingNrelApi(List<Object[]> list, float solar_panel_size,
			float solar_avaliable_time) {
		List<Object[]> data = new ArrayList<Object[]>();
		try {

		} catch (Exception e) {

		}
		return data;
	}

	public List<UtilityProvider> getUtilityProvider() {
		return uDao.getUtilityProvider();
	}

	public void calculateBill(String start_date, String end_date, String account_no) {
		Date start_date_obj = DateHelper.convertStringToDate(start_date, "yyyy-MM-dd");
		Date end_date_obj = DateHelper.convertStringToDate(end_date, "yyyy-MM-dd");
		List<UtilityIntervalData> list = uDao.getPlainIntervalDataUsingAccountNoAndStartDateAndEndDate(account_no,
				start_date_obj, end_date_obj);
		Calendar cal = Calendar.getInstance();
		List<UtilityBreakDown> ubdList = uDao.listUtilityBreakDown();
		List<UtilityRate> urList = uDao.listUtilityRate();
		List<UtilityIntervalData> utility_interval_list = new ArrayList<UtilityIntervalData>();
		for (UtilityIntervalData uidObj : list) {
			cal.setTime(uidObj.getDate());
			Integer interval_month = cal.get(Calendar.MONTH) + 1;
			Long ubd_id = 0L;
			String season = "";
			for (UtilityBreakDown ubdObj : ubdList) {
				cal.setTime(ubdObj.getStart_date());
				int ubd_start_month = cal.get(Calendar.MONTH) + 1;
				cal.setTime(ubdObj.getEnd_date());
				int ubd_end_month = cal.get(Calendar.MONTH) + 1;
				// System.out.println("interval_month = "+interval_month+"
				// ubd_start_month = "+ubd_start_month+" ubd_end_month =
				// "+ubd_end_month);
				List<Integer> month_list = UtilityHelper.getMonthArray(ubd_start_month, ubd_end_month);
				/*
				 * System.out.println("month list"); for(Integer i :
				 * month_list){ System.out.print(i+" , "); }
				 */
				if (month_list.contains(interval_month)) {
					ubd_id = ubdObj.getId();
					season = ubdObj.getSeason();
					// System.out.println("ubd_id = "+ubd_id+" season =
					// "+season);
					break;
				}
			}
			for (UtilityRate urObj : urList) {
				if (urObj.getUtility_break_down_id() == ubd_id) {
					Integer int_start_time = Integer.parseInt(uidObj.getStart_time().replace(":", ""));
					// Integer int_end_time =
					// Integer.parseInt(uidObj.getEnd_time().replace(":",""));
					Integer ur_start_time = Integer.parseInt(urObj.getStartTime().replace(":", ""));
					Integer ur_end_time = Integer.parseInt(urObj.getEnd_time().replace(":", ""));
					List<Integer> time_list = UtilityHelper.getTimeArr(ur_start_time, ur_end_time);
					/*
					 * System.out.println("int_start_time = "+int_start_time+
					 * " ur_start_time = "+ur_start_time +
					 * " ur_end_time = "+ur_end_time);
					 * System.out.println("time list"); for(Integer
					 * i:time_list){ System.out.print(i+" , "); }
					 */
					if (time_list.contains(int_start_time)) {
						Float usage = Float.parseFloat(uidObj.getUsage());
						Float rate = urObj.getRate();
						uidObj.setCal_price(usage * rate);
						uidObj.setGeneration(urObj.getGeneration() + " " + season);
						utility_interval_list.add(uidObj);
					}
				}
			}
		}
		uDao.saveUtilityIntervalData(utility_interval_list);
	}

	public List<com.gridscape.jsoninput.UtilityBreakDown> listUtilityBreakDown() {
		List<com.gridscape.jsoninput.UtilityBreakDown> list = new ArrayList<com.gridscape.jsoninput.UtilityBreakDown>();
		List<UtilityBreakDown> data_list = uDao.listUtilityBreakDown();
		com.gridscape.jsoninput.UtilityBreakDown new_utility_break_down = null;
		for (UtilityBreakDown obj : data_list) {
			new_utility_break_down = new com.gridscape.jsoninput.UtilityBreakDown();
			new_utility_break_down.setId(obj.getId());
			new_utility_break_down.setStart_date(obj.getStart_date());
			new_utility_break_down.setEnd_date(obj.getEnd_date());
			new_utility_break_down.setSeason(obj.getSeason());
			UtilityProvider up = uDao.findUtilityProviderById(obj.getUtility_provider_id());
			if (up != null) {
				new_utility_break_down.setUtility_provider_name(up.getUtilityName());
			}
			list.add(new_utility_break_down);
		}
		return list;
	}

	public List<JsonUtilityRate> listUtilityRate() {
		List<UtilityRate> list = uDao.listUtilityRate();
		List<JsonUtilityRate> jurList = new ArrayList<JsonUtilityRate>();
		JsonUtilityRate jur = null;
		for (UtilityRate obj : list) {
			jur = new JsonUtilityRate();
			jur.setId(obj.getId());
			jur.setGeneration(obj.getGeneration());
			jur.setStartTime(obj.getStartTime());
			jur.setEnd_time(obj.getEnd_time());
			jur.setRate(obj.getRate());
			jur.setUtility_break_down_id(obj.getUtility_break_down_id());
			UtilityBreakDown ubd = uDao.findBreakDownById(obj.getUtility_break_down_id());
			if (ubd != null) {
				jur.setUtility_break_down_season(ubd.getSeason());
				UtilityProvider up = uDao.findUtilityProviderById(ubd.getUtility_provider_id());
				if (up != null) {
					jur.setUtility_provider(up.getUtilityName());
				}
			}
			jurList.add(jur);
		}
		return jurList;
	}

	public UtilityBreakDown saveUtilityBreakDown(UtilityBreakDown obj) {
		return uDao.saveUtilityBreakDown(obj);
	}

	public UtilityBreakDown findBreakDownById(Long id) {
		return uDao.findBreakDownById(id);
	}

	public void deleteBreakDown(Long id) {
		uDao.deleteBreakDown(id);
	}

	public List<UtilityProvider> listProvider() {
		return uDao.getUtilityProvider();
	}

	public UtilityProvider saveUtilityProvider(UtilityProvider obj) {
		return uDao.saveUtilityProvider(obj);
	}

	public UtilityProvider findUtilityProviderById(Long id) {
		return uDao.findUtilityProviderById(id);
	}

	public void deleteUtilityProviderById(Long id) {
		uDao.deleteUtilityProviderById(id);
	}

	public List<UtilityBreakDown> findBreakDownByUtilityProviderId(Long id) {
		return uDao.findBreakDownByUtilityProviderId(id);
	}

	public UtilityRate saveUtilityRate(UtilityRate obj) {
		return uDao.saveUtilityRate(obj);
	}

	public JsonUtilityRate findUtilityRateById_with_json(Long id) {
		UtilityRate obj = uDao.findUtilityRateById(id);
		JsonUtilityRate jur = new JsonUtilityRate();
		jur = new JsonUtilityRate();
		jur.setId(obj.getId());
		jur.setGeneration(obj.getGeneration());
		jur.setStartTime(obj.getStartTime());
		jur.setEnd_time(obj.getEnd_time());
		jur.setRate(obj.getRate());
		jur.setUtility_break_down_id(obj.getUtility_break_down_id());
		UtilityBreakDown ubd = uDao.findBreakDownById(obj.getUtility_break_down_id());
		if (ubd != null) {
			jur.setUtility_break_down_season(ubd.getSeason());
			UtilityProvider up = uDao.findUtilityProviderById(ubd.getUtility_provider_id());
			if (up != null) {
				jur.setUtility_provider_id(up.getId());
				jur.setUtility_provider(up.getUtilityName());
			}
		}
		return jur;
	}

	public void deleteUtilityRate(Long id) {
		uDao.deleteUtilityRate(id);
	}

	public UtilityRate findUtilityRateById(Long id) {
		return uDao.findUtilityRateById(id);
	}

	public List<com.gridscape.jsoninput.UtilityBreakDown> findBreakDownListByUtilityProviderId(Long id) {
		List<com.gridscape.jsoninput.UtilityBreakDown> list = new ArrayList<com.gridscape.jsoninput.UtilityBreakDown>();
		List<UtilityBreakDown> data_list = uDao.findBreakDownByUtilityProviderId(id);
		com.gridscape.jsoninput.UtilityBreakDown new_utility_break_down = null;
		for (UtilityBreakDown obj : data_list) {
			new_utility_break_down = new com.gridscape.jsoninput.UtilityBreakDown();
			new_utility_break_down.setId(obj.getId());
			new_utility_break_down.setStart_date(obj.getStart_date());
			new_utility_break_down.setEnd_date(obj.getEnd_date());
			new_utility_break_down.setSeason(obj.getSeason());
			UtilityProvider up = uDao.findUtilityProviderById(obj.getUtility_provider_id());
			if (up != null) {
				new_utility_break_down.setUtility_provider_name(up.getUtilityName());
			}
			list.add(new_utility_break_down);
		}
		return list;
	}

	public com.gridscape.jsoninput.UtilityBreakDown findBreakDownByIdWithJson(Long id) {
		UtilityBreakDown obj = uDao.findBreakDownById(id);
		com.gridscape.jsoninput.UtilityBreakDown new_utility_break_down = null;
		new_utility_break_down = new com.gridscape.jsoninput.UtilityBreakDown();
		new_utility_break_down.setId(obj.getId());
		new_utility_break_down.setStart_date(obj.getStart_date());
		new_utility_break_down.setEnd_date(obj.getEnd_date());
		new_utility_break_down.setSeason(obj.getSeason());
		UtilityProvider up = uDao.findUtilityProviderById(obj.getUtility_provider_id());
		if (up != null) {
			new_utility_break_down.setUtility_provider_name(up.getUtilityName());
		}
		return new_utility_break_down;
	}

	public float findMinRate() {
		return uDao.findMinRate();
	}

	public SolarEstimateCustomer saveSolarEstimateCustomer(SolarEstimateCustomer sec) {
		return uDao.saveSolarEstimateCustomer(sec);
	}

	public List<UtilityIntervalData> getIntervalDataList() {
		return uDao.getIntervalDataList();
	}

	public List<Object> getAccountNoListFromIntervalData() {
		return uDao.getAccountNoListFromIntervalData();
	}

	public boolean fetchSolarEnergyProductionForGivenAttributesUsingNRELApi(Float lat, Float lon, Float sys_cap, Float azimuth,
			Float tilt) {
		
		SolarEnergyProduction solarEnergyProduction = solarEnergyProductionService.getHaving(lat, lon, sys_cap, azimuth, tilt);
		if(solarEnergyProduction != null){
			return true;
		}
		
		String response = nrelPVWatt.getSolarResourceData(lat, lon, sys_cap, azimuth, tilt);

		List<SolarEnergyProductionDetail> list = generateSolarProductionDetailListFromResponse(response, lat, lon,
				sys_cap, azimuth, tilt);
		if (list != null && list.size() > 0) {
			solarEnergyProductionDetailService.save(list);
			return true;
		} else {
			return false;
		}
	}

	private List<SolarEnergyProductionDetail> generateSolarProductionDetailListFromResponse(String response, Float lat,
			Float lon, Float sys_cap, Float azimuth, Float tilt) {
		
		
		getUtilityRateVariations();
		
		List<SolarEnergyProductionDetail> list = new ArrayList<SolarEnergyProductionDetail>();

		Calendar calendar = com.gridscape.helpers.Utility.getFirstDayOfNonLeapYear();		
		System.out.println(calendar.getTime().toString());
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = null;
		try {
			jsonNode = mapper.readTree(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String errors = null;
		JsonNode jsonNodeError = jsonNode.get("errors");
		if (jsonNodeError.size() > 0) {
			for (JsonNode jsonNodeVal : jsonNodeError) {
				errors += jsonNodeVal.asText();
			}
			return null;
		}

		SolarEnergyProduction solarEnergyProduction = solarEnergyProductionService.saveSolarProduction(lat, lon,
				sys_cap, azimuth, tilt);

		JsonNode jsonNodeOutPut = jsonNode.get("outputs");
		JsonNode jsonNodeAcOutput = jsonNodeOutPut.get("ac");
		JsonNode jsonNodeDcOutput = jsonNodeOutPut.get("dc");

		if (jsonNodeAcOutput.isArray() && jsonNodeDcOutput.isArray()) {
			SolarEnergyProductionDetail solarEnergyProductionDetail = null;
			for (int i = 0; i < jsonNodeAcOutput.size(); i++) {
				float ac_output = Float.parseFloat(jsonNodeAcOutput.get(i).asText());
				float dc_output = Float.parseFloat(jsonNodeDcOutput.get(i).asText());

				solarEnergyProductionDetail = new SolarEnergyProductionDetail();
				solarEnergyProductionDetail.setAc_output(ac_output);
				solarEnergyProductionDetail.setAc_output_unit("W");
				solarEnergyProductionDetail.setDc_output(dc_output);
				solarEnergyProductionDetail.setDate(calendar.getTime());
				solarEnergyProductionDetail.setStart_time(calendar.getTime());
				solarEnergyProductionDetail.setDate_time(calendar.getTime());
				solarEnergyProductionDetail.setSolarEnergyProduction(solarEnergyProduction);
				
				list.add(solarEnergyProductionDetail);
				calendar.add(Calendar.HOUR_OF_DAY, 1);
			}
		}
		return list;
	}
	
	public List<CheckTime> getUtilityRateVariations(){
		List<UtilityBreakDown> utilityBreakDowns = uDao.listUtilityBreakDown();
		List<CheckTime> checkTimes = new ArrayList<CheckTime>();
		for(UtilityBreakDown utilityBreakDown : utilityBreakDowns){
			List<CheckTime> checkTimes2 = new ArrayList<CheckTime>();
			List<UtilityRate> utilityRates = uDao.getHaving(utilityBreakDown.getId());
			for(UtilityRate utilityRate : utilityRates){
				String[] timeSplit = utilityRate.getStartTime().split(":");
				CheckTime checkTime = new CheckTime();
				Time time = new Time();
				time.setHour(Integer.parseInt(timeSplit[0]));
				time.setMinute(Integer.parseInt(timeSplit[1]));
				checkTime.setStartTime(time);
				time = new Time();
				timeSplit = utilityRate.getEnd_time().split(":");
				time.setHour(Integer.parseInt(timeSplit[0]));
				time.setMinute(Integer.parseInt(timeSplit[1]));
				checkTime.setEndTime(time);
				checkTime.setGeneration(utilityRate.getGeneration());
				checkTime.setRate(utilityRate.getRate());
				checkTimes2.add(checkTime);
			}
			generateSpecializedCheckTimeIfRequired(checkTimes2);
		}
		
		return null;
	}
	
	public void generateSpecializedCheckTimeIfRequired(List<CheckTime> checkTimes){
		List<CheckTime> checkTimesWithGenerated = new ArrayList<CheckTime>();
		for(CheckTime checkTime : checkTimes){
			checkTimesWithGenerated.add(checkTime);
			if(checkTime.getStartTime().getMinute() > 0){
				for(CheckTime checkTime2 : checkTimes){
					Time startTime = checkTime.getStartTime();
					Time endTime = checkTime2.getEndTime();
					if(startTime.getHour() == endTime.getHour() && startTime.getMinute() == endTime.getMinute()){
						CheckTime specializedCheckType = createSpecializedCheckTime(checkTime, checkTime2);
						checkTimesWithGenerated.add(specializedCheckType);
						break;
					}
				}
			}
		}
		
		System.out.println(checkTimesWithGenerated.size());
	}
	
	public CheckTime createSpecializedCheckTime(CheckTime startTime, CheckTime endTime){
		CheckTime generatedCheckTime = new GeneratedCheckTime();
		generatedCheckTime.setStartTime(new Time());
		
		generatedCheckTime.getStartTime().setHour(endTime.getEndTime().getHour());
		generatedCheckTime.getStartTime().setMinute(0);
		
		endTime.getEndTime().setMinute(0);
		
		generatedCheckTime.setEndTime(new Time());
		
		startTime.getStartTime().setHour(startTime.getStartTime().getHour()+1);
		startTime.getStartTime().setMinute(0);
		
		generatedCheckTime.getEndTime().setHour(startTime.getStartTime().getHour());
		generatedCheckTime.getEndTime().setMinute(0);
		
		Map<String, Float> generationType = new HashMap<String, Float>();
		generationType.put(startTime.getGeneration(), startTime.getRate());
		generationType.put(endTime.getGeneration(), endTime.getRate());
		
		generatedCheckTime.setGenerationRate(generationType);
		
		return generatedCheckTime;
	}
}
