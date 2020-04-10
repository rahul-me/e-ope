package com.gridscape.sep.controller;



import javax.ws.rs.Path;

import org.springframework.stereotype.Service;

import com.gridscape.sep.application.NotificationResource;
import com.gridscape.sep.org.zigbee.sep.Notification;


@Service
@Path("/test/me")
public class TestImpl implements NotificationResource {

	@Override
	public Notification GETNotification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void HEADNotification() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTNotification(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTNotification(Notification notification) {
		System.out.println("test me");
		
	}

	@Override
	public void DELETENotification() {
		// TODO Auto-generated method stub
		
	}

}

