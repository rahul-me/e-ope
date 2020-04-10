/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
package com.gridscape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.AssignOperatorDao;
import com.gridscape.model.AssignOperator;

@Service
public class AssignOperatorService {
	
	@Autowired
	AssignOperatorDao aod;

	public AssignOperator save(AssignOperator obj){
		return aod.save(obj);
	}

	public List<AssignOperator> listByParentId(Long id) {
		return aod.listByParentId(id);
	}

	public AssignOperator findByParentIdAndOperatorId(Long parentId, Long operatorId) {
		// TODO Auto-generated method stub
		return aod.findByParentIdAndOperatorId(parentId,operatorId);
	}

	public void deleteByParentIdAndOperatorId(Long parentId, Long operatorId) {
		aod.deleteByParentIdAndOperatorId(parentId,operatorId);
	}

	public List<AssignOperator> listByParentIdWithLimit(Long id, Integer start,Integer len) {
		return aod.listByParentIdWithLimit(id, start,len);
	}

	public int getTotalRecordByParentId(Long id) {
		// TODO Auto-generated method stub
		return aod.getTotalRecordByParentId(id);
	}

	public AssignOperator findById(Long id) {
		// TODO Auto-generated method stub
		return aod.findById(id);
	}

	public void deleteById(Long id) {
		aod.deleteById(id);
	}

	public List<AssignOperator> findListByOperatorId(Long id) {
		return aod.findListByOperatorId(id);
	}
	
	public AssignOperator findListByOperatorIdUnique(Long operatorId) {
		return aod.findListByOperatorIdUnique(operatorId);
	}
	
	public List<Long> getAssignedMGCIds(Long operatorId){
		List<Long> microGridIds = new ArrayList<Long>();
		AssignOperator assignOperator = findListByOperatorIdUnique(operatorId);
		String assignedMGCIds = assignOperator.getAssignMicrogrid();
		if(assignedMGCIds != null && assignedMGCIds.trim().length() > 0){
			if(assignedMGCIds.contains(",")){
				String arr[] = assignedMGCIds.split(",");
				for(String val : arr){
					microGridIds.add(Long.parseLong(val));
				}
			} else {
				microGridIds.add(Long.parseLong(assignedMGCIds));
			}
		}
		return microGridIds;
	}
}
