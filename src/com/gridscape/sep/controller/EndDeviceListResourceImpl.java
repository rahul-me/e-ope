package com.gridscape.sep.controller;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.api.service.EndDeviceAPIService;
import com.gridscape.sep.application.EndDeviceListResource;
import com.gridscape.sep.org.zigbee.sep.ConfigurationLink;
import com.gridscape.sep.org.zigbee.sep.DERListLink;
import com.gridscape.sep.org.zigbee.sep.DeviceCategoryType;
import com.gridscape.sep.org.zigbee.sep.DeviceInformationLink;
import com.gridscape.sep.org.zigbee.sep.DeviceStatusLink;
import com.gridscape.sep.org.zigbee.sep.EndDevice;
import com.gridscape.sep.org.zigbee.sep.EndDeviceList;
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

@Service
@Path("/edev")
public class EndDeviceListResourceImpl implements EndDeviceListResource {
	@Autowired
	DeviceService deviceService;

	@Autowired
	FunctionSetService functionSetService;

	@Autowired
	private EndDeviceAPIService endDeviceApiService;

	@Context
	private HttpServletRequest request;

	@Override
	public EndDeviceList GETEndDeviceList(Integer s, Integer l) {
		return (request.getScheme().equalsIgnoreCase("https")) ? endDeviceApiService.getEndDeviceListForSecureScheme(request)
				: new EndDeviceList();
	}

	@Override
	public void HEADEndDeviceList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void PUTEndDeviceList(EndDevice enddevice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void POSTEndDeviceList(EndDevice enddevice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DELETEEndDeviceList() {
		// TODO Auto-generated method stub

	}

}
