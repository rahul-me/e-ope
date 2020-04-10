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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridscape.API_Interface.MicroGridSessionManage;
import com.gridscape.helpers.MicroGridProfileHelper;
import com.gridscape.helpers.Utility;
import com.gridscape.jsoninput.ProfileMessage;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.CommandHistory;
import com.gridscape.model.MicroController;
import com.gridscape.model.MicroGridProfile;
import com.gridscape.service.CommandHistoryService;
import com.gridscape.service.MicroGridProfileService;
import com.gridscape.service.MicroGridService;

@Controller
@RequestMapping("/command")
public class CommandController extends MicroGridProfileHelper{
	@Autowired
	CommandHistoryService commandHistoryService;
	@Autowired
	CustomSecurityManager security_manager;
	@Autowired
	MicroGridSessionManage microGridSessionManage;
	
	@Autowired
	MicroGridProfileService mgps;
	
	@Autowired
	private MicroGridService microGridService;
	
	SimpleDateFormat dateFormatGmt = new SimpleDateFormat(
			"yyyy-MM-dd'T'H:m:s'Z'");
	

	@RequestMapping(value = "/send", method = RequestMethod.GET)	
	@ResponseBody public Map<String, Object> sendMessage(@RequestParam Map<String, String> input){
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));	
		Map<String, Object> map = new HashMap<String, Object>();
		CommandHistory ch = new CommandHistory();
		ch.setCommand_name(input.get("mode"));
		ch.setRequest_time(dateFormatGmt.format(new Date()));
		String microgrid_id = input.get("microgrid_id"); 
		Session session = microGridSessionManage.getCurentSession(microgrid_id);
		JSONObject obj = new JSONObject();
		String request_id = security_manager.getReferenceCode();
		ch.setRequest_id(request_id);
		ch.setMicro_grid_id(microgrid_id);
		ch.setInit("server");
		
		try {
			String mode = input.get("mode"); 
			System.out.println(mode);
			if(mode.equals("islanding")){
				obj.put("m","300");
				ch.setMethod_number("300");
			}else if(mode.equals("chargebatteryfromgrid")){
				obj.put("m","301");
				ch.setMethod_number("301");
			}else if(mode.equals("chargebatteryfromsolar")){
				obj.put("m","302");
				ch.setMethod_number("302");
			}else if(mode.equals("dischargebattery")){
				obj.put("m","303");
				ch.setMethod_number("303");
			}else if(mode.equals("userstop")){
				obj.put("m","304");
				ch.setMethod_number("304");
			}
			obj.put("micro_grid_id",input.get("microgrid_id"));
			obj.put("command_name", input.get("mode"));			
			obj.put("init", "server");
			TimeZone tz = TimeZone.getTimeZone("UTC");
			dateFormatGmt.setTimeZone(tz);
			obj.put("current_time", dateFormatGmt.format(new Date()));
			obj.put("request_id",request_id);
			obj.put("message","");
				if(session != null){
					ch.setState("in process");	
					//String data = "testing connection";
					//Charset charset = Charset.forName("UTF-8");
					//CharsetEncoder encoder = charset.newEncoder();					
					//session.getBasicRemote().sendPong(encoder.encode(CharBuffer.wrap(data)));					
					session.getBasicRemote().sendText(obj.toString());
					ch.setMessage(obj.toString());
				}else{
					ch.setState("Send fails");
				}
		} catch (IOException e) {
			ch.setState("Send fails");
			e.printStackTrace();
		} catch (JSONException e) {
			ch.setState("Send fails");
			e.printStackTrace();
		}
		commandHistoryService.Save(ch);
		map.put("status", "Success");	
		return map;
	}
	
	@RequestMapping(value="/set_profile",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> set_profile(@RequestParam Map<String, String> input){
		Map<String, Object> map = new HashMap<String, Object>();
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));	
		String microgrid_id = input.get("microgrid_id"); 
		CommandHistory ch = new CommandHistory();
		ch.setMicro_grid_id(microgrid_id);
		ch.setCommand_name("set profile");
		ch.setRequest_time(dateFormatGmt.format(new Date()));			
		String request_id = security_manager.getReferenceCode();
		ch.setRequest_id(request_id);
		try{
			JSONObject obj = new JSONObject();
			List<MicroGridProfile> mgpList = mgps.find_list_by_microgrid_id(microgrid_id);
			org.json.simple.JSONArray jsonArray = this.getListToJsonArray(mgpList);
			ch.setMessage(jsonArray.toString());
			obj.put("m","500");
			obj.put("micro_grid_id",microgrid_id);
			obj.put("management_profile",jsonArray);
			obj.put("init", "server");
			TimeZone tz = TimeZone.getTimeZone("UTC");
			dateFormatGmt.setTimeZone(tz);
			obj.put("current_time", dateFormatGmt.format(new Date()));
			obj.put("request_id",request_id);
			Session session = microGridSessionManage.getCurentSession(microgrid_id);
			if(session != null){		
				ch.setState("in process");	
				session.getBasicRemote().sendText(obj.toString());
			}else{
				System.out.println("session null");
				ch.setState("Send fails");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		commandHistoryService.Save(ch);
		map.put("status", "Success");	
		return map;
	}
	
	@RequestMapping(value="/action/{id}",method=RequestMethod.GET)
	public String actionCommand(@PathVariable("id")String id){
		return "/command/action";
	}
	
	@RequestMapping(value="/history/{id}",method=RequestMethod.GET)
	public String commandHistory(@PathVariable("id")String id){
		return "/command/history";
	}
	
	@RequestMapping(value="/gethistorylist",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getHistoryList(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = Utility.getMicrogrid_idByCookie(req);
		if(microgrid_id!=null){
			List<CommandHistory> list = commandHistoryService.findAllbyMicroGridId(microgrid_id);			
			map.put("data", list);
		}else{
			map.put("data", null);
		}
		return map;
	}
	
	@RequestMapping(value = "/sendProfile", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sendProfile(@RequestParam Map<String, String> input) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if (input != null) {
				String microGridId = input.get("microgrid_id");
				String message = input.get("message");
				String caseType = input.get("caseType");
				
				
				//save data to command history
				
				CommandHistory ch = new CommandHistory();
				ch.setMicro_grid_id(microGridId);
				ch.setCommand_name("set profile");
				ch.setRequest_time(dateFormatGmt.format(new Date()));
				if(caseType.equalsIgnoreCase("casefive")){
					ch.setMethod_number("300");					
				} else {
					ch.setMethod_number("500");
				}
				
				JSONArray jsonArray = null;
				if(!caseType.equalsIgnoreCase("casefive")){
					ObjectMapper om = new ObjectMapper();
					ProfileMessage profileMessage = om.readValue(message, ProfileMessage.class);
					profileMessage.setStart_time("00:00:00");
					profileMessage.setEnd_time("23:59:59");
					jsonArray = this.getJSONOfProfileMessage(profileMessage);
				}
				
				
				 
				MicroController microController = microGridService.findByMicrogrid_Id(microGridId); 
				
				// time zone specific manipulation
				String time_zone[] = microController.getTime_zone().toString().split("##");
				String sign_val = time_zone[0].substring(0,1);
				System.out.println("sing val = "+sign_val);
				String hr_min[] = time_zone[0].split(":");
				int hrs = Integer.parseInt(hr_min[0]);
				int min = Integer.parseInt(hr_min[1]);
				System.out.println("hr = "+hrs+" min = "+min);	
				int time_zone_val = ((hrs*60)+min)*60;
				//done
				
				String requestId = security_manager.getReferenceCode();
				ch.setRequest_id(requestId);
				
				try {
					JSONObject obj = new JSONObject();
					if(caseType.equalsIgnoreCase("casefive")){
						obj.put("m", "300");
						obj.put("command_name", "I-Landing");
						obj.put("message", "");
					} else {
						obj.put("m", "500");
						obj.put("management_profile", jsonArray);
						obj.put("time_zone",Integer.toString(time_zone_val));
					}					
					obj.put("micro_grid_id", microGridId);
					
					obj.put("init", "server");
					
					obj.put("current_time", dateFormatGmt.format(new Date()));
					obj.put("request_id",requestId);
					
					
					//send to controller
					Session session = microGridSessionManage.getCurentSession(microGridId);
					if(session != null){
						ch.setState("in process");
						session.getBasicRemote().sendText(obj.toString());
						ch.setState("SENT");
					}else{
						System.out.println("session null");
						response.put("status", "fail");
						response.put("reason", "controller is not connected to system");
					}
				} catch(Exception e){
					e.printStackTrace();
				}
				commandHistoryService.Save(ch);
			} else {
				response.put("status", "failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}
