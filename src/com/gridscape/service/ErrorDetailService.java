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

import com.gridscape.dao.ErrorDetailsDao;
import com.gridscape.model.ErrorDetails;

@Service
public class ErrorDetailService {

	@Autowired
	ErrorDetailsDao edd;
	
	public List<ErrorDetails> findListByMicrogrid_idAndEventDate(String microgrid_id,String eventDate){
		return edd.findListByMicrogrid_idAndEventDate(microgrid_id, eventDate);
	}

	public ErrorDetails save(ErrorDetails error_obj) {
		return edd.save(error_obj);
	}
	
	public List<ErrorDetails> findListByMicroControllerIdAndErrorCode(String error_code, String m_id, int limit){
		return edd.findListByErrorCodeAndMicroControllerId(error_code, m_id, limit);
	}
	
	public ErrorDetails findByErrorCodeAndRequestId(String error_code, String request_id){
		return edd.findByErrorCodeAndRequestId(error_code, request_id);
	}
	
	public List<ErrorDetails> getOpenErrorDetails(String microgrid_id){
		return edd.getOpenErrorDetails(microgrid_id);
	}
	public List<ErrorDetails> getResolvedErrorDetails(String microgrid_id){
		return edd.getResolvedErrorDetails(microgrid_id);
	}
	public List<ErrorDetails> getTotalErrorOccurred(String microgrid_id){
		return edd.getTotalErrorOccurred(microgrid_id);
	}
}
