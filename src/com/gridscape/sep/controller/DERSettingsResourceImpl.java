package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Constant;
import com.gridscape.sep.api.service.DERSettingsAPIService;
import com.gridscape.sep.application.DERSettingsResource;
import com.gridscape.sep.org.zigbee.sep.DERSettings;

@Service
@Path("/edev/{edevId}/der/{derId}/derg")
public class DERSettingsResourceImpl implements DERSettingsResource {
	
	@Autowired
	private DERSettingsAPIService dergAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public DERSettings GETDERSettings(Long edevId, Long derId) {
		return (isSchemeSecure()) ? dergAPIService.GETDERSettings(request, edevId, derId) : new DERSettings()  ;
	}

	@Override
	public void HEADDERSettings() {
		
	}

	@Override
	public void PUTDERSettings(DERSettings dersettings, Long edevId, Long derId) {
		if(isSchemeSecure()){
			
		}
		dergAPIService.PUTDERSettings(request, dersettings, edevId, derId);
		
	}

	@Override
	public void POSTDERSettings(DERSettings dersettings) {
		
	}

	@Override
	public void DELETEDERSettings() {
		
	}
	
	private boolean isSchemeSecure(){
		return (request.getScheme().equalsIgnoreCase(Constant.HTTPS)) ? true : false ;
	}

}

