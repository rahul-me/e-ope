package com.gridscape.sep.api.service;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.helpers.ReadProperties;
import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.SubscriptionModal;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.ActiveDERControlListLink;
import com.gridscape.sep.org.zigbee.sep.DERControlListLink;
import com.gridscape.sep.org.zigbee.sep.DERCurveListLink;
import com.gridscape.sep.org.zigbee.sep.DERProgramList;
import com.gridscape.sep.org.zigbee.sep.DefaultDERControlLink;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.PrimacyType;
import com.gridscape.sep.org.zigbee.sep.VersionType;
import com.gridscape.sep.service.DERProgramService;
import com.gridscape.sep.service.SubscriptionService;
import com.gridscape.sep.service.UserCertificateService;

@Component
public class DERProgramAPIService {

	@Autowired
	private DERProgramService derProgramService;

	@Autowired
	private UserCertificateService userCertificateService;

	@Autowired
	private SubscriptionService subscriptionService;

	public DERProgramList getDERProgramList(HttpServletRequest request, Long deviceId) {

		DERProgramList derProgramList = new DERProgramList();
		List<DERProgram> listModel = new ArrayList<DERProgram>();

		UserCertificate userCertificate = userCertificateService
				.getUserCertificateCorrespondingToCertificateInComingRequest(request);

		if (isUserAuthorized(userCertificate)) {
			if (isDeviceIdIsAvailableInQueryParameter(deviceId)) {
				List<DERProgram> derPrograms = getDERProgramListSpecificForDevice(deviceId);
				if (!derPrograms.isEmpty())
					listModel = derPrograms;
			} else {
				List<DERProgram> derPrograms = derProgramService.dERProgramList();
				if (!derPrograms.isEmpty())
					listModel = derPrograms;
			}
		}

		List<com.gridscape.sep.org.zigbee.sep.DERProgram> derProgramSepList = derProgramList.getDERProgram();
		if (!listModel.isEmpty())
			fillData(listModel, derProgramSepList);

		derProgramList.setAll(derProgramSepList.size());
		return derProgramList;
	}

	public void fillData(List<DERProgram> listModel, List<com.gridscape.sep.org.zigbee.sep.DERProgram> listSep) {
		for (DERProgram derProgramModel : listModel) {
			com.gridscape.sep.org.zigbee.sep.DERProgram derProgramSep = new com.gridscape.sep.org.zigbee.sep.DERProgram();
			listSep.add(generateModelToSEPObject(derProgramModel, derProgramSep));
		}
	}

	public com.gridscape.sep.org.zigbee.sep.DERProgram generateModelToSEPObject(DERProgram derProgramModel,
			com.gridscape.sep.org.zigbee.sep.DERProgram derProgramSep) {

		ReadProperties readProperties = new ReadProperties();
		Map<String, Object> configProperties = readProperties.read("config.properties");
		int pen = Integer.parseInt((String) configProperties.get("ianaPEN"));

		derProgramSep.setHref("/derp/" + derProgramModel.getId());

		derProgramSep.setMRID(new MRIDType());
		// derProgramSep.getMRID().setValue(derProgramModel.getM_rid().getBytes());
		derProgramSep.getMRID().setValue(Utility.getMRIDValue(derProgramModel.getId(), pen));

		derProgramSep.setVersion(new VersionType());
		derProgramSep.getVersion().setValue(derProgramModel.getVersion());

		derProgramSep.setDescription(derProgramModel.getDescription());

		derProgramSep.setActiveDERControlListLink(new ActiveDERControlListLink());
		derProgramSep.getActiveDERControlListLink().setHref("/derp/" + derProgramModel.getId() + "/actderc");

		derProgramSep.setDefaultDERControlLink(new DefaultDERControlLink());
		derProgramSep.getDefaultDERControlLink().setHref("/derp/" + derProgramModel.getId() + "/dderc");

		derProgramSep.setDERControlListLink(new DERControlListLink());
		derProgramSep.getDERControlListLink().setHref("/derp/" + derProgramModel.getId() + "/derc");

		derProgramSep.setDERCurveListLink(new DERCurveListLink());
		derProgramSep.getDERCurveListLink().setHref("/derp/" + derProgramModel.getId() + "/dc");

		derProgramSep.setPrimacy(new PrimacyType());
		derProgramSep.getPrimacy().setValue(derProgramModel.getPrimacy());
		return derProgramSep;
	}

	public com.gridscape.sep.org.zigbee.sep.DERProgram getDerProgram(HttpServletRequest request, long id) {
		com.gridscape.sep.org.zigbee.sep.DERProgram derProgramSep = new com.gridscape.sep.org.zigbee.sep.DERProgram();
		DERProgram derProgramModel = derProgramService.findById(id);

		if (derProgramModel != null) {
			UserCertificate userCertificate = userCertificateService
					.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if (userCertificate != null) {
				generateModelToSEPObject(derProgramModel, derProgramSep);
				return derProgramSep;
			} else {
				return derProgramSep;
			}			
		} else {
			return derProgramSep;
		}
	}

	private byte[] getMRIDValue() {
		byte[] bytes = new byte[16];
		int i = 0;
		for (byte bb : ByteBuffer.allocate(4).putInt(50287).array()) {
			System.out.println(String.format("%02X", bb));
			bytes[i] = bb;
			i++;
		}
		return bytes;
	}

	private List<DERProgram> getDERProgramListSpecificForDevice(Long deviceId) {
		List<DERProgram> derPrograms = new ArrayList<DERProgram>();
		List<SubscriptionModal> subscriptionModals = subscriptionService
				.getListByDeviceIdHavingSubscriptionLike(deviceId, "derp");

		if (!subscriptionModals.isEmpty()) {
			for (SubscriptionModal subscriptionModal : subscriptionModals) {
				String resource = subscriptionModal.getSubscribedResource();
				Long derProgramId = Long.parseLong(String.valueOf(resource.charAt(resource.length() - 1)));
				derPrograms.add(derProgramService.findById(derProgramId));
			}
		}
		return derPrograms;
	}

	private boolean isUserAuthorized(UserCertificate userCertificate) {
		return (userCertificate != null) ? true : false;
	}

	private boolean isDeviceIdIsAvailableInQueryParameter(Long deviceId) {
		return (deviceId != null && deviceId != 0) ? true : false;
	}
}
