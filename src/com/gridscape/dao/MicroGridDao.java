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

import java.util.HashMap;
import java.util.List;

import com.gridscape.model.MicroController;
import com.gridscape.model.User;

public interface MicroGridDao {
	public List<MicroController> GetList();
	public MicroController save(MicroController obj);
	public MicroController findById(Long id) ;
	public MicroController findByMicroGridID(String id) ;
	public List<MicroController> listMicroByUserId(Long id);
	public List<MicroController> findListByUserIdArr(Object[] obj);
	public MicroController findByMicrogrid_Id(String id);
	public List<MicroController> findListByUserId(Long id);
	public List<MicroController> findAllByMicroGridActiveStatus(boolean activeStatus);
	public List<User> findAllMicrogridControllerWithUserDetails(boolean uniqueUsers);
	public List<Object[]> findMicroControllerByFilter(HashMap<String,String> queryMap);
	public List<MicroController> findUniqueCitiesAssociateWithMicroController();
	public List<Object> findMicroControllerIdAssociationWithUser(String microgrid_id, long user_id);
	public List<Object> findMicroControllerIdAssociationWithUser(String microgrid_id, String user_token);
	public List<MicroController> getListByMGCIdArr(List<Long> mgcIds);
}
