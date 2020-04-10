package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.LogEventAPIService;
import com.gridscape.sep.application.LogEventListResource;
import com.gridscape.sep.org.zigbee.sep.LogEvent;
import com.gridscape.sep.org.zigbee.sep.LogEventList;

@Service
@Path("/edev/{edevId}/lel")
public class LogEventListResourceImpl implements LogEventListResource {
	
	
	@Autowired
	private LogEventAPIService logEventAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	@Override
	public LogEventList GETLogEventList(Integer s, Integer a, Integer l, Long edevId) {
		return (isSchemeSecure()) ? logEventAPIService.GETLogEventList(request, edevId): new LogEventList();
	}

	@Override
	public void HEADLogEventList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTLogEventList(LogEvent logevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTLogEventList(LogEvent logevent, Long edevId) {
		if(isSchemeSecure()){
			
		}
		logEventAPIService.POSTLogEventList(request, response, logevent, edevId);
	}

	@Override
	public void DELETELogEventList() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isSchemeSecure(){
		return (request.getScheme().equalsIgnoreCase("https")) ? true : false;
	}

}

