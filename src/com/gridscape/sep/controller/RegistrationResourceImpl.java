package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.model.sep.Device;
import com.gridscape.sep.api.service.RegistrationResourceAPIService;
import com.gridscape.sep.application.RegistrationResource;
import com.gridscape.sep.org.zigbee.sep.PINType;
import com.gridscape.sep.org.zigbee.sep.Registration;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.service.DeviceService;
@Path("/edev/{id}/reg")
public class RegistrationResourceImpl implements RegistrationResource {
	@Autowired	
	DeviceService deviceService;
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private RegistrationResourceAPIService regResApiService;
	
	@Override
	public Registration GETRegistration(String deviceId) {
		return (request.getScheme().equals("https")) ? regResApiService.GETRegistration(deviceId, request) : new Registration();
	}

	@Override
	public void HEADRegistration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTRegistration(Registration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTRegistration(Registration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registration DELETERegistration() {
		// TODO Auto-generated method stub
		return null;
	}
}

