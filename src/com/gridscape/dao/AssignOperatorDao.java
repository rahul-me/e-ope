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
 
  
  
package com.gridscape.dao;

import java.util.List;

import com.gridscape.model.AssignOperator;

public interface AssignOperatorDao {
	public AssignOperator save(AssignOperator obj);

	public List<AssignOperator> listByParentId(Long id);

	public AssignOperator findByParentIdAndOperatorId(Long parentId, Long operatorId);

	public void deleteByParentIdAndOperatorId(Long parentId, Long operatorId);

	public List<AssignOperator> listByParentIdWithLimit(Long id, Integer start,Integer len);

	public int getTotalRecordByParentId(Long id);

	public AssignOperator findById(Long id);

	public void deleteById(Long id);

	public List<AssignOperator> findListByOperatorId(Long id);
	
	public AssignOperator findListByOperatorIdUnique(Long id);
	
}
