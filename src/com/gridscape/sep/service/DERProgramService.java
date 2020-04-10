package com.gridscape.sep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.Device;
import com.gridscape.sep.dao.DERProgramDao;

@Service
public class DERProgramService {

	@Autowired
	DERProgramDao derDao;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private DeviceService deviceService;
	
	public DERProgram save(DERProgram obj){
		return derDao.save(obj);
	}

	public DERProgram findById(Long id){
		return derDao.findById(id);
	}
	
	public List<DERProgram> dERProgramList(){
		return derDao.dERProgramList();
	}
	
	public void deleteDERProgram(Long id){
		derDao.deleteDERProgram(id);
	}
	
	public List<DERProgram> getListByUserId(Long userId){
		List<DERProgram> derPrograms = new ArrayList<DERProgram>();
		List<Device> devices = deviceService.getDevicesByUserId(String.valueOf(userId));
		for(Device device : devices){
			List<DERProgram> derPrograms2 = subscriptionService.getDERPrograms(device.getId());
			if(!derPrograms2.isEmpty()){
				derPrograms.addAll(derPrograms2);
			}
		}
		
		if(!derPrograms.isEmpty()){
			for(int i = 0 ; i < derPrograms.size()-1; i++){
				DERProgram derProgram = derPrograms.get(0);
				for(int j = i+1 ; j < derPrograms.size() ; j++){
					DERProgram derProgram2 = derPrograms.get(j);
					if(derProgram.equals(derProgram2)){
						System.out.println("Equal: "+derProgram.getId());
						derPrograms.remove(derProgram2);
					}
				}
			}
		}
		return derPrograms;
	}
	
	public List<DERProgram> getListByDeviceId(Long endDeviceId){
		List<DERProgram> derPrograms = new ArrayList<DERProgram>();
		List<DERProgram> derPrograms2 = subscriptionService.getDERPrograms(endDeviceId);
		if(!derPrograms2.isEmpty()){
			derPrograms.addAll(derPrograms2);
		}
		return derPrograms;
	}
	
	
	
}
