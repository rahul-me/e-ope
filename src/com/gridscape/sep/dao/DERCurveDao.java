package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.DERCurveModal;

public interface DERCurveDao {
	
	public int saveOrUpdate(DERCurveModal derCurveModal);
	
	public DERCurveModal getById(Long dercId);
	
	public List<DERCurveModal> getByDerpId(Long derpId);
}

