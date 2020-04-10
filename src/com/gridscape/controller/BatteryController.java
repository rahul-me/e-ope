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

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gridscape.helpers.GoogleDriveUploader;
import com.gridscape.helpers.TimeZone;
import com.gridscape.helpers.Uploader;
import com.gridscape.helpers.Utility;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.User;
import com.gridscape.service.BatterySerivace;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.UserService;


@Controller
@RequestMapping("/battery")
public class BatteryController {

	@Autowired
	UserService uService;
	
	@Autowired
	BatterySerivace bSerivace;
	
	@Autowired
	MicroGridService mService;
	
	@Autowired
	EnergyDetailService eds;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "/battery/index";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> save(HttpServletRequest request,BatteryStatus obj,@CookieValue("token") String token) throws IllegalStateException, IOException, GeneralSecurityException{
		Map<String, Object> map = new HashMap<String, Object>();
		User user= uService.findByToken(token);
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> files = multiRequest.getFileMap();
		if(user!=null){
			if(obj.getId()!=null){
				BatteryStatus temp = bSerivace.findById(obj.getId());
				if(obj.getBatteryPic()!=null){
					temp.setBatteryPic(obj.getBatteryPic());
				}
				temp.setTechnology(obj.getTechnology());
				temp.setManufacture(obj.getManufacture());
				temp.setNo_of_rack(obj.getNo_of_rack());
				temp.setRack_description(obj.getRack_description());
				temp.setTotal_size(obj.getTotal_size());				
				BatteryStatus bs = bSerivace.save(temp); 				
				bs = uploadPic(files,bs);
				map.put("data",bs );
				GoogleDriveUploader.listFile();
			}else{
				if(user.getUserRole().getRole().equals("super-admin")){
					
				}else if(user.getUserRole().getRole().equals("customer-admin")){					
					BatteryStatus bs = bSerivace.save(obj); 
					bs = uploadPic(files,bs);
					map.put("data",bs );
				}else if(user.getUserRole().getRole().equals("operator")){
					
				}
			}
			
		}
		return map;
	}
	
	public BatteryStatus uploadPic(Map<String, MultipartFile> files,BatteryStatus temp) throws IllegalStateException, IOException, GeneralSecurityException{
		String filepath = null;
		for (MultipartFile file : files.values()) {
			Map<String,Object> map = Uploader.uploadFileToGoogleDrive(temp.getMicrogrid_id(), file, "battery",file.getContentType());
			//String thum_link = map.get("thum_link").toString();
			String fileId = map.get("fileId").toString();			
			filepath = fileId;
			if(filepath!=null){
				temp.setBatteryPic(filepath);
				temp = bSerivace.save(temp);
				return temp;
			}
		}
		return temp;
	}
	
	@RequestMapping(value="/findbymicrogrid_id/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> findByMicrogridId(@PathVariable("id") String id){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("data",bSerivace.findByMicrogridId(id));
		return map;
	}
	
	@RequestMapping(value="/removepic/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> removePic(@PathVariable ("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		BatteryStatus bs = bSerivace.findById( new Long(id));
		String path = context.getRealPath("/")+ bs.getBatteryPic();
		bs.setBatteryPic(null);
		bSerivace.save(bs);
		File file = new File(path);
		file.deleteOnExit();
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getList(HttpServletRequest req,@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		List<BatteryStatus> bsList = null;
		if(user.getUserRole().getRole().equals("super-admin")){
			bsList = bSerivace.findBatteryByMicroGridActive(true);
		}else if(user.getUserRole().getRole().equals("customer-admin")){						
			bsList = bSerivace.findAllBatteryStatusByUserId(user.getId());						
		}	
		map.put("data",bsList);
		map.put("recordsTotal", bsList.size());
		map.put("recordsFiltered", bsList .size());
		return map;
	}
	
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> findById(@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		BatteryStatus bs = bSerivace.findById(id);
		map.put("data", bs);
		return map;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> deleteBattery(@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		bSerivace.deleteBattery(id);
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="/battery_detail/{id}",method=RequestMethod.GET)
	public String batteryDetail(){
		return "battery/battery_detail";
	}
	
	@RequestMapping(value="/getbatterydata/{hourDiff}/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getBatteryData(@PathVariable("hourDiff") int hourDiff, @PathVariable("id") String id, HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		//String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		String microgrid_id = id;
		if(mService.findByMicrogrid_Id(microgrid_id) == null){
			return map;
		}
		
		TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
		map.put("zone", timeZone.getZone());
		map.put("current_voltage_data",this.getLast24CurrentVoltageByHour(microgrid_id,"battery", hourDiff));
		int month  = 0;
		if(req.getParameter("month")!=null){
			month = Integer.parseInt(req.getParameter("month"));
		}		
		//map.put("soc",this.getLast30DaysSOC(microgrid_id,"battery","charging"));
		//map.put("soc",this.getSocByMonth(microgrid_id,"battery",month));
		map.put("soh",this.getSoHByMonth(microgrid_id,"battery",month));
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="/getbatterydatamonth",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getBatteryDataMonth(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		map.put("current_voltage_data",this.getLast24CurrentVoltage(microgrid_id,"battery"));		
		int month  = 0;
		if(req.getParameter("month")!=null){
			month = Integer.parseInt(req.getParameter("month"));
		}		
		//map.put("soc",this.getLast30DaysSOC(microgrid_id,"battery","charging"));
		//map.put("soc",this.getSocByMonth(microgrid_id,"battery",month));
		map.put("soh",this.getSoHByMonth(microgrid_id,"battery",month));
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="/getbatterydatamonth/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getBatteryDataMonthForMicroGridId(@PathVariable("id") String id, HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = id;
		if(mService.findByMicrogrid_Id(microgrid_id) == null){
			return map;
		}		
		map.put("current_voltage_data",this.getLast24CurrentVoltage(microgrid_id,"battery"));		
		int month  = 0;
		if(req.getParameter("month")!=null){
			month = Integer.parseInt(req.getParameter("month"));
		}		
		//map.put("soc",this.getLast30DaysSOC(microgrid_id,"battery","charging"));
		//map.put("soc",this.getSocByMonth(microgrid_id,"battery",month));
		map.put("soh",this.getSoHByMonth(microgrid_id,"battery",month));
		map.put("status", true);
		return map;
	}
	
	@SuppressWarnings("unused")
	private List<EnergyDetails> getSocByMonth(String microgrid_id, String port_cfg, int month) {
		return eds.getSocByMonth(microgrid_id,port_cfg,month);
	}
	
	private List<EnergyDetails> getSoHByMonth(String microgrid_id, String port_cfg, int month) {
		return eds.getSoHByMonth(microgrid_id,port_cfg,month);
	}

	@SuppressWarnings("unused")
	private List<EnergyDetails> getLast30DaysSOH(String microgrid_id, String port_cfg) {
		List<EnergyDetails> list = eds.getLast30DaysSOH(microgrid_id,port_cfg);
		return list;
	}

	@RequestMapping(value="/getlatestbatteryvoltage",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getLatestBatteryVoltage(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		map.put("current_voltage",this.getLatestCurrentVoltage(microgrid_id));		
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="/getlatestbatteryvoltage/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getLatestBatteryVoltageForMicroGridId(@PathVariable("id") String id, HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		map.put("current_voltage",this.getLatestCurrentVoltage(microgrid_id));		
		map.put("status", true);
		return map;
	}
	
	private BatteryStatus getLatestCurrentVoltage(String microgrid_id) {
		BatteryStatus bs = bSerivace.getLatestCurrentVoltage(microgrid_id);
		return bs;
	}

	private List<EnergyDetails> getLast24CurrentVoltage(String microgrid_id,String port_cfg){		
		List<EnergyDetails> list = eds.getLast24CurrentVoltage(microgrid_id,port_cfg);		
		return list;
	}
	
	private List<EnergyDetails> getLast24CurrentVoltageByHour(String microgrid_id,String port_cfg, int hourDiff){		
		List<EnergyDetails> list = eds.getLast24CurrentVoltageByHour(microgrid_id,port_cfg, hourDiff);		
		return list;
	}
	
	@SuppressWarnings("unused")
	private List<EnergyDetails> getLast30DaysSOC(String microgrid_id,String port_cfg,String state){		
		List<EnergyDetails> list = eds.getLast30DaysSOC(microgrid_id,port_cfg,state);		
		return list;
	}
}
