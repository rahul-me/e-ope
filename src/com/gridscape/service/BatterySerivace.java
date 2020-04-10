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

import com.gridscape.dao.BatteryDao;
import com.gridscape.dao.MicroGridDao;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.MicroController;

@Service
public class BatterySerivace {
	
	@Autowired
	BatteryDao bDao;
	
	@Autowired
	MicroGridDao mgDao;
	
	public BatteryStatus save(BatteryStatus obj){
		return bDao.save(obj);
	}

	public BatteryStatus findByMicrogridId(String id) {
		return bDao.findByMicrogridId(id);
	}

	public BatteryStatus findById(Long id) {	
		return bDao.findById(id);
	}

	public List<BatteryStatus> findListByMicrogrid_id_arr(Object[] mIds) {
		
		return bDao.findListByMicrogrid_id_arr(mIds);
	}

	public void deleteBattery(Long id) {
		bDao.deleteBattery(id);
	}

	public List<BatteryStatus> getLast30DaysSOC(String microgrid_id,
			String port_cfg, String state) {
		return bDao.getLast30DaysSOC(microgrid_id,port_cfg,state);
	}

	public BatteryStatus getLatestCurrentVoltage(String microgrid_id) {		
		return bDao.getLatestCurrentVoltage(microgrid_id);
	}

	public List<BatteryStatus> findBatteryByMicroGridActive(boolean b) {
		List<MicroController> list = mgDao.findAllByMicroGridActiveStatus(b);
		List<BatteryStatus> bsList = null;
		if(list!=null && list.size()>0){
			Object mIds[] = new Object[list.size()];
			int index = 0;
			for(MicroController mobj:list){
				mIds[index] = mobj.getMicrogrid_id();
				index++;
			}
			bsList = bDao.findListByMicrogrid_id_arr(mIds);		
		}
		return bsList;
	}

	public List<BatteryStatus> findAllBatteryStatusByUserId(Long id) {
		List<MicroController> mList = mgDao.findListByUserId(id);
		List<BatteryStatus> bsList = null;
		Object mIds[] = new Object[mList.size()];
		int index = 0;
		for(MicroController mobj:mList){
			mIds[index] = mobj.getMicrogrid_id();
			index++;
		}
		bsList = bDao.findListByMicrogrid_id_arr(mIds);
		return bsList;
	}	
}
