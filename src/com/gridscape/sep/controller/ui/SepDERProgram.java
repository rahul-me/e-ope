package com.gridscape.sep.controller.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.Constant;
import com.gridscape.helpers.Utility;
import com.gridscape.model.User;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.service.DERProgramService;
import com.gridscape.service.UserService;

@Controller
@RequestMapping("/sep/derprograms")
public class SepDERProgram {
	
	@Autowired
	DERProgramService derService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfigProperties configProperties;

	@RequestMapping(value="/index",method=RequestMethod.GET)
	@ResponseBody public ModelAndView addFunction(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("endDeviceId", 0);
		mv.setViewName("/sep/derprogram");
		return mv;
	}
	
	@RequestMapping(value="/index/{endDeviceId}",method=RequestMethod.GET)
	@ResponseBody public ModelAndView associatedDERPs(@PathVariable("endDeviceId") Long endDeviceId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("endDeviceId", endDeviceId);
		mv.setViewName("/sep/derprogram");
		return mv;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody public DERProgram save(@RequestBody DERProgram obj){
		boolean dataExists = false;
		DERProgram derProgram = null;
		if(obj!=null){
			Long id = obj.getId();
			if(id != null){
				dataExists = true;
				DERProgram derProgram2 = derService.findById(obj.getId());
				String mrid = derProgram2.getM_rid();
				if(mrid == null){
					mrid = Utility.getStringFromByteArray(Utility.getMRIDValue(obj.getId(), configProperties.getIanaPEN()));
				}
				obj.setM_rid(mrid);
				Integer version = obj.getVersion();
				if(version != null){
					obj.setVersion(version + 1);
				}				
			} else {
				
			}
			derProgram = derService.save(obj);
			if(!dataExists){
				obj.setM_rid(Utility.getStringFromByteArray(Utility.getMRIDValue(obj.getId(), configProperties.getIanaPEN())));
				derService.save(obj);
			}
		}
		return derProgram;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> edit(@PathVariable Long id){
		Map<String, Object> derpList = new HashMap<String, Object>();
		DERProgram derp = derService.findById(id);
		derpList.put("data", derp);
		return derpList;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> list(HttpServletRequest request, @CookieValue("token") String userToken){
		
		User user = userService.findByToken(userToken);
		List<DERProgram> dList = new ArrayList<DERProgram>();
		
		switch (user.getUserRole().getRole()) {
		case Constant.USER_ROLE_SUPER:
			dList = derService.dERProgramList();
			break;
		case Constant.USER_ROLE_CUSTOMER_ADMIN:
			dList = derService.getListByUserId(user.getId());
			break;
		case Constant.USER_ROLE_OPERATOR:
			dList = derService.getListByUserId(user.getId());
			break;
		}		
		
		Map<String, Object> derpList = new HashMap<String, Object>();
//		List<DERProgram> dList = derService.dERProgramList();
		derpList.put("data", dList);
		return derpList;
	}
	
	@RequestMapping(value="/list/{endDeviceId}", method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> listBasedOnDevice(HttpServletRequest request, @CookieValue("token") String userToken, @PathVariable("endDeviceId") Long endDeviceId){
		
		User user = userService.findByToken(userToken);
		List<DERProgram> dList = new ArrayList<DERProgram>();
		
		switch (user.getUserRole().getRole()) {
		case Constant.USER_ROLE_SUPER:
			dList = derService.getListByDeviceId(endDeviceId);
			break;
		case Constant.USER_ROLE_CUSTOMER_ADMIN:
			dList = derService.getListByDeviceId(endDeviceId);
			break;
		case Constant.USER_ROLE_OPERATOR:
			dList = derService.getListByDeviceId(endDeviceId);
			break;
		}		
		
		Map<String, Object> derpList = new HashMap<String, Object>();
//		List<DERProgram> dList = derService.dERProgramList();
		derpList.put("data", dList);
		return derpList;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
	@ResponseBody public Map<String, Object> delete(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		derService.deleteDERProgram(id);
		map.put("status", true);
		return map;
	}
	
	
}
