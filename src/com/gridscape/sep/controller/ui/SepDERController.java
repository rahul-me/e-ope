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

import com.gridscape.jsoninput.DEREntry;
import com.gridscape.model.sep.DERModel;
import com.gridscape.model.sep.DERProgram;
import com.gridscape.model.sep.DERStatusModel;
import com.gridscape.sep.service.DERService;
import com.gridscape.sep.service.SubscriptionService;

@Controller
@RequestMapping("/edev/{endDeviceId}/der")
public class SepDERController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
    @Autowired
    private DERService derService;
	
	@RequestMapping("/page")
	public ModelAndView getDERPage(@PathVariable("endDeviceId") Long endDeviceId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("endDeviceId", endDeviceId);
		modelAndView.setViewName("/sep/ders");
		return modelAndView;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> getDERList(@PathVariable("endDeviceId") Long endDeviceId){
		boolean status = false;
		Map<String, Object> response = new HashMap<String, Object>();
		List<DERModel> derModels = derService.getListByEndDeviceId(endDeviceId);
		if(derModels != null && !derModels.isEmpty()){
			status = true;
		}
		if(status){
			response.put("data", derModels);
		} else {
			response.put("data", new ArrayList());
		}
		response.put("status", status);
		return response;
	}
	
	@RequestMapping(value = "/derp", method = RequestMethod.GET)
	@ResponseBody
	public Map<String , Object> endDeviceList(@PathVariable("endDeviceId") Long endDeviceId){
		boolean status = false;
		Map<String, Object> response = new HashMap<String, Object>();
		List<DERProgram> derPrograms = subscriptionService.getDERPrograms(endDeviceId);
		if(derPrograms!= null && !derPrograms.isEmpty()){
			status = true;
		}
		if(status){
			response.put("data", derPrograms);
		}
		response.put("status", status);
		return response;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveDER(@RequestBody DEREntry derEntry, @PathVariable("endDeviceId") Long endDeviceId){
		Map<String, Object> response = new HashMap<String, Object>();
		boolean status = false;
		DERModel derModel = new DERModel();
		if(derEntry != null){
			Long[] derPrograms = derEntry.getDerPrograms();
			if(derPrograms != null && derPrograms.length > 0){
				StringBuilder stringBuilder = new StringBuilder();
				for(Long val : derEntry.getDerPrograms()){
					stringBuilder.append(" "+val);
				}
				derModel.setDerPrograms(stringBuilder.toString());
			}
			Long currentDERProgram = derEntry.getCurrentDERProgram();
			if( currentDERProgram != null && currentDERProgram != 0){
				derModel.setCurrentDerProgram(currentDERProgram);
			}
			derModel.setEndDeviceId(endDeviceId);
			int result = derService.saveOrUpdate(derModel);
			if(result != -1){
				status = true;
			}
			response.put("status", status);
		}
		return response;
	}
	
	@RequestMapping(value = "/{derId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteDER(@PathVariable("endDeviceId") Long endDeviceId, @PathVariable("derId") Long derId){
		Map<String, Object> response = new HashMap<String, Object>();
		derService.deleteDER(derId);
		return response;
	}
	
	@RequestMapping(value = "/{derId}/ders", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDERStatus(@PathVariable("endDeviceId") Long endDeviceId, @PathVariable("derId") Long derId){
		Map<String, Object> response = new HashMap<String, Object>();
		boolean status = false;
		DERModel derModel = derService.getById(derId);
		DERStatusModel derStatusModel = derModel.getDerStatusModel();
		if(derStatusModel != null){
			response.put("data", derStatusModel);
			status = true;
		}
		response.put("status", status);
		return response;
	}
	
	
}

