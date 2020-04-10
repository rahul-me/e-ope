package com.gridscape.sep.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edev/{endDeviceId}/der/{derId}/ders")
public class SepDERStatusController {
	
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView getDERStatusPage(@PathVariable("endDeviceId") Long endDeviceId, @PathVariable("derId") Long derId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("endDeviceId", endDeviceId);
		modelAndView.addObject("derId", derId);
		modelAndView.setViewName("/sep/derstatus");
		return modelAndView;
	}
}

