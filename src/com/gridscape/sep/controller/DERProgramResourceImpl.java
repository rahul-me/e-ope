package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERProgramAPIService;
import com.gridscape.sep.application.DERProgramResource;
import com.gridscape.sep.org.zigbee.sep.DERProgram;

@Service
@Path("/derp/{id}")
public class DERProgramResourceImpl implements DERProgramResource {
	
	@Context
	private HttpServletRequest request; 
	
	@Autowired
	private DERProgramAPIService derProgramApiService;
	
	@Override
	public DERProgram GETDERProgram(String id) {
		return (request.getScheme().equalsIgnoreCase("https")) ? derProgramApiService.getDerProgram(request,Long.parseLong(id)) : new DERProgram();		
	}

	@Override
	public void HEADDERProgram() {
		
		
	}

	@Override
	public void PUTDERProgram(DERProgram derprogram) {
		
		
	}

	@Override
	public void POSTDERProgram(DERProgram derprogram) {
		
		
	}

	@Override
	public DERProgram DELETEDERProgram() {
	
		return null;
	}

}

