package com.gridscape.sep.controller.ui;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.service.FunctionSetService;

@Controller
@RequestMapping("/sep/devices/{did}/addfunction")	
public class SepFunctionSet {
	
	@Autowired
	FunctionSetService fService;
	
	@Autowired
	private ConfigProperties configProperties;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	@ResponseBody public ModelAndView addFunction(@PathVariable Long did){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sep/addfunction");
		mv.addObject("deviceId", did);
		return mv;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public  Map<String, Object> save(@RequestBody FunctionSet obj){
		boolean newdata = false;
		Map<String, Object> map = new HashMap<String, Object>();
		Long functionSetId = obj.getId();
		if(functionSetId != null){
			obj.setVersion(obj.getVersion() + 1);
			FunctionSet functionSet = fService.findById(obj.getId());
			String mrid = functionSet.getM_rid();
			if(mrid == null){
				obj.setM_rid(Utility.getStringFromByteArray(Utility.getMRIDValue(functionSet.getId(), configProperties.getIanaPEN())));
			} else {
				obj.setM_rid(mrid);
			}
			
		} else {
			newdata = true;			
		}
		FunctionSet d = fService.save(obj);
		if(newdata){
			obj.setM_rid(Utility.getStringFromByteArray(Utility.getMRIDValue(obj.getId(), configProperties.getIanaPEN())));
			fService.save(obj);
		}
		map.put("status", true);
		//map.put("data", d);
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> functionSetList(@PathVariable Long did){
		System.out.println("get list "+did);
		Map<String, Object> map = new HashMap<String, Object>();
		List<FunctionSet> functionSet = fService.findByDeviceId(did);
		
		map.put("status", true);
		map.put("data", functionSet);
		return map;
		
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> edit(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		FunctionSet f = fService.findById(id);
		map.put("data", f);
		return map;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> updateStatus(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		fService.deleteFunctionSet(id);
		map.put("status", true);
		
		return map; 
	}

}
