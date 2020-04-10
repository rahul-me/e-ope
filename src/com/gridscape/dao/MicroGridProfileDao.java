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

import com.gridscape.model.MicroGridDefaultProfile;
import com.gridscape.model.MicroGridProfile;

public interface MicroGridProfileDao {
	public MicroGridProfile save(MicroGridProfile obj);
	public List<MicroGridProfile> list();
	public List<MicroGridProfile> findByMicrogrid__id_arr(Object[] mIds);
	public MicroGridProfile findById(Long id);
	public void delete_profile(Long id);
	public List<MicroGridProfile> find_list_between_start_emd_time(
			Long lng_start_date, Long lng_end_date);
	public List<MicroGridProfile> find_list_by_microgrid_id_and__between_start_emd_time(
			String microgrid_id, Long lng_start_date, Long lng_end_date);
	public List<MicroGridProfile> find_list_by_microgrid_id(String microgrid_id);
	public void delete_by_microgrid_id(String microgrid_id);
	public MicroGridDefaultProfile saveMicrogridDefaultProfile(
			MicroGridDefaultProfile mdp);
	public void deleteAllMicroGridDefaultProfile();
	public List<MicroGridDefaultProfile> listMicrogridDefaultProfile();
	public MicroGridDefaultProfile findDefaultProfileById(Long id);
	public List<Object[]> findStandardProfile(String start_time,
			String end_time);		
}
