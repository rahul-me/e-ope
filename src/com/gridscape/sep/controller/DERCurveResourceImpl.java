package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERCurveAPIService;
import com.gridscape.sep.application.DERCurveResource;
import com.gridscape.sep.org.zigbee.sep.DERCurve;

@Service
@Path("/derp/{derp_id}/dc/{dc_id}")
public class DERCurveResourceImpl implements DERCurveResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERCurveAPIService derCurveAPIService;
	
	@Override
	public DERCurve GETDERCurve(Long derpId, Long dcId) {
		
		return (request.getScheme().equalsIgnoreCase("https")) ? derCurveAPIService.GETDERCurve(request, derpId, dcId) : new DERCurve();
	}

	@Override
	public void HEADDERCurve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDERCurve(DERCurve dercurve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDERCurve(DERCurve dercurve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DERCurve DELETEDERCurve() {
		// TODO Auto-generated method stub
		return null;
	}

}

