package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERAPIService;
import com.gridscape.sep.application.DERResource;
import com.gridscape.sep.org.zigbee.sep.DER;

@Service
@Path("/edev/{endDeviceId}/der/{derId}")
public class DERResourceImpl implements DERResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERAPIService derAPIService;
	
	@Override
	public DER GETDER(Long endDeviceId, Long derId) {
		return (request.getScheme().equalsIgnoreCase("https")) ? derAPIService.GETDER(request, endDeviceId, derId) : new DER();
	}

	@Override
	public void HEADDER() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDER(DER der) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDER(DER der) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DER DELETEDER() {
		// TODO Auto-generated method stub
		return null;
	}

}

