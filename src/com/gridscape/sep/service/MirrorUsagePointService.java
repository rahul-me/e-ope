package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.MirrorUsagePointModel;
import com.gridscape.sep.dao.MirrorUsagePointDao;

@Service
public class MirrorUsagePointService {
	
	@Autowired
	private MirrorUsagePointDao mirrorUsagePointDao;
	
	public int saveOrUpdate(MirrorUsagePointModel mirrorUsagePointModel){
		return mirrorUsagePointDao.saveOrUpdate(mirrorUsagePointModel);
	}
	
	public MirrorUsagePointModel getById(Long id){
		return mirrorUsagePointDao.getById(id);
	}
		
	public int deleteById(Long id){
		return mirrorUsagePointDao.deleteById(id);
	}
	
	public List<MirrorUsagePointModel> getAll(){
		return mirrorUsagePointDao.getAll();
	}
}

