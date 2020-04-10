package com.gridscape.sep.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.Device;
import com.gridscape.sep.dao.DERProgramDao;

@Component
public class DERProgramDaoImpl implements DERProgramDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public DERProgram save(DERProgram obj){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public DERProgram findById(Long id){
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(DERProgram.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<DERProgram> derProgramList = ctr.list();
		DERProgram d = null;
		for(DERProgram derp : derProgramList){
			d = new DERProgram();
			d.setId(derp.getId());
			d.setUser_id(derp.getUser_id());
			d.setPrimacy(derp.getPrimacy());
			d.setM_rid(derp.getM_rid());
			d.setDescription(derp.getDescription());
			d.setVersion(derp.getVersion());
		}
		session.close();
		return d;
	}
	
	@Override
	@Transactional
	public List<DERProgram> dERProgramList(){
		Session session = sessionFactory.openSession();
		String query = "from DERProgram";
		Query q = session.createQuery(query);
		@SuppressWarnings("unchecked")
		List<DERProgram> derpList = q.list();
		session.close();
		List<DERProgram> tmpList = new ArrayList<DERProgram>();
		if(derpList.size() > 0){
			DERProgram d = null;
			for(DERProgram derp:derpList){
				d = new DERProgram();
				d.setId(derp.getId());
				d.setPrimacy(derp.getPrimacy());
				d.setM_rid(derp.getM_rid());
				d.setDescription(derp.getDescription());
				d.setVersion(derp.getVersion());
				
				tmpList.add(d);
			}
		}
		return tmpList;
	}
	
	@Override
	@Transactional
	public void deleteDERProgram(Long id){
		
		Session session = sessionFactory.openSession();
		String query = "Delete FROM DERProgram where id=:id";
		session.createQuery(query).setLong("id", id).executeUpdate();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DERProgram> getListByUserId(Long userId) {
		List<DERProgram> deviceList = new ArrayList<DERProgram>();
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from DERProgram where user_id= :user_id");
			query.setString("user_id", String.valueOf(userId));
			deviceList = query.list();
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			session.flush();
			session.close();
		}
		return deviceList;
	}
	
	
}
