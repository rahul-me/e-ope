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
import com.gridscape.model.BatteryStatus;

public interface BatteryDao {
	public long addBattery(BatteryStatus battery);

	public BatteryStatus save(BatteryStatus obj);

	public BatteryStatus findByMicrogridId(String id);

	public BatteryStatus findById(Long id);

	public List<BatteryStatus> findListByMicrogrid_id_arr(Object[] mIds);

	public void deleteBattery(Long id);

	public List<BatteryStatus> getLast30DaysSOC(String microgrid_id,
			String port_cfg, String state);

	public BatteryStatus getLatestCurrentVoltage(String microgrid_id);	

}
