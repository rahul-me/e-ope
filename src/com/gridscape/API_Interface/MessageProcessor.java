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
 
package com.gridscape.API_Interface;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.websocket.Session;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridscape.dao.BatteryDao;
import com.gridscape.dao.MicroGridDao;
import com.gridscape.helpers.MicroGridProfileHelper;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.CommandHistory;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.ErrorDetails;
import com.gridscape.model.MicroController;
import com.gridscape.model.MicroControllerStatus;
import com.gridscape.model.MicroGridProfile;
import com.gridscape.service.CommandHistoryService;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.ErrorDetailService;
import com.gridscape.service.MicroControllerStatusServices;
import com.gridscape.service.MicroGridProfileService;

@Service
public class MessageProcessor {

	@Autowired
	BatteryDao batteryDao; 
	
	@Autowired
	EnergyDetailService eds;
	
	@Autowired
	ErrorDetailService errorService;
	
	@Autowired	
	MicroControllerStatusServices microControllerStatusServices;
	
	@Autowired
	CommandHistoryService commandHistoryService;
	
	@Autowired
	MicroGridSessionManage microGridSessionManage;
	
	@Autowired
	MicroGridDao microGridDao;
	
	@Autowired
	MicroGridProfileService mgps;
	
	@Autowired
	CustomSecurityManager security_manager;
	
	final static Logger logger = Logger.getLogger(MessageProcessor.class.getName());	
	
	public void process(String message,String uri) throws IOException {
		Session session = microGridSessionManage.getCurentSession(uri);
		String ref_request_id = null;
		String init = null;
		logger.info(uri);
		 try {
			 logger.info(message);
			 String date_pattern = "yyyy-MM-dd'T'H:m:s'Z'";
			 SimpleDateFormat format = new SimpleDateFormat(date_pattern);
			 JSONObject obj = new JSONObject(message.toString());
			 String method = obj.get("m").toString();
			 String microgrid_id = obj.get("micro_grid_id").toString();
			 ref_request_id = obj.get("request_id").toString();
			 String ref_response_id = null;
			 if(!obj.isNull("ref_request_id")){
				 ref_response_id = obj.get("ref_request_id").toString();
			 }
			 init = obj.get("init").toString();
			 if(!uri.equalsIgnoreCase(microgrid_id)){
				String ack = "{\"status\":\"Invalid MicroGrid\",\"m\":\"400\",\"ref_request_id\":\""+ref_request_id+"\",\"init\":\""+init+"\"}"; 
				session.getBasicRemote().sendText(ack);
				logger.info(ack);		
				System.out.println("test");
			 }else{
				 String request_id = obj.get("request_id").toString();
				 String current_time = obj.get("current_time").toString();
				 Date eventtime = format.parse(current_time);
				 // update_date microgrid id
				 MicroController micro = microGridDao.findByMicroGridID(microgrid_id);
				 micro.setUpdated_at(new Date());
				 microGridDao.save(micro);
				 // end
				
				 if(method.equals("200")){
					 ObjectMapper mapper = new ObjectMapper();
					 if(!obj.isNull("battery")){
					 JSONObject entries = obj.getJSONObject("battery");
						 if(entries!=null){
							 BatteryStatus bs = mapper.readValue(entries.toString(),BatteryStatus.class);
							 BatteryStatus battery_status = batteryDao.findByMicrogridId(microgrid_id);
							 if(battery_status == null){
								 battery_status = new BatteryStatus(); 
							 }
							 battery_status.setStateOfCurrent((String)entries.get("soc"));
							 battery_status.setStateOfHelth((String)entries.get("soh"));
							 battery_status.setStatus((String)entries.get("state"));
							 battery_status.setState((String)entries.get("state"));
							 battery_status.setTemperature(entries.get("temperature").toString());
							 battery_status.setCurrent_c(bs.getCurrent_c());
							 battery_status.setWattage_w(bs.getWattage_w());
							 battery_status.setVoltage_v(bs.getVoltage_v());							 
							 battery_status.setMicrogrid_id(microgrid_id);						 
							 bs.setMicrogrid_id(microgrid_id);
							 batteryDao.save(battery_status);						 
							 this.save(entries, microgrid_id, mapper,eventtime);
							 
						 }	
					 }
					 if(!obj.isNull("port1")){
						 JSONObject solr= obj.getJSONObject("port1");
						 this.save(solr, microgrid_id, mapper,eventtime);
					 }
					 if(!obj.isNull("port2")){
						 JSONObject load= obj.getJSONObject("port2");
						 this.save(load, microgrid_id, mapper,eventtime);
					 }
					 if(!obj.isNull("port3")){
						 JSONObject grid= obj.getJSONObject("port3");
						 this.save(grid, microgrid_id, mapper,eventtime);
					 }
					 if(!obj.isNull("other_data")){
						 JSONArray other_data = obj.getJSONArray("other_data");
						 this.saveOtherData(other_data, microgrid_id, mapper,eventtime);
					 }				 
					 this.SendAckStatus(session,ref_request_id,init);
					 
				 }else if(method.equals("400")){
					 if(ref_response_id!=null){
						 CommandHistory commandObj = commandHistoryService.findByRequestId(ref_response_id);
						 if(commandObj==null){
							 commandObj = new CommandHistory();
						 }
						 commandObj.setState("Send Successfully");
						 commandHistoryService.Save(commandObj);
						 ErrorDetails errorDetails_ = errorService.findByErrorCodeAndRequestId(obj.getString("error_code"), obj.getString("request_id"));
						 boolean valid = true;
						 if(errorDetails_ != null){
							 String ack = "{\"status\":\"Duplicate request_id and error_code combination\",\"m\":\"400\",\"ref_request_id\":\""+obj.getString("request_id")+"\",\"init\":\"server\"}";
							 session.getBasicRemote().sendText(ack);
							 valid = false;
						 }
						 if(valid){
							 ErrorDetails errorDetails = errorService.findByErrorCodeAndRequestId(obj.getString("error_code"), obj.getString("ref_request_id"));
							 if(errorDetails != null){
								 if(errorDetails.getError_details() != null && errorDetails.getError_details() != "" && obj.getString("error_details").equalsIgnoreCase("ok") ){
									 errorDetails.setUpdated_at(new Date());
									 errorDetails.setStatus("resolved");
									 errorService.save(errorDetails);
								 }
								 
							 } else {
								 ErrorDetails error_obj = new ErrorDetails();
								 error_obj.setMicro_grid_id(microgrid_id);
								 String error_code = obj.get("error_code").toString();
								 error_obj.setError_code(error_code);
								 error_obj.setError_details(obj.get("error_details").toString());
								 error_obj.setRequest_id(request_id);
								 error_obj.setRef_request_id(obj.get("ref_request_id").toString());
								 error_obj.setInit_by(init);
								 error_obj.setEvent_time(obj.get("current_time").toString());
								 error_obj.setStatus("open");
								 errorService.save(error_obj);
							 } 
						 }						 						  						
					 }				 
				 }else if(method.equals("401")){
					 ObjectMapper mapper = new ObjectMapper();
					 CommandHistory commandHistory = mapper.readValue(message.toString(),CommandHistory.class);
					 CommandHistory commandHistoryDB = commandHistoryService.findByRequestId(obj.getString("ref_request_id"));
					 if(commandHistoryDB != null){
						 commandHistoryDB.setStatus_code(commandHistory.getStatus_code());
						 commandHistoryDB.setState(commandHistory.getStatus_details());
						 commandHistoryDB.setStatus_details(commandHistory.getStatus_details());
						 commandHistoryDB.setResponse_time(obj.get("current_time").toString());
						 commandHistoryDB.setResponse_id(obj.getString("request_id"));
						 commandHistoryDB.setInit(init);
						 commandHistoryService.Save(commandHistoryDB);	 
					 }else{
						 session.getBasicRemote().sendText("{\"status\":\"Invalid Refrance id\",\"code\":400}");
					 }
					 this.SendAckStatus(session,ref_request_id,init);
				 }else if(method.equals("201")){
					 ObjectMapper mapper = new ObjectMapper();
					 JSONObject entries = obj.getJSONObject("micro_grid_status");
					 MicroControllerStatus microControllerStatus = mapper.readValue(entries.toString(),MicroControllerStatus.class);
					 List<MicroControllerStatus> microControllerStatusDB =  microControllerStatusServices.findAllbyMicroGridId(microgrid_id);
					 if(microControllerStatusDB.size() > 0){
						 microControllerStatusDB.get(0).getId();
						 microControllerStatus.setId(microControllerStatusDB.get(0).getId());
						 microControllerStatus.setMicro_grid_id(microgrid_id);
						 microControllerStatusServices.Save(microControllerStatus);
					 }else{
						 microControllerStatus.setMicro_grid_id(microgrid_id);
						 microControllerStatusServices.Save(microControllerStatus);
					 }					
					 this.SendAckStatus(session,ref_request_id,init);
				 }else if(method.equals("501")){					
					 					 
					 this.SendAckStatus(session,ref_request_id,init);
					 
					 List<MicroGridProfile> mgpList = mgps.find_list_by_microgrid_id(microgrid_id);
					 MicroGridProfileHelper mgph = new MicroGridProfileHelper();
					 org.json.simple.JSONArray message_data = mgph.getListToJsonArray(mgpList);
					 CommandHistory ch = new CommandHistory();
					 ch.setMicro_grid_id(microgrid_id);
					 ch.setCommand_name("set profile");
					 SimpleDateFormat dateFormatGmt = new SimpleDateFormat(
							"yyyy-MM-dd'T'H:m:s'Z'");	
					 TimeZone tz = TimeZone.getTimeZone("UTC");
					 dateFormatGmt.setTimeZone(tz);
					 ch.setMessage(message_data.toString());					 
					 ch.setRequest_time(dateFormatGmt.format(new Date()));
					 ch.setRequest_id(security_manager.getReferenceCode());
					 
					 obj.put("m","500");
					 obj.put("micro_grid_id",microgrid_id);
					 obj.put("management_profile",message_data);
					 obj.put("init", "server");
					 obj.put("current_time", dateFormatGmt.format(new Date()));
					 obj.put("ref_request_id",request_id);
					 session.getBasicRemote().sendText(obj.toString()); 
					 ch.setState("Send");	
					 ch.setInit("server");
					 ch.setMethod_number("500");
					 commandHistoryService.Save(ch);
				 }
				// saveOrUpdateCommandHistory(message,method,microgrid_id,init,ref_request_id,current_time,commandName,"Command Received");
			 }	 
		}catch(Exception e){
			logger.error(e);		
			String ack = "{\"m\":\"400\",\"ref_request_id\":\""+ref_request_id+"\",\"status\":\""+e.getMessage()+"\",\"init\":\""+init+"\"}";
			session.getBasicRemote().sendText(ack);
			logger.info(ack);
		}
	}
/*	private void saveOrUpdateCommandHistory(String message, String method,
			String microgrid_id, String init, String ref_request_id,
			String current_time,String commandName,String status) {		
		CommandHistory chObj = commandHistoryService.findByRequestId(ref_request_id);
		if(chObj!=null){
			chObj.setState(status);
			chObj.setResponse_id(ref_request_id);			
			chObj.setResponse_time(current_time);
			chObj.setCommand_name(commandName);
			chObj.setInit(init);
			commandHistoryService.Save(chObj);
		}else{
			chObj = new CommandHistory();
			chObj.setMicro_grid_id(microgrid_id);
			chObj.setCommand_name(commandName);
			chObj.setMethod_number(method);
			chObj.setRequest_id(ref_request_id);
			chObj.setRequest_time(current_time);
			chObj.setMessage(message);
			chObj.setState(status);
			chObj.setInit(init);
			commandHistoryService.Save(chObj);
		}
	}*/
	public void SendAckStatus(Session session,String ref_request_id,String init) throws IOException{
		String ack = "{\"status\":\"Success\",\"m\":\"200\",\"ref_request_id\":\""+ref_request_id+"\",\"init\":\""+init+"\"}";
		session.getBasicRemote().sendText(ack);	
		logger.info(ack);
	}
	public EnergyDetails save(JSONObject jobj,String microgrid_id,ObjectMapper mapper,Date eventtime) throws JsonParseException, JsonMappingException, IOException{	
		EnergyDetails ed = null;
		if(jobj!=null){			 
			 ed = mapper.readValue(jobj.toString(),EnergyDetails.class);
			 if(ed.getKwh()==null || ed.getKwh() == ""){
				 ed.setKwh("0"); 
			 }
			 ed.setMicrogrid_id(microgrid_id);
			 ed.setEvent_time(eventtime);
			 ed.setJson_string(jobj.toString());
			 eds.save(ed);
		}
		return ed;	
	}
	public EnergyDetails saveOtherData(JSONArray jobj,String microgrid_id,ObjectMapper mapper,Date eventtime) throws JsonParseException, JsonMappingException, IOException, JSONException{
		  EnergyDetails ed = null;
		  JSONObject grid = null;
		  JSONObject renewable = null;
		  JSONObject load = null;
		  List<JSONObject> jArray = new ArrayList<JSONObject>();
		  if(jobj!= null){
			  for(int i=0;i<jobj.length();i++){
				 JSONObject data = jobj.getJSONObject(i);
				 if(data.get("port_cfg").equals("grid")){
					 grid = data;
					 jArray.add(data);
				 }else if (data.get("port_cfg").equals("renewable")){
					 renewable = data;
					 jArray.add(data);
				 }else if(data.get("port_cfg").equals("load")){
					 load = data;					
				 }else{
					 
					 jArray.add(data);
				 }
			  }
			  if(grid != null && renewable != null){
				  Float g_voltage_v =   Float.parseFloat((String) grid.get("voltage_v"));
				  Float g_wattage_w = Float.parseFloat((String) grid.get("wattage_w"));
				  Float g_kwh = Float.parseFloat((String) grid.get("kwh"));
				  Float g_current_c = Float.parseFloat((String)  grid.get("current_c"));
				  
				  Float r_voltage_v = Float.parseFloat((String) renewable.get("voltage_v"));
				  Float r_wattage_w = Float.parseFloat((String)  renewable.get("wattage_w"));
				  Float r_kwh = Float.parseFloat((String) renewable.get("kwh"));
				  Float r_current_c = Float.parseFloat((String) renewable.get("current_c"));
				  Float voltage_v = g_voltage_v + r_voltage_v;
				  Float wattage_w = g_wattage_w + r_wattage_w;
				  Float current_c = g_current_c + r_current_c;
				  
				  String state = (String) grid.get("state");
				  if(state.equalsIgnoreCase("in")){
					  g_kwh = - g_kwh;
					  if(voltage_v > 0){
						  voltage_v = voltage_v  - g_voltage_v - g_voltage_v;
					  }				 
					  if(wattage_w > 0){
						  wattage_w = wattage_w - g_wattage_w - g_wattage_w;
					  }				
					  if(current_c > 0){
						  current_c = current_c - g_current_c - g_current_c;
					  }  
				  }				  
				  load.put("voltage_v",String.format("%.6f", voltage_v));
				  load.put("wattage_w",String.format("%.6f", wattage_w));
				  load.put("kwh",String.format("%.6f", (g_kwh + r_kwh)));
				  load.put("state","in");
				  load.put("current_c",String.format("%.6f", current_c));
				  jArray.add(load);	 
			  }			 
			  			  
			 for(int i=0;i<jArray.size();i++){
		     JSONObject data = jArray.get(i);		     
		     ed = mapper.readValue(data.toString(),EnergyDetails.class);
		     ed.setMicrogrid_id(microgrid_id);
		     ed.setEvent_time(eventtime);
		     ed.setJson_string(data.toString());
		     if (((String)data.get("port_cfg")).equalsIgnoreCase("battery")){
		      BatteryStatus bs = mapper.readValue(data.toString(),BatteryStatus.class);
		      BatteryStatus battery_status = batteryDao.findByMicrogridId(microgrid_id);
		      if(battery_status == null){
		       battery_status = new BatteryStatus(); 
		      }
		      battery_status.setStateOfCurrent((String)data.get("soc"));
		      battery_status.setStateOfHelth((String)data.get("soh"));
		      battery_status.setStatus((String)data.get("state"));
		      battery_status.setState((String)data.get("state"));
		      battery_status.setTemperature(data.get("temperature").toString());
		      battery_status.setCurrent_c(bs.getCurrent_c());
		      battery_status.setWattage_w(bs.getWattage_w());
		      battery_status.setVoltage_v(bs.getVoltage_v());        
		      battery_status.setMicrogrid_id(microgrid_id);       
		      bs.setMicrogrid_id(microgrid_id);
		      batteryDao.save(battery_status); 
		     }
		     eds.save(ed);
		    }    
		   }
		  return ed; 
		 }
}
