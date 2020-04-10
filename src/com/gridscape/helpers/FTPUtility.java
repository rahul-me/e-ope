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
	
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

@Service
public class FTPUtility {
	private String server;
	private int port;
	private String user;
	private String pass;
	private String ftp_file_path;
	private String destination_path;
	FTPClient ftpClient = new FTPClient();
	
	private void setData(){
		ReadProperties rp = new ReadProperties();
		Map<String,Object> map = rp.read("whether.properties");
		this.server = map.get("host").toString();
		this.port = Integer.parseInt(map.get("port").toString());
		this.user = map.get("userName").toString();
		this.pass = map.get("password").toString();
		this.ftp_file_path = map.get("ftp_file_path").toString();
		this.destination_path = map.get("destination_path").toString();
	}
	public String getFtpFilePath(){
		setData();
		return this.ftp_file_path;
	}
	public String getDestinationPath(){
		setData();
		return this.destination_path;
	}
	private void doLogin(){
		try {
			setData();
			this.ftpClient.connect(server, port);
			showServerReply(this.ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");			
			}

			boolean success = ftpClient.login(user, pass);
			showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
	
	public void printDirectoriesFile(String dirName) throws IOException{
		this.doLogin();
		FTPFile[] files = ftpClient.listFiles(dirName);
		for (FTPFile file : files) {
			String details = file.getName();
			System.out.println(details);
		}
		this.closeFtpConnection();
	}
	public void downLoadFileFromDirectories() throws IOException{
		this.doLogin();
		FTPFile[] files = ftpClient.listFiles(ftp_file_path);		
		for (FTPFile file : files) {
			String fileName = file.getName();
			String destination = destination_path;
			destination += "/"+fileName;
			File downloadFile = new File(destination);
			
			File parentDir = downloadFile.getParentFile();
			if (!parentDir.exists()) {
				parentDir.mkdir();
			}
			String remoteFile = ftp_file_path+"/"+fileName;
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destination));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile);
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
                outputStream.write(bytesArray, 0, bytesRead);
            } 
            boolean success = ftpClient.completePendingCommand();
            if (success) {                
               // ftpClient.deleteFile(remoteFile);
                System.out.println(fileName+ " has been downloaded successfully.");
            }
            outputStream.close();
            inputStream.close();
		}
		this.closeFtpConnection();
	}
	
	private void closeFtpConnection() throws IOException{
		if (ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}
}
