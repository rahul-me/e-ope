package com.gridscape.sep.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gridscape.model.sep.UserCertificate;

@Repository
public interface UserCertificateDao {
	public byte save(UserCertificate userCertificate);
	
	public UserCertificate getCertificateById(String id);
	
	public UserCertificate getCertificateByName(String name);
	
	public UserCertificate getCertificateBySerialNumber(String serialNumber);
	
	public UserCertificate getCertificateBySignature(String signature);
	
	public UserCertificate getCertificateBySignatureForGivenUserId(String signature, String id);
	
	public List<UserCertificate> getCertificateListByUserId(String id);
	
	public int deleteCertificateById(String id);
}

