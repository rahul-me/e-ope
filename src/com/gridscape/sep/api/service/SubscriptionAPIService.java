package com.gridscape.sep.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.HttpServiceHandler;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.SubscriptionModal;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.org.zigbee.sep.Subscription;
import com.gridscape.sep.org.zigbee.sep.SubscriptionList;
import com.gridscape.sep.service.DERProgramService;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.sep.service.SubscriptionService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class SubscriptionAPIService {

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private UserCertificateService userCertificateService;

	@Autowired
	private HttpServiceHandler httpServiceHandler;

	@Autowired
	private DERProgramService derProgramService;

	private static Logger log = Logger.getLogger(SubscriptionAPIService.class);

	public SubscriptionList GETSubscriptionList(HttpServletRequest request, Long deviceId, Integer s, Integer l) {
		SubscriptionList subscriptionList = new SubscriptionList();
		Device device = userCertificateService.isDeviceExistsWithUserAuthenticityHavingPermissionToDevice(request,
				deviceId);
		if(device != null){
			List<SubscriptionModal> subscriptionModals = subscriptionService.getListByDeviceId(deviceId);
			if(!subscriptionModals.isEmpty()){
				List<Subscription> subscriptions = subscriptionList.getSubscription(); 
				generateSEPObjectListFromModalObjectList(subscriptions, subscriptionModals);
				log.info("Size of Array: "+subscriptions.size());
			}				
		}
		return subscriptionList;
	}

	public void POSTSubscriptionList(HttpServletRequest request, HttpServletResponse response, Long deviceId,
			Subscription subscription) {
		if (isSubscriptionResourceExists(subscription)) {
			Device device = userCertificateService.isDeviceExistsWithUserAuthenticityHavingPermissionToDevice(request,
					deviceId);
			if (device != null) {
				SubscriptionModal subscriptionModal = subscriptionService.getByDeviceIdHavingSubscribedResource(deviceId, subscription.getSubscribedResource());
				if(subscriptionModal != null){
					subscriptionModal.setSubscribedResource(subscription.getSubscribedResource());
					subscriptionModal.setNotificationUri(subscription.getNotificationURI());
					subscriptionService.saveOrUpdate(subscriptionModal);
					notifyToClientAboutSubscription(subscription);
				} else {
					subscriptionService.saveOrUpdate(generateModalFromSEPObject(subscription, deviceId));
					notifyToClientAboutSubscription(subscription);
					SubscriptionModal subscriptionModal2 = subscriptionService.getByDeviceIdHavingSubscribedResource(deviceId, subscription.getSubscribedResource());
					response.setStatus(HttpServletResponse.SC_CREATED);
					response.setHeader("Location", "/edev/"+deviceId+"/sub/"+subscriptionModal2.getId());
				}
				
			}
		}

	}

	private SubscriptionModal generateModalFromSEPObject(Subscription subscription, Long deviceId) {
		SubscriptionModal subscriptionModal = new SubscriptionModal();
		subscriptionModal.setDeviceId(deviceId);
		subscriptionModal.setNotificationUri(subscription.getNotificationURI());
		subscriptionModal.setSubscribedResource(subscription.getSubscribedResource());
		return subscriptionModal;
	}
	
	private Subscription generateSEPObjectFromModal(SubscriptionModal subscriptionModal){
		Subscription subscription = new Subscription();
		subscription.setSubscribedResource(subscriptionModal.getSubscribedResource());
		subscription.setNotificationURI(subscriptionModal.getNotificationUri());
		return subscription;
	}
	
	private List<Subscription> generateSEPObjectListFromModalObjectList(List<Subscription> subscriptions, List<SubscriptionModal> subscriptionModals){		
		for(SubscriptionModal subscriptionModal: subscriptionModals){
			subscriptions.add(generateSEPObjectFromModal(subscriptionModal));
		}
		return subscriptions;
	}

	private boolean notifyToClientAboutSubscription(Subscription subscription) {
		httpServiceHandler.sendPostRequest(subscription);
		return false;
	}

	private boolean isSubscriptionResourceExists(Subscription subscription) {
		boolean is = Boolean.FALSE;
		if (subscription != null && subscription.getSubscribedResource() != null) {
			String resource = subscription.getSubscribedResource();
			if (resource.contains("derp")) {
				try {
					Long derProgramId = Long.parseLong(String.valueOf(resource.charAt(resource.length() - 1)));
					DERProgram derProgram = derProgramService.findById(derProgramId);
					if (derProgram != null)
						is = Boolean.TRUE;
				} catch (Exception e) {
					log.error(e);
				}
			}
		}

		return is;
	}
	
	
	
	/*    Subscription
	 *  
	 */
	
	public Subscription GETSubscription(HttpServletRequest request,Long deviceId, Long subscriptionId){
		Subscription subscription = new Subscription();
		SubscriptionModal subscriptionModal = subscriptionService.getById(subscriptionId);
		if(subscriptionModal != null){
			Device device = userCertificateService.isDeviceExistsWithUserAuthenticityHavingPermissionToDevice(request, deviceId);
			if(device!= null){
				subscription = generateSEPObjectFromModal(subscriptionModal);
			}
		}
		return subscription;
	}
	
	public void PUTSubscription(Subscription subscription, Long deviceId, Long subscriptionId){
		SubscriptionModal subscriptionModal = subscriptionService.getById(subscriptionId);
		if(subscriptionModal != null && subscription != null){
			subscriptionModal.setSubscribedResource(subscription.getSubscribedResource());
			subscriptionModal.setNotificationUri(subscription.getNotificationURI());
			subscriptionService.saveOrUpdate(subscriptionModal);
		}		
	}
	
	public Subscription DELETESubscription(HttpServletRequest request,Long deviceId, Long subscriptionId){
		Subscription subscription = new Subscription();
		SubscriptionModal subscriptionModal = subscriptionService.getById(subscriptionId);
		if(subscriptionModal != null){
			Device device = userCertificateService.isDeviceExistsWithUserAuthenticityHavingPermissionToDevice(request, deviceId);
			if(device != null){
				subscription = generateSEPObjectFromModal(subscriptionModal);
				subscriptionService.deleteById(subscriptionId);				
			}
		}
		return subscription;
	}
	
	

}
