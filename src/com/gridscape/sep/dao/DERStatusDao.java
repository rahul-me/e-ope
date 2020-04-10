package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.DERStatusModel;

public interface DERStatusDao {
	
	public int saveOrUpdate(DERStatusModel derStatusModel);
	
	public DERStatusModel getById(Long id);
	
	public List<DERStatusModel> getListByDERId(Long id);
	
	public int deleteById(Long id);
}

