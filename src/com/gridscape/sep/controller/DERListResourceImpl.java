package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERAPIService;
import com.gridscape.sep.application.DERListResource;
import com.gridscape.sep.org.zigbee.sep.DER;
import com.gridscape.sep.org.zigbee.sep.DERList;

@Service
@Path("/edev/{endDeviceId}/der")
public class DERListResourceImpl implements DERListResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERAPIService derAPIService;
	
	@Override
	public DERList GETDERList(Integer s, Integer l, Long endDeviceId) {
		return (request.getScheme().equalsIgnoreCase("https")) ? derAPIService.GETDERList(request, endDeviceId) : new DERList();
	}

	@Override
	public void HEADDERList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDERList(DER der) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDERList(DER der) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEDERList() {
		// TODO Auto-generated method stub
		
	}

}

