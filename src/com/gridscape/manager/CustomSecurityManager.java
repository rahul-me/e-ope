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
 
  
  
package com.gridscape.manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CustomSecurityManager {
	
	static final String password = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public String encryptPassword(String password) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] md5hash = new byte[32];
		 md.update(password.getBytes());
		 md5hash = md.digest();		
		 return convertToHex(md5hash);	
	}
	
	public String singletoneToken(String userdata) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] md5hash = new byte[32];
		 md.update(userdata.getBytes());
		 md5hash = md.digest();		 
		 return convertToHex(md5hash);

	}
	public String perishableToken(){
		UUID pToken = UUID.randomUUID();		
		return pToken.toString();
	}
	public String dynamicToken(String cResource,String cIP,String oID)throws NoSuchAlgorithmException{
	
		String tokenString = cResource+cIP+oID;		
		MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] md5hash = new byte[32];
		 md.update(tokenString.getBytes());
		 md5hash = md.digest();		 
		 return convertToHex(md5hash);
		 
	}
	public String getReferenceCode(){
		UUID refcode = UUID.randomUUID();		
		return refcode.toString();
	}
	
	public String getRandomPassword(){
		Random rnd = new Random();
		   StringBuilder sb = new StringBuilder( 5 );
		   for( int i = 0; i < 5; i++ ) 
		      sb.append( password.charAt( rnd.nextInt(password.length()) ) );
		   return sb.toString();

	}
	
	private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
}
