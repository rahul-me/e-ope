package com.gridscape.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.gridscape.property.ConfigProperties;

/**
 * @author GridScape_Solutions
 *
 */
@Component
public class NrelPVWatt {

	@Autowired
	private ConfigProperties configProperties;

	public String getSolarResourceData(float lattitude, float longitude, float systemCapacity, float azimuth,
			float tilt) {
		String responseString = null;
		try {
			HttpClient httpClient2 = createHttpClientThatAcceptsUnTrustedCert();
			HttpGet httpGet = new HttpGet(
					getNrelUrlWithParameters(lattitude, longitude, systemCapacity, azimuth, tilt));
			HttpResponse response = httpClient2.execute(httpGet);
			HttpEntity entity = null;
			try {
				entity = response.getEntity();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
				String responseLines = "", responseLine = "";
				while ((responseLine = bufferedReader.readLine()) != null) {
					responseLines += responseLine;
				}
				// System.out.println(responseLines);
				if (responseLines != null && responseLines.length() > 0) {
					responseString = responseLines;
				}
			} finally {
				if (entity != null) {
					EntityUtils.consume(entity);
				}
			}
			return responseString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getNrelUrlWithParameters(float lattitude, float longitude, float systemCapacity, float azimuth,
			float tilt) {
		return configProperties.getNrelApiUrl() + "?api_key=" + configProperties.getNrelApiKey() + "&lat=" + lattitude
				+ "&lon=" + longitude + "&system_capacity=" + systemCapacity + "&azimuth=" + azimuth + "&tilt=" + tilt
				+ "&array_type=1&module_type=0&losses=14&dataset=intl&timeframe=hourly";
	}

	@SuppressWarnings("deprecation")
	public HttpClient createHttpClientThatAcceptsUnTrustedCert() {
		try {
			HttpClientBuilder b = HttpClientBuilder.create();

			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
					return true;
				}
			}).build();
			b.setSslcontext(sslContext);

			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory())
					.register("https", sslSocketFactory).build();

			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			b.setConnectionManager(connMgr);

			HttpClient client = b.build();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public void checkResponseData(){
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			JsonNode jsonNode = objectMapper.readTree(getSolarResourceData(22.25f, 73.15f, 3.8f, 270f, 22.6f));
			
			jsonNode = jsonNode.get("outputs");
			
			JsonNode jsonNodeForAcHourlyData = jsonNode.get("ac");
			if(jsonNodeForAcHourlyData.isArray()){
				int sizehour = jsonNodeForAcHourlyData.size();
				System.out.println(sizehour);
			}
			jsonNode = jsonNode.get("ac_monthly");
			if(jsonNode.isArray()){
				for(int i = 0 ; i < jsonNode.size() ; i++){
					System.out.println(jsonNode.get(i));
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
