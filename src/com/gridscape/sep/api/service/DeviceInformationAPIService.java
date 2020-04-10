package com.gridscape.sep.api.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.DeviceInformation;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DeviceInformationAPIService {
	
	private Logger log = Logger.getLogger(DeviceInformationAPIService.class);
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	@Autowired
	private DeviceService deviceService;
	
	public DeviceInformation GETDeviceInformation(HttpServletRequest request, Long edevId) {
		DeviceInformation deviceInformation = new DeviceInformation();
		try {
			UserCertificate userCertificate  = getUserCertificate(request);
			if(userCertificate != null){
				Device device = deviceService.findById(edevId);
				if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
					String deviceInfoStr = device.getDeviceInformation();
					if(deviceInfoStr != null){
						DeviceInformation deviceInformation2 = (DeviceInformation) Utility.getObjectFromJSONString(deviceInfoStr, DeviceInformation.class);
						if(deviceInformation2 != null){
							deviceInformation = deviceInformation2;
						}
					}
				}
			}
		} catch(Exception e ){
			log.error(e);
			e.printStackTrace();
		}
		
		return deviceInformation;
	}
	
	public void PUTDeviceInformation(HttpServletRequest request, DeviceInformation deviceinformation, Long edevId) {
		DeviceInformation deviceInformation = new DeviceInformation();
		try {
			UserCertificate userCertificate  = getUserCertificate(request);
			if(userCertificate != null || userCertificate == null){
				Device device = deviceService.findById(edevId);
				if(device != null /*&& device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))*/ && deviceinformation != null){
					device.setDeviceInformation(Utility.convertToJsonString(deviceinformation));
					deviceService.save(device);
				}
			}
		} catch(Exception e ){
			log.error(e);
			e.printStackTrace();
		}
	}
	
	private UserCertificate getUserCertificate(HttpServletRequest request){
		return userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
	}
		
}

