package com.gridscape.sep.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.dao.UserCertificateDao;

@Repository
public class UserCertificateDaoImpl implements UserCertificateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public byte save(UserCertificate userCertificate) {
		Session session = sessionFactory.openSession();
		try{			
			session.saveOrUpdate(userCertificate);
			return 1;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			session.flush();
			session.close();
		}
		
	}

	@Override
	public UserCertificate getCertificateByName(String name) {
		return null;
	}

	@Override
	public UserCertificate getCertificateBySerialNumber(String serialNumber) {
		return null;
	}

	@Override
	public UserCertificate getCertificateBySignature(String signature) {
		UserCertificate userCertificate = null;
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from UserCertificate where signature= :signature");
			query.setString("signature", signature);
			userCertificate = (UserCertificate)query.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}		
		return userCertificate;
	}
	
	@Override
	public UserCertificate getCertificateBySignatureForGivenUserId(String signature, String id) {
		UserCertificate userCertificate = null;
		Session session = sessionFactory.openSession();
		try {			
			Query query = session.createQuery("from UserCertificate where signature= :signature and user_id= :user_id");
			query.setString("signature", signature);
			query.setLong("user_id", Long.parseLong(id));
			userCertificate = (UserCertificate)query.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}		
		return userCertificate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCertificate> getCertificateListByUserId(String id) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from UserCertificate where user_id= :user_id");
			query.setLong("user_id", Long.parseLong(id));
			return query.list();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int deleteCertificateById(String id){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("delete from UserCertificate where id= :id");
			query.setLong("id", Long.parseLong(id));
			return query.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			session.flush();
			session.close();
		}
	}
	
	@Override
	public UserCertificate getCertificateById(String id){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from UserCertificate where id= :id");
			query.setLong("id", Long.parseLong(id));
			return (UserCertificate)query.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			session.flush();
			session.clear();
		}
	}
	
}

