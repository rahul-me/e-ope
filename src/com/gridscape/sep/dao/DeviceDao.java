package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.Device;



public interface DeviceDao {
 
	public Device save(Device obj);

	public Device findById(Long id);

	public List<Device> deviceList();
	
	public void deleteDevice(Long id);
	
	public int getNumberOfDevice();
	
	public List<Device> getDevicesByUserId(String userId);
	
	public Device findByIdHavingLogEvents(Long id);
	
}
