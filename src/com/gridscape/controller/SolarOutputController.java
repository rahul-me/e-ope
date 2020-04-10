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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gridscape.model.SolarOutput;

@Controller
@RequestMapping("/solaroutput")
public class SolarOutputController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "solar/index";
	}
	
	@RequestMapping(value="/read_data",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> readFile(){		
		Map<String,Object> map = new HashMap<String, Object>();
		
		return map;
	}
	
	@RequestMapping(value="/index1",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> list(){		
		Map<String,Object> map = new HashMap<String, Object>();
		//List<SolarOutput> lsit = 
		return map;
	}
}

