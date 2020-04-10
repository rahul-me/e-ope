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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.TimeZone;
import com.gridscape.helpers.Utility;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.ErrorDetails;
import com.gridscape.model.MicroController;
import com.gridscape.model.User;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.ErrorDetailService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.UserService;


@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	
	@Autowired
	EnergyDetailService eds;
	
	@Autowired
	UserService uService;

	@Autowired
	MicroGridService microGridService;
	
	@Autowired
	ErrorDetailService errorService;
	
	@Autowired
	EnergyDetailService energyDetailService;
	
	@RequestMapping(value="/battery_analsis/{id}",method=RequestMethod.GET)
	public ModelAndView batteryProfile(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/battery_analysis");
		return mv;
	}
	
	@RequestMapping(value="/get_battery_analysis",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> get_battery_analysis_data(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		if(microgrid_id!=null){
			List<EnergyDetails> edList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"battery","charging");
			map.put("battery",edList);
		}else{
			map.put("battery",null);
		}
		return map;
	}
	
	@RequestMapping(value="/load_analysis/{id}",method=RequestMethod.GET)
	public ModelAndView load_analysis(@PathVariable String id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/load_analysis");
		return mv;
	}
	
	@RequestMapping(value="/get_load_analysis",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> get_load_analysis_data(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		
		if(microgrid_id!=null){
			TimeZone timeZone = Utility.getTimeZoneObject(microGridService.findZoneById(microgrid_id));
			List<EnergyDetails> edList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"load","in");		
			map.put("load",edList);
			map.put("zone", timeZone.getZone());
		}else{
			map.put("load",null);
			map.put("zone", "");
		}
		return map;
	}
	
	@RequestMapping(value="/get_load_analysis/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> get_load_analysis_data_id_para(@PathVariable("id") String id,HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		//String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		
		
		String microgrid_id = id;
		if(microGridService.findByMicrogrid_Id(microgrid_id) == null){
			return map;
		}
		
		if(microgrid_id!=null){
			TimeZone timeZone = Utility.getTimeZoneObject(microGridService.findZoneById(microgrid_id));
			List<EnergyDetails> edList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"load","in");		
			map.put("load",edList);
			map.put("zone", timeZone.getZone());
		}else{
			map.put("load",null);
			map.put("zone", "");
		}
		return map;
	}
	
	@RequestMapping(value="/solar_analysis/{id}",method=RequestMethod.GET)
	public ModelAndView solar_analysis(@PathVariable String id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/solar_analysis");
		return mv;
	}
	
	@RequestMapping(value="/get_solar_analysis",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> get_solar_analysis_data(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		if(microgrid_id!=null){
			List<EnergyDetails> edList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"solar","out");
			map.put("solar",edList);
		}else{
			map.put("solar",null);
		}
		return map;
	}
	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView index(@PathVariable("id") String id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/index");
		return mv;
	}
	
	@RequestMapping(value="/getenergysourcedata",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> energySource(HttpServletRequest req) throws ParseException{
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		List<EnergyDetails> solarList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"solar","out");
		List<EnergyDetails> gridList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"grid","out");
		List<EnergyDetails> loadList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"load","in");
		TimeZone timeZone = Utility.getTimeZoneObject(microGridService.findZoneById(microgrid_id));
		map.put("grid",gridList);
		map.put("solr",solarList);
		map.put("load",loadList);
		map.put("zone", timeZone.getZone());
		return map;
	}
	
	@RequestMapping(value="/getenergysourcedata/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> energySourceByMicroGridId(@PathVariable String id,HttpServletRequest req) throws ParseException{
		Map<String, Object> map = new HashMap<String, Object>();
		//String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		String microgrid_id = id;
		
		if(microGridService.findByMicrogrid_Id(microgrid_id) == null){
			return map;
		}
		List<EnergyDetails> solarList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"solar","out");
		List<EnergyDetails> gridList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"grid","out");
		List<EnergyDetails> loadList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id,"load","in");
		TimeZone timeZone = Utility.getTimeZoneObject(microGridService.findZoneById(microgrid_id));
		map.put("grid",gridList);
		map.put("solr",solarList);
		map.put("load",loadList);
		map.put("zone", timeZone.getZone());
		return map;
	}
	
	@RequestMapping(value="/energy_source_list",method=RequestMethod.GET)
	public ModelAndView energySourceList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/energy_source_list");
		return mv;
	}
	
	@RequestMapping(value="/getenergysourcelist",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getEnergySourceList(HttpServletRequest req,@CookieValue("token") String token) throws ParseException{
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		String role = user.getUserRole().getRole();
		if(role != null && (role.equals("customer-admin") || role.equals("super-admin"))){			
			//List<MicroController> microList = microGridService.listMicroByUserId(user.getId());
			String microgrid_list = req.getParameter("microgrid_list");			
			String mgObj = "'"+microgrid_list+"'";			
			/*Object obj[] = new Object[microList.size()];
			int index = 0;
			for(MicroController mg:microList){
				mgObj += "'"+mg.getMicrogrid_id()+"'";
				obj[index] = mg.getMicrogrid_id();
				if(index<microList.size()-1){
					mgObj += ",";
				}
				index++;
			}	*/		
			String port_cfg = req.getParameter("port_cfg");
			String event_date = req.getParameter("event_date");
			List<EnergyDetails> energy_source_list = eds.findListByMicrogridArrAndPortCFGAndEventDate(mgObj,port_cfg,event_date);
			map.put("data", energy_source_list);
		}else{
			map.put("data", new ArrayList<EnergyDetails>());
		}
		return map;
	}
	
	@RequestMapping(value="/message_error_list",method=RequestMethod.GET)
	public ModelAndView messageErrorList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/message_error_list");
		return mv;
	}
	
	@RequestMapping(value="/geterrorlist",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getErrorList(HttpServletRequest req,@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		if(user.getUserRole().getRole().equals("customer-admin")){
			List<MicroController> microList = microGridService.listMicroByUserId(user.getId());
			String mgObj = "";
			Object obj[] = new Object[microList.size()];
			int index = 0;
			for(MicroController mg:microList){
				mgObj = "'"+mg.getMicrogrid_id()+"'";
				obj[index] = mg.getMicrogrid_id();
				if(index<microList.size()-1){
					mgObj += ",";
				}
				index++;
			}
			String event_date = req.getParameter("event_date");
			List<ErrorDetails> error_list = errorService.findListByMicrogrid_idAndEventDate(mgObj, event_date);
			map.put("data", error_list);
		}else{
			map.put("data", null);
		}
		return map;
	}
	
	@RequestMapping(value="/power_analysis", method=RequestMethod.GET)
	public ModelAndView getPowerAnalysis(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/power_analysis");
		return mv;
	}
	
	@RequestMapping(value="/generation", method=RequestMethod.GET)
	public ModelAndView getTotalGeneration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/analysis/total_generation");
		return mv;
	}
	

	@RequestMapping(value="/gettotalusage", method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getTotalGeneration(HttpServletRequest req,@CookieValue("token") String token) throws JSONException {
		Map<String, Object> response = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		
		List<MicroController> microControllerList = new ArrayList<MicroController>();		
		
		switch(user.getUserRole().getRole()){		
			case "super-admin":
				microControllerList = microGridService.GetList();
				break;
			case "customer-admin":
				microControllerList = microGridService.findListByUserId(user.getId());
				break;
			case "operator":			
		}
		
		if(microControllerList.size() > 0) {
			for(MicroController microController : microControllerList) {				
				microController.setMicrogrid_name(microController.getMicrogrid_id()+" - "+microController.getMicrogrid_name());
				microController.setLatitude(energyDetailService.getTotalGenerationSpecificForMicroGridIdPortCfgAndState(microController.getMicrogrid_id(), "solar", "out"));
				microController.setLongitude(energyDetailService.getTotalGenerationSpecificForMicroGridIdPortCfgAndState(microController.getMicrogrid_id(), "grid", "out"));				
			}
		}
		
		response.put("data", microControllerList);
		return response;
		
	}
	
	
	
	
	

}
