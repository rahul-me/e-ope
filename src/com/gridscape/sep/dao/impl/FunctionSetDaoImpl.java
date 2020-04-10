package com.gridscape.sep.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.dao.FunctionSetDao;

@Component
public class FunctionSetDaoImpl implements FunctionSetDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public FunctionSet save(FunctionSet obj){
		System.out.println("val "+obj.getId()+" "+obj.getDevice_id()+" "+obj.getUser_id()+" "+obj.getM_rid()+" "+obj.getDescription());
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public FunctionSet findById(Long id){
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(FunctionSet.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<FunctionSet> functionSetList = ctr.list();
		FunctionSet f = null;
		for(FunctionSet functionSet:functionSetList){
			f = new FunctionSet();
			f.setId(functionSet.getId());
			f.setUser_id(functionSet.getUser_id());
			f.setM_rid(functionSet.getM_rid());			
			f.setDescription(functionSet.getDescription());
		}
		session.close();
		return f;
	}
	
	@Override
	@Transactional
	public List<FunctionSet> findByDeviceId(Long id){
		
		System.out.println("id =>>"+id);
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(FunctionSet.class);
//		ctr.createAlias("device_id","device");
		ctr.add(Restrictions.eq("device", session.load(Device.class, id)));
//		ctr.add(Restrictions.eq("device.id", id));
		@SuppressWarnings("unchecked")
		List<FunctionSet> functionSetList = ctr.list();
		
	
		List<FunctionSet> tempFunctionSetList = new ArrayList<FunctionSet>();
		if(functionSetList.size()>0){
			FunctionSet f = null;
			for(FunctionSet functionSet:functionSetList){
				f = new FunctionSet();
				f.setId(functionSet.getId());
				f.setUser_id(functionSet.getUser_id());
				f.setM_rid(functionSet.getM_rid());				
				f.setDescription(functionSet.getDescription());
				
				tempFunctionSetList.add(f);
			}
		}
		session.close();
		return tempFunctionSetList;
	}

	@Override
	@Transactional
	public List<FunctionSet> functionSetList(){
		Session session = sessionFactory.openSession();
		String sql = "from FunctionSet";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<FunctionSet> functionSetList = q.list();
		session.close();
		List<FunctionSet> tempFunctionSetList = new ArrayList<FunctionSet>();
		if(functionSetList.size()>0){
			FunctionSet f = null;
			for(FunctionSet functionSet:functionSetList){
				f = new FunctionSet();
				f.setId(functionSet.getId());
				f.setDevice_id(functionSet.getDevice_id());
				f.setUser_id(functionSet.getUser_id());
				f.setM_rid(functionSet.getM_rid());				
				f.setDescription(functionSet.getDescription());				
				tempFunctionSetList.add(f);
			}
		}
		return tempFunctionSetList;
	}
	
	@Override
	@Transactional
	public void deleteFunctionSet(Long id){
		Session session = sessionFactory.openSession();
		String sql = "Delete FROM FunctionSet where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<FunctionSet> getFunctionSetAssignmentsHavingUserId(String userId, Long deviceId){
		List<FunctionSet> functionSetAssignments = new ArrayList<FunctionSet>();
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from FunctionSet where user_id= :user_id and device_id= :device_id");
			query.setString("user_id", userId);
			query.setLong("device_id", deviceId);
			functionSetAssignments = query.list();
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			session.flush();
			session.close();
		}
		return functionSetAssignments;
	}
	
}
