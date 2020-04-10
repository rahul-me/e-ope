package com.gridscape.sep.dao;

import java.util.List;

import com.gridscape.model.sep.DERProgram;

public interface DERProgramDao {

	public DERProgram save(DERProgram obj);

	public DERProgram findById(Long id);
	
	public List<DERProgram> dERProgramList();
	
	public void deleteDERProgram(Long id);
	
	public List<DERProgram> getListByUserId(Long userId);
	
}
