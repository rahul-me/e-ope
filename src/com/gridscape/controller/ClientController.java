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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gridscape.jsoninput.ClientInput;
import com.gridscape.model.EnergyDetails;
import com.gridscape.service.EnergyDetailService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	EnergyDetailService eds;
	
//	@RequestMapping(value="/index",method=RequestMethod.GET)
//	public String index(){
//		return "client/index";
//	}
	
	@RequestMapping(value="/getdata",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> getResponse(@RequestBody ClientInput obj){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
	        DefaultHttpClient Client = new DefaultHttpClient();
	        Client.getCredentialsProvider().setCredentials(
	                AuthScope.ANY,
	                new UsernamePasswordCredentials(obj.getUserName(),obj.getPassword())
	        );

	        HttpGet httpGet = new HttpGet(obj.getUrl());
	        HttpResponse response = Client.execute(httpGet);

	        BufferedReader breader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	        StringBuilder responseString = new StringBuilder();
	        String line = "";
	        while ((line = breader.readLine()) != null) {
	            responseString.append(line);	            
	        }
	        breader.close();
	        String responseStr = responseString.toString();
	        map.put("data", responseStr);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		map.put("status", true);
		return map;
	}
	
	@RequestMapping(value="dummy_data",method=RequestMethod.GET)
	public String dummyData(){
		return "client/dummy_data";
	}
	
	@RequestMapping(value="save_dummy_data",method=RequestMethod.GET)
	@ResponseBody public void saveDummyData(HttpServletRequest req){
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String microgrid_id = req.getParameter("microgrid_id");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
	        Date s_date = df.parse(start_date);
	        Date e_date = df.parse(end_date);
	        int days = getDiffDay(s_date,e_date);
	        for(int i=0;i<days;i++){
	        	for(int j=0;j<24*2;j++){	        		
	        		saveDummy(s_date, microgrid_id,"solar");
	        		saveDummy(s_date, microgrid_id,"grid");
	        		saveDummy(s_date, microgrid_id,"load");
	        		saveDummy(s_date, microgrid_id,"battery");
	        		Calendar cal = Calendar.getInstance();
			        cal.setTime(s_date);
			        cal.add(Calendar.MINUTE, 30);
			        String newTime = df.format(cal.getTime());
			        System.out.println(newTime+" random float = "+randomFloat(0.0f,4.0F));
			        s_date = df.parse(newTime);			        
	        	}	        	
	        }	       	       
	    }
	    catch ( Exception ex ){
	        System.out.println(ex);
	    }
		
	}
	
	public void saveDummy(Date s_date,String microgrid_id,String port_cfg){
		EnergyDetails ed = new EnergyDetails();
        ed.setEvent_time(s_date);
        ed.setCurrent_c(randomFloat(0.0f,10.0F).toString());        
        ed.setMicrogrid_id(microgrid_id);
        ed.setPort_cfg(port_cfg);
        if(port_cfg.equals("load")){
        	ed.setState("in");
        	ed.setKwh(randomFloat(15.0f,20.0F).toString());
        	ed.setWattage_w(randomFloat(1000.0f,10000.0F).toString());          	
        }else if(port_cfg.equals("solar")){
        	ed.setState("out");
        	ed.setKwh(randomFloat(15.0f,20.0F).toString());
        	ed.setWattage_w(randomFloat(1000.0f,10000.0F).toString());
        }else if(port_cfg.equals("grid")){
        	ed.setState("out");
        	ed.setKwh(randomFloat(15.0f,20.0F).toString());
        	ed.setWattage_w(randomFloat(1000.0f,10000.0F).toString());
        }else if(port_cfg.equals("battery")){
        	if(rendomInt()==1){
        		ed.setState("charging");
        	}else{
        		ed.setState("discharging");
        	}        	
        	ed.setSoc(randomFloat(0.0f, 100.0F).toString());
        	ed.setSoh("100");
        	ed.setTemperature("0.0");
        }
        ed.setVoltage_v(randomFloat(100.0f, 1000.0F).toString());        
        eds.save(ed);
        ed = null;
	}
	
	public int getDiffDay(Date start_date,Date end_date){
		int days = 0;
		try{
			/*long diff = end_date.getTime() - start_date.getTime();
	        long diffSeconds = diff / 1000 % 60;
	        long diffMinutes = diff / (60 * 1000) % 60;
	        long diffHours = diff / (60 * 60 * 1000);*/
	        days = (int) ((end_date.getTime() - start_date.getTime()) / (1000 * 60 * 60 * 24));
		}catch(Exception e){
			
		}
		return days;		
	}
	
	public Float randomFloat(float min,float max){
		Float r = 0.0f;
		Random rand = new Random();
		r = rand.nextFloat() * (max - min) + min;
		return r;
	}
	public int rendomInt(){
		Random rand = new Random();
		int r = rand.nextInt() * (2 - 1) + 1;
		return r;
	}
}
