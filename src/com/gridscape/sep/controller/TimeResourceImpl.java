package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.sep.api.service.TimeResourceAPIService;
import com.gridscape.sep.application.TimeResource;
import com.gridscape.sep.org.zigbee.sep.Time;	
@Path("/tm")
public class TimeResourceImpl implements TimeResource{
	
	@Autowired
	private TimeResourceAPIService timeResourceAPIService;
	
	@Context
	private HttpServletRequest request;

	@Override	
	public Time GETTime() {
		return (request.getScheme().equalsIgnoreCase("https")) ? timeResourceAPIService.GETTime(request) : new Time();		
	}

	@Override
	public void HEADTime() {
		System.out.println("head method @HEAD");
		
	}

	@Override
	public void PUTTime(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTTime(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETETime() {
		// TODO Auto-generated method stub
		
	}
}

