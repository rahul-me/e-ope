package com.gridscape.sep.api.service;


import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.CurveDataModal;
import com.gridscape.model.sep.DERCurveModal;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.org.zigbee.sep.CurveData;
import com.gridscape.sep.org.zigbee.sep.DERCurve;
import com.gridscape.sep.org.zigbee.sep.DERCurveList;
import com.gridscape.sep.org.zigbee.sep.DERCurveType;
import com.gridscape.sep.org.zigbee.sep.DERUnitRefType;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.PowerOfTenMultiplierType;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.org.zigbee.sep.VersionType;
import com.gridscape.sep.service.CurveDataService;
import com.gridscape.sep.service.DERCurveService;
import com.gridscape.sep.service.DERProgramService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERCurveAPIService {
	@Autowired
	private DERCurveService derCurveService;
	
	@Autowired
	private CurveDataService curveDataService;
	
	@Autowired
	private DERProgramService derProgramService;
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	public DERCurveList GETDERCurveList(HttpServletRequest request, Long derpId){
		boolean status = false;
		DERCurveList derCurveList = new DERCurveList();
		DERProgram derProgram = derProgramService.findById(derpId);
		if(derProgram != null){
			UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if(userCertificate != null){
				List<DERCurveModal> derCurveModals = derCurveService.getByDerpId(derpId);
				if(derCurveModals != null && !derCurveModals.isEmpty()){
					derCurveList = generateDERCurveListFromModals(derCurveModals);
					status = true;
				}
			}
		}
		return derCurveList;
	}
	
	private DERCurveList generateDERCurveListFromModals(List<DERCurveModal> derCurveModals){
		DERCurveList derCurveList = new DERCurveList();
		List<DERCurve> derCurves =  derCurveList.getDERCurve();
		for(DERCurveModal derCurveModal : derCurveModals){
			DERCurve derCurve = generateDERCurveFromDERCurveModal(derCurveModal);
			derCurves.add(derCurve);
		}
		return derCurveList;
	}
	
	private DERCurve generateDERCurveFromDERCurveModal(DERCurveModal derCurveModal){
		DERCurve derCurve = new DERCurve();
		derCurve.setDescription(derCurveModal.getDescription());
		
		derCurve.setHref("/derp/"+derCurveModal.getDerpId()+"/dc/"+derCurveModal.getId());
		
		VersionType versionType = new VersionType();
		versionType.setValue(derCurveModal.getVersion());
		derCurve.setVersion(versionType);
		
		MRIDType mridType = new MRIDType();
		byte[] mrid = Utility.getMRIDValue(derCurveModal.getId(), configProperties.getIanaPEN());
		mridType.setValue(mrid);
		derCurve.setMRID(mridType);
		
		TimeType timeType = new TimeType();
		timeType.setValue(Calendar.getInstance().getTimeInMillis()/1000);
		derCurve.setCreationTime(timeType);
		
		setCurveDataList(derCurveModal, derCurve);
		
		DERCurveType derCurveType = new DERCurveType();
		derCurveType.setValue(derCurveModal.getDerCurveType());
		derCurve.setCurveType(derCurveType);
		
		derCurve.setRampDecTms(derCurveModal.getRampDecTms());
		derCurve.setRampIncTms(derCurveModal.getRampIncTms());
		derCurve.setRampPT1Tms(derCurveModal.getRampPT1Tms());
		
		Byte xMul = derCurveModal.getxMultiplier();
		byte xmul = 0, ymul = 0;
		Byte yMul = derCurveModal.getyMultiplier();
		PowerOfTenMultiplierType powerOfTenMultiplierType = new PowerOfTenMultiplierType();
		if(isNotNull(xMul)){
			xmul = xMul;
		}
		if(isNotNull(yMul)){
			ymul = yMul;
		}
		powerOfTenMultiplierType.setValue(xmul);
		derCurve.setXMultiplier(powerOfTenMultiplierType);
		powerOfTenMultiplierType = new PowerOfTenMultiplierType();
		powerOfTenMultiplierType.setValue(ymul);
		derCurve.setYMultiplier(powerOfTenMultiplierType);
		
		Short derUnitRefT = derCurveModal.getDerUnitRefType();
		short derURT = 0;
		DERUnitRefType derUnitRefType = new DERUnitRefType();
		if(isNotNull(derUnitRefT)){
			derURT = derUnitRefT;
		}
		derUnitRefType.setValue(derURT);
		
		return derCurve;
		
	
	}
	
	private void setCurveDataList(DERCurveModal derCurveModal, DERCurve derCurve){
		List<CurveData> curveDatas = derCurve.getCurveData();
		List<CurveDataModal> curveDataModals = curveDataService.getByDerCurveId(derCurveModal.getId());
		if(curveDataModals != null && !curveDataModals.isEmpty()){
			for(CurveDataModal curveDataModal : curveDataModals){
				CurveData curveData = new CurveData();
				curveData.setExcitation(curveDataModal.getExitation());
				curveData.setXvalue(curveDataModal.getXvalue());
				curveData.setYvalue(curveDataModal.getYvalue());
				curveDatas.add(curveData);
			}
		}		
	}
	
	/*
	 * DERCurve
	 */
	
	public DERCurve GETDERCurve(HttpServletRequest request, Long derpId, Long dcId){
		boolean status = false;
		DERCurve derCurve = null;
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			DERProgram derProgram = derProgramService.findById(derpId);
			if(derProgram != null){
				DERCurveModal derCurveModal = derCurveService.getById(dcId);
				if(derCurveModal != null){
					status = true;
					derCurve = generateDERCurveFromDERCurveModal(derCurveModal);
				}
			}
		}
		return (status) ? derCurve : new DERCurve();
		
		
	}
	
	private <T> boolean isNotNull(T... val) {
		for (T t : val) {
			if (t == null) {
				return false;
			}
		}
		return true;
	}
}

