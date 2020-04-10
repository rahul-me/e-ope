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
 
  
  
package com.gridscape.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.Email;
import com.gridscape.helpers.Utility;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.Organization;
import com.gridscape.model.User;
import com.gridscape.model.UserLogin;
import com.gridscape.model.UserRole;
import com.gridscape.service.CommonService;
import com.gridscape.service.LoginService;
import com.gridscape.service.UserService;


@Controller
@RequestMapping("/login")
public class LogingController {
	@Autowired
	LoginService lService;
	
	@Autowired
	CommonService cService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	CustomSecurityManager security_manager;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/organization", method = RequestMethod.GET)
	public ModelAndView showRegistration(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("organization");
		return mv;
	}
	
	@RequestMapping(value = "/userroll", method = RequestMethod.GET)
	public ModelAndView showUserRoll(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userRoll");
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddUser(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("org", lService.getOrgForSelect());
		mv.addObject("userroll", lService.getUserRollForSelect());
		mv.setViewName("addUser");
		return mv;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getAllOrg() {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("data", lService.getAllOrg());
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/allUserRoll", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getAllUserRoll() {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("data", lService.getAllUserRoll());
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/alluser", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getAllUser() {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("data", lService.getAllUser());
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody Organization org) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		org.setOrgId("ORG"+cService.getCode("Organization"));
		lService.saveOrg(org);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/createUserRoll", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> createUserRoll(@RequestBody UserRole userRoll) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		//userRoll.setUserRollId("USR-Roll"+cService.getCode("UserRoll"));
		lService.saveUserRoll(userRoll);
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> create(@RequestBody User user) {		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pass = user.getPassword();
			user.setPassword(security_manager.encryptPassword(pass));
			lService.addUser(user);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);	
			map.put("Error", e.getMessage());	
		}
		return map;
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> doLogin(@RequestBody User user) {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
		
			User userObj = uService.findByEmail(user.getEmail());
			if(userObj!=null){
				String email = userObj.getEmail();
				String password = userObj.getPassword();
				boolean Active =  userObj.isActive();
				if(user.getEmail().equalsIgnoreCase(email) && password.equalsIgnoreCase(security_manager.encryptPassword(user.getPassword())) && Active == true){
					User db_user = userObj;
					if(db_user.getDynamicToken() == null || db_user.getDynamicToken().length() < 1){
						db_user.setDynamicToken(security_manager.getReferenceCode());	
					}
					String logintoken = security_manager.getReferenceCode();
					long login_count = db_user.getLogin_count(); 
					db_user.setLogin_count((login_count+1));
					uService.createLoginToken(logintoken, db_user.getId().toString(), user.getEmail());
					lService.updateUser(db_user);				
					data.put("token",db_user.getDynamicToken());
					data.put("logintoken",logintoken);
					data.put("status", true);
					data.put("username", db_user.getUserName());
					data.put("roleName", db_user.getUserRole().getRole());
					data.put("image", db_user.getImage());
					data.put("user", userObj);
					data.put("sepAccess", db_user.isSepAccess());
					data.put("sepOnly", db_user.isSepOnly());
					data.put("userid", db_user.getId());
				}else{					
					data.put("status", false);
				}
			}else{
				data.put("status", false);
			}
		} catch (Exception e) {
			data.put("status", false);
			data.put("Error", e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> logout(HttpServletRequest req) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
				uService.deleteLoginToken(Utility.getLoginTokenByCookie(req));
				map.put("status", true);	
		
		} catch (Exception e) {
			map.put("status", false);	
			map.put("Error", e.getMessage());	
		}
		return map;
	}
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> checkLogin(HttpServletRequest req) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserLogin userLogin =  uService.findUserByLoginToken(Utility.getLoginTokenByCookie(req));
			if(userLogin != null){
				map.put("status", true);	
			}else{
				map.put("status", false);
			}
			
		} catch (Exception e) {
			map.put("status", false);	
			map.put("Error", e.getMessage());	
		}
		return map;
	}
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> forgotPassword(@RequestBody User user,HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pass = security_manager.getRandomPassword();
			User userObj = uService.findByEmail(user.getEmail());
			userObj.setPassword(security_manager.encryptPassword(pass));
			uService.save(userObj);
			userObj.setPassword(pass);
			this.sendUserMail(userObj, req);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);	
			map.put("Error", e.getMessage());	
		}
		return map;
	}
	
	
	private void sendUserMail(User obj,HttpServletRequest req){
		Email email = new Email();
		String message = "Account details :\n";
		message += "Email : " + obj.getEmail() + "\n";
		message += "Password : " + obj.getPassword() + "\n";
		message += "Click on below link to access our portal\n";
		message += req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + req.getContextPath() + "/home/login.jsp";
		email.sendMail(obj.getEmail(), "MicroGrid-OS Reset password detail", message);
	}

	
}
