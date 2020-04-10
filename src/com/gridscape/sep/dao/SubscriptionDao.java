package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.SubscriptionModal;
import com.gridscape.sep.org.zigbee.sep.Subscription;

public interface SubscriptionDao {
	public int saveOrUpdate(SubscriptionModal subscriptionModal);
	
	public SubscriptionModal getById(Long subscriptionId);
	
	public List<SubscriptionModal> getListByDeviceId(Long deviceId);
	
	public List<SubscriptionModal> getListByDeviceIdHavingSubscriptionLike(Long deviceId, String subscription);
	
	public SubscriptionModal getByDeviceIdHavingSubscribedResource(Long deviceId, String subscribedResource);
	
	public int deleteById(Long subscriptionId);
	
}

