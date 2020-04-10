package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.DERControlModal;

public interface DERControlDao {
	
	public int saveOrUpdate(DERControlModal derControlModal);
	
	public DERControlModal getById(Long dercId);
	
	public List<DERControlModal> getByDerpId(Long derpId);
	
	public boolean deleteDERControl(Long id);
	
	public DERControlModal getDefaultTypeDERControl(Long derpId);
	
	public List<DERControlModal> getNormalTypeDERControl(Long derpId);
}

