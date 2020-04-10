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
 
  
  
package com.gridscape.scheduler;

import java.util.Date;
import java.util.Map;

import javax.websocket.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import com.gridscape.API_Interface.MicroGridSessionManage;
import com.gridscape.dao.MicroGridDao;
import com.gridscape.helpers.Parameters;
import com.gridscape.helpers.Utility;
import com.gridscape.model.MicroController;

@Configuration
@EnableScheduling
@Service
public class SessionTimeOutScheduler {
	
	final static Logger logger = Logger.getLogger(SessionTimeOutScheduler.class);	

	@Autowired
	MicroGridDao mgd;
	
	@Autowired
	MicroGridSessionManage mgsession;
	
	@Scheduled(fixedRate = 1000000)
	public void printMessage() {
		Map<String,Session> session = mgsession.getAllSession();
		for (Map.Entry<String, Session> entry : session.entrySet()) {
		    String key = entry.getKey();
		    MicroController micro = mgd.findByMicrogrid_Id(key);
		    long diffmin = Utility.getDateDiffInMin(micro.getUpdated_at(),new Date());
		    logger.info("diff min = "+diffmin);
		    logger.info("Session time out parameter = "+Parameters.getSessionTimeOut());
		    System.out.println("diff min = "+diffmin);
		    System.out.println("Session time out parameter = "+Parameters.getSessionTimeOut());
		    if(diffmin>Parameters.getSessionTimeOut()){
		    	System.out.println("delete session");
		    	System.out.println("key ="+key);
		    	mgsession.RemoveSession(key,null);
		    }
		}
	}	
}
