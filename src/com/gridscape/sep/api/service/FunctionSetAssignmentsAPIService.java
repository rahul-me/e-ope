package com.gridscape.sep.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.helpers.Utility;
import com.gridscape.model.sep.FunctionSet;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.property.ConfigProperties;
import com.gridscape.sep.org.zigbee.sep.DERProgramListLink;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignments;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignmentsList;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.MessagingProgramListLink;
import com.gridscape.sep.org.zigbee.sep.VersionType;
import com.gridscape.sep.service.FunctionSetService;
import com.gridscape.sep.service.UserCertificateService;

@Component
public class FunctionSetAssignmentsAPIService {
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Autowired
	private FunctionSetService  functionSetService;
	
	@Autowired
	private UserCertificateService userCertificateService;
	
	public FunctionSetAssignmentsList GETFunctionSetAssignmentsListForSecure(HttpServletRequest request, String device_id){
		FunctionSetAssignmentsList functionSetAssignmentsList = new FunctionSetAssignmentsList();
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			List<FunctionSet> functionSets = functionSetService.getFunctionSetAssignmentsHavingUserId(String.valueOf(userCertificate.getUser_id()), new Long(device_id));
			if(!functionSets.isEmpty()){
				functionSetAssignmentsList = generateFSAListFromModalObjects(functionSets, device_id);
			}
		}
		return functionSetAssignmentsList;
	}
	
	/*public FunctionSetAssignmentsList GETFunctionSetAssignmentsListForUnsecure(String device_id){
		FunctionSetAssignmentsList functionSetAssignmentsList = new FunctionSetAssignmentsList();
		List<FunctionSet> functionSets = functionSetService.functionSetList();
		if(!functionSets.isEmpty())functionSetAssignmentsList = generateFSAListFromModalObjects(functionSets);
		return functionSetAssignmentsList;
	}*/
	
	/*public FunctionSetAssignments GETFunctionSetAssignmentsForUnsecure(String deviceId, String functionId){
		FunctionSetAssignments functionSetAssignments = new FunctionSetAssignments();
		FunctionSet functionSet = functionSetService.findById(new Long(functionId));
		if(functionSet != null)functionSetAssignments = generateModelToSEPObject(functionSet);
		return functionSetAssignments;
	}*/
	
	public FunctionSetAssignments GETFunctionSetAssignmentsForSecure(HttpServletRequest request, String funcSetAssignId, String deviceId){
		FunctionSetAssignments functionSetAssignments = new FunctionSetAssignments();
		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if(userCertificate != null){
			FunctionSet functionSet = functionSetService.findById(new Long(funcSetAssignId));
			if(functionSet != null){
				if(Long.parseLong(functionSet.getUser_id()) == userCertificate.getUser_id() ){
					functionSetAssignments = generateModelToSEPObject(functionSet, deviceId);
				}
			}
			
		}
		return functionSetAssignments;
	}
	
	private FunctionSetAssignmentsList generateFSAListFromModalObjects(List<FunctionSet> functionSets, String deviceId){
		FunctionSetAssignmentsList functionSetAssignmentsList = new FunctionSetAssignmentsList();
		List<FunctionSetAssignments> functionSetAssignments = functionSetAssignmentsList.getFunctionSetAssignments();
		for(FunctionSet functionSet : functionSets){
			functionSetAssignments.add(generateModelToSEPObject(functionSet, deviceId));
		}
		return functionSetAssignmentsList;
	}
	
	private FunctionSetAssignments generateModelToSEPObject(FunctionSet functionSet, String deviceId){
		FunctionSetAssignments functionSetAssignments = new FunctionSetAssignments();
		functionSetAssignments.setDescription(functionSet.getDescription());
		MessagingProgramListLink messagingProgramListLink = new MessagingProgramListLink();
		messagingProgramListLink.setAll(0);
		messagingProgramListLink.setHref("");
		functionSetAssignments.setMessagingProgramListLink(messagingProgramListLink);
		
		DERProgramListLink derProgramListLink = new DERProgramListLink();
		derProgramListLink.setHref("/derp?edev="+deviceId);
		functionSetAssignments.setDERProgramListLink(derProgramListLink);
		
		VersionType versionType = new VersionType();
		versionType.setValue(functionSet.getVersion());
		functionSetAssignments.setVersion(versionType);
		
		functionSetAssignments.setHref("/edev/"+deviceId+"/fsal/"+functionSet.getId());
		MRIDType mRIDType = new MRIDType();
		mRIDType.setValue(Utility.getMRIDValue(functionSet.getId(), configProperties.getIanaPEN()));
		functionSetAssignments.setMRID(mRIDType);
		return functionSetAssignments;
	}	
}

