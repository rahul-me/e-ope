package com.gridscape.sep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.api.service.EndDeviceAPIService;
import com.gridscape.sep.application.EndDeviceResource;
import com.gridscape.sep.org.zigbee.sep.ConfigurationLink;
import com.gridscape.sep.org.zigbee.sep.DERListLink;
import com.gridscape.sep.org.zigbee.sep.DeviceInformationLink;
import com.gridscape.sep.org.zigbee.sep.DeviceStatusLink;
import com.gridscape.sep.org.zigbee.sep.EndDevice;
import com.gridscape.sep.org.zigbee.sep.FileStatusLink;
import com.gridscape.sep.org.zigbee.sep.FlowReservationRequestListLink;
import com.gridscape.sep.org.zigbee.sep.FlowReservationResponseListLink;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignmentsListLink;
import com.gridscape.sep.org.zigbee.sep.IPInterfaceListLink;
import com.gridscape.sep.org.zigbee.sep.LoadShedAvailabilityLink;
import com.gridscape.sep.org.zigbee.sep.LogEventListLink;
import com.gridscape.sep.org.zigbee.sep.PowerStatusLink;
import com.gridscape.sep.org.zigbee.sep.RegistrationLink;
import com.gridscape.sep.org.zigbee.sep.SFDIType;
import com.gridscape.sep.org.zigbee.sep.SubscriptionListLink;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.FunctionSetService;
@Path("/edev/{id}")
public class EndDeviceResourceImpl implements EndDeviceResource{
	
	@Autowired
	DeviceService deviceService;
	@Autowired
	FunctionSetService  functionSetService;
	
	@Autowired
	private EndDeviceAPIService endDeviceApiService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public EndDevice GETEndDevice(String id) {
		
		return (request.getScheme().equalsIgnoreCase("https")) ? endDeviceApiService.getEndDeviceForSecureScheme(request, new Long(id)) : new EndDevice();
		/*EndDevice endDevice = new EndDevice();
		Device deviceItem = deviceService.findById(new Long(id));
		List<FunctionSet>  functionSetlist = functionSetService.findByDeviceId(deviceItem.getId());
		SFDIType  sfdiType =  new SFDIType();
		FlowReservationRequestListLink flowReservationRequestListLink = new FlowReservationRequestListLink();
		FlowReservationResponseListLink flowReservationResponseListLink = new FlowReservationResponseListLink();
		FunctionSetAssignmentsListLink functionSetAssignmentsListLink = new FunctionSetAssignmentsListLink();
		RegistrationLink registrationLink = new RegistrationLink();
		SubscriptionListLink subscriptionListLink = new SubscriptionListLink();
		ConfigurationLink configurationLink = new ConfigurationLink();
		DERListLink derListLink = new DERListLink();
		PowerStatusLink powerStatusLink = new PowerStatusLink();
		LogEventListLink logEventListLink = new LogEventListLink();
		LoadShedAvailabilityLink loadShedAvailabilityLink = new LoadShedAvailabilityLink();
		IPInterfaceListLink ipInterfaceListLink = new IPInterfaceListLink();
		FileStatusLink fileStatusLink = new FileStatusLink();
		DeviceStatusLink deviceStatusLink = new DeviceStatusLink();
		DeviceInformationLink deviceInformationLink = new DeviceInformationLink();
		configurationLink.setHref("/edev/"+deviceItem.getId()+"/cfg");
		deviceInformationLink.setHref("/edev/"+deviceItem.getId()+"/di");
		deviceStatusLink.setHref("/edev/"+deviceItem.getId()+"/ds");
		fileStatusLink.setHref("/edev/"+deviceItem.getId()+"/fs");
		powerStatusLink.setHref("/edev/"+deviceItem.getId()+"/ps");
		registrationLink.setHref("/edev/"+deviceItem.getId()+"/reg");
		subscriptionListLink.setHref("/edev/"+deviceItem.getId()+"/subl");
		subscriptionListLink.setAll(0);
		sfdiType.setValue(deviceItem.getS_fdi());
		functionSetAssignmentsListLink.setAll(functionSetlist.size());
		functionSetAssignmentsListLink.setHref("/edev/"+deviceItem.getId()+"/fsal");
		endDevice.setConfigurationLink(configurationLink);
		endDevice.setDeviceInformationLink(deviceInformationLink);
		endDevice.setDeviceStatusLink(deviceStatusLink);
		endDevice.setFileStatusLink(fileStatusLink);
		endDevice.setPowerStatusLink(powerStatusLink);
		endDevice.setRegistrationLink(registrationLink);
		endDevice.setSubscriptionListLink(subscriptionListLink);
		endDevice.setFunctionSetAssignmentsListLink(functionSetAssignmentsListLink);
		endDevice.setSFDI(sfdiType);
		endDevice.setHref("/edev/"+deviceItem.getId());
		return endDevice;*/
	}

	@Override
	public void HEADEndDevice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTEndDevice(EndDevice enddevice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTEndDevice(EndDevice enddevice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EndDevice DELETEEndDevice() {
		// TODO Auto-generated method stub
		return null;
	}

}

