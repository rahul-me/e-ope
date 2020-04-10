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

import com.gridscape.model.User;
import com.gridscape.model.UserLogin;

public interface UserDao {
		
	
	public User save(User obj);

	public User findById(Long id);

	public List<User> userList();

	public void deleteUser(Long id);

	public User findByUserName(String userName);

	public User findByEmail(String email);

	public List<User> getUserListByLimit(Integer start, Integer len, String search);

	public User findByToken(String dynamicToken);

	public List<User> getCustomerAdminList();

	public List<User> getListByOperatorArr(Object[] obj);

	public List<User> getListByOperatorArrWithLimit(Object[] obj,
			Integer start, Integer len);
	
	public void createLoginToken(String token,String userId,String email);
	public UserLogin findUserByLoginToken(String token);
	public void deleteLoginToken(String token);
		
		
	
}
