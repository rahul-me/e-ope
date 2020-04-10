package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Constant;
import com.gridscape.sep.api.service.DERCapabilityAPIService;
import com.gridscape.sep.application.DERCapabilityResource;
import com.gridscape.sep.org.zigbee.sep.DERCapability;

@Service
@Path("/edev/{edevId}/der/{derId}/dercap")
public class DERCapabilityResourceImpl implements DERCapabilityResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERCapabilityAPIService dercapAPIService;
	
	@Override
	public DERCapability GETDERCapability(Long edevId, Long derId) {
		return (isSchemeSecure()) ? dercapAPIService.GETDERCapability(request, edevId, derId) : new DERCapability() ;
	}

	@Override
	public void HEADDERCapability() {
		
	}

	@Override
	public void PUTDERCapability(DERCapability dercapability, Long edevId, Long derId) {
		if(isSchemeSecure()){
			
		}
		dercapAPIService.PUTDERCapability(request, dercapability, edevId, derId);
	}

	@Override
	public void POSTDERCapability(DERCapability dercapability) {
		
	}

	@Override
	public void DELETEDERCapability() {
		
	}
	
	private boolean isSchemeSecure(){
		return (request.getScheme().equalsIgnoreCase(Constant.HTTPS)) ? true : false;
	}

}

