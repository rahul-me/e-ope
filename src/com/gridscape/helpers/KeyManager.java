package com.gridscape.helpers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class KeyManager {

	public boolean importCerti(InputStream certIn, String clientAlias, String keyStorePath) {

		ReadProperties readProperties = new ReadProperties();
		Map<String, Object> serverProperties = readProperties.read("server.properties");
		keyStorePath = (String)serverProperties.get("keystorePath");
		String keyStorePass = (String)serverProperties.get("keyStorePass");

		try {
			InputStream localCertIn = new FileInputStream(keyStorePath);

			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(localCertIn, keyStorePass.toCharArray());
			if (keystore.containsAlias(clientAlias)) {
				certIn.close();
				localCertIn.close();
				return false;
			}
			localCertIn.close();

			BufferedInputStream bis = new BufferedInputStream(certIn);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			while (bis.available() > 0) {
				Certificate cert = cf.generateCertificate(bis);				
				keystore.setCertificateEntry(clientAlias, cert);
			}
					
			certIn.close();

			OutputStream out = new FileOutputStream(keyStorePath);
			keystore.store(out, keyStorePass.toCharArray());
			out.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean deleteEntry(String clientAlias){
		try {
			ReadProperties readProperties = new ReadProperties();
			Map<String, Object> serverProperties = readProperties.read("server.properties");
			String keyStorePath = (String)serverProperties.get("keystorePath");
			String keyStorePass = (String)serverProperties.get("keyStorePass");
			
			InputStream localCertIn = new FileInputStream(keyStorePath);

			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(localCertIn, keyStorePass.toCharArray());
			
			if (keystore.containsAlias(clientAlias)) {
				keystore.deleteEntry(clientAlias);			
			}
			localCertIn.close();
			
			OutputStream out = new FileOutputStream(keyStorePath);
			keystore.store(out, keyStorePass.toCharArray());
			out.close();
			return true;
			
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
