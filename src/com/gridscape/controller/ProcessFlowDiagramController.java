package com.gridscape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pfd")
public class ProcessFlowDiagramController {
	
	@RequestMapping(value = "/page/{m_id}", method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable("m_id") String m_id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("m_id", m_id);
		modelAndView.setViewName("/pfd/pfd");
		return modelAndView;
	}
	
}

