package com.gridscape.sep.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.LogEventModel;
import com.gridscape.sep.dao.DeviceDao;


@Component
public class DeviceDaoImpl implements DeviceDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override	
	@Transactional
	public Device save(Device obj){
		Session session = sessionFactory.openSession();
		
		session.saveOrUpdate(obj);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public Device findById(Long id){
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(Device.class);
		ctr.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Device> deviceList = ctr.list();
		Device d = null;
		for(Device device:deviceList){
			d = new Device();
			d.setId(device.getId());
			d.setUser_id(device.getUser_id());
			d.setPin(device.getPin());
			d.setS_fdi(device.getS_fdi());
			d.setCreated_at(device.getCreated_at());
			d.setDevice_category_type(device.getDevice_category_type());
			d.setDeviceInformation(device.getDeviceInformation());
		}
		session.close();
		return d;
	}
	
	@Override
	@Transactional
	public Device findByIdHavingLogEvents(Long id){
		Session session = sessionFactory.openSession();
		Device device = null;
		try {
			Serializable getById = id;
			device = (Device)session.get(Device.class, getById);
			Hibernate.initialize(device.getLogEventModels());
		} catch(Exception e){
			e.printStackTrace();			
		} finally {
			session.flush();
			session.close();
		}
		return device;
	}

	@Override
	@Transactional
	public List<Device> deviceList(){
		Session session = sessionFactory.openSession();
		String sql = "from Device";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Device> deviceList = q.list();
		System.out.println(deviceList);
		session.close();
		List<Device> tempDeviceList = new ArrayList<Device>();
		if(deviceList.size()>0){
			Device d = null;
			for(Device device:deviceList){
				d = new Device();
				d.setId(device.getId());
				d.setUser_id(device.getUser_id());
				d.setS_fdi(device.getS_fdi());
				d.setDevice_category_type(device.getDevice_category_type());				
				tempDeviceList.add(d);
			}
		}
		return tempDeviceList;
	}
	
	@Override
	@Transactional
	public void deleteDevice(Long id){
		Session session = sessionFactory.openSession();
		String sql = "Delete FROM Device where id = :id";
		session.createQuery(sql).setLong("id", id).executeUpdate();
		session.close();
	}
	
	@Override
	@Transactional
	public int getNumberOfDevice(){
		Session session = sessionFactory.openSession();
		String sql = "from Device";
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Device> deviceList = q.list();
		session.close();
		return deviceList.size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Device> getDevicesByUserId(String userId){
		List<Device> deviceList = new ArrayList<Device>();
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from Device where user_id= :user_id");
			query.setString("user_id", userId);
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
