package com.gridscape.sep.controller.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.model.User;
import com.gridscape.model.sep.Device;
import com.gridscape.sep.service.DeviceService;
import com.gridscape.service.UserService;

@Controller
@RequestMapping("/sep/devices")
public class SepDevice {
	
	private static Logger log = Logger.getLogger(SepDevice.class);

	@Autowired
	DeviceService deviceService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sep/devices");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Device save(@RequestBody Device obj) {
		log.info(obj);
		Device d = null;
		try {
		d = deviceService.save(obj);
		} catch(Exception e){
			log.error(e);
		}
		return d;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> edit(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Device d = deviceService.findById(id);
		map.put("data", d);
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest req, @CookieValue("token") String userToken) {
		List<Device> devices = null;
		User user = userService.findByToken(userToken);

		switch (user.getUserRole().getRole()) {
		case "super-admin":
			devices = deviceService.deviceList();			
			break;
		case "customer-admin":
			devices = deviceService.getDevicesByUserId(String.valueOf(user.getId()));		
			break;
		case "operator":
			devices = deviceService.getDevicesByUserId(String.valueOf(user.getId()));
			break;
		}		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", devices);
		return map;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateStatus(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * User user = uService.findByToken(token);
		 * if(user.getUserRole().getRole().equalsIgnoreCase("super-admin")){
		 * user.setIsDelete(true); uService.save(user); }else
		 * if(user.getUserRole().getRole().equalsIgnoreCase("customer-admin")){
		 */
		deviceService.deleteDevice(id);
		map.put("status", true);
		// }
		// map.put("status", true);
		return map;
	}
}