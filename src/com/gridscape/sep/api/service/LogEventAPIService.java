package com.gridscape.sep.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.LogEventModel;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.LogEvent;
import com.gridscape.sep.org.zigbee.sep.LogEventList;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.LogEventService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class LogEventAPIService {

	private static Logger log = Logger.getLogger(LogEventAPIService.class);

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private LogEventService logEventService;

	@Autowired
	private UserCertificateService userCertificateService;

	/*
	 * Methods that are part of LogEventListResource
	 */

	public LogEventList GETLogEventList(HttpServletRequest request, Long edevId) {
		LogEventList logEventList = new LogEventList();
		UserCertificate userCertificate = getUserCertificate(request);
		if (userCertificate != null) {
			// Device device = deviceService.findById(edevId);
			Device device = deviceService.findByIdHavingLogEvent(edevId);
			if (device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))) {
				// Set<LogEventModel> logEventModels =
				// device.getLogEventModels();
				// Collection<LogEventModel> logEventModels =
				// logEventService.getByEndDeviceId(edevId);
				Collection<LogEventModel> logEventModels = device.getLogEventModels();
				if (logEventModels != null && !logEventModels.isEmpty()) {
					logEventList = generateLogEventList(logEventModels);
				}
			}
		}
		return logEventList;

	}

	public boolean POSTLogEventList(HttpServletRequest request, HttpServletResponse response, LogEvent logevent, Long edevId) {
		boolean status = false;
		UserCertificate userCertificate = getUserCertificate(request);
		if (userCertificate != null || userCertificate == null) {
			Device device = deviceService.findById(edevId);
			if (device != null /*&& device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))*/) {
				try {
					LogEventModel logEventModel = new LogEventModel();
					logEventModel.setLogEvent(getJSONStr(logevent));
					logEventModel.setDevice(device);
					logEventService.saveOrUpdate(logEventModel);
					status = true;
					response.setHeader("Location", "/edev/"+edevId+"/lel/"+logEventModel.getId());
				} catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	/*
	 * Methods that are part of LogEventResource
	 */

	public LogEvent GETLogEvent(HttpServletRequest request, Long edevId, Long leId) {
		LogEvent logEvent = new LogEvent();
		UserCertificate userCertificate = getUserCertificate(request);
		if(userCertificate != null){
			LogEventModel logEventModel = logEventService.getById(leId);
			if(logEventModel != null){
				Device device = logEventModel.getDevice();
				if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
					LogEvent logEvent2 = getSEPObjectFromModelObject(logEventModel);
					if(logEvent2 != null){
						logEvent = logEvent2;
					}
				}
			}
		}
		return logEvent;
	}

	public boolean PUTLogEvent(HttpServletRequest request, LogEvent logevent, Long edevId, Long leId) {
		boolean status = false;
		UserCertificate userCertificate = getUserCertificate(request);
		if(userCertificate != null || userCertificate == null){
			LogEventModel logEventModel = logEventService.getById(leId);
			if(logEventModel != null){
				Device device = logEventModel.getDevice();
				if(device != null /*&& device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))*/){
					logEventModel.setLogEvent(getJSONStr(logevent));
					int result = logEventService.saveOrUpdate(logEventModel);
					if(result != -1){
						status = true;
					}					
				}
			}
		}
		return status;
	}

	public LogEvent DELETELogEvent(HttpServletRequest request, Long edevId, Long leId) {
		LogEvent logEvent = new LogEvent();
		UserCertificate userCertificate = getUserCertificate(request);
		if(userCertificate != null){
			LogEventModel logEventModel = logEventService.getById(leId);
			if(logEventModel != null){
				Device device = logEventModel.getDevice();
				if(device != null && device.getUser_id().equalsIgnoreCase(String.valueOf(userCertificate.getUser_id()))){
					LogEvent logEvent2 = getSEPObjectFromModelObject(logEventModel);
					if(logEvent2 != null){
						logEvent = logEvent2;
						logEventService.delete(logEventModel);
					}
				}
			}
		}
		return logEvent;
	}

	/*
	 * Helper methods
	 */

	private LogEvent getSEPObjectFromModelObject(LogEventModel logEventModel) {
		LogEvent logEvent = null;
		String logEventJSONStr = logEventModel.getLogEvent();
		Object object = Utility.getObjectFromJSONString(logEventJSONStr, LogEvent.class);
		if (object != null && object instanceof LogEvent) {
			logEvent = (LogEvent) object;
			logEvent.setHref("/edev/" + logEventModel.getDevice().getId() + "/lel/"+logEventModel.getId());
		}
		return logEvent;
	}

	private String getJSONStr(LogEvent logEvent) {
		return Utility.convertToJsonString(logEvent);
	}

	private LogEventList generateLogEventList(Collection<LogEventModel> logEventModels) {
		LogEventList logEventList = new LogEventList();
		List<LogEvent> logEvents = logEventList.getLogEvent();
		for (LogEventModel logEventModel : logEventModels) {
			LogEvent logEvent = getSEPObjectFromModelObject(logEventModel);
			if (logEvent != null) {
				logEvents.add(logEvent);
			}
		}
		return logEventList;
	}
	
	private UserCertificate getUserCertificate(HttpServletRequest request){
		return userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
	}

}
