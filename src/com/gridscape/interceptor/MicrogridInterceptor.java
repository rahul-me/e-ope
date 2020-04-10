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
 
  
  
package com.gridscape.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MicrogridInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		String url = req.getRequestURI();
		System.out.println(url);
		String durl[] = url.split("/");
		System.out.println("controller = "+durl[3]);
		System.out.println("action = "+durl[4]);
		if (url.contains("testController")){
			return true;
		}
		if (url.contains("sep")){
			return true;
		}
		else if(durl[3].equals("home") && durl[4].equals("contactus")){
			return true;
		}else if(durl[3].equals("home") && durl[4].contains("login")){
			return true;
		}else if(durl[3].equals("login") && durl[4].equals("dologin")){
			return true;
		}else if(durl[3].equals("login") && durl[4].equals("forgotpassword")){
			return true;
		}else if(durl[3].equals("home") && durl[4].equals("publicmap")){
			return true;
		}else if(durl[3].equals("micro") && durl[4].equals("mapdata")){
			return true;
		}else if(durl[3].equals("users") && durl[4].equals("save")){
			return true;
		}else if(durl[3].equals("users") && durl[4].equals("isuniqueemail")){
			return true;
		}else{
			Boolean flag = false;
			Cookie c[] = req.getCookies();
			if( c != null ){
		         Cookie cookie = null;
		         for (int i = 0; i < c.length; i++){
		            cookie = c[i];
		            if(cookie.getName().equals("token")){
		            	flag = true;
		            	if(cookie.getValue()!=null){
		            		break;
		            	}
		            }
		         }
		         System.out.println("flat = "+flag);
		         if(flag == true){
		        	 return true;
		         }else{
		        	 res.sendRedirect(req.getContextPath()+"/rest/home/login");
		         }
			} 
		}
		return true;
	}

}
