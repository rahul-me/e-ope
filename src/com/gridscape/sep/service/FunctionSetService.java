package com.gridscape.sep.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.dao.DeviceDao;
import com.gridscape.sep.dao.FunctionSetDao;
	

@Service
public class FunctionSetService {

	@Autowired
	FunctionSetDao fDao;
	@Autowired
	DeviceDao deviceDao;
	
	public FunctionSet save(FunctionSet obj){
		return fDao.save(obj);
	}

	public FunctionSet findById(Long id) {
		return fDao.findById(id);
	}

	public List<FunctionSet> functionSetList() {
		return fDao.functionSetList();
	}
	
	public void deleteFunctionSet(Long id){
		fDao.deleteFunctionSet(id);
	}
	
	public List<FunctionSet> findByDeviceId(Long id){
		return fDao.findByDeviceId(id);
	
	}
	
	public List<FunctionSet> getFunctionSetAssignmentsHavingUserId(String userId, Long device_id){
		return fDao.getFunctionSetAssignmentsHavingUserId(userId, device_id);
	}
}
