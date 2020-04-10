package com.gridscape.sep.api.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.DERModel;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.DERCapability;
import com.gridscape.sep.org.zigbee.sep.DERSettings;
import com.gridscape.sep.service.DERService;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERSettingsAPIService {

	@Autowired
	private UserCertificateService userCertificateService;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private DERService derService;

	public DERSettings GETDERSettings(HttpServletRequest request, Long edevId, Long derId) {
		DERSettings derSettings = new DERSettings();
		UserCertificate userCertificate = userCertificateService
				.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if (userCertificate != null) {
			DERModel derModel = derService.getById(derId);
			if (derModel != null && derModel.getEndDeviceId().longValue() == edevId.longValue()) {
				Device device = deviceService.findById(edevId);
				if (device != null
						&& device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))) {
					String derSettingsStr = derModel.getDerSettings();
					if (derSettingsStr != null) {
						DERSettings derSettings2 = getObjectFromJSONStr(derSettingsStr);
						if (derSettings2 != null) {
							derSettings = derSettings2;
						}
					}
				}
			}
		}
		return derSettings;
	}

	public void PUTDERSettings(HttpServletRequest request, DERSettings dersettings, Long edevId, Long derId) {
		// UserCertificate userCertificate =
		// userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		// if(userCertificate != null){
		DERModel derModel = derService.getById(derId);
		if (derModel != null && derModel.getEndDeviceId().longValue() == edevId.longValue()) {
			Device device = deviceService.findById(edevId);
			if (device != null /*
								 * &&
								 * device.getUser_id().equalsIgnoreCase(String.
								 * valueOf(userCertificate.getUser_id()))
								 */) {
				String derCapabilityStr = getJSONStrFromObject(dersettings);
				derModel.setDerSettings(derCapabilityStr);
				derService.saveOrUpdate(derModel);
			}
		}
		// }
	}

	private String getJSONStrFromObject(DERSettings derSettings) {
		return Utility.convertToJsonString(derSettings);
	}

	private DERSettings getObjectFromJSONStr(String jsonStr) {
		DERSettings derSettings = null;
		ObjectMapper objectMapper = Utility.getObjectMapperInsatnce();
		try {
			derSettings = objectMapper.readValue(jsonStr, DERSettings.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return derSettings;
	}

}
