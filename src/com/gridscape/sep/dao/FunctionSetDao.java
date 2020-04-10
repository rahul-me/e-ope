package com.gridscape.sep.dao;

import java.util.List;
import java.util.Set;

import com.gridscape.model.sep.FunctionSet;

public interface FunctionSetDao {

	public FunctionSet save(FunctionSet obj);

	public FunctionSet findById(Long id);
	
	public List<FunctionSet> functionSetList();
	
	public void deleteFunctionSet(Long id);
	
	public List<FunctionSet> findByDeviceId(Long id);
	
	public List<FunctionSet> getFunctionSetAssignmentsHavingUserId(String userId, Long device_id);
}
