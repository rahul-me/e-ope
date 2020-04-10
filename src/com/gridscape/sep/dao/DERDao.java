package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.DERModel;

public interface DERDao {
	
	public int saveOrUpdate(DERModel derModel);
	
	public DERModel getById(Long derId);
	
	public List<DERModel> getListByEndDeviceId(Long endDeviceId);
	
	public boolean deleteDER(Long id);
}

