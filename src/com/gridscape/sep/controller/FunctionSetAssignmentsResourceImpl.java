package com.gridscape.sep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.api.service.FunctionSetAssignmentsAPIService;
import com.gridscape.sep.application.FunctionSetAssignmentsResource;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignments;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.MessagingProgramListLink;
import com.gridscape.sep.service.FunctionSetService;
@Path("/edev/{device_id}/fsal/{function_id}")
public class FunctionSetAssignmentsResourceImpl implements FunctionSetAssignmentsResource{

	@Autowired
	FunctionSetService  functionSetService;
	
	@Autowired
	private FunctionSetAssignmentsAPIService fsaApiService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public FunctionSetAssignments GETFunctionSetAssignments(String device_id, String function_id) {
		return (request.getScheme().equalsIgnoreCase("https")) ? fsaApiService.GETFunctionSetAssignmentsForSecure(request, function_id, device_id) : new FunctionSetAssignments(); 
		/*FunctionSet functionSet = functionSetService.findById(new Long(function_id));
		FunctionSetAssignments functionSetAssignments = new FunctionSetAssignments();
//		functionSetAssignments.setCustomerAccountListLink(value);
//		functionSetAssignments.setDemandResponseProgramListLink(value);
//		functionSetAssignments.setDERProgramListLink(value);
		functionSetAssignments.setDescription(functionSet.getDescription());
//		functionSetAssignments.setFileListLink(value);
		MessagingProgramListLink messagingProgramListLink = new MessagingProgramListLink();
		messagingProgramListLink.setAll(0);
		messagingProgramListLink.setHref("");
		functionSetAssignments.setMessagingProgramListLink(messagingProgramListLink);
		functionSetAssignments.setHref("/edev/"+device_id+"/fsal/"+functionSet.getId());
		MRIDType mRIDType = new MRIDType();
		mRIDType.setValue(functionSet.getM_rid().getBytes());
		functionSetAssignments.setMRID(mRIDType);
		return functionSetAssignments;*/
	}
	@Override
	public void HEADFunctionSetAssignments() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTFunctionSetAssignments(FunctionSetAssignments functionsetassignments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTFunctionSetAssignments(FunctionSetAssignments functionsetassignments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FunctionSetAssignments DELETEFunctionSetAssignments() {
		// TODO Auto-generated method stub
		return null;
	}


}

