package com.gridscape.sep.api.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.DeviceCapability;
import com.gridscape.sep.org.zigbee.sep.EndDeviceListLink;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePointListLink;
import com.gridscape.sep.org.zigbee.sep.TimeLink;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.MirrorUsagePointService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DeviceCapabilityAPIService {
	
	private static Logger log = Logger.getLogger(DeviceCapabilityAPIService.class);
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private MirrorUsagePointService mirrorUsagePointService;

	public DeviceCapability GETDeviceCapability(HttpServletRequest request){
		DeviceCapability deviceCapability = new DeviceCapability();
		
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			try {
				EndDeviceListLink endDeviceListLink = new EndDeviceListLink();
				endDeviceListLink.setHref("/edev");
				endDeviceListLink.setAll(deviceService.getDevicesByUserId(String.valueOf(userCertificate.getUser_id())).size());
				deviceCapability.setEndDeviceListLink(endDeviceListLink);
				
				MirrorUsagePointListLink mirrorUsagePointListLink = new MirrorUsagePointListLink();
				mirrorUsagePointListLink.setHref("/mup");
				mirrorUsagePointListLink.setAll(mirrorUsagePointService.getAll().size());
				deviceCapability.setMirrorUsagePointListLink(mirrorUsagePointListLink);
				
				TimeLink timeLink = new TimeLink();
				timeLink.setHref("/tm");
				deviceCapability.setTimeLink(timeLink);
			} catch(Exception e){
				e.printStackTrace();
				log.error(e);
			}
			
			
		}
		return deviceCapability;
	}
	
}

