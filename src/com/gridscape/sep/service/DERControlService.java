package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Constant;
import com.gridscape.helpers.DateHelper;
import com.gridscape.model.sep.DERControlModal;
import com.gridscape.sep.dao.DERControlDao;
import com.gridscape.sep.dao.DERCurveDao;
import com.gridscape.sep.jsoninput.DERControlEntry;

@Service
public class DERControlService {
	
	@Autowired
	private DERControlDao derControlDao;
	
	@Autowired
	private DERCurveDao derCurveDao;
	
	public int saveOrUpdate(DERControlModal derControlModal){
		return derControlDao.saveOrUpdate(derControlModal);
	}
	
	public DERControlModal getById(Long dercId){
		return derControlDao.getById(dercId);		
	}
	
	public List<DERControlModal> getByDerpId(Long derpId){
		return derControlDao.getByDerpId(derpId);
	}
	
	public boolean deleteDERControl(Long id){
		return derControlDao.deleteDERControl(id);
	}
	
	public DERControlModal getDefaultTypeDERControl(Long derpId){
		return derControlDao.getDefaultTypeDERControl(derpId);
	}
	
	public List<DERControlModal> getNormalTypeDERControls(Long derpId){
		return derControlDao.getNormalTypeDERControl(derpId);
	}
	
	public DERControlModal generateDERControlModalFromDERControlEntry(DERControlEntry derControlEntry){
		DERControlModal derControlModal = new DERControlModal();
		derControlModal.setEventStartTime(DateHelper.convertStringToDate(derControlEntry.getEventStartTime(), Constant.DATE_TIME_FORMAT_FULLDATE).getTime());
		derControlModal.setEventDuration(derControlEntry.getEventDuration());
		derControlModal.setDescription(derControlEntry.getDescription());
		derControlModal.setDerpId(derControlEntry.getDerpId());
		derControlModal.setRandomizeDuration(derControlEntry.getRandomizeDuration());
		derControlModal.setRandomizeStart(derControlEntry.getRandomizeStart());
		derControlModal.setId(derControlEntry.getId());
		derControlModal.setVersion(derControlEntry.getVersion());
		
		//DERControl
		derControlModal.setOpModFixedFlow(derControlEntry.getOpModFixedFlow());
		derControlModal.setOpModFixedPFDisplacement(derControlEntry.getOpModFixedPFDisplacement());
		derControlModal.setOpModFixedPFMultiplier(derControlEntry.getOpModFixedPFMultiplier());
		derControlModal.setOpModFixedVArRefType(derControlEntry.getOpModFixedVArRefType());
		derControlModal.setOpModFixedVArValue(derControlEntry.getOpModFixedVArValue());
		derControlModal.setOpModFixedW(derControlEntry.getOpModFixedW());
				
		derControlModal.setOpModFreqWatt(derControlEntry.getOpModFreqWatt());
		derControlModal.setOpModHVRTLowerLimit(derControlEntry.getOpModHVRTLowerLimit());
		derControlModal.setOpModHVRTUpperLimit(derControlEntry.getOpModHVRTUpperLimit());
		derControlModal.setOpModLVRTLowerLimit(derControlEntry.getOpModLVRTLowerLimit());
		derControlModal.setOpModLVRTUpperLimit(derControlEntry.getOpModLVRTUpperLimit());
		derControlModal.setOpModVoltVAr(derControlEntry.getOpModVoltVAr());
		derControlModal.setOpModVoltWatt(derControlEntry.getOpModVoltWatt());
		derControlModal.setOpModWattPF(derControlEntry.getOpModWattPF());
		derControlModal.setRampTms(derControlEntry.getRampTms());
		derControlModal.setDefaultDERControl(derControlEntry.isDefaultDERControl());
		
		return derControlModal;
	}
	
	public DERControlEntry generateDERControlEntryFromDERControlModel(DERControlModal derControlModal){
		DERControlEntry derControlEntry = new DERControlEntry();
		try {
			derControlEntry.setDescription(derControlModal.getDescription());
			derControlEntry.setRandomizeStart(derControlModal.getRandomizeStart());
			derControlEntry.setRandomizeDuration(derControlModal.getRandomizeDuration());
			derControlEntry.setEventDuration(derControlModal.getEventDuration());
			String eventStartTime = DateHelper.generateDateStringHavingGivenFormatFromMillies(derControlModal.getEventStartTime(), Constant.DATE_TIME_FORMAT_FULLDATE);			
			derControlEntry.setEventStartTime(eventStartTime);
			derControlEntry.setId(derControlModal.getId());
			derControlEntry.setVersion(derControlModal.getVersion());
			
			//DERControlBase
			
			derControlEntry.setOpModFixedFlow(derControlModal.getOpModFixedFlow());
			derControlEntry.setOpModFixedPFDisplacement(derControlModal.getOpModFixedPFDisplacement());
			derControlEntry.setOpModFixedPFMultiplier(derControlModal.getOpModFixedPFMultiplier());
			derControlEntry.setOpModFixedVArRefType(derControlModal.getOpModFixedVArRefType());
			derControlEntry.setOpModFixedVArValue(derControlModal.getOpModFixedVArValue());
			derControlEntry.setOpModFixedW(derControlModal.getOpModFixedW());
			
			//
			Long getOpModFreqWatt = derControlModal.getOpModFreqWatt();
			derControlEntry.setOpModFreqWatt(getOpModFreqWatt);
			Long getOpModHVRTLowerLimit = derControlModal.getOpModHVRTLowerLimit();
			derControlEntry.setOpModHVRTLowerLimit(getOpModHVRTLowerLimit);
			Long getOpModHVRTUpperLimit = derControlModal.getOpModHVRTUpperLimit();
			derControlEntry.setOpModHVRTUpperLimit(getOpModHVRTUpperLimit);
			Long getOpModLVRTLowerLimit = derControlModal.getOpModLVRTLowerLimit();
			derControlEntry.setOpModLVRTLowerLimit(getOpModLVRTLowerLimit);
			Long getOpModLVRTUpperLimit = derControlModal.getOpModLVRTUpperLimit();
			derControlEntry.setOpModLVRTUpperLimit(getOpModLVRTUpperLimit);
			Long getOpModVoltVAr = derControlModal.getOpModVoltVAr();
			derControlEntry.setOpModVoltVAr(getOpModVoltVAr);
			Long getOpModVoltWatt = derControlModal.getOpModVoltWatt();
			derControlEntry.setOpModVoltWatt(getOpModVoltWatt);
			Long getOpModWattPF = derControlModal.getOpModWattPF();
			derControlEntry.setOpModWattPF(getOpModWattPF);
			
			if(isNotNull(getOpModFreqWatt)){
				derControlEntry.setOpModFreqWattOb(derCurveDao.getById(getOpModFreqWatt));
			}			
			if(isNotNull(getOpModHVRTLowerLimit)){
				derControlEntry.setOpModHVRTLowerLimitOb(derCurveDao.getById(getOpModHVRTLowerLimit));
			}
			if(isNotNull(getOpModHVRTUpperLimit)){
				derControlEntry.setOpModHVRTUpperLimitOb(derCurveDao.getById(getOpModHVRTUpperLimit));
			}
			if(isNotNull(getOpModLVRTLowerLimit)){
				derControlEntry.setOpModLVRTLowerLimitOb(derCurveDao.getById(getOpModLVRTLowerLimit));
			}
			if(isNotNull(getOpModLVRTUpperLimit)){
				derControlEntry.setOpModLVRTUpperLimitOb(derCurveDao.getById(getOpModLVRTUpperLimit));
			}
			if(isNotNull(getOpModVoltVAr)){
				derControlEntry.setOpModVoltVArOb(derCurveDao.getById(getOpModVoltVAr));
			}
			if(isNotNull(getOpModVoltWatt)){
				derControlEntry.setOpModVoltWattOb(derCurveDao.getById(getOpModVoltWatt));
			}
			if(isNotNull(getOpModWattPF)){
				derControlEntry.setOpModWattPFOb(derCurveDao.getById(getOpModWattPF));
			}
			
			//
			derControlEntry.setRampTms(derControlModal.getRampTms());
			
			derControlEntry.setDefaultDERControl(derControlModal.isDefaultDERControl());
			
			return derControlEntry;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
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
	 * DERControlPart
	 * 
	 * 
	 * 
	 */
	
	
}

