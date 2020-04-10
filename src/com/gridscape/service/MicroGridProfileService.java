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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.MicroGridDao;
import com.gridscape.dao.MicroGridProfileDao;
import com.gridscape.jsoninput.JsonMicrGridProfile;
import com.gridscape.model.MicroController;
import com.gridscape.model.MicroGridDefaultProfile;
import com.gridscape.model.MicroGridProfile;

@Service
public class MicroGridProfileService {

	@Autowired
	MicroGridProfileDao mgpDao;

	@Autowired
	MicroGridDao mgDao;

	public MicroGridProfile save(MicroGridProfile obj) {
		return mgpDao.save(obj);
	}

	public List<MicroGridProfile> findByMicrogrid__id_arr(Object[] mIds) {
		return mgpDao.findByMicrogrid__id_arr(mIds);
	}

	public List<MicroGridProfile> list() {
		return mgpDao.list();
	}

	public MicroGridProfile findById(Long id) {
		return mgpDao.findById(id);
	}

	public JsonMicrGridProfile findByIdWithJson(Long id) {
		JsonMicrGridProfile jmgp = null;
		MicroGridProfile mgp = mgpDao.findById(id);
		if (mgp != null) {
			jmgp = new JsonMicrGridProfile();
			jmgp.setId(mgp.getId());
			jmgp.setMicrogrid_id(mgp.getMicrogrid_id());
			MicroController mc = mgDao.findByMicrogrid_Id(mgp.getMicrogrid_id());
			if (mc != null) {
				jmgp.setMicrogrid_name(mc.getMicrogrid_name());
			}
			jmgp.setBattery_charge_source(mgp.getBattery_charge_source());
			jmgp.setBattery_low(mgp.getBattery_low());
			jmgp.setBattery_low_threshold(mgp.getBattery_low_threshold());
			jmgp.setSolar_low(mgp.getSolar_low());
			jmgp.setStandard_situation(mgp.getStandard_situation());
			jmgp.setStart_time(mgp.getStart_time());
			jmgp.setEnd_time(mgp.getEnd_time());
			jmgp.setCritical_situation(mgp.getCritical_situation());
			jmgp.setLng_end_time(mgp.getLng_end_time());
			jmgp.setLng_start_time(mgp.getLng_start_time());
			jmgp.setSolar_present(mgp.getSolar_present());
			jmgp.setSolar_gr_load(mgp.getSolar_gr_load());
			jmgp.setBattery_soc(mgp.getBattery_soc());

		}
		return jmgp;
	}

	public void delete_profile(Long id) {
		mgpDao.delete_profile(id);
	}

	public List<MicroGridProfile> find_list_between_start_emd_time(Long lng_start_date, Long lng_end_date) {
		return mgpDao.find_list_between_start_emd_time(lng_start_date, lng_end_date);
	}

	public List<MicroGridProfile> find_list_by_microgrid_id_and__between_start_emd_time(String microgrid_id,
			Long lng_start_date, Long lng_end_date) {
		return mgpDao.find_list_by_microgrid_id_and__between_start_emd_time(microgrid_id, lng_start_date, lng_end_date);
	}

	public List<MicroGridProfile> find_list_by_microgrid_id(String microgrid_id) {
		List<MicroGridProfile> list = mgpDao.find_list_by_microgrid_id(microgrid_id);
		List<MicroGridProfile> new_list = new ArrayList<MicroGridProfile>();
		for (MicroGridProfile obj : list) {
			if (obj.getBattery_low_threshold() == null || obj.getBattery_low() == null
					|| obj.getBattery_charge_source() == null || obj.getCritical_situation() == null
					|| obj.getStandard_situation() == null || obj.getSolar_low() == null) {
				MicroGridDefaultProfile mgdp = this.findStandardProfile(obj.getStart_time(), obj.getEnd_time());
				obj.setBattery_charge_source(mgdp.getBattery_charge_source());
				obj.setBattery_low(mgdp.getBattery_low());
				obj.setBattery_low_threshold(mgdp.getBattery_low_threshold());
				obj.setCritical_situation(mgdp.getCritical_situation());
				obj.setStandard_situation(mgdp.getStandard_situation());
				obj.setSolar_low(mgdp.getSolar_low());
				obj.setSolar_present(mgdp.getSolar_present());
				obj.setBattery_soc(mgdp.getBattery_soc());
				obj.setSolar_gr_load(mgdp.getSolar_gr_load());
			}
			new_list.add(obj);
		}
		return new_list;
	}

	public List<MicroGridProfile> get_profiles_by_microgrid_id(String microgrid_id) {
		List<MicroGridProfile> list = mgpDao.find_list_by_microgrid_id(microgrid_id);
		List<MicroGridProfile> new_list = new ArrayList<MicroGridProfile>();
		for (MicroGridProfile obj : list) {
			MicroGridDefaultProfile mgdp = this.findStandardProfile(obj.getStart_time(), obj.getEnd_time());
			if (obj.getBattery_low_threshold() == null) {
				obj.setBattery_low_threshold(mgdp.getBattery_low_threshold());
			}
			if (obj.getBattery_low() == null) {
				obj.setBattery_low(mgdp.getBattery_low());
			}
			if (obj.getBattery_charge_source() == null) {
				obj.setBattery_charge_source(mgdp.getBattery_charge_source());
			}
			if (obj.getCritical_situation() == null) {
				obj.setCritical_situation(mgdp.getCritical_situation());
			}
			if (obj.getStandard_situation() == null) {
				obj.setStandard_situation(mgdp.getStandard_situation());
			}
			if (obj.getSolar_low() == null) {
				obj.setSolar_low(mgdp.getSolar_low());
			}
			new_list.add(obj);
		}
		return new_list;
	}

	public void generate_profile(String microgrid_id, String time_slot) {
		mgpDao.delete_by_microgrid_id(microgrid_id);
		Integer timeSlot = Integer.parseInt(time_slot);
		String start_time = "";
		String end_time = "";
		MicroGridProfile mp = null;
		for (int i = 0; i < 24;) {
			mp = new MicroGridProfile();
			mp.setMicrogrid_id(microgrid_id);
			if (i == 0) {
				start_time = i + ":00:00";
			} else if (i < 10) {
				start_time = "0" + i + ":00:00";
			} else {
				start_time = i + ":00:00";
			}
			i = i + timeSlot;
			if (i < 10) {
				end_time = "0" + i + ":00:00";
			} else if (i == 24) {
				end_time = (i - 1) + ":59:59";
			} else {
				end_time = i + ":00:00";
			}

			mp.setStart_time(start_time);
			mp.setEnd_time(end_time);
			this.save(mp);
		}
	}

	public void generate_default_profile(String time_slot) {
		mgpDao.deleteAllMicroGridDefaultProfile();
		Integer timeSlot = Integer.parseInt(time_slot);
		String start_time = "";
		String end_time = "";
		MicroGridDefaultProfile mdp = null;

		for (int i = 0; i < 24;) {
			mdp = new MicroGridDefaultProfile();
			if (i == 0) {
				start_time = i + ":00:00";
			} else if (i < 10) {
				start_time = "0" + i + ":00:00";
			} else {
				start_time = i + ":00:00";
			}
			i = i + timeSlot;
			if (i < 10) {
				end_time = "0" + i + ":00:00";
			} else if (i == 24) {
				end_time = (i - 1) + ":59:59";
			} else {
				end_time = i + ":00:00";
			}
			mdp.setStart_time(start_time);
			mdp.setEnd_time(end_time);
			System.out.println("===\n" + mdp + "===\n");
			this.saveMicrogridDefaultProfile(mdp);
		}
	}

	public Map<String, Object> saveMicrogridDefaultProfile(MicroGridDefaultProfile obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj.getId() != null) {
			MicroGridDefaultProfile mgp = this.findDefaultProfileById(obj.getId());
			if (mgp != null) {
				mgp.setBattery_low_threshold(obj.getBattery_low_threshold());
				mgp.setBattery_charge_source(obj.getBattery_charge_source());
				mgp.setStandard_situation(obj.getStandard_situation());
				mgp.setCritical_situation(obj.getCritical_situation());
				mgp.setBattery_low(obj.getBattery_low());
				mgp.setSolar_low(obj.getSolar_low());
				mgp.setSolar_gr_load(obj.getSolar_gr_load());
				mgp.setBattery_soc(obj.getBattery_soc());
				mgp.setSolar_present(obj.getSolar_present());
				System.out.println(mgp);
				mgpDao.saveMicrogridDefaultProfile(mgp);
				map.put("data", mgp);
				map.put("status", true);
			} else {
				map.put("status", false);
			}
		} else {
			mgpDao.saveMicrogridDefaultProfile(obj);
			map.put("status", true);
		}
		return map;
	}

	public List<MicroGridDefaultProfile> listMicrogridDefaultProfile() {
		return mgpDao.listMicrogridDefaultProfile();
	}

	public JsonMicrGridProfile findDefaultProfileByIdWithJson(Long id) {
		JsonMicrGridProfile jmgp = null;
		MicroGridDefaultProfile mgp = mgpDao.findDefaultProfileById(id);
		if (mgp != null) {
			jmgp = new JsonMicrGridProfile();
			jmgp.setId(mgp.getId());
			jmgp.setBattery_charge_source(mgp.getBattery_charge_source());
			jmgp.setBattery_low(mgp.getBattery_low());
			jmgp.setBattery_low_threshold(mgp.getBattery_low_threshold());
			jmgp.setSolar_low(mgp.getSolar_low());
			jmgp.setStandard_situation(mgp.getStandard_situation());
			jmgp.setStart_time(mgp.getStart_time());
			jmgp.setEnd_time(mgp.getEnd_time());
			jmgp.setCritical_situation(mgp.getCritical_situation());
			jmgp.setLng_end_time(mgp.getLng_end_time());
			jmgp.setLng_start_time(mgp.getLng_start_time());
			jmgp.setBattery_soc(mgp.getBattery_soc());
			jmgp.setSolar_gr_load(mgp.getSolar_gr_load());
			jmgp.setSolar_present(mgp.getSolar_present());

		}
		return jmgp;
	}

	public MicroGridDefaultProfile findDefaultProfileById(Long id) {
		return mgpDao.findDefaultProfileById(id);
	}

	public MicroGridDefaultProfile findStandardProfile(String start_time, String end_time) {
		List<Object[]> list = mgpDao.findStandardProfile(start_time, end_time);
		MicroGridDefaultProfile mgdp = null;
		Object object[] = list.get(0);
		mgdp = new MicroGridDefaultProfile();
		mgdp.setId(Long.parseLong(object[0].toString()));
		if (object[4] != null)
			mgdp.setBattery_charge_source(object[4].toString());
		if (object[5] != null)
			mgdp.setBattery_low(object[5].toString());
		if (object[6] != null)
			mgdp.setBattery_low_threshold(object[6].toString());
		if (object[7] != null)
			mgdp.setCritical_situation(object[7].toString());
		if (object[11] != null)
			mgdp.setSolar_low(object[11].toString());
		if (object[12] != null)
			mgdp.setStandard_situation(object[12].toString());
		if(object[14] != null){
			mgdp.setBattery_soc((Integer)object[14]);
		}

		return mgdp;
	}

}
