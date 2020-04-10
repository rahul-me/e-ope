package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.MirrorUsagePointAPIService;
import com.gridscape.sep.application.MirrorUsagePointResource;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint;

@Service
@Path("/mup/{mupId}")
public class MirrorUsagePointResourceImpl implements MirrorUsagePointResource {
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	@Autowired
	private MirrorUsagePointAPIService mirrorUsagePointAPIService;
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.MirrorUsagePointResource#GETMirrorUsagePoint()
	 */
	@Override
	public MirrorUsagePoint GETMirrorUsagePoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void HEADMirrorUsagePoint() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.MirrorUsagePointResource#PUTMirrorUsagePoint(com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint)
	 */
	@Override
	public void PUTMirrorUsagePoint(MirrorUsagePoint mirrorusagepoint, Long mupId) {
		if(isSecureScheme(request)){
			
		} else {
			
		}
		mirrorUsagePointAPIService.PUTMirrorUsagePoint(request, mirrorusagepoint, mupId);
		
	}
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.MirrorUsagePointResource#POSTMirrorUsagePoint(javax.xml.transform.Source)
	 */
	@Override
	public void POSTMirrorUsagePoint(Source source, Long mupId) {
		if(isSecureScheme(request)){
			
		} else {
			
		}
		mirrorUsagePointAPIService.POSTMirrorUsagePoint(request, response, source, mupId);
	}
	
	/*
	 * Required
	 * (non-Javadoc)
	 * @see com.gridscape.sep.application.MirrorUsagePointResource#DELETEMirrorUsagePoint()
	 */
	@Override
	public MirrorUsagePoint DELETEMirrorUsagePoint(Long mupId) {
		return mirrorUsagePointAPIService.DELETEMirrorUsagePoint(request, mupId);
		
	}
	
	private boolean isSecureScheme(HttpServletRequest request){
		return (request.getScheme().equalsIgnoreCase("https")) ? true : false;
	}
	
}

