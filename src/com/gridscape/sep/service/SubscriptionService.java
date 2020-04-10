package com.gridscape.sep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.SubscriptionModal;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.dao.DERProgramDao;
import com.gridscape.sep.dao.SubscriptionDao;

@Service
public class SubscriptionService {
	
	
	@Autowired
	private SubscriptionDao subscriptionDao;
	
	@Autowired
	private DERProgramDao derProgramDao;
	
	@Autowired
	private ConfigProperties configProperties;
	
	public int saveOrUpdate(SubscriptionModal subscriptionModal){
		return subscriptionDao.saveOrUpdate(subscriptionModal);
	}
	
	public SubscriptionModal getById(Long subscriptionId){
		return subscriptionDao.getById(subscriptionId);
	}
	
	public List<SubscriptionModal> getListByDeviceId(Long deviceId){
		return subscriptionDao.getListByDeviceId(deviceId);
	}
	
	public List<SubscriptionModal> getListByDeviceIdHavingSubscriptionLike(Long deviceId, String subscription){
		return subscriptionDao.getListByDeviceIdHavingSubscriptionLike(deviceId, subscription);
	}
	
	public SubscriptionModal getByDeviceIdHavingSubscribedResource(Long deviceId, String subscribedResource){
		return subscriptionDao.getByDeviceIdHavingSubscribedResource(deviceId, subscribedResource);
	}
	
	public int deleteById(Long subscriptionId){
		return subscriptionDao.deleteById(subscriptionId);
	}
	
	public List<DERProgram> getDERPrograms(Long endDeviceId){
		boolean status = false;
		List<DERProgram> derPrograms = new ArrayList<DERProgram>();
		List<SubscriptionModal> subscriptionModals = getListByDeviceIdHavingSubscriptionLike(endDeviceId, "derp");
		if(subscriptionModals != null && !subscriptionModals.isEmpty()){
			for(SubscriptionModal subscriptionModal : subscriptionModals){
				String subscribedResource = subscriptionModal.getSubscribedResource();
				Long derpId = Long.parseLong(String.valueOf(subscribedResource.charAt(subscribedResource.length()-1)));
				DERProgram derProgram = derProgramDao.findById(derpId);
				if(derProgram != null){
					byte vals[] = Utility.getMRIDValue(derProgram.getId(), configProperties.getIanaPEN());
					StringBuilder stringBuilder = new StringBuilder();
					for(byte val: vals){
						stringBuilder.append(String.format("%02X", val));
					}					
					derProgram.setM_rid(stringBuilder.toString());
					derPrograms.add(derProgram);
				}
			}
		}
		return derPrograms;
	}
		
}

