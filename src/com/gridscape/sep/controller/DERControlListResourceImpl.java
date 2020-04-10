package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERControlAPIService;
import com.gridscape.sep.application.DERControlListResource;
import com.gridscape.sep.org.zigbee.sep.DERControl;
import com.gridscape.sep.org.zigbee.sep.DERControlList;

@Service
@Path("/derp/{derp_id}/derc")
public class DERControlListResourceImpl implements DERControlListResource{
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERControlAPIService derControlAPIService;

	@Override
	public DERControlList GETDERControlList(Integer s, Integer a, Integer l, Long derpId) {
		if(isRequestContextIsSecure(request)){
			return derControlAPIService.GETDERControlList(request,derpId);
		} else {
			return new DERControlList();
		}
	}

	@Override
	public void HEADDERControlList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDERControlList(DERControl dercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDERControlList(DERControl dercontrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEDERControlList() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isRequestContextIsSecure(HttpServletRequest request){
		return (request.getScheme().equalsIgnoreCase("https")) ? Boolean.TRUE : Boolean.FALSE;
	}

}

