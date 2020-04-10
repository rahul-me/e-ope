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

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.UserDao;
import com.gridscape.dao.UserRollDao;
import com.gridscape.helpers.Email;
import com.gridscape.jsoninput.Operator;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.AssignOperator;
import com.gridscape.model.User;
import com.gridscape.model.UserLogin;
import com.gridscape.model.UserRole;

@Service
public class UserService {

	@Autowired
	UserDao uDao;

	@Autowired
	UserRollDao urDao;

	CustomSecurityManager csm = new CustomSecurityManager();

	public User save(User obj) {

		return uDao.save(obj);
	}

	public User findById(Long id) {
		return uDao.findById(id);
	}

	public List<User> userList() {
		return uDao.userList();
	}

	public void deleteUser(Long id) {
		uDao.deleteUser(id);
	}

	public User findByUserName(String userName) {
		return uDao.findByUserName(userName);
	}

	public User findByEmail(String email) {
		return uDao.findByEmail(email);
	}

	public List<User> getUserListByLimit(Integer start, Integer len, String search) {
		return uDao.getUserListByLimit(start, len, search);
	}

	public User findByToken(String dynamicToken) {
		return uDao.findByToken(dynamicToken);
	}

	public List<User> getCustomerAdminList() {
		return uDao.getCustomerAdminList();
	}

	public List<User> getListByOperatorArr(Object[] obj) {
		return uDao.getListByOperatorArr(obj);
	}

	public List<User> getListByOperatorArrWithLimit(Object[] obj, Integer start, Integer len) {
		return uDao.getListByOperatorArrWithLimit(obj, start, len);
	}

	public void createLoginToken(String token, String userId, String email) {
		uDao.createLoginToken(token, userId, email);
	}

	public UserLogin findUserByLoginToken(String token) {
		return uDao.findUserByLoginToken(token);
	}

	public void deleteLoginToken(String token) {
		uDao.deleteLoginToken(token);
	}

	public UserRole findUserRoleByRole(String role) {
		return urDao.findByRoleName(role);
	}

	private void sendMail(User obj, HttpServletRequest req) {
		Email email = new Email();
		String message = "Account details :\n";
		message += "Email : " + obj.getEmail() + "\n";
		message += "Password : " + obj.getPassword() + "\n";
		message += "Our admin review your account and activated soon. After Click on below link to access our portal\n";
		message += req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath()
				+ "/rest/home/login.jsp";
		email.sendMail(obj.getEmail(), "Energy-Scope login detail", message);

	}

	public Map<String, Object> registerUser(User obj, HttpServletRequest request) throws NoSuchAlgorithmException {

		UserRole userRole = findUserRoleByRole("customer-admin");

		Map<String, Object> map = new HashMap<String, Object>();
		if (userRole != null) {
			if (obj.getId() != null) {
				User user = findById(obj.getId());
				// user.setUserRole(userRole);

				obj.setUpdated_by(user.getUpdated_by());
				obj.setLongitude(user.getLongitude());
				obj.setLatitude(user.getLatitude());
				obj.setActive(user.isActive());
				obj.setDynamicToken(user.getDynamicToken());
				obj.setImage(user.getImage());
				obj.setIsDelete(user.getIsDelete());
				obj.setLogin_count(user.getLogin_count());
				obj.setPassword(user.getPassword());
				obj.setUserId(user.getUserId());
				obj.setUserRole(user.getUserRole());
				obj.setSepAccess(user.isSepAccess());
				obj.setSepOnly(user.isSepOnly());
				obj.setAnalysisAccess(user.isAnalysisAccess());
				obj.setAnalysisOnlyAccess(user.isAnalysisOnlyAccess());
				save(obj);
				map.put("status", true);
			} else {
				User user = findByEmail(obj.getEmail());
				System.out.println(user);
				if (user == null) {
					String password = obj.getPassword();
					if (password == null) {
						password = "gridscape91";
					}
					obj.setPassword(csm.encryptPassword(password));
					obj.setActive(false);
					obj.setIsDelete(false);
					if (obj.getUserRole() != null) {
						UserRole ur = new UserRole();
						ur.setId(obj.getUserRole().getId());
						user.setUserRole(ur);
					} else {
						obj.setUserRole(userRole);
					}
					save(obj); // service method for inserting data into user
								// table.
					obj.setPassword(password);
					this.sendMail(obj, request);
					map.put("status", true);
				} else {
					map.put("status", false);
					map.put("message", "Email address already used.!");
				}
			}
		} else {
			map.put("status", false);
			map.put("message", "Application has not been submitted. Contact admistrative person");
		}
		return map;
	}

	public Map<String, Object> saveoperator(HttpServletRequest req, AssignOperatorService aoService,
			com.gridscape.jsoninput.AssignOperator obj, String token) throws NoSuchAlgorithmException {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = findByEmail(obj.getEmail());

		if (user != null) {
			User tempUser = findByToken(token);
			if (user.getUserRole().getId() == 3) {
				// System.out.println("parent id = "+tempUser.getId()+" operator
				// id = "+user.getId());
				AssignOperator temp = aoService.findByParentIdAndOperatorId(tempUser.getId(), user.getId());
				if (temp != null) {
					map.put("status", true);
				} else {
					AssignOperator ao = new AssignOperator();
					ao.setOperatorId(user.getId());
					ao.setParentId(tempUser.getId());
					ao.setIsActive(true);
					aoService.save(ao);
					map.put("status", true);
				}
			} else {
				map.put("status", false);
				map.put("message", "You can not assign owner as operator!");
			}
		} else {
			User u = new User();
			u.setEmail(obj.getEmail());
			UserRole ur = new UserRole();
			ur.setId(obj.getRoleId());
			u.setUserRole(ur);
			u.setActive(obj.getActive());
			u.setIsDelete(false);
			String password = csm.getRandomPassword();
			u.setPassword(csm.encryptPassword(password));
			u = save(u);
			User tempUser = findByToken(token);
			u.setPassword(password);
			this.sendMail(u, req);
			com.gridscape.model.AssignOperator ao = new com.gridscape.model.AssignOperator();
			ao.setOperatorId(u.getId());
			ao.setParentId(tempUser.getId());
			ao.setIsActive(true);
			aoService.save(ao);
			map.put("status", true);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getListByRole(HttpServletRequest req, AssignOperatorService aoService, String rolename,
			String token) {
		Integer start = Integer.parseInt(req.getParameter("start"));
		Integer len = Integer.parseInt(req.getParameter("length"));
		User user = findByToken(token);
		String search = req.getParameter("search[value]");
		if (rolename.equalsIgnoreCase("super-admin")) {
			return getListForSuperAdmin(search, start, len);
		} else if (rolename.equalsIgnoreCase("customer-admin")) {
			return getListForCustomerAdmin(aoService, user, start, len);
		}
		return (Map<String, Object>) new HashMap<String, Object>().put("data", null);
	}

	public Map<String, Object> getListForSuperAdmin(String search, Integer start, Integer len) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> userList = getUserListByLimit(start, len, search);
		List<User> uList = userList();
		map.put("recordsTotal", uList.size());
		map.put("recordsFiltered", uList.size());
		map.put("data", userList);
		return map;
	}

	public Map<String, Object> getListForCustomerAdmin(AssignOperatorService aoService, User user, Integer start,
			Integer len) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AssignOperator> aoList = aoService.listByParentIdWithLimit(user.getId(), start, len);
		int count = aoService.getTotalRecordByParentId(user.getId());
		List<Operator> listOperator = new ArrayList<Operator>();
		if (aoList.size() > 0) {
			listOperator = new ArrayList<Operator>();
			Operator op = null;
			for (AssignOperator obj : aoList) {
				op = new Operator();
				op.setId(obj.getId());
				User u = findById(obj.getOperatorId());
				op.setEmail(u.getEmail());
				op.setFullname(u.getFullname());
				op.setUserName(u.getUserName());
				op.setActive(obj.getIsActive());
				listOperator.add(op);
			}
			map.put("recordsTotal", count);
			map.put("recordsFiltered", count);
			map.put("data", listOperator);
		} else {
			map.put("data", listOperator);
		}
		return map;
	}

	public boolean isSEPModuleAccessibilityTrue(String token) {
		User user = findByToken(token);
		return (user.isSepAccess()) ? true : false;
	}

	public boolean isSEPOnlyModuleAccessibilityTrue(String token) {
		User user = findByToken(token);
		return (user.isSepAccess()) ? true : false;
	}

	public boolean checkRequiredParametersForFindLatLong(User user) {
		return (ifDataIsNotNullAndIsNotBlank(user.getAddress_line_1()) && ifDataIsNotNullAndIsNotBlank(user.getCity()) && ifDataIsNotNullAndIsNotBlank(user.getZip_code())) ? true : false ;
	}
	
	private boolean ifDataIsNotNullAndIsNotBlank(String data){
		return (data != null && data.trim().length() > 0) ? true : false;
	}

}
