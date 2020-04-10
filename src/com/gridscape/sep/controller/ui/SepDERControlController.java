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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.DERControlModal;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.jsoninput.DERControlEntry;
import com.gridscape.sep.service.DERControlService;

@Controller
@RequestMapping("/sep/derprograms/{derp_id}")
public class SepDERControlController {

	@Autowired
	private DERControlService derControlService;

	@Autowired
	private ConfigProperties configProperties;

	@RequestMapping(value = "/derc", method = RequestMethod.GET)
	public ModelAndView addDerControl(@PathVariable("derp_id") Long derpId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("derpId", derpId);
		mv.setViewName("/sep/dercontrol");
		return mv;
	}

	@RequestMapping(value = "/derc/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveDerControl(@PathVariable("derp_id") Long derpId,
			@RequestBody DERControlEntry derControlEntry) {
		boolean isNewEntry = false;
		Map<String, Object> response = new HashMap<String, Object>();
		if (derControlEntry != null) {
			DERControlModal derControlModal = derControlService
					.generateDERControlModalFromDERControlEntry(derControlEntry);
			Long derControlId = derControlModal.getId();
			if (derControlId != null) {
				DERControlModal derControlModal2 = derControlService.getById(derControlId);
				String mrid = derControlModal2.getMrid();
				if(mrid == null){
					derControlModal.setMrid(Utility.getStringFromByteArray(Utility.getMRIDValue(derControlId, configProperties.getIanaPEN())));
				} else {
					derControlModal.setMrid(mrid);
				}
				derControlModal.setVersion(derControlModal.getVersion() + 1);
			} else {
				isNewEntry = true;
			}
			derControlService.saveOrUpdate(derControlModal);
			if (isNewEntry) {
				derControlModal.setMrid(Utility.getStringFromByteArray(
						Utility.getMRIDValue(derControlModal.getId(), configProperties.getIanaPEN())));
			}
		}
		return response;
	}

	@RequestMapping(value = "/derc/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getList(@PathVariable("derp_id") Long derpId) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<DERControlModal> derControlModals = null;
		List<DERControlEntry> derControlEntries = new ArrayList<DERControlEntry>();
		boolean status = false;
		try {
			// derControlModals = derControlService.getByDerpId(derpId);
			derControlModals = derControlService.getNormalTypeDERControls(derpId);
			if (derControlModals != null && !derControlModals.isEmpty()) {
				for (DERControlModal derControlModal : derControlModals) {
					derControlEntries
							.add(derControlService.generateDERControlEntryFromDERControlModel(derControlModal));
				}
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.put("status", true);
		if (status) {
			response.put("data", derControlEntries);
		} else {
			response.put("data", new ArrayList<DERControlModal>());
		}
		return response;
	}

	@RequestMapping(value = "/derc/default", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDefault(@PathVariable("derp_id") Long derpId) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<DERControlEntry> derControlEntries = new ArrayList<DERControlEntry>();
		boolean status = false;
		try {
			// derControlModals = derControlService.getByDerpId(derpId);
			DERControlModal derControlModal = derControlService.getDefaultTypeDERControl(derpId);
			if (derControlModal != null) {
				derControlEntries.add(derControlService.generateDERControlEntryFromDERControlModel(derControlModal));
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.put("status", true);
		if (status) {
			response.put("data", derControlEntries);
		} else {
			response.put("data", new ArrayList<DERControlEntry>());
		}
		return response;
	}

	@RequestMapping(value = "/derc/{derc_id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDerc(@PathVariable("derp_id") Long derpId, @PathVariable("derc_id") Long derc_id) {
		Map<String, Object> response = new HashMap<String, Object>();
		boolean status = false;
		DERControlEntry derControlEntry = new DERControlEntry();
		DERControlModal derControlModal = derControlService.getById(derc_id);
		if (derControlModal != null) {
			derControlEntry = derControlService.generateDERControlEntryFromDERControlModel(derControlModal);
			if (derControlEntry != null) {
				response.put("data", derControlEntry);
				status = true;
			}
		}
		if (status) {
			response.put("data", derControlEntry);
		}
		response.put("status", status);
		return response;
	}

	@RequestMapping(value = "/derc/{derc_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteDER(@PathVariable("derp_id") Long derpId, @PathVariable("derc_id") Long dercId) {
		Map<String, Object> response = new HashMap<String, Object>();
		derControlService.deleteDERControl(dercId);
		return response;
	}

}
