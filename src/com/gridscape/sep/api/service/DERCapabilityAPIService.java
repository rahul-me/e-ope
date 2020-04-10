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
import com.gridscape.sep.service.DERService;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERCapabilityAPIService {
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	@Autowired
	private DERService derService;
	
	@Autowired
	private DeviceService deviceService;
	
	public void PUTDERCapability(HttpServletRequest request, DERCapability dercapability, Long edevId, Long derId){
		//UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		//if(userCertificate != null){
			DERModel derModel = derService.getById(derId);
			if(derModel != null && derModel.getEndDeviceId().longValue() == edevId.longValue()){
				Device device = deviceService.findById(edevId);
				if(device != null /*&& device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))*/){
					String derCapabilityStr = getJSONStrFromObject(dercapability);
					derModel.setDerCapability(derCapabilityStr);
					derService.saveOrUpdate(derModel);
				}
			}
		//}
	}
	
	public DERCapability GETDERCapability(HttpServletRequest request, Long edevId, Long derId){
		DERCapability derCapability = new DERCapability();
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			DERModel derModel = derService.getById(derId);
			if(derModel != null && derModel.getEndDeviceId().longValue() == edevId.longValue()){
				Device device = deviceService.findById(edevId);
				if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
					String derCapabilityStr = derModel.getDerCapability();
					if(derCapabilityStr != null){
						DERCapability derCapability2 = getObjectFromJSONStr(derCapabilityStr);
						if(derCapability2 != null){
							derCapability = derCapability2;
						}
					}
				}
			}
		}
		return derCapability;
	}
	
	private String getJSONStrFromObject(DERCapability derCapability){
		return Utility.convertToJsonString(derCapability);
	}
	
	private DERCapability getObjectFromJSONStr(String jsonStr){
		DERCapability derCapability = null;
		ObjectMapper objectMapper = Utility.getObjectMapperInsatnce();
		try {
			derCapability = objectMapper.readValue(jsonStr, DERCapability.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return derCapability;
	}
}

