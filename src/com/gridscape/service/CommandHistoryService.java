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

import com.gridscape.dao.CommandHistoryDao;
import com.gridscape.model.CommandHistory;
@Service
public class CommandHistoryService {
	
	@Autowired
	CommandHistoryDao commandHistoryDao;
	
	public CommandHistory findById(String id){
		return commandHistoryDao.findById(id);
	}
	public CommandHistory findByRequestId(String requestId){
		return commandHistoryDao.findByRequestId(requestId);
	}
	public List<CommandHistory> findAllbyMicroGridId(String microGridId){
		return commandHistoryDao.findAllbyMicroGridId(microGridId);
	}
	public CommandHistory Save(CommandHistory ch){
		return commandHistoryDao.Save(ch);
	}
	public CommandHistory update(CommandHistory ch){
		return commandHistoryDao.update(ch);
	}
}
