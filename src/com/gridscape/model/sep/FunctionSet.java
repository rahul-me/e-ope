package com.gridscape.model.sep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_device_functionset")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionSet extends BaseEntity implements Serializable{

private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "device_id", nullable = false)
	private Device device;

	@Column(name = "user_id", length = 50)
	private String user_id;

	@Column(name = "m_rid", length = 50)
	private String m_rid;
	
	@Column(name = "description", length = 50)
	private String description;
	
	@Column(name = "version",columnDefinition="int default 0")
	private int version;
		
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getM_rid() {
		return m_rid;
	}

	public void setM_rid(String m_rid) {
		this.m_rid = m_rid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Device getDevice_id() {
		return device;
	}

	public void setDevice_id(Device device_id) {
		this.device = device_id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((device == null) ? 0 : device.hashCode());		
		result = prime * result + ((m_rid == null) ? 0 : m_rid.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionSet other = (FunctionSet) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;		
		if (m_rid == null) {
			if (other.m_rid != null)
				return false;
		} else if (!m_rid.equals(other.m_rid))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	
	
	
}
