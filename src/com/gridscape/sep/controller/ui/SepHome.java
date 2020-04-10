package com.gridscape.sep.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sep/home")
public class SepHome {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	@ResponseBody public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sep/index");
		return mv;		
	}
}

