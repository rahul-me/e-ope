package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.CurveDataModal;


public interface CurveDataDao {
	public int saveOrUpdate(CurveDataModal curveDataModal);

	public CurveDataModal getById(Long curveDataId);

	public List<CurveDataModal> getByDerCurveId(Long derCurveId);
	
	public boolean deleteCurveData(Long id);
}
