package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.CurveDataModal;
import com.gridscape.sep.dao.CurveDataDao;

@Service
public class CurveDataService {
	
	@Autowired
	private CurveDataDao curveDataDao;
	
	public int saveOrUpdate(CurveDataModal curveDataModal){
		return curveDataDao.saveOrUpdate(curveDataModal);
	}

	public CurveDataModal getById(Long curveDataId){
		return curveDataDao.getById(curveDataId);
	}

	public List<CurveDataModal> getByDerCurveId(Long derCurveId){
		return curveDataDao.getByDerCurveId(derCurveId);
	}
	
	public boolean deleteCurveData(Long id){
		return curveDataDao.deleteCurveData(id);
	}
}

