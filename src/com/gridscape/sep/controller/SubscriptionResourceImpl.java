package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.sep.api.service.SubscriptionAPIService;
import com.gridscape.sep.application.SubscriptionResource;
import com.gridscape.sep.org.zigbee.sep.Subscription;

@Service
@Path("/edev/{deviceId}/sub/{subId}")
public class SubscriptionResourceImpl implements SubscriptionResource {

	@Autowired
	private SubscriptionAPIService subscriptionAPIService;

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	@Override
	public Subscription GETSubscription(Long deviceId, Long subscriptionId) {
		return (request.getScheme().equalsIgnoreCase("https"))
				? subscriptionAPIService.GETSubscription(request, deviceId, subscriptionId) : new Subscription();
	}

	@Override
	public void HEADSubscription() {
		// TODO Auto-generated method stub

	}

	@Override
	public void PUTSubscription(Subscription subscription, Long deviceId, Long subscriptionId) {
		if(isRequestContextIsSecure())subscriptionAPIService.PUTSubscription(subscription, deviceId, subscriptionId);
	}

	@Override
	public void POSTSubscription(Subscription subscription) {
		// TODO Auto-generated method stub

	}

	@Override
	public Subscription DELETESubscription(Long deviceId, Long subscriptionId) {
		return (isRequestContextIsSecure()) ? subscriptionAPIService.DELETESubscription(request, deviceId,subscriptionId) : new Subscription();		
	}
	
	private boolean isRequestContextIsSecure(){
		return (request.getScheme().equalsIgnoreCase("https")) ? Boolean.TRUE : Boolean.FALSE;
	}

}
