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
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gridscape.model.MicroControllerStatus;
import com.gridscape.service.MicroControllerStatusServices;

@Controller
@RequestMapping("/micro_status")
public class MicroControllerStatusController {
		
	@Autowired	
	private MicroControllerStatusServices microControllerStatusServices;	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody public Map<String, Object	>  findAllStatus(@PathVariable("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MicroControllerStatus> microControllerStatusList =  microControllerStatusServices.findAllbyMicroGridId(id);
			map.put("data", microControllerStatusList);
			map.put("status", true);
		} catch (Exception e) {
			map.put("status", false);
		}
		return map;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object	> save(MicroControllerStatus mcs){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MicroControllerStatus microControllerStatus = microControllerStatusServices.Save(mcs);
			map.put("data", microControllerStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	@ResponseBody public Map<String, Object> getStatus(@PathVariable("id") String m_id){
		Map<String,Object> response = new HashMap<String, Object>();
		MicroControllerStatus microControllerStatus = microControllerStatusServices.getMCStatus(m_id);
		if(microControllerStatus != null){
			response.put("status", true);
			response.put("data", microControllerStatus);
		} else {
			response.put("status", false);
		}
		return response;
	}
}
	