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
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.MicroGridDao;
import com.gridscape.model.MicroController;
import com.gridscape.model.User;

/**
 * @author GridScape_Solutions
 *
 */
@Service
public class MicroGridService {
	@Autowired
	MicroGridDao microGridDao;
	
	@Autowired
	private AssignOperatorService assignOperatorService;

	public MicroController save(MicroController obj) {
		return microGridDao.save(obj);
	}

	public MicroController findById(Long id) {
		return microGridDao.findById(id);
	}

	public List<MicroController> GetList() {
		return microGridDao.GetList();
	}

	public List<MicroController> listMicroByUserId(Long id) {
		// TODO Auto-generated method stub
		return microGridDao.listMicroByUserId(id);
	}

	public List<MicroController> findListByUserIdArr(Object[] obj) {
		// TODO Auto-generated method stub
		return microGridDao.findListByUserIdArr(obj);
	}

	public MicroController findByMicrogrid_Id(String id) {
		return microGridDao.findByMicrogrid_Id(id);
	}

	public List<MicroController> findListByUserId(Long id) {
		return microGridDao.findListByUserId(id);
	}

	public List<MicroController> findAllByMicroGridStatusActive(boolean b) {
		return microGridDao.findAllByMicroGridActiveStatus(b);
	}

	public List<User> findAllMicrogridControllerWithUserDetails(boolean uniqueUsers) {
		return microGridDao.findAllMicrogridControllerWithUserDetails(uniqueUsers);
	}

	public List<Object[]> findMicroControllerByFilter(HashMap<String, String> queryMap) {
		return microGridDao.findMicroControllerByFilter(queryMap);
	}

	public List<MicroController> findUniqueCitiesAssociateWithMicroController() {
		return microGridDao.findUniqueCitiesAssociateWithMicroController();
	}

	public String findZoneById(String microgrid_id) {
		return this.findByMicrogrid_Id(microgrid_id).getTime_zone();
	}

	public boolean checkValidMicroGridId(String microgrid_id) {
		MicroController mc = this.findByMicrogrid_Id(microgrid_id);
		if (mc == null) {
			return false;
		} else {
			return true;
		}
	}

	public List<Object> findMicroControllerAssociationWithUser(String microgrid_id, long user_id) {
		return microGridDao.findMicroControllerIdAssociationWithUser(microgrid_id, user_id);
	}

	public List<Object> findMicroControllerAssociationWithUser(String microgrid_id, String user_token) {
		return microGridDao.findMicroControllerIdAssociationWithUser(microgrid_id, user_token);
	}
	
	public List<MicroController> getListByMGCIdArr(List<Long> mgcIds){
		return microGridDao.getListByMGCIdArr(mgcIds);
	}

	/**
	 * It will fetch out the list of micro grid controllers accessed by given
	 * user.
	 * 
	 * @param user:
	 *            specific user for which list of micro grid controller can be
	 *            retrieved.
	 * @return List of micro grid controller
	 */
	public List<MicroController> getBy(User user) {
		List<MicroController> mgcList = null;
		switch (user.getUserRole().getRole()) {
		case "super-admin":
			mgcList = GetList();
			break;
		case "operator":
			List<Long> list = assignOperatorService.getAssignedMGCIds(user.getId());
			mgcList = getListByMGCIdArr(list);
			break;
		case "customer-admin":
			mgcList = listMicroByUserId(user.getId());
			break;
		}
		if(mgcList == null){
			mgcList = new ArrayList<MicroController>();
		}
		return mgcList;
	}
	
	

}
