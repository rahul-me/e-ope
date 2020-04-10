
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
 
  
  
package com.gridscape.controller;

import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.RequestTokenPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;
import com.dropbox.core.DbxException;
import com.gridscape.API_Interface.MicroGridSessionManage;
import com.gridscape.helpers.Email;
import com.gridscape.jsoninput.ChangePassword;
import com.gridscape.jsoninput.InputData;
import com.gridscape.jsoninput.Operator;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.AssignOperator;
import com.gridscape.model.User;
import com.gridscape.model.UserRole;
import com.gridscape.service.AssignOperatorService;
import com.gridscape.service.UserService;
	
@Controller
@RequestMapping("/users")
public class UsersController {
	
	final static Logger logger = Logger.getLogger(UsersController.class);	

	@Autowired
	MicroGridSessionManage micro_grid_mg;
	
	@Autowired	
	UserService uService;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AssignOperatorService aoService;

	private static final String APP_KEY = "Your APP key that you got from step 5";  
	private static final String APP_SECRET = "Your APP Secret that you got from step 5";  
	private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;  
	private static DropboxAPI<WebAuthSession> mDBApi;  
	
	CustomSecurityManager csm = new CustomSecurityManager();
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users/index");
		return mv;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody public Map<String , Object> save(@RequestBody User obj, HttpServletRequest req) throws NoSuchAlgorithmException{
		Map<String, Object> map = uService.registerUser(obj, req);
		return map;
	}
	
	@RequestMapping(value="/saveoperator",method=RequestMethod.POST)
	@ResponseBody public Map<String , Object> saveOperator(@RequestBody com.gridscape.jsoninput.AssignOperator obj,HttpServletRequest req,@CookieValue("token") String token) throws NoSuchAlgorithmException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		User user = uService.findByEmail(obj.getEmail());
		if(user!=null){
			 User tempUser = uService.findByToken(token);
			 if(user.getUserRole().getRole().equals("operator")){
				// System.out.println("parent id = "+tempUser.getId()+" operator id = "+user.getId());
				 AssignOperator temp = aoService.findByParentIdAndOperatorId(tempUser.getId(), user.getId());
				 if(temp!=null){
					 map.put("status",true);
				 }else{
					 AssignOperator ao = new AssignOperator();
					 ao.setOperatorId(user.getId());
					 ao.setParentId(tempUser.getId());
					 ao.setIsActive(true);					 
					 aoService.save(ao);
					 map.put("status",true);
				 }
			 }else{
				 map.put("status",false);
				 map.put("message","You can not assign owner as operator!");
			 }
		}else{
			 User u = new User();
			 u.setSepAccess(obj.isSepAccess());
			 u.setSepOnly(obj.isSepOnly());
			 u.setEmail(obj.getEmail());
			 UserRole ur = new UserRole();
			 ur.setId(obj.getRoleId());
			 u.setUserRole(ur);
			 u.setActive(obj.getActive());
			 u.setIsDelete(false);
			 String password = csm.getRandomPassword();
			 u.setPassword(csm.encryptPassword(password));
			 u = uService.save(u);	
			 User tempUser = uService.findByToken(token);
			 u.setPassword(password);
			 this.sendMail(u, req);
			 AssignOperator ao = new AssignOperator();
			 ao.setOperatorId(u.getId());
			 ao.setParentId(tempUser.getId());
			 ao.setIsActive(true);
			 aoService.save(ao);
			 map.put("status",true);
		}
		return map;
	}
	
	

	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> edit(@PathVariable Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findById(id);
		map.put("data", user);
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> list(HttpServletRequest req,@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		return uService.getListByRole( req, aoService, user.getUserRole().getRole(), token);
		/*Integer start = Integer.parseInt(req.getParameter("start"));
		Integer len = Integer.parseInt(req.getParameter("length"));
		
		if(user.getUserRole().getRole().equalsIgnoreCase("super-admin")){
			String search = req.getParameter("search[value]");
			List<User> userList = uService.getUserListByLimit(start,len,search);
			List<User> uList = uService.userList();
			map.put("recordsTotal", uList.size());
			map.put("recordsFiltered", uList .size());
			map.put("data", userList);
			logger.info("list data");
		}else if(user.getUserRole().getRole().equalsIgnoreCase("customer-admin")){
			List<AssignOperator> aoList = aoService.listByParentIdWithLimit(user.getId(),start,len);
			int count = aoService.getTotalRecordByParentId(user.getId());
			List<Operator> listOperator = null;
			if(aoList.size()>0){
				listOperator = new ArrayList<Operator>();
				Operator op = null;
				for(AssignOperator obj:aoList){
					op = new Operator();
					op.setId(obj.getId());
					User u = uService.findById(obj.getOperatorId());
					op.setEmail(u.getEmail());
					op.setFullname(u.getFullname());
					op.setUserName(u.getUserName());
					op.setActive(obj.getIsActive());
					listOperator.add(op);
				}
				map.put("recordsTotal", count);
				map.put("recordsFiltered", count);
				map.put("data", listOperator);
			}else{
				map.put("data", listOperator);
			}
		}
		return map;*/
	}
	
	@RequestMapping(value="/getlist",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> listdata(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> user = uService.userList();
		map.put("data", user);
		return map;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> updateStatus(@PathVariable Long id,@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		if(user.getUserRole().getRole().equalsIgnoreCase("super-admin")){
			user.setIsDelete(true);
			uService.save(user);
		}else if(user.getUserRole().getRole().equalsIgnoreCase("customer-admin")){
			aoService.deleteById(id);
			map.put("status", true);
		}
		map.put("status", true);
		return map; 
	}
	
	@RequestMapping(value="/updatestatus",method=RequestMethod.POST)
	@ResponseBody public Map<String , Object> updateStatus(@RequestBody User obj,@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		if(user.getUserRole().getRole().equalsIgnoreCase("super-admin")){
			if(obj.getId()!= null){
				User userObj = uService.findById(obj.getId());
				userObj.setActive(obj.isActive());
				userObj.setIsDelete(false);
				uService.save(userObj);
				map.put("status", true);
			}
		}else if(user.getUserRole().getRole().equalsIgnoreCase("customer-admin")){
			System.out.println("operator = "+obj.getId());
			AssignOperator ao = aoService.findById(obj.getId());
			ao.setIsActive(obj.isActive());			
			aoService.save(ao);
			map.put("status", true);
		}
		return map;
	}
	
	@RequestMapping(value="/operatormicro",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> assignMicro(@RequestBody Map<String, Object> data) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			long operatorId = Long.parseLong((String)data.get("operatorId"));
			String microIds = (String)data.get("microIds");
			AssignOperator assignOperator = aoService.findById(operatorId);
			assignOperator.setAssignMicrogrid(microIds);
			aoService.save(assignOperator);
			result.put("status", "success");
		}catch(Exception e) {
			result.put("status", "fail");
		}
		return result;
	}
	
	@RequestMapping(value="/isuniqueemail",method=RequestMethod.POST)
	@ResponseBody public Map<String , Object> uniqueEmail(@RequestBody User obj){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByEmail(obj.getEmail());
		if(user!=null){
			map.put("status", false);
		}else{
			map.put("status", true);
		}
		return map;
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile(){
		return "/users/profile";
	}
	
	@RequestMapping(value="/gettokeninfo",method=RequestMethod.POST)
	@ResponseBody public Map<String, Object> findByToken(@RequestBody User obj){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("token= "+obj.getDynamicToken());
		User user = uService.findByToken(obj.getDynamicToken());
		map.put("data", user);
		return map;
	}
	
	@RequestMapping(value="/location",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> findByToken(@CookieValue("token") String token){
		Map<String, Object> map = new HashMap<String, Object>();		
		User user = uService.findByToken(token);
		map.put("data", user);
		return map;
	}
	
	@RequestMapping(value="/savechangepassword",method=RequestMethod.POST)
	@ResponseBody public Map<String,Object> changePassword(@RequestBody ChangePassword obj) throws NoSuchAlgorithmException{
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findById(obj.getId());
		if(user!=null){
			String oldPassword = csm.encryptPassword(obj.getOldPassword());
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(csm.encryptPassword(obj.getNewPassword()));
				uService.save(user);
				map.put("status", "1");
			}else{
				map.put("status", "0");
			}
		}else{
			map.put("status", "2");
		}
		return map;
	}
	
	@RequestMapping(value="/saveimage",method=RequestMethod.POST)
	@ResponseBody
	public String saveImagefile(MultipartHttpServletRequest request,HttpServletRequest req) {
		
		String id = req.getParameter("id");
		Iterator<String> itr = request.getFileNames();

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded!");

		Iterator<String> itrator = request.getFileNames();
		MultipartFile multiFile = request.getFile(itrator.next());
		String fileName = mpf.getOriginalFilename();
		String path = "";
		try {
			byte[] bytes = multiFile.getBytes();
			path = context.getRealPath("/")+ "/public/images/users/"+id+"/";
			File directory = new File(path);
            if(!directory.exists()){
            	directory.mkdirs();
            }
            System.out.println(directory.getAbsolutePath());
			File file = new File(path + mpf.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			stream.write(bytes);
			stream.close();
			User user = uService.findById(Long.parseLong(id));
			if(user!=null){
				user.setImage("/public/images/users/"+id+"/"+fileName);
				uService.save(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "File Upload";
	}
	
	@RequestMapping(value="/saveimagedb",method=RequestMethod.POST)
	@ResponseBody
	public String saveImagefiletoDB(MultipartHttpServletRequest request,HttpServletRequest req) throws IOException, DbxException {
	        //DbxAppInfo appInfo = new DbxAppInfo("o2bu3d7isnn7wwh", "jocv1qw9r2uufvw");
	        try{
		        AppKeyPair appKeys = new AppKeyPair("o2bu3d7isnn7wwh", "jocv1qw9r2uufvw"); 
		        AccessTokenPair tokens = new AccessTokenPair("o2bu3d7isnn7wwh","jocv1qw9r2uufvw");
		        WebAuthSession session = new WebAuthSession(appKeys,ACCESS_TYPE,tokens);  
		        WebAuthInfo authInfo = session.getAuthInfo();  
		        RequestTokenPair pair = authInfo.requestTokenPair;  
		        String url = authInfo.url;  	
		        Desktop.getDesktop().browse(new URL(url).toURI());  
			    JOptionPane.showMessageDialog(null, "Press ok to continue once you have authenticated.");  
		        session.retrieveWebAccessToken(pair);  
		        
        		session.setAccessTokenPair(tokens); 
		        System.out.println("Use this token pair in future so you don't have to re-authenticate each time:");  
		        System.out.println("Key token: " + tokens.key);  
		        System.out.println("Secret token: " + tokens.secret);  
		        mDBApi = new DropboxAPI<WebAuthSession>(session);  
		        
		       
		        System.out.println();  
		        System.out.print("Uploading file...");  
		        String fileContents = "Hello World!";  
		        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContents.getBytes());  
		        Entry newEntry = mDBApi.putFile("/testing123.txt", inputStream, fileContents.length(), null, null);  
		        System.out.println("Done. \nRevision of file: " + newEntry.rev);
	        
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        
		return "";
	}
	
	@RequestMapping(value="/listcustomeradmin",method=RequestMethod.GET)
	@ResponseBody public Map<String,Object> getCustomerAdminList(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> customerAdmin = uService.getCustomerAdminList();
		map.put("data", customerAdmin);
		return map;
	}
	
	@RequestMapping(value="/checkUserAdminPerForSEP", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkUserAdminPerForSEP(@RequestBody Map<String, String> requestPara){
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			User user = uService.findByToken(requestPara.get("token"));
			if(user.isSepAccess()){
				response.put("access", true);
			} else {
				response.put("access", false);
			}
			if(user.isSepOnly()){
				response.put("seponly", true);
			} else {
				response.put("seponly", false);
			}
			if(user.isAnalysisAccess()){
				response.put("analysisAccess", true);
			} else if(user.isAnalysisOnlyAccess()){
				response.put("analysisOnlyAccess", true);
			}
			response.put("status", "success");
		} catch(Exception e){
			e.printStackTrace();
			response.put("status", "fail");
		}
		return response;
	}
	
	
	private void sendMail(User obj, HttpServletRequest req) {
		Email email = new Email();
		String message = "Account details :\n";
		message += "Email : " + obj.getEmail() + "\n";
		message += "Password : " + obj.getPassword() + "\n";
		message += "Our admin review your account and activated soon. After Click on below link to access our portal\n";
		message += req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + req.getContextPath() + "/rest/home/login.jsp";
		email.sendMail(obj.getEmail(), "MicroGrid-OS login detail", message);

	}
}
