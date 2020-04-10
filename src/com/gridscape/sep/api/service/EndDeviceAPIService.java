package com.gridscape.sep.api.service;

import java.security.cert.X509Certificate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.ConfigurationLink;
import com.gridscape.sep.org.zigbee.sep.DERListLink;
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
import com.gridscape.sep.service.UserCertificateService;

@Component
public class EndDeviceAPIService {
	@Autowired
	private DeviceService deviceService;

	@Autowired
	private FunctionSetService functionSetService;

	@Autowired
	private UserCertificateService userCertificateService;

	public EndDeviceList getEndDeviceListForUnsecureScheme() {
		List<Device> device = deviceService.deviceList();
		return generateEndDeviceListFromDevices(device);
	}

	public EndDeviceList getEndDeviceListForSecureScheme(HttpServletRequest request) {
		X509Certificate x509Certificate = getCertificateFromRequest(request);
		if (x509Certificate == null) {
			return null;
		} else {
			UserCertificate userCertificate = userCertificateService
					.getCertificateBySignature(new String(x509Certificate.getSignature()));
			if (userCertificate != null) {
				List<Device> device = deviceService.getDevicesByUserId(String.valueOf(userCertificate.getUser_id()));
				if (device != null && !device.isEmpty()) {
					return generateEndDeviceListFromDevices(device);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}

	private EndDeviceList generateEndDeviceListFromDevices(List<Device> devices) {
		EndDeviceList endDeviceList = new EndDeviceList();
		List<EndDevice> endDevices = endDeviceList.getEndDevice();
		for (Device modelObject : devices) {
			endDevices.add(generateModelToSEPObject(modelObject));
		}
		return endDeviceList;
	}

	private X509Certificate getCertificateFromRequest(HttpServletRequest request) {
		X509Certificate x509Certificate = null;
		X509Certificate[] certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
		if (certs != null && certs.length > 0) {
			x509Certificate = certs[0];
			return x509Certificate;
		} else {
			return x509Certificate;
		}
	}

	private EndDevice generateModelToSEPObject(Device endDeviceDb) {
		EndDevice endDevice = new EndDevice();
		// Device deviceItem = deviceService.findById(new Long(id));
		List<FunctionSet> functionSetlist = functionSetService.findByDeviceId(endDeviceDb.getId());
		SFDIType sfdiType = new SFDIType();
		// FlowReservationRequestListLink flowReservationRequestListLink = new
		// FlowReservationRequestListLink();
		// FlowReservationResponseListLink flowReservationResponseListLink = new
		// FlowReservationResponseListLink();
		FunctionSetAssignmentsListLink functionSetAssignmentsListLink = new FunctionSetAssignmentsListLink();
		RegistrationLink registrationLink = new RegistrationLink();
		SubscriptionListLink subscriptionListLink = new SubscriptionListLink();
		ConfigurationLink configurationLink = new ConfigurationLink();
		// DERListLink derListLink = new DERListLink();
		PowerStatusLink powerStatusLink = new PowerStatusLink();
		// LogEventListLink logEventListLink = new LogEventListLink();
		// LoadShedAvailabilityLink loadShedAvailabilityLink = new
		// LoadShedAvailabilityLink();
		// IPInterfaceListLink ipInterfaceListLink = new IPInterfaceListLink();
		FileStatusLink fileStatusLink = new FileStatusLink();
		DeviceStatusLink deviceStatusLink = new DeviceStatusLink();
		DeviceInformationLink deviceInformationLink = new DeviceInformationLink();
		configurationLink.setHref("/edev/" + endDeviceDb.getId() + "/cfg");
		deviceInformationLink.setHref("/edev/" + endDeviceDb.getId() + "/di");
		deviceStatusLink.setHref("/edev/" + endDeviceDb.getId() + "/ds");
		fileStatusLink.setHref("/edev/" + endDeviceDb.getId() + "/fs");
		powerStatusLink.setHref("/edev/" + endDeviceDb.getId() + "/ps");
		registrationLink.setHref("/edev/" + endDeviceDb.getId() + "/reg");
		subscriptionListLink.setHref("/edev/" + endDeviceDb.getId() + "/sub");
		subscriptionListLink.setAll(0);
		sfdiType.setValue(endDeviceDb.getS_fdi());
		functionSetAssignmentsListLink.setAll(functionSetlist.size());
		functionSetAssignmentsListLink.setHref("/edev/" + endDeviceDb.getId() + "/fsal");
		endDevice.setConfigurationLink(configurationLink);
		endDevice.setDeviceInformationLink(deviceInformationLink);
		endDevice.setDeviceStatusLink(deviceStatusLink);
		endDevice.setFileStatusLink(fileStatusLink);
		endDevice.setPowerStatusLink(powerStatusLink);
		endDevice.setRegistrationLink(registrationLink);
		endDevice.setSubscriptionListLink(subscriptionListLink);
		endDevice.setFunctionSetAssignmentsListLink(functionSetAssignmentsListLink);
		endDevice.setSFDI(sfdiType);
		endDevice.setHref("/edev/" + endDeviceDb.getId());
		LogEventListLink logEventListLink = new LogEventListLink();
		logEventListLink.setHref("/edev/"+endDeviceDb.getId()+"/lel");
		endDevice.setLogEventListLink(logEventListLink);
		
		DERListLink derListLink = new DERListLink();
		derListLink.setHref("/edev/"+endDeviceDb.getId()+"/der");
		endDevice.setDERListLink(derListLink);
		
		return endDevice;
	}

	public EndDevice getEndDeviceForUnsecureScheme(Long id) {
		Device device = deviceService.findById(id);
		return generateModelToSEPObject(device);
	}

	public EndDevice getEndDeviceForSecureScheme(HttpServletRequest request, Long id) {

		UserCertificate userCertificate = userCertificateService
				.getUserCertificateCorrespondingToCertificateInComingRequest(request);

		if (userCertificate != null) {
			Device device = deviceService.findById(id);
			if (device != null) {
				if(Long.parseLong(device.getUser_id()) == userCertificate.getUser_id()){
					return generateModelToSEPObject(device);
				} else {
					return null;
				}				
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

}
