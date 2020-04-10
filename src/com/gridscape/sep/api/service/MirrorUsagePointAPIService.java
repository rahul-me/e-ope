package com.gridscape.sep.api.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridscape.model.sep.MirrorUsagePointModel;
import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.jsoninput.MirrorMeterReadingListEntry;
import com.gridscape.sep.org.zigbee.sep.MRIDType;
import com.gridscape.sep.org.zigbee.sep.MeterReading;
import com.gridscape.sep.org.zigbee.sep.MeterReadingBase;
import com.gridscape.sep.org.zigbee.sep.MirrorMeterReading;
import com.gridscape.sep.org.zigbee.sep.MirrorMeterReadingList;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePointList;
import com.gridscape.sep.org.zigbee.sep.RoleFlagsType;
import com.gridscape.sep.org.zigbee.sep.ServiceKind;
import com.gridscape.sep.org.zigbee.sep.VersionType;
import com.gridscape.sep.service.MirrorUsagePointService;
import com.gridscape.sep.service.UserCertificateService;

@Service
public class MirrorUsagePointAPIService {

	private static Logger log = Logger.getLogger(MirrorUsagePointAPIService.class);

	@Autowired
	private MirrorUsagePointService mirrorUsagePointService;

	@Autowired
	private UserCertificateService userCertificateService;

	public Response POSTMirrorUsagePointList(HttpServletRequest request, HttpServletResponse response,
			MirrorUsagePoint mirrorusagepoint) {
		if (isUserRegistered(request)) {

		}
		MirrorUsagePointModel mirrorUsagePointModel = generateModelFromSEPObject(mirrorusagepoint);
		mirrorUsagePointService.saveOrUpdate(mirrorUsagePointModel);
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader("Location", "/mup/" + mirrorUsagePointModel.getId());
		return Response.status(Response.Status.CREATED).build();
	}

	private MirrorUsagePointModel generateModelFromSEPObject(MirrorUsagePoint mirrorUsagePoint) {
		MirrorUsagePointModel mirrorUsagePointModel = new MirrorUsagePointModel();
		try {
			if (mirrorUsagePoint != null) {
				mirrorUsagePointModel.setDescription(mirrorUsagePoint.getDescription());
				mirrorUsagePointModel.setDeviceLFDI(mirrorUsagePoint.getDeviceLFDI());

				MRIDType mridType = mirrorUsagePoint.getMRID();
				if (isNotNull(mridType)) {
					mirrorUsagePointModel.setMrid(mridType.getValue());
				}

				RoleFlagsType roleFlagsType = mirrorUsagePoint.getRoleFlags();
				if (isNotNull(roleFlagsType)) {
					mirrorUsagePointModel.setRoleFlags(roleFlagsType.getValue());
				}

				ServiceKind serviceKind = mirrorUsagePoint.getServiceCategoryKind();
				if (isNotNull(serviceKind)) {
					mirrorUsagePointModel.setServiceCategoryKind(serviceKind.getValue());
				}
				mirrorUsagePointModel.setStatus(mirrorUsagePoint.getStatus());
				String mirrorMeterReadings = generateMirrorMeterReadings(mirrorUsagePoint.getMirrorMeterReading());
				if (isNotNull(mirrorMeterReadings)) {
					mirrorUsagePointModel.setMirrorMeterReadingList(mirrorMeterReadings);
				}
								
			}
		} catch (Exception e) {
			log.error(e);
		}
		return mirrorUsagePointModel;
	}

	private String generateMirrorMeterReadings(List<MirrorMeterReading> mirrorMeterReadings) {
		MirrorMeterReadingListEntry mirrorMeterReadings2 = new MirrorMeterReadingListEntry();
		mirrorMeterReadings2.setMirrorMeterReading(mirrorMeterReadings);
		return generateMirrorMeterReadingListEntry(mirrorMeterReadings2);
	}

	private String generateMirrorMeterReadingListEntry(MirrorMeterReadingListEntry mirrorMeterReadings) {
		String mirrorMeterReadingsStr = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			mirrorMeterReadingsStr = objectMapper.writeValueAsString(mirrorMeterReadings);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return mirrorMeterReadingsStr;
	}

	private <T> boolean isNotNull(@SuppressWarnings("unchecked") T... val) {
		for (T t : val) {
			if (t == null) {
				return false;
			}
		}
		return true;
	}

	private boolean isUserRegistered(HttpServletRequest request) {
		UserCertificate userCertificate = userCertificateService
				.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		return (userCertificate != null) ? true : false;
	}

	/*
	 * Part of GET Implementation
	 */

	public MirrorUsagePointList GETMirrorUsagePointList(HttpServletRequest request) {
		MirrorUsagePointList mirrorUsagePointList = new MirrorUsagePointList();
		if (isUserRegistered(request)) {
			List<MirrorUsagePointModel> mirrorUsagePointModels = mirrorUsagePointService.getAll();
			if (!mirrorUsagePointModels.isEmpty()) {
				MirrorUsagePointList mirrorUsagePointList2 = generateMirrorUsagePointListFromModelList(
						mirrorUsagePointModels);
				if (mirrorUsagePointList2 != null) {
					mirrorUsagePointList = mirrorUsagePointList2;
				}
			}
		}
		return mirrorUsagePointList;
	}

	private MirrorUsagePointList generateMirrorUsagePointListFromModelList(
			List<MirrorUsagePointModel> mirrorUsagePointModels) {
		MirrorUsagePointList mirrorUsagePointList = new MirrorUsagePointList();
		List<MirrorUsagePoint> mirrorUsagePoints = mirrorUsagePointList.getMirrorUsagePoint();
		for (MirrorUsagePointModel mirrorUsagePointModel : mirrorUsagePointModels) {
			MirrorUsagePoint mirrorUsagePoint = generateSEPObjectFromModelObject(mirrorUsagePointModel);
			mirrorUsagePoints.add(mirrorUsagePoint);
		}
		return mirrorUsagePointList;
	}

	private MirrorUsagePoint generateSEPObjectFromModelObject(MirrorUsagePointModel mirrorUsagePointModel) {
		MirrorUsagePoint mirrorUsagePoint = new MirrorUsagePoint();
		try {
			mirrorUsagePoint.setDescription(mirrorUsagePointModel.getDescription());
			mirrorUsagePoint.setDeviceLFDI(mirrorUsagePointModel.getDeviceLFDI());
			mirrorUsagePoint.setHref("/mup/" + mirrorUsagePointModel.getId());
			MRIDType mridType = new MRIDType();
			mridType.setValue(mirrorUsagePointModel.getMrid());
			mirrorUsagePoint.setMRID(mridType);
			RoleFlagsType roleFlagsType = new RoleFlagsType();
			roleFlagsType.setValue(mirrorUsagePointModel.getRoleFlags());
			mirrorUsagePoint.setRoleFlags(roleFlagsType);
			ServiceKind serviceKind = new ServiceKind();
			serviceKind.setValue(mirrorUsagePointModel.getServiceCategoryKind());
			mirrorUsagePoint.setServiceCategoryKind(serviceKind);
			mirrorUsagePoint.setStatus(mirrorUsagePointModel.getStatus());
			VersionType versionType = new VersionType();
			versionType.setValue(mirrorUsagePointModel.getVersion());
			mirrorUsagePoint.setVersion(versionType);

			String meterReadings = mirrorUsagePointModel.getMirrorMeterReadingList();
			ObjectMapper mapper = new ObjectMapper();
			MirrorMeterReadingListEntry meterReadings2 = mapper.readValue(meterReadings,
					MirrorMeterReadingListEntry.class);

			List<MirrorMeterReading> meterReadings3 = meterReadings2.getMirrorMeterReading();
			List<MirrorMeterReading> meterReadings4 = mirrorUsagePoint.getMirrorMeterReading();
			int count = 0;
			for (MirrorMeterReading mirrorMeterReading : meterReadings3) {
				meterReadings4.add(mirrorMeterReading);
				System.out.println("Count: " + (++count));
			}

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}

		return mirrorUsagePoint;
	}

	/*
	 * Part of mirror usage point resource implementation
	 */

	public void POSTMirrorUsagePoint(HttpServletRequest request, HttpServletResponse response, Source source, Long mupId) {

		if (isUserRegistered(request)) {

		} else {

		}
		MirrorUsagePointModel mirrorUsagePointModel = mirrorUsagePointService.getById(mupId);
		if (isNotNull(mirrorUsagePointModel)) {
			Object object = getResourceFromSource(source);
			if (isNotNull(object)) {
				boolean status = false;
				if (object instanceof MirrorMeterReading) {
					handlePostOfMirrorMeterReading((MirrorMeterReading) object, mirrorUsagePointModel);
					status = true;
				} else if (object instanceof MirrorMeterReadingList) {
					handlePostOfMirrorMeterReadingList((MirrorMeterReadingList) object, mirrorUsagePointModel);
					status = true;
				}
				if(status){
					response.setStatus(HttpServletResponse.SC_CREATED);
					response.setHeader("Location", "/upt/"+mupId+"/mr");
				}
			}
		}				
	}

	private void handlePostOfMirrorMeterReading(MirrorMeterReading mirrorMeterReading, MirrorUsagePointModel mirrorUsagePointModel) {		
		MirrorMeterReadingListEntry mirrorMeterReadingListEntry = generateMirrorMeterReadingListEntry(mirrorMeterReading);
		mirrorUsagePointModel.setMirrorMeterReadingList(generateMirrorMeterReadingListEntry(mirrorMeterReadingListEntry));
		mirrorUsagePointService.saveOrUpdate(mirrorUsagePointModel);
	}

	private void handlePostOfMirrorMeterReadingList(MirrorMeterReadingList mirrorMeterReadingList, MirrorUsagePointModel mirrorUsagePointModel) {
		MirrorMeterReadingListEntry mirrorMeterReadingListEntry = generateMirrorMeterReadingListEntry(mirrorMeterReadingList);
		mirrorUsagePointModel.setMirrorMeterReadingList(generateMirrorMeterReadingListEntry(mirrorMeterReadingListEntry));
		mirrorUsagePointService.saveOrUpdate(mirrorUsagePointModel);
		
	}
	
	private MirrorMeterReadingListEntry generateMirrorMeterReadingListEntry(MirrorMeterReading mirrorMeterReading){
		MirrorMeterReadingListEntry mirrorMeterReadingListEntry = new MirrorMeterReadingListEntry();
		List<MirrorMeterReading> mirrorMeterReadings = new ArrayList<MirrorMeterReading>();
		mirrorMeterReadings.add(mirrorMeterReading);
		mirrorMeterReadingListEntry.setMirrorMeterReading(mirrorMeterReadings);
		return mirrorMeterReadingListEntry;
	}
	
	private MirrorMeterReadingListEntry generateMirrorMeterReadingListEntry(MirrorMeterReadingList mirrorMeterReadingList){
		MirrorMeterReadingListEntry mirrorMeterReadingListEntry = new MirrorMeterReadingListEntry();			
		mirrorMeterReadingListEntry.setMirrorMeterReading(mirrorMeterReadingList.getMirrorMeterReading());
		return mirrorMeterReadingListEntry;
	}

	@SuppressWarnings("unchecked")
	private <T> T getResourceFromSource(Source source) {
		boolean status = false;
		T t = null;
		System.out.println(source.getSystemId());
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			StreamResult xmlOutput = new StreamResult(new StringWriter());
			transformer.transform(source, xmlOutput);
			String xmlContent = xmlOutput.getWriter().toString();

			JAXBContext jaxbContext = JAXBContext.newInstance(MirrorMeterReading.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(xmlContent);
			try {
				MirrorMeterReading mirrorMeterReading = (MirrorMeterReading) unmarshaller.unmarshal(reader);
				t = (T) mirrorMeterReading;
				status = true;
				System.out.println("MUST BE A OBJECT TYPE");
				log.info("MirrorMeterReading Class");
			} catch (ClassCastException e) {
				System.out.println("MUST BE A LIST TYPE");
				log.info("MirrorMeterReadingList");
				jaxbContext = JAXBContext.newInstance(MirrorMeterReadingList.class);
				unmarshaller = jaxbContext.createUnmarshaller();
				reader = new StringReader(xmlContent);
				try {
					MirrorMeterReadingList mirrorMeterReadingList = (MirrorMeterReadingList) unmarshaller
							.unmarshal(reader);
					t = (T) mirrorMeterReadingList;
					status = true;
				} catch (ClassCastException ee) {
					log.error(e);
					e.printStackTrace();
				}
				// e.printStackTrace();
				log.error(e);
			}

		} catch (TransformerConfigurationException e) {
			System.out.println("TransformerConfigurationException");
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			System.out.println("TransformerFactoryConfigurationError");
			e.printStackTrace();
		} catch (TransformerException e) {
			System.out.println("TransformerException");
			e.printStackTrace();
		} catch (JAXBException e) {
			System.out.println("JAXBException");
			e.printStackTrace();
		}

		return t;
	}

	private MirrorMeterReadingListEntry buildMirrorMeterReadingsFromJSONString(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		MirrorMeterReadingListEntry meterReadings = null;
		try {
			meterReadings = mapper.readValue(jsonString, MirrorMeterReadingListEntry.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return meterReadings;
	}
	
	public void PUTMirrorUsagePoint(HttpServletRequest request, MirrorUsagePoint mirrorusagepoint, Long mupId){
		if(isUserRegistered(request)){
			
		} else {
			
		}
		MirrorUsagePointModel mirrorUsagePointModel = mirrorUsagePointService.getById(mupId);
		if(isNotNull(mirrorUsagePointModel)){
			mirrorUsagePointModel = generateModelFromSEPObject(mirrorusagepoint);
			mirrorUsagePointModel.setId(mupId);
			mirrorUsagePointService.saveOrUpdate(mirrorUsagePointModel);
		}
	}
	
	public MirrorUsagePoint DELETEMirrorUsagePoint(HttpServletRequest request, Long mupId){
		if(isUserRegistered(request)){
			MirrorUsagePoint mirrorUsagePoint = null;
			MirrorUsagePointModel mirrorUsagePointModel = mirrorUsagePointService.getById(mupId);
			if(mirrorUsagePointModel != null){
				int result = mirrorUsagePointService.deleteById(mupId);
				if(result != -1){
					log.info("DATA IS DELETED");
					mirrorUsagePoint = generateSEPObjectFromModelObject(mirrorUsagePointModel);
				} else {
					log.info("DATA IS NOT DELETED");
				}
			}		
			return mirrorUsagePoint;
		} else {
			return new MirrorUsagePoint();
		}
		
	}
}
