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

import com.gridscape.dao.MicroControllerStatusDao;
import com.gridscape.model.MicroControllerStatus;

@Service
public class MicroControllerStatusServices {
	@Autowired
	MicroControllerStatusDao microControllerStatus;
	
	
	public MicroControllerStatus findById(String id){
		return microControllerStatus.findById(id);
	}
	public MicroControllerStatus findByRequestId(String requestId){
		return microControllerStatus.findByRequestId(requestId);
	}
	public List<MicroControllerStatus> findAllbyMicroGridId(String microGridId){
		return microControllerStatus.findAllbyMicroGridId(microGridId);
	}
	public MicroControllerStatus Save(MicroControllerStatus mcs){
		return microControllerStatus.Save(mcs);
	}
	public MicroControllerStatus update(MicroControllerStatus mcs){
		return microControllerStatus.update(mcs);	
	}
	public MicroControllerStatus getMCStatus(String microId){
		return microControllerStatus.getMCStatus(microId);
	}
		
}
