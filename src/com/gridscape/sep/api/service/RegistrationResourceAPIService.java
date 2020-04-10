package com.gridscape.sep.api.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.PINType;
import com.gridscape.sep.org.zigbee.sep.Registration;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Component
public class RegistrationResourceAPIService {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private UserCertificateService userCertificateService;

	public Registration GETRegistration(String deviceId, HttpServletRequest request) {
		Long did = new Long(deviceId);
		Registration registration = new Registration();

		Device device = deviceService.findById(did);

		if (device != null) {

			UserCertificate userCertificate = userCertificateService
					.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if (userCertificate != null) {
				if (!device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))) {
					return registration;
				}
			} else {
				return registration;
			}

			TimeType dateTimeRegistered = new TimeType();
			dateTimeRegistered.setValue((device.getCreated_at().getTime() / 1000));
			registration.setDateTimeRegistered(dateTimeRegistered);
			PINType pINType = new PINType();
			pINType.setValue(device.getPin());
			registration.setPIN(pINType);
			registration.setHref("/edev/" + device.getId() + "/reg");
		}

		return registration;
	}
}
