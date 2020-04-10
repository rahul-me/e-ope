package com.gridscape.helpers;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gridscape.sep.org.zigbee.sep.Notification;
import com.gridscape.sep.org.zigbee.sep.Subscription;

@Service
public class HttpServiceHandler {

	static Logger log = Logger.getLogger(HttpServiceHandler.class);

	public void sendPostRequest(Subscription subscription) {
		
		CloseableHttpClient closeableHttpClient = null;
		HttpResponse response = null;
		closeableHttpClient = HttpClients.createDefault();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Notification.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			Notification notification = new Notification();
			notification.setSubscribedResource(subscription.getSubscribedResource());
			
			StringWriter writer = new StringWriter();
			marshaller.marshal(notification, writer);

			StringEntity stringEntity = new StringEntity(writer.toString());
			
			HttpPost postRequest = new HttpPost(subscription.getNotificationURI());
			//StringEntity stringEntity = getPostRequestEntity(sepObject);
			postRequest.setEntity(stringEntity);
			postRequest.addHeader("Content-Type", "application/sep+xml");
			response = closeableHttpClient.execute(postRequest);
			
			int statusCode = response.getStatusLine().getStatusCode();			
			log.info("HTTP POST status code " + statusCode);

		} catch (JAXBException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
