package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERControlAPIService;
import com.gridscape.sep.application.DefaultDERControlResource;
import com.gridscape.sep.org.zigbee.sep.DefaultDERControl;

@Service
@Path("/derp/{derpId}/dderc")
public class DefaultDERControlResourceImpl implements DefaultDERControlResource {
	
	@Autowired
	private DERControlAPIService derControlAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public DefaultDERControl GETDefaultDERControl(Long derpId) {
		return derControlAPIService.GETDefaultDERControl(request, derpId);
	}

	@Override
	public void HEADDefaultDERControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDefaultDERControl(DefaultDERControl defaultdercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDefaultDERControl(DefaultDERControl defaultdercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEDefaultDERControl() {
		// TODO Auto-generated method stub
		
	}

}

