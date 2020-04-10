package com.gridscape.sep.service;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gridscape.helpers.KeyManager;
import com.gridscape.model.sep.Device;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.dao.UserCertificateDao;

@Service
public class UserCertificateService {
	
	static Logger log = Logger.getLogger(UserCertificateService.class);

	@Autowired
	private UserCertificateDao userCertificateDao;

	@Autowired
	private KeyManager keyManager;
	
	@Autowired
	private DeviceService deviceService;

	public byte save(UserCertificate userCertificate) {
		return userCertificateDao.save(userCertificate);
	}
	
	public UserCertificate getCertificateById(String id){
		return userCertificateDao.getCertificateById(id);
	}

	public UserCertificate getCertificateBySignature(String signature) {
		return userCertificateDao.getCertificateBySignature(signature);
	}
	
	public UserCertificate getCertificateBySignatureForGivenUserId(String signature, String id) {
		return userCertificateDao.getCertificateBySignatureForGivenUserId(signature, id);
	}
	
	public List<UserCertificate> getCertificateListByUserId(String id){
		return userCertificateDao.getCertificateListByUserId(id);
	}
	
	public int deleteCertificateById(String id){
		return userCertificateDao.deleteCertificateById(id);
	}

	public boolean isCertificateNotExists(String signature, String id) {
		return (getCertificateBySignatureForGivenUserId(signature, id) == null) ? true : false;
	}
	
	public boolean isCertificateNotExists(String signature) {
		return (getCertificateBySignature(signature) == null) ? true : false;
	}

	public Map<String, Object> saveCertificate(MultipartFile file, String id, String fullContextPath) {
		Map<String, Object> status = new HashMap<String, Object>();
		
		//Path Manipulation
		String keyStorePath = fullContextPath+"../../tomcat.keystore";
		
		String clientAlias = getUniqueClintAlias();
		X509Certificate cert;
		try {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

			cert = (X509Certificate) certificateFactory.generateCertificate(file.getInputStream());
			String signature = new String(cert.getSignature());

			if (isCertificateNotExists(signature)) {

				UserCertificate userCertificate = new UserCertificate();
				userCertificate.setCer_name(cert.getIssuerDN().getName());
				userCertificate.setFile(file.getBytes());
				userCertificate.setSignature(signature);
				userCertificate.setSerial_number(String.valueOf(cert.getSerialNumber().intValue()));
				userCertificate.setUser_id(Long.parseLong(id));
				userCertificate.setClientAlias(clientAlias);

				byte result = save(userCertificate);
				if(result == -1){
					status.put("dataAdded", false);					
				} else {
					status.put("dataAdded", true);
				}
									

				// Import certificate into key store file
				if(keyManager.importCerti(file.getInputStream(), clientAlias, keyStorePath)){
					status.put("dataImported", true);
				} else {
					status.put("dataImported", false);
				}
			} else {
				status.put("dataExisted", true);
			}
			status.put("status", "succeeded");

		} catch (CertificateException | IOException e) {
			e.printStackTrace();
			status.put("status", "failed");
		}
		
		return status;
	}
	
	public boolean deleteCertificate(String id){
		boolean flagDB = false, flagKS = false;
		Map<String, Object> response = new HashMap<String, Object>();
		flagKS = deleteEntryFromKeystore(getCertificateById(id));
		flagDB = deleteEntryFromDatabase(id);				
		return (flagDB && flagKS) ? true : false;	
	}
	
	public boolean deleteEntryFromDatabase(String id){
		return (userCertificateDao.deleteCertificateById(id) == -1) ? false : true; 		
	}
	
	public boolean deleteEntryFromKeystore(UserCertificate userCertificate){		
		return keyManager.deleteEntry(userCertificate.getClientAlias());
	}
	
	private String getUniqueClintAlias(){
		return String.valueOf(System.currentTimeMillis());
	}
	
	public UserCertificate getUserCertificateCorrespondingToCertificateInComingRequest(HttpServletRequest request){
		X509Certificate x509Certificate = getCertificateFromRequest(request);
		if(x509Certificate == null){
			return null;
		} else {
			UserCertificate userCertificate = getCertificateBySignature(new String(x509Certificate.getSignature()));
			return (userCertificate != null) ? userCertificate : null;
		}
	}
	
	private X509Certificate getCertificateFromRequest(HttpServletRequest request){
		X509Certificate x509Certificate = null;
		X509Certificate[] certs = (X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
		if(certs != null && certs.length > 0){
			x509Certificate = certs[0];
			return x509Certificate;
		} else {
			return x509Certificate;
		}
	}
	
	public Device isDeviceExistsWithUserAuthenticityHavingPermissionToDevice(HttpServletRequest request, Long deviceId){
		boolean is = false;
		Device endDevice = deviceService.findById(deviceId);
		if(endDevice != null){ //CHECK device existence
			UserCertificate userCertificate = getUserCertificateCorrespondingToCertificateInComingRequest(request);
			if(userCertificate != null){  //CHECK user authenticity
				if(endDevice.getUser_id().equalsIgnoreCase( String.valueOf(userCertificate.getUser_id()))){   //CHECK whether device is accessible to user
					is = true;
				}
			} 
		}
		return (is) ? endDevice : null;		
	}
	
	

}
