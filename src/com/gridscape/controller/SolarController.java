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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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

import com.gridscape.helpers.FTPUtility;
import com.gridscape.helpers.ImportCSV;
import com.gridscape.helpers.Uploader;
import com.gridscape.helpers.Utility;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.MicroController;
import com.gridscape.model.SolarService;
import com.gridscape.model.User;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.UserService;

@Controller
@RequestMapping("/solar")
public class SolarController {

	@Autowired
	MicroGridService mgs;
	
	@Autowired
	UserService uService;
	
	@Autowired
	EnergyDetailService eds;
	
	@Autowired
	FTPUtility ftpService;
	
	@Autowired
	com.gridscape.service.SolarService sService;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "solar/index";
	}
	
	@RequestMapping(value="/service",method=RequestMethod.GET)
	public String service(){
		return "solar/service";
	}
	
	@RequestMapping(value="/servicelist",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> serviceList(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<SolarService> serviceList = sService.list();
		map.put("data", serviceList);
		return map;
	}
	
	@RequestMapping(value="/f_read_ftp",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> force_read_solar_service_data(HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try{			
			//ftpService.downLoadFileFromDirectories();
			String path = ftpService.getDestinationPath();
			System.out.println(path);
			File file = new File(path);
			ImportCSV csv_reader = null;
			SolarService ss = null;
			List<SolarService> ssList = new ArrayList<SolarService>();
			int index = 0;
			List<String> header = null;
			DateFormat formatterser = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date = null;
			for(File flist:file.listFiles()){	
				header = new ArrayList<String>();
				if(flist.isFile()){
					String name = flist.getName(); 
					System.out.println("File Name = "+name);
					index = 0;
					if(!name.contains("GRIDSCAPE-SLR")){
						String file_path = path+name;
						System.out.println(file_path);
						File ftp_file = new File(file_path);
						csv_reader = new ImportCSV();
						InputStream is = new FileInputStream(ftp_file);						
						Map<String, List<String[]>> data = csv_reader.Import(is);
						System.out.println(data.size());
						List<String[]> rows = data.get("data");
						System.out.println(rows.size());
						if(rows!=null){
							int i = 0;
							for(String str[]:rows){
								for(String s:str){
									System.out.print(s+" ");
									
								}
								if(index!=0){
									i++;				 
									if(str[1]==null){
										ss = new SolarService();
									}else{
										date = formatterser.parse(str[1]);
										ss = sService.findBySolarServiceByStationIdAndDateTime(str[0],date);
									}									
									if(ss==null){
										ss = new SolarService();
									}
									ss.setFile_name(name);	
									System.out.println("header size = "+header.size());
									for(int hIndex=0;hIndex<header.size();hIndex++){	
										
										if(header.get(hIndex).equals("StationID")){
											ss.setStation_id(str[hIndex]);
										}
										if(header.get(hIndex).equals("DateTime") || header.get(hIndex).equals("Valid Date")){
											date = formatterser.parse(str[hIndex]);								
											ss.setDatetime(date);
										}
										if(header.get(hIndex).equals("GHI")){
											ss.setGhi(str[hIndex]);
										}
										if(header.get(hIndex).equals("PoA")){
											ss.setPoa(str[hIndex]);
										}
										if(header.get(hIndex).equals("PWR") || header.get(hIndex).equals("Power")){
											ss.setPwr(str[hIndex]);
										}
									}
									System.out.println(ss);
									ssList.add(ss);														
								}else if(index==0){
									for(int headerIndex=0;headerIndex<str.length;headerIndex++){
										System.out.println("header =" +str[headerIndex]);
										header.add(str[headerIndex]);
									}
								}
								index = 1;
							}
							header = null;
						}
						sService.saveSolarServiceList(ssList);	
						File newFile = new File(path+"done/"+name);
						InputStream inStream = null;
						OutputStream outStream = null;
						inStream = new FileInputStream(ftp_file);
			    	    outStream = new FileOutputStream(newFile);
			    	    byte[] buffer = new byte[1024];		    		
			    	    int length;
			    	    //copy the file content in bytes 
			    	    while ((length = inStream.read(buffer)) > 0){		    	  
			    	    	outStream.write(buffer, 0, length);		    	 
			    	    }		    	 
			    	    inStream.close();
			    	    outStream.close();
			    	    
			    	    System.out.println("delete file path = "+ftp_file.getAbsolutePath());
			    	    ftp_file.setWritable(true);
			    	    boolean status = ftp_file.delete();
			    	    System.out.println("status = "+status);
			    	    data = null;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return map;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> save(HttpServletRequest request,MicroController obj,@CookieValue("token") String token) throws IllegalStateException, IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(obj);
		try{
			String microgrid_id = request.getParameter("microgrid_id");
			System.out.println("microgrid id = "+microgrid_id);
			MicroController mc = mgs.findByMicrogrid_Id(microgrid_id);
			System.out.println(mc);
			if(mc!=null){
				System.out.println("set solar data");
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				Map<String, MultipartFile> files = multiRequest.getFileMap();	
				mc.setTotal_size(obj.getTotal_size());
				mc.setNo_of_solar_panel(obj.getNo_of_solar_panel());
				mc.setSolar_panel_description(obj.getSolar_panel_description());
				mc.setStation_id(obj.getStation_id());
				String fileId = null;
				for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
			        MultipartFile file = entry.getValue();
			        String contentType = file.getContentType();
			        Map<String,Object> file_detail = Uploader.uploadFileToGoogleDrive(microgrid_id, file,"solar",contentType);
			        fileId = file_detail.get("fileId").toString();
			        mc.setSolar_pic(fileId);
				}   		
				System.out.println("set solar data");
				mgs.save(mc);
				map.put("status", true);
			}else{
				System.out.println("not set solar data");
				map.put("status", false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> list(@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		List<MicroController> mList = null;
		if(user!=null){
			if(user.getUserRole().getRole().equals("super-admin")){		
				mList = mgs.findAllByMicroGridStatusActive(true);
			}else if(user.getUserRole().getRole().equals("customer-admin")){			
				mList = mgs.findListByUserId(user.getId());								
			}
			map.put("data",mList);
			map.put("recordsTotal", mList.size());
			map.put("recordsFiltered", mList .size());
		}else{
			map.put("status", false);
		}
		return map;
	}
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> findById(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController mc = mgs.findById(id);
		if(mc!=null){
			map.put("data", mc);
		}else{
			map.put("data", null);
		}
		return map;
	}
		
	@RequestMapping(value="/findbymicrogrid_id/{microgrid_id}",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> findByMicrogrid_id(@PathVariable String microgrid_id){
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController mc = mgs.findByMicrogrid_Id(microgrid_id);
		if(mc!=null){
			map.put("data", mc);
		}else{
			map.put("data", null);
		}
		return map;
	}
	
	@RequestMapping(value="/removepic/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> removepic(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController mc = mgs.findById(id);
		if(mc!=null){
			mc.setSolar_pic(null);
			mc = mgs.save(mc);
			map.put("data", mc);
			map.put("status", true);
		}else{
			map.put("data", null);
			map.put("status", false);
		}
		return map;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> deleteSolar(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController mc = mgs.findById(id);
		if(mc!=null){
			mc.setSolar_pic(null);
			mc.setTotal_size(null);
			mc.setNo_of_solar_panel(null);
			mc.setSolar_pic(null);
			mc = mgs.save(mc);
			map.put("data", mc);
			map.put("status", true);
		}else{
			map.put("data", null);
			map.put("status", false);
		}
		return map;
	}
	
	@RequestMapping(value="/solar_detail/{microgrid_id}",method=RequestMethod.GET)
	public String solarDetail(){
		return "solar/solar_detail";
	}
	
	@RequestMapping(value="/get_solar_data",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> get_solar_data(HttpServletRequest req,@CookieValue("token") String token){
		Map<String,Object> map = new HashMap<String, Object>();
		String search_filter = req.getParameter("search_filter");
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);				
		if(search_filter.equals("week")){			
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");			
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Start_EndDate(microgrid_id,"solar","out",start_date,end_date);
			map.put("data", list);			
		}else if(search_filter.equals("month")){
			System.out.println(req.getParameter("year"));
			int month_no = Integer.parseInt(req.getParameter("month"));
			int year = Integer.parseInt(req.getParameter("year"));
			System.out.println(year);
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Month(microgrid_id,"solar","out",month_no, year);			
			map.put("data", list);						
		}else if(search_filter.equals("year")){
			int year_no = Integer.parseInt(req.getParameter("year"));			
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Year(microgrid_id,"solar","out",year_no);			
			map.put("data", list);					
		}
		return map;
	}
	
	@RequestMapping(value="/get_solar_data/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> get_solar_dataForMicroGridId(@PathVariable("id") String id,HttpServletRequest req,@CookieValue("token") String token){
		Map<String,Object> map = new HashMap<String, Object>();
		String search_filter = req.getParameter("search_filter");
		String microgrid_id = id;				
		if(search_filter.equals("week")){			
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");			
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Start_EndDate(microgrid_id,"solar","out",start_date,end_date);
			map.put("data", list);			
		}else if(search_filter.equals("month")){
			System.out.println(req.getParameter("year"));
			int month_no = Integer.parseInt(req.getParameter("month"));
			int year = Integer.parseInt(req.getParameter("year"));
			System.out.println(year);
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Month(microgrid_id,"solar","out",month_no, year);			
			map.put("data", list);						
		}else if(search_filter.equals("year")){
			int year_no = Integer.parseInt(req.getParameter("year"));			
			List<EnergyDetails> list = eds.findByMicrogrid_Id_PortCfg_State_Year(microgrid_id,"solar","out",year_no);			
			map.put("data", list);					
		}
		return map;
	}
	
	
	
	@RequestMapping(value="/get_ana_data", method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getAnalysisData(HttpServletRequest req, @CookieValue("token") String token){
		Map<String, Object> map = get_solar_data(req, token);
		String search_filter = req.getParameter("search_filter");
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		String station_id = null;
		if(microgrid_id != null){
			station_id = mgs.findByMicrogrid_Id(microgrid_id).getStation_id();
		}
		if (search_filter.equals("week")) {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			List<SolarService> solarServiceList = sService.findSolarServiceByStartAndEndDate(station_id, start_date, end_date);
			map.put("service", solarServiceList);
		} else if (search_filter.equals("month")) {
			int month_no = Integer.parseInt(req.getParameter("month"));
			int year = Integer.parseInt(req.getParameter("year"));					
			List<SolarService> solarServiceList = sService.findSolarServiceSpecificForMonth(station_id, month_no, year);			
			map.put("service", solarServiceList);					
		} else if (search_filter.equals("year")) {
			int year_no = Integer.parseInt(req.getParameter("year"));						
			List<SolarService> solarServiceList = sService.findSolarServiceSpecificForYear(station_id, year_no);			
			map.put("service", solarServiceList);
		}
		return map;
	}
}
