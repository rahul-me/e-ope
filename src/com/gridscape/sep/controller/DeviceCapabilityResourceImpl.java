package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DeviceCapabilityAPIService;
import com.gridscape.sep.application.DeviceCapabilityResource;
import com.gridscape.sep.org.zigbee.sep.DeviceCapability;

@Service
@Path("/dcap")
public class DeviceCapabilityResourceImpl implements DeviceCapabilityResource {
	
	@Autowired
	private DeviceCapabilityAPIService dcapAPIService;
	
	@Context
	private HttpServletRequest request;
	
	/* 
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.DeviceCapabilityResource#GETDeviceCapability()
	 */
	@Override
	public DeviceCapability GETDeviceCapability() {
		return (isSchemeSecure(request)) ? dcapAPIService.GETDeviceCapability(request) : new DeviceCapability();
	}

	@Override
	public void HEADDeviceCapability() {
		
	}

	@Override
	public void PUTDeviceCapability(DeviceCapability devicecapability) {
		
	}

	@Override
	public void POSTDeviceCapability(DeviceCapability devicecapability) {
		
	}

	@Override
	public void DELETEDeviceCapability() {
		
	}
	
	private boolean isSchemeSecure(HttpServletRequest request){
		return (request.getScheme().equalsIgnoreCase("https")) ? true : false;
	}

}

