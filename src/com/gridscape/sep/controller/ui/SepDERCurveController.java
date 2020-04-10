package com.gridscape.sep.controller.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.model.sep.CurveDataModal;
import com.gridscape.model.sep.DERCurveModal;
import com.gridscape.sep.service.CurveDataService;
import com.gridscape.sep.service.DERCurveService;



@Controller
@RequestMapping("/derp/{derp_id}/dc")
public class SepDERCurveController {
	
	@Autowired
	private DERCurveService derCurveService;
	
	@Autowired
	private CurveDataService curveDataService;
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView getDCPage(@PathVariable("derp_id") Long derpId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("derpId", derpId);
		modelAndView.setViewName("/sep/dercurve");
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveDerCurve(@PathVariable("derp_id") Long derpId, @RequestBody DERCurveModal derCurveModal){
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if(derCurveModal.getId() != null){
				derCurveModal.setVersion(derCurveModal.getVersion() + 1);
			}
			derCurveService.save(derCurveModal);
			response.put("status", true);
		} catch(Exception e){
			e.printStackTrace();
			response.put("status", false);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getList(@PathVariable("derp_id") Long derpId){
		boolean status = false;
		Map<String, Object> response = new HashMap<String, Object>();
		List<DERCurveModal> derCurveModals = derCurveService.getByDerpId(derpId);
		if(derCurveModals != null && !derCurveModals.isEmpty()){
			status = true;			
		}
		if(status){
			response.put("data", derCurveModals);
		} else {
			response.put("data", new ArrayList());
		}
		response.put("status", status);
		return response;
	}
	
	@RequestMapping(value = "/{dc_id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDerCurve(@PathVariable("dc_id") Long dc_id){
		boolean status = false;
		Map<String, Object> response = new HashMap<String, Object>();
		DERCurveModal derCurveModal = derCurveService.getById(dc_id);
		if(derCurveModal != null){
			status = true;
			response.put("data", derCurveModal);
		}
		response.put("status",status);
		return response;
	}
	
	
	
	@RequestMapping(value = "/{dc_id}/page", method = RequestMethod.GET)
	public ModelAndView getCurveDataPage(@PathVariable("derp_id") Long derpId, @PathVariable("dc_id") Long dcId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("derpId", derpId);
		modelAndView.addObject("dcId", dcId);
		modelAndView.setViewName("/sep/curvedata");
		return modelAndView;
	}
	
	@RequestMapping(value = "/{dc_id}/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCurveDataList(@PathVariable("derp_id") Long derpId, @PathVariable("dc_id") Long dcId){
		boolean status = false;
		Map<String, Object> response = new HashMap<String, Object>();
		List<CurveDataModal> curveDataModals = curveDataService.getByDerCurveId(dcId);
		if(curveDataModals != null && !curveDataModals.isEmpty()){
			status = true;			
		}
		if(status){
			response.put("data", curveDataModals);
		} else {
			response.put("data", new ArrayList());
		}
		response.put("status", status);
		return response;
	}
	
	@RequestMapping(value = "/{dc_id}/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveCurveData(@PathVariable("derp_id") Long derpId, @PathVariable("dc_id") Long dcId, @RequestBody CurveDataModal curveDataModal){
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			curveDataService.saveOrUpdate(curveDataModal);
			response.put("status", true);
		} catch(Exception e){
			e.printStackTrace();
			response.put("status", false);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/{dc_id}/{curveDataId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteCurveData(@PathVariable("derp_id") Long derpId, @PathVariable("dc_id") Long dcId, @PathVariable("curveDataId") Long curveDataId){
		Map<String, Object> response = new HashMap<String, Object>();
		boolean result = curveDataService.deleteCurveData(curveDataId);
		response.put("status", result);
		return response;
	}
	
	
	
	
}

