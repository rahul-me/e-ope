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
 
  
  
package com.gridscape.helpers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.gridscape.jsoninput.ProfileMessage;
import com.gridscape.model.MicroGridProfile;

public class MicroGridProfileHelper {

	@SuppressWarnings("unchecked")
	public JSONArray getListToJsonArray(List<MicroGridProfile> mgpList) throws JSONException{
		JSONArray jsonArray = new JSONArray();
		for(MicroGridProfile objMgp:mgpList){
			 JSONObject formDetailsJson = new JSONObject();
			 formDetailsJson.put("start_time", objMgp.getStart_time());
			 formDetailsJson.put("end_time", objMgp.getEnd_time());
			 formDetailsJson.put("battery_low_threshold",objMgp.getBattery_low_threshold());
			 formDetailsJson.put("critical_situation",objMgp.getCritical_situation());
			 formDetailsJson.put("solar_low",objMgp.getSolar_low());
			 formDetailsJson.put("standard_situation",objMgp.getStandard_situation());
			 formDetailsJson.put("battery_low",objMgp.getBattery_low());
			 formDetailsJson.put("battery_charge_source",objMgp.getBattery_charge_source());
			 formDetailsJson.put("battery_high_threshold", objMgp.getBattery_soc());
			 jsonArray.add(formDetailsJson);
		}
		return jsonArray;
	}
	
	public JSONArray getJSONOfProfileMessage(ProfileMessage objMgp){
		JSONArray jsonArray = new JSONArray();
		try {			
			
			JSONObject formDetailsJson = new JSONObject();
			 formDetailsJson.put("start_time", objMgp.getStart_time());
			 formDetailsJson.put("end_time", objMgp.getEnd_time());
			 formDetailsJson.put("battery_low_threshold",objMgp.getBattery_low_threshold());
			 formDetailsJson.put("critical_situation",objMgp.getCritical_situation());
			 formDetailsJson.put("solar_low",objMgp.getSolar_low());
			 formDetailsJson.put("standard_situation",objMgp.getStandard_situation());
			 formDetailsJson.put("battery_low",objMgp.getBattery_low());
			 formDetailsJson.put("battery_charge_source",objMgp.getBattery_charge_source());
			 jsonArray.add(formDetailsJson);
		} catch(Exception e){
			e.printStackTrace();
		}
		return jsonArray;
	}
}
