package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.Device;
import com.gridscape.sep.dao.DeviceDao;	



@Service
public class DeviceService {	
	@Autowired
	DeviceDao dDao;
	
	public Device save(Device obj){	
		return dDao.save(obj);
	}

	public Device findById(Long id) {
		return dDao.findById(id);
	}
	
	public Device findByIdHavingLogEvent(Long id) {
		return dDao.findByIdHavingLogEvents(id);
	}

	public List<Device> deviceList() {
		return dDao.deviceList();
	}
	
	public void deleteDevice(Long id){
		dDao.deleteDevice(id);
	}
	
	public int getNumberOfDevice(){
		return dDao.getNumberOfDevice();
	}
	
	public List<Device> getDevicesByUserId(String userId){
		return dDao.getDevicesByUserId(userId);
	}

}
