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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.dao.MicroGridDao;
import com.gridscape.model.MicroController;
	
@Component
public class MicroGridSessionManage {
	
	@Autowired
	MicroGridDao microGridDao;
	
	private static Map<String,Session> session;
	
	public MicroGridSessionManage(){
		session = new HashMap<String, Session>();
	}
	public Session getCurentSession(String microID){
		return session.get(microID);
	}
	public Map<String,Session>  getAllSession(){
		return session;
	}
	public String setNewSession(String microID,Session sessioninput){
		MicroController micro = microGridDao.findByMicroGridID(microID);		
		if(micro != null && micro.getMicrogrid_id().equalsIgnoreCase(microID)){
			micro.setUpdated_at(new Date());
			microGridDao.save(micro);
			Session sessionout = session.get(microID);
			if(sessionout == null){
				session.put(microID, sessioninput);
			}else{
				try {
					sessionout.close();
					session.put(microID, sessioninput);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	   return "";
	}
	public String RemoveSession(String microID,Session sessioninput){
		
		Session sessionout = session.get(microID);
		if(sessionout == null){
			session.remove(microID);
		}else{
			try {				
				session.remove(microID);
				sessionout.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";	
	}
	public String RemoveSessionMap(String microID,Session sessioninput){
		
		Session sessionout = session.get(microID);
		if(sessionout == null){
			session.remove(microID);
		}else{
			try {
				session.remove(microID);		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";	
	}
}
