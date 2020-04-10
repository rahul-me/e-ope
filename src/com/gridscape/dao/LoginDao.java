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
import java.util.Map;

import com.gridscape.model.Organization;
import com.gridscape.model.User;
import com.gridscape.model.UserRole;

public interface LoginDao {
	public List<Organization> getAllOrg();
	public List<User> getAllUser();
	public void saveOrg(Organization org);
	public void saveUserRoll(UserRole userRoll);
	public long addUser(User user);
	public List<User> getUser(String username);
	public List<UserRole> getAllUserRoll();
	public Map<Long, String> getOrgForSelect();
	public Map<Long, String> getUserRollForSelect();
	public List<Map<String, Object>> getUserRollById(int id);
	public long updateUser(User user);
}
