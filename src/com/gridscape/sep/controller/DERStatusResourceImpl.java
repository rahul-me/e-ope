package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERStatusAPIService;
import com.gridscape.sep.application.DERStatusResource;
import com.gridscape.sep.org.zigbee.sep.DERStatus;

@Service
@Path("/edev/{endDeviceId}/der/{derId}/ders")
public class DERStatusResourceImpl implements DERStatusResource {
	
	@Context
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private DERStatusAPIService derStatusAPIService;
	
	@Override
	public DERStatus GETDERStatus(Long endDeviceId, Long derId) {
		return (httpServletRequest.getScheme().equalsIgnoreCase("https")) ? derStatusAPIService.GETDERStatus(httpServletRequest,endDeviceId, derId) : new DERStatus();
	}

	@Override
	public void HEADDERStatus() {
		
	}

	@Override
	public void PUTDERStatus(DERStatus derstatus, Long endDeviceId, Long derId) {
		if(httpServletRequest.getScheme().equalsIgnoreCase("https")) {
			derStatusAPIService.PUTDERStatus(httpServletRequest, derstatus, endDeviceId, derId);
		}
	}

	@Override
	public void POSTDERStatus(DERStatus derstatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEDERStatus() {
		// TODO Auto-generated method stub
		
	}

}

