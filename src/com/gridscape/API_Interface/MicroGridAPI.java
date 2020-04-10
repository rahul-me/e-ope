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
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.server.standard.SpringConfigurator;

@ServerEndpoint(value = "/services/microGridAPI/{microGridIdentity}",configurator = SpringConfigurator.class)
public class MicroGridAPI {

	private static final Logger LOG = Logger.getLogger(MicroGridAPI.class.getName());
	@Autowired
	MessageProcessor mp;	
	@Autowired
	MicroGridSessionManage micro_grid_mg;
	@OnMessage
	public void onMessage(String message, Session session, @PathParam("microGridIdentity") String microGridIdentity) throws IOException {
		 LOG.info(microGridIdentity+ " message recevie="+message);
		 mp.process(message,microGridIdentity);
	}

	@OnOpen
	public void onOpen(Session session, @PathParam("microGridIdentity") String microGridIdentity) {
		LOG.info("Client connected="+microGridIdentity);
		micro_grid_mg.setNewSession(microGridIdentity, session);
	}

	@OnClose
	public void onClose(Session session, @PathParam("microGridIdentity") String microGridIdentity) {
		LOG.info("Client disconnected="+microGridIdentity);
		micro_grid_mg.RemoveSessionMap(microGridIdentity, session);
	}	
	
	@OnMessage
	public void onPong(PongMessage pongMessage,@PathParam("microGridIdentity") String microGridIdentity) {
		System.out.println(microGridIdentity);
		LOG.info("Pong receive ="+microGridIdentity);		
	}
}
