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
 
  
  
package com.gridscape.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.dao.CommonDao;

@Component
public class CommonDaoImpl implements CommonDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public String getCode(String className) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("SELECT id FROM " + className + " order by id desc");
		q.setMaxResults(1);
		List list = q.list();		
		Integer cid = 1;
		String id = "1";
		for (int i = 0; i < list.size(); i++) {
			Object obj = (Object) list.get(i);
			cid = Integer.parseInt(obj.toString());
			cid++;
			id = cid+"";
			break;
		}
		if (cid < 10) {
			return "0000" + id;
		} else if (cid >= 10 && cid < 100) {
			return "000" + id;
		} else if (cid >= 100 && cid < 1000) {
			return "00" + id;
		} else if (cid >= 1000 && cid < 10000) {
			return "0" + id;
		} else if (cid >= 10000 && cid < 100000) {
			return id;
		} else {
			return null;
		}
	}
}
