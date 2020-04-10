package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.LogEventModel;

public interface LogEventDao {
	
	public int saveOrUpdate(LogEventModel logEventModel);
	
	public List<LogEventModel> getAll();
	
	public List<LogEventModel> getByEndDeviceId(Long edevId);
	
	public int delete(Long leId);
	
	public LogEventModel getById(Long leId);
	
	public int delete(LogEventModel logEventModel);
}

