package com.gridscape.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("testController")
public class TestController {
	
	@RequestMapping("/testx")
	@ResponseBody
	public String testx(HttpServletRequest request) throws IOException{
		String path = request.getServletContext().getRealPath("/");
		
		InputStream file = new FileInputStream(path+"../hello.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		
		
		return "testx tested";
	}
	
}

