package com.gridscape.model.sep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_log_event")
public class LogEventModel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4997218049555837501L;
	
	@Column(name = "log_event", columnDefinition = "mediumtext")
	private String logEvent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "edev_id", nullable = false)
	private Device device;

	public String getLogEvent() {
		return logEvent;
	}

	public void setLogEvent(String logEvent) {
		this.logEvent = logEvent;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	

}

