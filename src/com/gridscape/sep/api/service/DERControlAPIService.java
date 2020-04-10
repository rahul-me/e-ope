package com.gridscape.sep.api.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.DERControlModal;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.org.zigbee.sep.CurvePairType;
import com.gridscape.sep.org.zigbee.sep.DERControl;
import com.gridscape.sep.org.zigbee.sep.DERControlBase;
import com.gridscape.sep.org.zigbee.sep.DERControlList;
import com.gridscape.sep.org.zigbee.sep.DERCurveLink;
import com.gridscape.sep.org.zigbee.sep.DERUnitRefType;
import com.gridscape.sep.org.zigbee.sep.DateTimeInterval;
import com.gridscape.sep.org.zigbee.sep.DefaultDERControl;
import com.gridscape.sep.org.zigbee.sep.EventStatus;
import com.gridscape.sep.org.zigbee.sep.FixedPowerFactor;
import com.gridscape.sep.org.zigbee.sep.FixedVAr;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.OneHourRangeType;
import com.gridscape.sep.org.zigbee.sep.PerCent;
import com.gridscape.sep.org.zigbee.sep.PowerOfTenMultiplierType;
import com.gridscape.sep.org.zigbee.sep.SignedPerCent;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.org.zigbee.sep.VersionType;
import com.gridscape.sep.service.DERControlService;
import com.gridscape.sep.service.DERProgramService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERControlAPIService {
	
	private static Logger log = Logger.getLogger(DERControlAPIService.class);

	@Autowired
	private DERControlService derControlService;

	@Autowired
	private DERProgramService derProgramService;

	@Autowired
	private UserCertificateService userCertificateService;

	@Autowired
	private ConfigProperties configProperties;

	public DERControlList GETDERControlList(HttpServletRequest request, Long derpId) {
		DERControlList derControlList = new DERControlList();
		boolean status = false;
		DERProgram derProgram = derProgramService.findById(derpId);
		if (derProgram != null) {
			UserCertificate userCertificate = userCertificateService
					.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if (userCertificate != null) {
				status = true;
				List<DERControlModal> derControlModals = derControlService.getByDerpId(derpId);
				if (derControlModals != null && !derControlModals.isEmpty()) {
					DERControlList derControlList1 = generateDERControlListFromModalList(derControlModals);
					if (derControlList1 != null) {
						derControlList1.setHref("/derp/" + derpId + "/derc");
						derControlList = derControlList1;
					}
				}

			}
		}
		return derControlList;
	}

	private DERControl generateDERControlFromDERControlModal(DERControlModal derControlModal) {
		DERControl derControl = new DERControl();

		Long derpId = derControlModal.getDerpId();
		Long dercId = derControlModal.getId();

		derControl.setHref("/derp/" + derControlModal.getDerpId() + "/derc/" + derControlModal.getId());

		MRIDType mridType = new MRIDType();
		mridType.setValue(Utility.getMRIDValue(derControlModal.getId(), configProperties.getIanaPEN()));
		derControl.setMRID(mridType);

		derControl.setDescription(derControlModal.getDescription());

		OneHourRangeType oneHourRangeType = new OneHourRangeType();
		oneHourRangeType.setValue(derControlModal.getRandomizeStart());
		derControl.setRandomizeStart(oneHourRangeType);

		oneHourRangeType = new OneHourRangeType();
		oneHourRangeType.setValue(derControlModal.getRandomizeDuration());
		derControl.setRandomizeDuration(oneHourRangeType);

		VersionType versionType = new VersionType();
		versionType.setValue(derControlModal.getVersion());
		derControl.setVersion(versionType);

		EventStatus eventStatus = new EventStatus();
		eventStatus.setCurrentStatus((short) 0);

		TimeType timeType = new TimeType();
		timeType.setValue(new Date().getTime()/1000);
		eventStatus.setDateTime(timeType);

		timeType = new TimeType();
		timeType.setValue(new Date().getTime()/1000);
		derControl.setCreationTime(timeType);

		DateTimeInterval dateTimeInterval = new DateTimeInterval();
		timeType = new TimeType();
		Long timeVal = derControlModal.getEventStartTime();
		if(timeVal != null){
			timeType.setValue(timeVal/1000);
			dateTimeInterval.setStart(timeType);
			dateTimeInterval.setDuration(derControlModal.getEventDuration());
			derControl.setInterval(dateTimeInterval);
		}
		

		// DERControlBase

		DERControlBase derControlBase = new DERControlBase();
		DERUnitRefType derUnitRefType = null;
		SignedPerCent signedPerCent = null;
		DERCurveLink derCurveLink = null;
		CurvePairType curvePairType = null;

		// SignedPerCent opModFixedFlow
		Short opModFixedFlow = derControlModal.getOpModFixedFlow();
		if (opModFixedFlow != null /* && opModFixedFlow != 0 */) {
			signedPerCent = new SignedPerCent();
			signedPerCent.setValue(opModFixedFlow);
			derControlBase.setOpModFixedFlow(signedPerCent);
		}

		// FixedPowerFactor opModFixedPF
		Short opModFixedPFDis = derControlModal.getOpModFixedPFDisplacement();
		Byte opModFixedPFMul = derControlModal.getOpModFixedPFMultiplier();
		if (opModFixedPFDis != null
				&& opModFixedPFMul != null/*
											 * && opModFixedPFDis != 0 &&
											 * opModFixedPFMul != 0
											 */) {
			FixedPowerFactor fixedPowerFactor = new FixedPowerFactor();
			fixedPowerFactor.setDisplacement(opModFixedPFDis);
			PowerOfTenMultiplierType powerOfTenMultiplierType = new PowerOfTenMultiplierType();
			powerOfTenMultiplierType.setValue(opModFixedPFMul);
			fixedPowerFactor.setMultiplier(powerOfTenMultiplierType);
			derControlBase.setOpModFixedPF(fixedPowerFactor);
		}

		// FixedVAr opModFixedVAr
		Short opModFixedVArReft = derControlModal.getOpModFixedVArRefType();
		Short opModFixedVArVal = derControlModal.getOpModFixedVArValue();
		if (isNotNull(opModFixedVArReft, opModFixedVArVal)) {
			FixedVAr fixedVAr = new FixedVAr();
			derUnitRefType = new DERUnitRefType();
			derUnitRefType.setValue(opModFixedVArReft);
			fixedVAr.setRefType(derUnitRefType);
			signedPerCent = new SignedPerCent();
			signedPerCent.setValue(opModFixedVArVal);
			fixedVAr.setValue(signedPerCent);
			derControlBase.setOpModFixedVAr(fixedVAr);
		}

		// PerCent opModFixedW
		Integer opModFixedW = derControlModal.getOpModFixedW();
		if (isNotNull(opModFixedW)) {
			PerCent perCent = new PerCent();
			perCent.setValue(opModFixedW);
			derControlBase.setOpModFixedW(perCent);
		}

		// DERCurveLink opModFreqWatt
		Long opModFreqWatt = derControlModal.getOpModFreqWatt();
		if (isNotNull(opModFreqWatt)) {
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModFreqWatt);
			derControlBase.setOpModFreqWatt(derCurveLink);
		}

		// protected CurvePairType opModHVRT;
		curvePairType = new CurvePairType();
		boolean ll = false, ul = false;
		Long opModHVRTLowL = derControlModal.getOpModHVRTLowerLimit();
		if (isNotNull(opModHVRTLowL)) {
			ll = true;
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModHVRTLowL);
			curvePairType.setLowerLimit(derCurveLink);
		}
		Long opModHVRTUppL = derControlModal.getOpModHVRTUpperLimit();
		if (isNotNull(opModHVRTLowL)) {
			ul = true;
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModHVRTUppL);
			curvePairType.setUpperLimit(derCurveLink);
		}
		if (ll || ul) {
			derControlBase.setOpModHVRT(curvePairType);
		}

		// protected CurvePairType opModLVRT
		curvePairType = new CurvePairType();
		ll = false;
		ul = false;
		Long opModLVRTLowL = derControlModal.getOpModLVRTLowerLimit();
		if (isNotNull(opModLVRTLowL)) {
			ll = true;
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModLVRTLowL);
			curvePairType.setLowerLimit(derCurveLink);
		}
		Long opModLVRTUppL = derControlModal.getOpModLVRTUpperLimit();
		if (isNotNull(opModLVRTUppL)) {
			ul = true;
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModLVRTUppL);
			curvePairType.setUpperLimit(derCurveLink);
		}
		if (ll || ul) {
			derControlBase.setOpModLVRT(curvePairType);
		}

		// DERCurveLink opModVoltVAr
		Long opModVoltVAr = derControlModal.getOpModVoltVAr();
		if (isNotNull(opModVoltVAr)) {
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModVoltVAr);
			derControlBase.setOpModVoltVAr(derCurveLink);
		}

		// DERCurveLink opModVoltWatt
		Long opModVoltWatt = derControlModal.getOpModVoltVAr();
		if (isNotNull(opModVoltWatt)) {
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModVoltWatt);
			derControlBase.setOpModVoltWatt(derCurveLink);
		}

		// DERCurveLink opModWattPF
		Long opModWattPF = derControlModal.getOpModWattPF();
		if (isNotNull(opModWattPF)) {
			derCurveLink = new DERCurveLink();
			derCurveLink.setHref("/derp/" + derpId + "/dc/" + opModWattPF);
			derControlBase.setOpModWattPF(derCurveLink);
		}
		
		//protected Integer rampTms;
		Integer rampTms = derControlModal.getRampTms();
		if(isNotNull(rampTms)){
			derControlBase.setRampTms(rampTms);
		}
		
		derControl.setDERControlBase(derControlBase);

		return derControl;

	}

	private DERControlList generateDERControlListFromModalList(List<DERControlModal> derControlModals) {
		DERControlList derControlList = new DERControlList();
		List<DERControl> derControls = derControlList.getDERControl();

		for (DERControlModal derControlModal : derControlModals) {
			derControls.add(generateDERControlFromDERControlModal(derControlModal));
		}
		return derControlList;
	}

	/*
	 * DERControl
	 */

	public DERControl GETDERControl(HttpServletRequest request, Long derpId, Long dercId) {
		DERControl derControl = new DERControl();
		DERProgram derProgram = derProgramService.findById(derpId);
		DERControlModal derControlModal = derControlService.getById(dercId);
		if (derControlModal != null && derProgram != null && derControlModal.getDerpId() == derpId) {
			UserCertificate userCertificate = userCertificateService
					.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if (userCertificate != null) {
				DERControl derControl2 = generateDERControlFromDERControlModal(derControlModal);
				if (derControl2 != null) {
					derControl = derControl2;
				}
			}
		}
		return derControl;
	}

	private boolean isNotNull(Byte byteVal, Short... shortVal) {
		boolean status = false;
		if (byteVal == null) {
			return status;
		}
		for (Short short1 : shortVal) {
			if (short1 == null) {
				return status;
			}
		}
		status = true;
		return status;
	}

	private boolean isNotNull(Short... shortVal) {
		for (Short short1 : shortVal) {
			if (short1 == null) {
				return false;
			}
		}
		return true;
	}

	private <T> boolean isNotNull(T... val) {
		for (T t : val) {
			if (t == null) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * DefaultDERControl Part
	 * 
	 * 
	 */
	
	public DefaultDERControl GETDefaultDERControl(HttpServletRequest request, Long derpId){
		DefaultDERControl defaultDERControl = new DefaultDERControl();
		try {
			UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if(userCertificate != null){
				DERProgram derProgram  = derProgramService.findById(derpId);
				if(derProgram != null){
					DERControlModal derControlModal = derControlService.getDefaultTypeDERControl(derpId);
					if(derControlModal != null){
						DERControl derControl = generateDERControlFromDERControlModal(derControlModal);
						defaultDERControl.setDERControlBase(derControl.getDERControlBase());
						defaultDERControl.setMRID(derControl.getMRID());
						defaultDERControl.setHref("/derp/"+derpId+"/dderc");
						defaultDERControl.setVersion(derControl.getVersion());
						defaultDERControl.setDescription(derControl.getDescription());
					}
				}
			}
		} catch(Exception e){
			log.error(e);
		}
		return defaultDERControl;
	}

}
