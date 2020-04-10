package com.gridscape.sep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;

import com.gridscape.model.sep.FunctionSet;
import com.gridscape.sep.api.service.FunctionSetAssignmentsAPIService;
import com.gridscape.sep.application.FunctionSetAssignmentsListResource;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignments;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignmentsList;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.MessagingProgramListLink;
import com.gridscape.sep.service.FunctionSetService;
@Path("/edev/{id}/fsal")
public class FunctionSetAssignmentsListResourceImpl implements FunctionSetAssignmentsListResource{
	
	@Autowired
	FunctionSetService  functionSetService;
	
	@Autowired
	private FunctionSetAssignmentsAPIService functionSetAssignmentsAPIService;
	
	@Context
	private HttpServletRequest request;
	
	@Override
	public FunctionSetAssignmentsList GETFunctionSetAssignmentsList(String deviceId,Integer s, Integer l) {
		
		return (request.getScheme().equalsIgnoreCase("https")) ? functionSetAssignmentsAPIService.GETFunctionSetAssignmentsListForSecure(request, deviceId) : new FunctionSetAssignmentsList();
		
		/*List<FunctionSet>  functionSetlist = functionSetService.findByDeviceId(new Long(id));
		FunctionSetAssignmentsList functionSetAssignmentsList = new FunctionSetAssignmentsList();
		List<FunctionSetAssignments> assignmentsList = functionSetAssignmentsList.getFunctionSetAssignments();
		functionSetAssignmentsList.setAll(functionSetlist.size());
		for(FunctionSet functionSet: functionSetlist ){
			FunctionSetAssignments functionSetAssignments = new FunctionSetAssignments();
			functionSetAssignments.setDescription(functionSet.getDescription());
			MessagingProgramListLink messagingProgramListLink = new MessagingProgramListLink();
			messagingProgramListLink.setAll(0);
			messagingProgramListLink.setHref("");
			functionSetAssignments.setMessagingProgramListLink(messagingProgramListLink);
//			functionSetAssignments.set\DERProgramListLink(value);
//			functionSetAssignments.setTimeLink(value);
			functionSetAssignments.setHref("/edev/"+id+"/fsal/"+functionSet.getId());
			MRIDType mRIDType = new MRIDType();
			mRIDType.setValue(functionSet.getM_rid().getBytes());
			functionSetAssignments.setMRID(mRIDType);
			assignmentsList.add(functionSetAssignments);
			
		}
		
		return functionSetAssignmentsList;*/
	}

	@Override
	public void HEADFunctionSetAssignmentsList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTFunctionSetAssignmentsList(FunctionSetAssignments functionsetassignments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTFunctionSetAssignmentsList(FunctionSetAssignments functionsetassignments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DELETEFunctionSetAssignmentsList() {
		// TODO Auto-generated method stub
		
	}

}

