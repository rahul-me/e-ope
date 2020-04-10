package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.DERCurveAPIService;
import com.gridscape.sep.application.DERCurveListResource;
import com.gridscape.sep.org.zigbee.sep.DERCurve;
import com.gridscape.sep.org.zigbee.sep.DERCurveList;

@Service
@Path("/derp/{derp_id}/dc")
public class DERCurveListResourceImpl implements DERCurveListResource {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private DERCurveAPIService derCurveAPIService;
	
	@Override
	public DERCurveList GETDERCurveList(Integer s, Integer l, Long derpId) {
		return (request.getScheme().equalsIgnoreCase("https")) ? derCurveAPIService.GETDERCurveList(request, derpId) : new DERCurveList();
	}

	@Override
	public void HEADDERCurveList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTDERCurveList(DERCurve dercurve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTDERCurveList(DERCurve dercurve) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEDERCurveList() {
		// TODO Auto-generated method stub
		
	}

}

