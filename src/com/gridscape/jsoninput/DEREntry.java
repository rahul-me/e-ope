package com.gridscape.jsoninput;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DEREntry {
	private Long[] derPrograms;
	
	private Long currentDERProgram;

	public Long[] getDerPrograms() {
		return derPrograms;
	}

	public void setDerPrograms(Long[] derPrograms) {
		this.derPrograms = derPrograms;
	}

	public Long getCurrentDERProgram() {
		return currentDERProgram;
	}

	public void setCurrentDERProgram(Long currentDERProgram) {
		this.currentDERProgram = currentDERProgram;
	}
	
	
}

