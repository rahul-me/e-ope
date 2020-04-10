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

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Children;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.ChildList;
import com.google.api.services.drive.model.ChildReference;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.ParentList;
import com.google.api.services.drive.model.ParentReference;

public class GoogleDriveUploader {

	private static String SERVICE_ACCOUNT_ID = "e-scope-server@e-scope-drive.iam.gserviceaccount.com"; 
	private static String SERVICE_ACCOUNT_USER = "gridscape1@gmail.com";
	private static String SERVICE_ACCOUNT_PRIVATE_KEY_ID="notasecret";	
	public static Drive getDriveService()
			throws GeneralSecurityException, IOException { 
		URL urls = GoogleDriveUploader.class.getResource("../../../e-Scope-drive-b61a536c978a.p12");
		System.out.println(urls.getPath());
		String fullPath = urls.getPath();
		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(jsonFactory)				
				.setServiceAccountId(SERVICE_ACCOUNT_ID)
				.setServiceAccountScopes(Arrays.asList(DriveScopes.DRIVE))
				.setServiceAccountUser(SERVICE_ACCOUNT_USER)
				.setServiceAccountPrivateKeyId(SERVICE_ACCOUNT_PRIVATE_KEY_ID)
				.setServiceAccountPrivateKeyFromP12File(
						new java.io.File(fullPath))	
				.build();
		Drive service = new Drive.Builder(httpTransport, jsonFactory, null)
				.setHttpRequestInitializer(credential).build();
		
		return service;
	}

	public static void printFilesInFolder(String folderId)throws IOException, GeneralSecurityException {
		Drive service = GoogleDriveUploader.getDriveService();
		Children.List request = service.children().list(folderId);
		do {
			try {
				ChildList children = request.execute();
				for (ChildReference child : children.getItems()) {
					System.out.println("File Id: " + child.getId());
				}
				request.setPageToken(children.getNextPageToken());
			} catch (IOException e) {
				System.out.println("An error occurred: " + e);
				request.setPageToken(null);
			}
		} while (request.getPageToken() != null && request.getPageToken().length() > 0);
	}

	public static Map<String, Object> insertFile(String title,String description, String parentId, String mimeType,java.io.File filenamePath) throws IOException, GeneralSecurityException {
		Drive service = GoogleDriveUploader.getDriveService();
		// File's metadata.
		File body = new File();
		body.setTitle(title);
		body.setDescription(description);
		body.setMimeType(mimeType);
		// Set the parent folder.
		if (parentId != null && parentId.length() > 0) {
			body.setParents(Arrays.asList(new ParentReference().setId(parentId)));
		}

		// File's content.
		//java.io.File fileContent = new java.io.File(
		FileContent mediaContent = new FileContent(mimeType, filenamePath);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			File file = service.files().insert(body, mediaContent).execute();
			resultMap.put("fileId", file.getId());
			resultMap.put("thum_link", file.getThumbnailLink());
			resultMap.put("downloadUrl", file.getWebContentLink());			
		} catch (IOException e) {
			System.out.println("An error occured: " + e);
			return null;
		}
		return resultMap;
	}

	

	public static void printParents(String fileId) throws GeneralSecurityException, IOException {
		Drive service = GoogleDriveUploader.getDriveService();
		try {
			ParentList parents = service.parents().list(fileId).execute();

			for (ParentReference parent : parents.getItems()) {
				System.out.println("File Id: " + parent.getId());
			}
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
	}

	public static File createFolder(String folderName) throws IOException, GeneralSecurityException{
		Drive service = GoogleDriveUploader.getDriveService();
		File body = new File();
		body.setTitle(folderName);
		body.setMimeType("application/vnd.google-apps.folder");
		File file = service.files().insert(body).execute();
		return file;
	}
	
	public static void listFile() throws IOException, GeneralSecurityException{
		Drive service = GoogleDriveUploader.getDriveService();
		FileList result = service.files().list().setQ("trashed = false").execute();
		List<File> files = result.getItems();
		if (files == null || files.size() == 0) {
			System.out.println("No files found.");
		} else {
			System.out.println("Files:");
			for (File file : files) {
				System.out.printf("%s (%s)\n", file.getTitle(), file.getId());				
			}
		}
	}
	public static String createSubFolder(String parentId,String folderName) throws IOException, GeneralSecurityException{
		Drive service = GoogleDriveUploader.getDriveService();
		File body = new File();
		body.setTitle(folderName);		
		body.setParents(Arrays.asList(new ParentReference().setId(parentId)));
		body.setMimeType("application/vnd.google-apps.folder");
		File file = service.files().insert(body).execute();
		return file.getId();
	}	

	public static void removeFileFromFolder(String folderId,String fileId) throws GeneralSecurityException {
		try {
			Drive service = GoogleDriveUploader.getDriveService();
			service.parents().delete(fileId, folderId).execute();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
	}

	public static void removeFolder(String folderId){
		try{
			Drive service = GoogleDriveUploader.getDriveService();
			service.files().delete(folderId).execute();
			System.out.println("remove id = "+folderId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeAll(String parentName){
		try{
			Drive service = GoogleDriveUploader.getDriveService();
			FileList result = service.files().list().setMaxResults(10).execute();
			List<File> files = result.getItems();
			if (files == null || files.size() == 0) {
				System.out.println("No files found.");
			} else {
				System.out.println("Files:");
				for (File file : files) {
					String title = file.getTitle();
					if(!title.equalsIgnoreCase(parentName)){
						service.files().delete(file.getId()).execute();
						System.out.println("deleted = "+title);						
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void demo(String args[]) throws IOException, GeneralSecurityException {
		//createFolder("e-Scope");
		//createSubFolder("0B2BMyI4gzow-bHl6dDVmWnRxQkE", "MG2");
		//printFilesInFolder("e-Scope");		
		//insertFile(service, "test", "test", "0B2BMyI4gzow-VEtmQkRMc1BaZ28","image/jpeg", "friend.jpg");
		//removeFileFromFolder("0B2BMyI4gzow-VEtmQkRMc1BaZ28","0B2BMyI4gzow-WEEyemtWSDNnaU0");		
		listFile();
		removeAll("e-Scope");
		listFile();
	}

	public static String getParentId(String microgrid_id) throws IOException, GeneralSecurityException {
		Drive service = GoogleDriveUploader.getDriveService();
		FileList result = service.files().list().setMaxResults(10).execute();
		List<File> files = result.getItems();
		String id = null;
		if (files == null || files.size() == 0) {
			System.out.println("No files found.");
		} else {
			System.out.println("Files:");
			for (File file : files) {
				String title = file.getTitle();				
				if(title.equalsIgnoreCase(microgrid_id)){
					id = file.getId();
					break;
				}
			}
		}
		System.out.println("microgrid_id = "+microgrid_id);		
		return id;
	}
}
