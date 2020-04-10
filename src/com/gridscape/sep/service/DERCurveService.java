package com.gridscape.sep.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERCurveModal;
import com.gridscape.sep.dao.DERCurveDao;

@Service
public class DERCurveService {
	
	@Autowired
	private DERCurveDao derCurveDao;
	
	public int saveOrUpdate(DERCurveModal derCurveModal){
		return derCurveDao.saveOrUpdate(derCurveModal);
	}

	public DERCurveModal getById(Long dercId) {
		return derCurveDao.getById(dercId);
	}

	public List<DERCurveModal> getByDerpId(Long derpId){
		return derCurveDao.getByDerpId(derpId);
	}
	
	public int save(DERCurveModal derCurveModal){
		derCurveModal.setCreationTime(Calendar.getInstance().getTimeInMillis());
		return saveOrUpdate(derCurveModal);
	}
}
