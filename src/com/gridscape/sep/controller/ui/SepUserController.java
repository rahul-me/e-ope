package com.gridscape.sep.controller.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.ReadProperties;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.service.UserCertificateService;

@RestController
@RequestMapping(value="/sep")
public class SepUserController {
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	@RequestMapping(value="/certificate/{id}", method=RequestMethod.GET)
	public ModelAndView getCertificatePage(@PathVariable String id){
		return new ModelAndView("sep/uploadcer").addObject("userId", id);
	}
	
	@RequestMapping(value="/certi", method=RequestMethod.POST)
	public Map<String, Object> addCertificate(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("userId") String id){
		Map<String, Object> response = new HashMap<String, Object>();
		String fullContextPath = request.getServletContext().getRealPath("/");
		return (response = userCertificateService.saveCertificate(file, id, fullContextPath));
	}
	
	@RequestMapping(value="/certi/list", method=RequestMethod.GET)
	public Map<String, Object> getCertiList(HttpServletRequest request){
		Map<String, Object> response = new HashMap<String, Object>();		
		
		List<UserCertificate> list = userCertificateService.getCertificateListByUserId(request.getParameter("userId"));
		if(!list.isEmpty()){
			response.put("dataAvailability", true);
			response.put("data", list);
		} else {
			response.put("dataAvailability", false);
			response.put("data", new ArrayList<>());
		}
		return response;
	}
	
	@RequestMapping(value="/certi/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteCerti(@PathVariable("id") String id){
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if(userCertificateService.deleteCertificate(id)){
				response.put("status", true);
			} else {
				response.put("status", false);
			}
		} catch(Exception e){
			e.printStackTrace();
			response.put("status", false);
		}
		return response;
	}
	
	@RequestMapping(value="/certi/download", method=RequestMethod.GET)
	public void getPublicKeyCertificateOfServer(HttpServletResponse response){
		try {
			ReadProperties readProperties = new ReadProperties();
			Map<String, Object> serverProperties = readProperties.read("server.properties");
			try {
				String dataDirectory = (String)serverProperties.get("certificatePath");
		        Path file = Paths.get(dataDirectory, (String)serverProperties.get("certificateFileName"));
		        if (Files.exists(file)) 
		        {
		            response.setContentType("application/pkix-cert");
		            response.addHeader("Content-Disposition", "attachment; filename="+(String)serverProperties.get("certificateFileName"));
		            try
		            {
		                Files.copy(file, response.getOutputStream());
		                response.getOutputStream().flush();
		            } 
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			} catch(Exception e){
				e.printStackTrace();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

