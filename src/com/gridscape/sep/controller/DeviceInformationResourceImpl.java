package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DeviceInformationAPIService;
import com.gridscape.sep.application.DeviceInformationResource;
import com.gridscape.sep.org.zigbee.sep.DeviceInformation;

@Service
@Path("/edev/{edevId}/di")
public class DeviceInformationResourceImpl implements DeviceInformationResource {
	
	
	@Autowired
	private DeviceInformationAPIService deviceInformationAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	/**
	 * Required
	 */
	@Override
	public DeviceInformation GETDeviceInformation(Long edevId) {
		return (isSchemeSecure()) ? deviceInformationAPIService.GETDeviceInformation(request, edevId) : new DeviceInformation();
	}

	@Override
	public void HEADDeviceInformation() {
		
	}
	
	/**
	 * Required
	 */
	@Override
	public void PUTDeviceInformation(DeviceInformation deviceinformation, Long edevId) {
		if(isSchemeSecure()){
			
		}
		deviceInformationAPIService.PUTDeviceInformation(request, deviceinformation, edevId);
	}

	@Override
	public void POSTDeviceInformation(DeviceInformation deviceinformation) {
		
	}

	@Override
	public DeviceInformation DELETEDeviceInformation() {
		return null;
	}
	
	private boolean isSchemeSecure(){
		return (request.getScheme().equalsIgnoreCase("https")) ? true: false;
	}

}

