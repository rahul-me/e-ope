package com.gridscape.sep.api.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERModel;
import com.gridscape.model.sep.DERStatusModel;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.ConnectStatusType;
import com.gridscape.sep.org.zigbee.sep.DERStatus;
import com.gridscape.sep.org.zigbee.sep.InverterStatusType;
import com.gridscape.sep.org.zigbee.sep.LocalControlModeStatusType;
import com.gridscape.sep.org.zigbee.sep.ManufacturerStatusType;
import com.gridscape.sep.org.zigbee.sep.OperationalModeStatusType;
import com.gridscape.sep.org.zigbee.sep.PerCent;
import com.gridscape.sep.org.zigbee.sep.StateOfChargeStatusType;
import com.gridscape.sep.org.zigbee.sep.StorageModeStatusType;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.service.DERService;
import com.gridscape.sep.service.DERStatusService;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class DERStatusAPIService {
	
	private static Logger log = Logger.getLogger(DERStatusAPIService.class);
	
	@Autowired
	private DERStatusService derStatusService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	@Autowired
	private DERService derService;
	
	public boolean PUTDERStatus(HttpServletRequest request, DERStatus derStatus, Long endDeviceId, Long derId){
		int result = 0;
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			Device device = deviceService.findById(endDeviceId);			
			if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
				DERModel derModel = derService.getById(derId);
				if(derModel != null && derModel.getEndDeviceId().longValue() == endDeviceId.longValue()){
					boolean recordExist = false;
					DERStatusModel derStatusModelt = derStatusService.getById(derId);
					if(derStatusModelt != null){
						recordExist = true;
					}
					DERStatusModel derStatusModel = generateDERStatusModelFromDERStatus(derStatus);
					derStatusModel.setDerModel(derModel);
					if(recordExist){
						derStatusModel.setId(derModel.getId());
					}
					result = derStatusService.saveOrUpdate(derStatusModel);
				}
			}
		}
		return (result == -1) ? false : true;
	}
	
	public DERStatus GETDERStatus(HttpServletRequest request, Long endDeviceId, Long derId){
		DERStatus requiredDERStatus = null;
		boolean status = false;
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			Device device = deviceService.findById(endDeviceId);
			if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
				DERModel derModel = derService.getById(derId);
				if(derModel != null && derModel.getEndDeviceId().longValue() == endDeviceId.longValue()){									
					DERStatusModel derStatusModel = derModel.getDerStatusModel();
					if(derStatusModel != null){
						DERStatus derStatus = generateDERStatusFromDERStatusModel(derStatusModel, derModel);
						requiredDERStatus = derStatus;
						status = true;
					}
				}
			}
		}
		return (status) ? requiredDERStatus : new DERStatus();
	}
	
	private DERStatusModel generateDERStatusModelFromDERStatus(DERStatus derStatus){
		DERStatusModel derStatusModel = new DERStatusModel();		
		TimeType timeType = null;
		
		if(isNotNull(derStatus)){
			ConnectStatusType genConStaType =  derStatus.getGenConnectStatus();
			if(isNotNull(genConStaType)){
				timeType = genConStaType.getDateTime();
				if(isNotNull(timeType)){
					derStatusModel.setGenConnectStatusTime(timeType.getValue());
				}
				derStatusModel.setGenConnectStatus(genConStaType.getValue());				
			}
			
			InverterStatusType inverterStatusType = derStatus.getInverterStatus();
			if(isNotNull(inverterStatusType)){
				timeType = inverterStatusType.getDateTime();
				if(isNotNull(timeType)){
					derStatusModel.setInverterStatusTime(timeType.getValue());
				}
				derStatusModel.setInverterStatus(inverterStatusType.getValue());
			}
			
			LocalControlModeStatusType localControlModeStatusType = derStatus.getLocalControlModeStatus();
			if(isNotNull(localControlModeStatusType)){
				timeType = localControlModeStatusType.getDateTime();
				if(isNotNull(timeType)){
					derStatusModel.setLocalControlModeStatusTime(timeType.getValue());
				}
				derStatusModel.setLocalControlModeStatus(localControlModeStatusType.getValue());
			}
			
			ManufacturerStatusType manufacturerStatus = derStatus.getManufacturerStatus();
			if(isNotNull(manufacturerStatus)){
				timeType = manufacturerStatus.getDateTime();
				if(isNotNull(timeType)){
					derStatusModel.setManufacturerStatusTime(timeType.getValue());
				}
				derStatusModel.setManufacturerStatus(manufacturerStatus.getValue());
			}
			
			OperationalModeStatusType operationalModeStatusType = derStatus.getOperationalModeStatus();
			if(isNotNull(operationalModeStatusType)){
				addPara(operationalModeStatusType, derStatusModel, "setOperationalModeStatus");
			}
			
			StateOfChargeStatusType stateOfChargeStatusType = derStatus.getStateOfChargeStatus();
			if(stateOfChargeStatusType != null){
				timeType = stateOfChargeStatusType.getDateTime();
				if(isNotNull(timeType)){
					derStatusModel.setStateOfChargeStatusTime(timeType.getValue());
				}
				PerCent perCent = stateOfChargeStatusType.getValue();
				if(isNotNull(perCent)){
					derStatusModel.setStateOfChargeStatus(perCent.getValue());
				}				
			}
			
			StorageModeStatusType storageModeStatusType = derStatus.getStorageModeStatus();
			if(isNotNull(storageModeStatusType)){
				addPara(storageModeStatusType, derStatusModel, "setStorageModeStatus");
			}
			
			timeType = derStatus.getReadingTime();
			if(isNotNull(timeType)){
				derStatusModel.setReadingTime(timeType.getValue());
			}
			
			
			
			
			
		} else {
			return null;
		}
		return derStatusModel;
		
	}
	
	private DERStatus generateDERStatusFromDERStatusModel(DERStatusModel derStatusModel, DERModel derModel){
		DERStatus derStatus = new DERStatus();
		try {			
			derStatus.setHref("/edev/"+derModel.getEndDeviceId()+"/der/"+derModel.getId()+"/ders");
			
			TimeType timeType = null;
			long timeVal = 0;
			
			timeVal = derStatusModel.getGenConnectStatusTime();
			if(timeVal != 0){
				ConnectStatusType connectStatusType = new ConnectStatusType();
				addPara(connectStatusType, timeVal, derStatusModel.getGenConnectStatus());
				derStatus.setGenConnectStatus(connectStatusType);
				/*timeType = new TimeType();
				timeType.setValue(timeVal);
				connectStatusType.setDateTime(timeType);
				connectStatusType.setValue(derStatusModel.getGenConnectStatus());*/
			}
			
			timeVal = derStatusModel.getInverterStatusTime();
			if(timeVal != 0){
				InverterStatusType inverterStatusType = new InverterStatusType();
				addPara(inverterStatusType, timeVal, derStatusModel.getInverterStatus());
				derStatus.setInverterStatus(inverterStatusType);
			}
			
			timeVal = derStatusModel.getLocalControlModeStatusTime();
			if(timeVal != 0){
				LocalControlModeStatusType localControlModeStatusType = new LocalControlModeStatusType();
				addPara(localControlModeStatusType, timeVal, derStatusModel.getInverterStatus());
				derStatus.setLocalControlModeStatus(localControlModeStatusType);
			}
			
			timeVal = derStatusModel.getManufacturerStatusTime();
			if(timeVal != 0){
				ManufacturerStatusType manufacturerStatusType  = new ManufacturerStatusType();
				addPara(manufacturerStatusType, timeVal, derStatusModel.getManufacturerStatus());
				derStatus.setManufacturerStatus(manufacturerStatusType);
			}
			
			timeVal = derStatusModel.getOperationalModeStatusTime();
			if(timeVal != 0){
				OperationalModeStatusType operationalModeStatusType = new OperationalModeStatusType();
				addPara(operationalModeStatusType, timeVal, derStatusModel.getOperationalModeStatus());
				derStatus.setOperationalModeStatus(operationalModeStatusType);
			}
			
			timeVal = derStatusModel.getReadingTime();
			if(timeVal != 0){
				timeType = new TimeType();
				timeType.setValue(timeVal);
				derStatus.setReadingTime(timeType);
			}
			
			timeVal = derStatusModel.getStateOfChargeStatusTime();
			if(timeVal != 0){
				StateOfChargeStatusType stateOfChargeStatusType = new StateOfChargeStatusType();
				addPara(stateOfChargeStatusType, timeVal, derStatusModel.getStateOfChargeStatus());
				derStatus.setStateOfChargeStatus(stateOfChargeStatusType);
			}
			
			timeVal = derStatusModel.getStorageModeStatusTime();
			if(timeVal != 0){
				StorageModeStatusType storageModeStatusType = new StorageModeStatusType();
				addPara(storageModeStatusType, timeVal, derStatusModel.getStorageModeStatus());
				derStatus.setStorageModeStatus(storageModeStatusType);
			}
			
			timeVal = derStatusModel.getStorConnectStatusTime();
			if(timeVal != 0){
				ConnectStatusType connectStatusType = new ConnectStatusType();
				addPara(connectStatusType, timeVal, derStatusModel.getStorConnectStatus());
				derStatus.setStorConnectStatus(connectStatusType);
			}			
			
		} catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		
		
		return derStatus;
	}
	
	private <T> boolean isNotNull(@SuppressWarnings("unchecked") T... val) {
		for (T t : val) {
			if (t == null) {
				return false;
			}
		}
		return true;
	}
	
	private <T> void addPara(T derStatus, long timeVal, short val){
		TimeType timeType = new TimeType();
		timeType.setValue(timeVal);
		try {
			Method methSetDateTime = derStatus.getClass().getMethod("setDateTime", TimeType.class);
			Method methSetValue = derStatus.getClass().getMethod("setValue", short.class);
			try {
				methSetDateTime.invoke(derStatus, timeType);
				methSetValue.invoke(derStatus, val);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}						
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private <T> void addPara(T derStatus, long timeVal, String val){
		TimeType timeType = new TimeType();
		timeType.setValue(timeVal);
		try {
			Method methSetDateTime = derStatus.getClass().getMethod("setDateTime", TimeType.class);
			Method methSetValue = derStatus.getClass().getMethod("setValue", String.class);
			try {
				methSetDateTime.invoke(derStatus, timeType);
				methSetValue.invoke(derStatus, val);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}						
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private <T> void addPara(T derStatus, long timeVal, int val){
		TimeType timeType = new TimeType();
		PerCent perCent = new PerCent();
		timeType.setValue(timeVal);
		perCent.setValue(val);
		try {
			Method methSetDateTime = derStatus.getClass().getMethod("setDateTime", TimeType.class);
			Method methSetValue = derStatus.getClass().getMethod("setValue", PerCent.class);
			try {
				methSetDateTime.invoke(derStatus, timeType);
				methSetValue.invoke(derStatus, perCent);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}						
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private <T> void addPara(T obj, DERStatusModel derStatusModel, String dsmMethod){
		try {
			Method method = obj.getClass().getMethod("getDateTime");
			TimeType timeType = (TimeType) method.invoke(obj);
			
			if(isNotNull(timeType)){
				Method methodDerStatusModel = derStatusModel.getClass().getMethod(dsmMethod+"Time", long.class);
				methodDerStatusModel.invoke(derStatusModel, timeType.getValue());
			}
			
			method = obj.getClass().getMethod("getValue");
			short value = (Short) method.invoke(obj);
			
			method = derStatusModel.getClass().getMethod(dsmMethod, short.class);
			method.invoke(derStatusModel, value);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			log.error(e);
		} catch (SecurityException e) {
			e.printStackTrace();
			log.error(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			log.error(e);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.error(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			log.error(e);
		}
	}
}

