package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.DERStatusModel;
import com.gridscape.sep.dao.DERStatusDao;

@Service
public class DERStatusService {
	
	@Autowired
	private DERStatusDao derStatusDao;
	
	public int saveOrUpdate(DERStatusModel derStatusModel){
		return derStatusDao.saveOrUpdate(derStatusModel);
	}
	
	public DERStatusModel getById(Long id){
		return derStatusDao.getById(id);
	}
	
	public List<DERStatusModel> getListByDERId(Long id){
		return derStatusDao.getListByDERId(id);
	}
	
	public int deleteById(Long id){
		return derStatusDao.deleteById(id);
	}
}

