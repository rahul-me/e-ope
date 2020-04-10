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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.LoginDao;
import com.gridscape.model.Organization;
import com.gridscape.model.User;
import com.gridscape.model.UserRole;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	public List<Organization> getAllOrg(){
		return loginDao.getAllOrg();
	}
	
	public List<UserRole> getAllUserRoll(){
		return loginDao.getAllUserRoll();
	}
	
	public List<User> getAllUser(){
		return loginDao.getAllUser();
	}
	
	public void saveOrg(Organization org){
		loginDao.saveOrg(org);
	}
	
	public void saveUserRoll(UserRole userRoll){
		loginDao.saveUserRoll(userRoll);
	}
	
	public long addUser(User user){
		return loginDao.addUser(user);
	}
	
	public List<User> getUser(String username){
		return loginDao.getUser(username);
	}
	
	public Map<Long, String> getOrgForSelect(){
		return loginDao.getOrgForSelect();
	}
	
	public Map<Long, String> getUserRollForSelect(){
		return loginDao.getUserRollForSelect();
	}
	
	public List<Map<String, Object>> getUserRollById(int id){
		return loginDao.getUserRollById(id);
	}
	public long updateUser(User user){
		return loginDao.updateUser(user);
	}
}
