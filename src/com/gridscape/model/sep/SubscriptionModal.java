package com.gridscape.model.sep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name="sep_subscription")
public class SubscriptionModal extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1682311168236439933L;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "subscribed_resource")
	private String subscribedResource;
	
	@Column(name = "device_id")
	private Long deviceId;
	
	@Column(name = "notification_uri")
	private String notificationUri;

	public String getNotificationUri() {
		return notificationUri;
	}

	public void setNotificationUri(String notificationUri) {
		this.notificationUri = notificationUri;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSubscribedResource() {
		return subscribedResource;
	}

	public void setSubscribedResource(String subscribedResource) {
		this.subscribedResource = subscribedResource;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	
}

