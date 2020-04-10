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

import com.gridscape.dao.UserRollDao;
import com.gridscape.model.UserRole;

@Service
public class UserRollService {

	@Autowired
	UserRollDao urDao;
	
	public UserRole save(UserRole obj){
		return urDao.save(obj);
	}

	public List<UserRole> UserRollList() {
		return urDao.UserRollList();
	}

	public UserRole findById(Long id) {
		// TODO Auto-generated method stub
		return urDao.findById(id);
	}
	
	public UserRole findByRoleName(String rolename){
		return urDao.findByRoleName(rolename);
	}
}
