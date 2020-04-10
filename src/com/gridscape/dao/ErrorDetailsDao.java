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

import com.gridscape.model.ErrorDetails;

public interface ErrorDetailsDao {
	public ErrorDetails findById(String id);
	public ErrorDetails findByRequestId(String requestId);
	public List<ErrorDetails> findAllbyMicroGridId(String microGridId);
	public ErrorDetails save(ErrorDetails ed);
	public ErrorDetails update(ErrorDetails ed);	
	public List<ErrorDetails> findListByMicrogrid_idAndEventDate(String microgrid_id,String eventDate);
	public List<ErrorDetails> findListByErrorCodeAndMicroControllerId(String error_code, String m_id, int limit);
	public ErrorDetails findByErrorCodeAndRequestId(String error_code, String request_id);
	public List<ErrorDetails> getOpenErrorDetails(String microgrid_id);
	public List<ErrorDetails> getResolvedErrorDetails(String microgrid_id);
	public List<ErrorDetails> getTotalErrorOccurred(String microgrid_id);
}	
