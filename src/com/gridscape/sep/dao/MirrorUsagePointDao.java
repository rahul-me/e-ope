package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.MirrorUsagePointModel;

public interface MirrorUsagePointDao {
	
	public int saveOrUpdate(MirrorUsagePointModel mirrorUsagePointModel);
	
	public MirrorUsagePointModel getById(Long id);
		
	public int deleteById(Long id);
	
	public List<MirrorUsagePointModel> getAll();
}

