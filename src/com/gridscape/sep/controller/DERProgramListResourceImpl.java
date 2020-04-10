package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.sep.api.service.DERProgramAPIService;
import com.gridscape.sep.application.DERProgramListResource;
import com.gridscape.sep.org.zigbee.sep.DERProgram;
import com.gridscape.sep.org.zigbee.sep.DERProgramList;

@org.springframework.stereotype.Service
@Path("/derp")
public class DERProgramListResourceImpl implements DERProgramListResource {
	
	
	
	@Autowired
	private DERProgramAPIService derProgramAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public DERProgramList GETDERProgramList(Long deviceId, Integer s, Integer l) {	
		return (request.getScheme().equalsIgnoreCase("https")) ? derProgramAPIService.getDERProgramList(request, deviceId) : new DERProgramList();		
	}

	@Override
	public void HEADDERProgramList() {
		
	}

	@Override
	public void PUTDERProgramList(DERProgram derprogram) {
		
	}

	@Override
	public void POSTDERProgramList(DERProgram derprogram) {
		
	}

	@Override
	public void DELETEDERProgramList() {
		
	}
}

