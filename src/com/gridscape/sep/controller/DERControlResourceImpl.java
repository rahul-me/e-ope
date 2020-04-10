package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERControlAPIService;
import com.gridscape.sep.application.DERControlResource;
import com.gridscape.sep.org.zigbee.sep.DERControl;

@Service
@Path("/derp/{derp_id}/derc/{derc_id}")
public class DERControlResourceImpl implements DERControlResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERControlAPIService derControlAPIService;
	
	@Override
	public DERControl GETDERControl(Long derpId, Long dercId) {
		if(isRequestContextIsSecure(request)){
			return derControlAPIService.GETDERControl(request, derpId, dercId);
		} else {
			return new DERControl();
		}
	}

	@Override
	public void HEADDERControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDERControl(DERControl dercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDERControl(DERControl dercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DERControl DELETEDERControl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isRequestContextIsSecure(HttpServletRequest request){
		return (request.getScheme().equalsIgnoreCase("https")) ? Boolean.TRUE : Boolean.FALSE;
	}

}

