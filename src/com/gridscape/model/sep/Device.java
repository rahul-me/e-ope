package com.gridscape.model.sep;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.BaseEntity;


@Entity
@Table(name = "sep_devices")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name = "s_fdi")
	private Long s_fdi;
	
	@Column(name = "pin")
	private Long pin;
	
	@Column(name = "device_category_type", length = 50)
	private String device_category_type;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	private Set<FunctionSet> functions;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	private Set<LogEventModel> logEventModels;
	
	@Column(name = "device_information", columnDefinition = "mediumtext")
	private String deviceInformation;
		
	public String getDeviceInformation() {
		return deviceInformation;
	}

	public void setDeviceInformation(String deviceInformation) {
		this.deviceInformation = deviceInformation;
	}

	public Set<LogEventModel> getLogEventModels() {
		return logEventModels;
	}

	public void setLogEventModels(Set<LogEventModel> logEventModels) {
		this.logEventModels = logEventModels;
	}

	public String getUser_id() {
		return user_id;
	}	

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDevice_category_type() {
		return device_category_type;
	}

	public void setDevice_category_type(String device_category_type) {
		this.device_category_type = device_category_type;
	}

	public long getS_fdi() {
		return s_fdi;
	}

	public void setS_fdi(long s_fdi) {
		this.s_fdi = s_fdi;
	}

	public Set<FunctionSet> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<FunctionSet> functions) {
		this.functions = functions;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((device_category_type == null) ? 0 : device_category_type.hashCode());
		result = prime * result + ((functions == null) ? 0 : functions.hashCode());
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
		Device other = (Device) obj;
		if (device_category_type == null) {
			if (other.device_category_type != null)
				return false;
		} else if (!device_category_type.equals(other.device_category_type))
			return false;
		if (functions == null) {
			if (other.functions != null)
				return false;
		} else if (!functions.equals(other.functions))
			return false;
		if (s_fdi == null) {
			if (other.s_fdi != null)
				return false;
		} else if (!s_fdi.equals(other.s_fdi))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Device [user_id=" + user_id + ", s_fdi=" + s_fdi + ", pin=" + pin + ", device_category_type="
				+ device_category_type + " ]";
	}

	
}
