package com.gridscape.sep.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.SubscriptionAPIService;
import com.gridscape.sep.application.SubscriptionListResource;
import com.gridscape.sep.org.zigbee.sep.Subscription;
import com.gridscape.sep.org.zigbee.sep.SubscriptionList;


@Service
@Path("/edev/{id}/sub")
public class SubscriptionListResourceImpl implements SubscriptionListResource {
	
	
	@Autowired
	private SubscriptionAPIService subscriptionAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	@Override
	public SubscriptionList GETSubscriptionList(Long deviceId, Integer s, Integer l) {		
		return (request.getScheme().equalsIgnoreCase("https")) ? subscriptionAPIService.GETSubscriptionList(request, deviceId, s, l) : new SubscriptionList();
	}

	@Override
	public void HEADSubscriptionList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTSubscriptionList(Subscription subscription) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTSubscriptionList(Long deviceId, Subscription subscription) {		
		if(request.getScheme().equalsIgnoreCase("https")){
			subscriptionAPIService.POSTSubscriptionList(request, response, deviceId, subscription);
		} else {
			
		}
		
	}

	@Override
	public void DELETESubscriptionList() {
		// TODO Auto-generated method stub
		
	}

	

}

