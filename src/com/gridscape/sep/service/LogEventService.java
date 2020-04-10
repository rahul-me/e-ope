package com.gridscape.sep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.model.sep.LogEventModel;
import com.gridscape.sep.dao.LogEventDao;

@Service
public class LogEventService {

	@Autowired
	private LogEventDao logEventDao;
	
	public int saveOrUpdate(LogEventModel logEventModel){
		return logEventDao.saveOrUpdate(logEventModel);
	}
	
	public List<LogEventModel> getAll(){
		return logEventDao.getAll();
	}
	
	public List<LogEventModel> getByEndDeviceId(Long edevId){
		return logEventDao.getByEndDeviceId(edevId);
	}
	
	public int delete(Long leId){
		return logEventDao.delete(leId);
	}
	
	public LogEventModel getById(Long leId){
		return logEventDao.getById(leId);
	}
	
	public int delete(LogEventModel logEventModel){
		return logEventDao.delete(logEventModel);
	}
	
	
	
}

