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

import com.gridscape.model.MicroControllerStatus;

public interface MicroControllerStatusDao {
	
	public MicroControllerStatus findById(String id);
	public MicroControllerStatus findByRequestId(String requestId);
	public List<MicroControllerStatus> findAllbyMicroGridId(String microGridId);
	public MicroControllerStatus Save(MicroControllerStatus mcs);
	public MicroControllerStatus update(MicroControllerStatus mcs);
	public MicroControllerStatus getMCStatus(String microId);

}
