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
 
  
  
package com.gridscape.helpers;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Uploader extends GoogleDriveUploader{
	
	public static Map<String,Object> uploadFile(MultipartFile file , String path) throws IllegalStateException, IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		File directory = new File(path);
        if(!directory.exists()){
        	directory.mkdirs();
        }
        file.transferTo(directory);
        map.put("file_name",file.getOriginalFilename());
		return map;
	}
	
	public static Map<String, Object> uploadFileToGoogleDrive(String microgrid_id,MultipartFile file,String fileName,String contentType) throws IOException, GeneralSecurityException{
		Map<String, Object> map = new HashMap<String, Object>();
		File convFile = new File( file.getOriginalFilename());
		file.transferTo(convFile);
		System.out.println("microgrid id = "+microgrid_id);
		String parentId = GoogleDriveUploader.getParentId(microgrid_id);
		System.out.println("parent id = "+parentId);
		if(parentId==null){
			System.out.println("parent id = null");
			parentId = GoogleDriveUploader.createSubFolder("0B2BMyI4gzow-bHl6dDVmWnRxQkE", microgrid_id);			
		}
		System.out.println("parent id = "+parentId);
		map = GoogleDriveUploader.insertFile(fileName,fileName,parentId,contentType,convFile);
		return map;
	}

	public static void listGoogleDriveFile() throws IOException, GeneralSecurityException{
		GoogleDriveUploader.listFile();
	}
	
	public static void removeGoogleDriveFile(String id, String string) {
		
	}
}
