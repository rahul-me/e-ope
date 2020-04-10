package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERModel;
import com.gridscape.sep.dao.DERDao;

@Service
public class DERService {
	
	@Autowired
	private DERDao derDao;

	public int saveOrUpdate(DERModel derModel) {
		return derDao.saveOrUpdate(derModel);
	}

	public DERModel getById(Long derId) {
		return derDao.getById(derId);
	}

	public List<DERModel> getListByEndDeviceId(Long endDeviceId) {
		return derDao.getListByEndDeviceId(endDeviceId);
	}
	
	public boolean deleteDER(Long id){
		return derDao.deleteDER(id);
	}
}
