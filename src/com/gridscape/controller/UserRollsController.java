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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gridscape.helpers.Utility;
import com.gridscape.model.User;
import com.gridscape.model.UserRole;
import com.gridscape.service.UserRollService;
import com.gridscape.service.UserService;

@Controller
@RequestMapping("/role")
public class UserRollsController {
	
	@Autowired
	UserRollService urService;
	
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "/role/index";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public Map<String , Object> save(@RequestBody UserRole obj){
		Map<String, Object> map = new HashMap<String, Object>();
		if(obj.getId()!= null){
			UserRole role = urService.findById(obj.getId());
			role.setRole(obj.getRole());
			urService.save(role);
			map.put("status", true);
		}else{
			urService.save(obj);
			map.put("status", true);
		}
		
		return map;
	}
	
	@RequestMapping(value="/rolllist",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> rollList(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();		
		String token = Utility.getTokenByCookie(req);
		if(token!=null){
			User user = uService.findByToken(token);
			System.out.println("token = "+token);
			List<UserRole> urList = urService.UserRollList();
			List<UserRole> urList1 = new ArrayList<UserRole>();
			UserRole ur = null;
			for(UserRole obj : urList){
				ur = new UserRole();
				if(user.getUserRole().getRole().equals("super-admin")){
					break;
				}else if(user.getUserRole().getRole().equals("customer-admin")){
					System.out.println(obj.getRole());
					if(!obj.getRole().equals("customer-admin") & !obj.getRole().equals("super-admin")){
						ur.setId(obj.getId());
						ur.setRole(obj.getRole());
						urList1.add(ur);
					}
				}
			}
			if(user.getUserRole().getRole().equals("super-admin")){
				map.put("maprole", urList);
			}else{
				map.put("maprole", urList1);
			}
			
			map.put("data",urService.UserRollList());
		}else{
			map.put("maprole", null);
			map.put("data", null);
		}
		
		return map;
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> edit(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(urService.findById(id));
		map.put("data",urService.findById(id));
		return map;
	}
	
	
	@RequestMapping(value="/checkRoleForCustomerAdmin", method=RequestMethod.POST)
	@ResponseBody public String checkRoleForCustomerAdmin(@RequestBody UserRole userRole){
		String role = userRole.getRole();
		urService.findByRoleName(role);
		return "Hello";
	}
}
