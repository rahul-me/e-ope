package com.gridscape.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class ConfigProperties {
	
	@Value("${nrelApiUrl}")
	private String nrelApiUrl;
	
	@Value("${nrelApiKey}")
	private String nrelApiKey;
	
	@Value("${solarGenCharge}")
	private String solarGenCharge;
	
	@Value("${ianaPEN}")
	private int ianaPEN;

	public String getSolarGenCharge() {
		return solarGenCharge;
	}

	public String getNrelApiUrl() {
		return nrelApiUrl;
	}

	public String getNrelApiKey() {
		return nrelApiKey;
	}

	public int getIanaPEN() {
		return ianaPEN;
	}
	
}

