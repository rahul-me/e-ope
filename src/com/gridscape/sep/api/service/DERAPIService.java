package com.gridscape.sep.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERModel;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.AssociatedDERProgramListLink;
import com.gridscape.sep.org.zigbee.sep.AssociatedUsagePointLink;
import com.gridscape.sep.org.zigbee.sep.CurrentDERProgramLink;
import com.gridscape.sep.org.zigbee.sep.DER;
import com.gridscape.sep.org.zigbee.sep.DERAvailabilityLink;
import com.gridscape.sep.org.zigbee.sep.DERCapabilityLink;
import com.gridscape.sep.org.zigbee.sep.DERList;
import com.gridscape.sep.org.zigbee.sep.DERSettingsLink;
import com.gridscape.sep.org.zigbee.sep.DERStatusLink;
import com.gridscape.sep.service.DERService;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERAPIService {

	@Autowired
	private DERService derService;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private UserCertificateService userCertificateService;

	public DERList GETDERList(HttpServletRequest request, Long endDeviceId) {
		Boolean status = Boolean.FALSE;
		DERList derList = null;
		UserCertificate userCertificate = userCertificateService
				.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if (userCertificate != null) {
			Device device = deviceService.findById(endDeviceId);
			if (device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))) {
				List<DERModel> derModels = derService.getListByEndDeviceId(endDeviceId);
				if (derModels != null && !derModels.isEmpty()) {
					DERList derListTemp = generateDERListFromDERModels(derModels);
					if (derListTemp != null) {
						status = Boolean.TRUE;
						derList = derListTemp;
					}
				}
			}
		}
		return (status) ? derList : new DERList();
	}

	private DERList generateDERListFromDERModels(List<DERModel> derModels) {
		DERList derList = new DERList();
		List<DER> ders = derList.getDER();
		for (DERModel derModel : derModels) {
			DER der = generateDERFromDERModel(derModel);
			if (der != null) {
				ders.add(der);
			}
		}
		return derList;
	}

	private DER generateDERFromDERModel(DERModel derModel) {
		DER der = new DER();

		Long endDeviceId = derModel.getEndDeviceId();
		Long derModelId = derModel.getId();

		der.setHref("/edev/" + endDeviceId + "/der/" + derModelId);

		AssociatedDERProgramListLink associatedDERProgramListLink = new AssociatedDERProgramListLink();
		associatedDERProgramListLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/derp");
		der.setAssociatedDERProgramListLink(associatedDERProgramListLink);

		AssociatedUsagePointLink associatedUsagePointLink = new AssociatedUsagePointLink();
		associatedUsagePointLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/upt");
		der.setAssociatedUsagePointLink(associatedUsagePointLink);

		CurrentDERProgramLink currentDERProgramLink = new CurrentDERProgramLink();
		currentDERProgramLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/cdp");
		der.setCurrentDERProgramLink(currentDERProgramLink);

		DERAvailabilityLink derAvailabilityLink = new DERAvailabilityLink();
		derAvailabilityLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/dera");
		der.setDERAvailabilityLink(derAvailabilityLink);

		DERCapabilityLink derCapabilityLink = new DERCapabilityLink();
		derCapabilityLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/dercap");
		der.setDERCapabilityLink(derCapabilityLink);

		DERSettingsLink derSettingsLink = new DERSettingsLink();
		derSettingsLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/derg");
		der.setDERSettingsLink(derSettingsLink);

		DERStatusLink derStatusLink = new DERStatusLink();
		derStatusLink.setHref("/edev/" + endDeviceId + "/der/" + derModelId + "/ders");
		der.setDERStatusLink(derStatusLink);

		return der;
	}
	
	
	/*
	 * DER
	 */
	
	public DER GETDER(HttpServletRequest request, Long endDeviceId, Long derId){
		boolean status = false;
		DER der = null;
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			DERModel derModel = derService.getById(derId);
			Device device = deviceService.findById(endDeviceId);
			if(derModel != null && derModel.getEndDeviceId() == endDeviceId && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
				DER derTemp = generateDERFromDERModel(derModel);
				if(derTemp != null){
					status = true;
					der = derTemp;
				}
				
			}
		}
		return (status) ? der : new DER();
	}
}
