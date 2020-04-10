package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.MirrorUsagePointAPIService;
import com.gridscape.sep.application.MirrorUsagePointListResource;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePointList;

@Service
@Path("/mup")
public class MirrorUsagePointListResourceImpl implements MirrorUsagePointListResource {
	
	@Autowired
	private MirrorUsagePointAPIService mirrorUsageAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	@Override
	public MirrorUsagePointList GETMirrorUsagePointList(Integer s, Integer l) {		
		return (isSecureScheme(request)) ? mirrorUsageAPIService.GETMirrorUsagePointList(request) : new MirrorUsagePointList();	
	}

	@Override
	public void HEADMirrorUsagePointList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTMirrorUsagePointList(MirrorUsagePoint mirrorusagepoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Response POSTMirrorUsagePointList(MirrorUsagePoint mirrorusagepoint) {
		if(isSecureScheme(request)){
			
		} else {
			
		}
		return mirrorUsageAPIService.POSTMirrorUsagePointList(request,response,mirrorusagepoint);
		
	}

	@Override
	public void DELETEMirrorUsagePointList() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isSecureScheme(HttpServletRequest request){
		return (request.getScheme().equalsIgnoreCase("https")) ? true : false;
	}

}

