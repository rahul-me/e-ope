package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.LogEventAPIService;
import com.gridscape.sep.application.LogEventResource;
import com.gridscape.sep.org.zigbee.sep.LogEvent;

@Service
@Path("/edev/{edevId}/lel/{leId}")
public class LogEventResourceImpl implements LogEventResource {
	
	@Autowired
	private LogEventAPIService logEventAPIService;
	
	@Context
	private HttpServletRequest request;
	
	/*
	 * 
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.LogEventResource#GETLogEvent()
	 */
	@Override
	public LogEvent GETLogEvent(Long edevId, Long leId) {
		return (isSchemeSecure()) ? logEventAPIService.GETLogEvent(request, edevId, leId) : new LogEvent();
	}

	@Override
	public void HEADLogEvent() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.LogEventResource#PUTLogEvent(com.gridscape.sep.org.zigbee.sep.LogEvent)
	 */
	@Override
	public void PUTLogEvent(LogEvent logevent, Long edevId, Long leId) {
		if(isSchemeSecure()){
			
		}
		logEventAPIService.PUTLogEvent(request, logevent, edevId, leId);
	}

	@Override
	public void POSTLogEvent(LogEvent logevent) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.LogEventResource#DELETELogEvent(java.lang.Long, java.lang.Long)
	 */
	@Override
	public LogEvent DELETELogEvent(Long edevId, Long leId) {
		return (isSchemeSecure()) ? logEventAPIService.DELETELogEvent(request, edevId, leId) : new LogEvent();
	}
	
	private boolean isSchemeSecure(){
		return (request.getScheme().equalsIgnoreCase("https")) ? true : false;
	}
	
}

