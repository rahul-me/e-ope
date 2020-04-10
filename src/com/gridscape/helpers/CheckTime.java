package com.gridscape.helpers;

import java.util.Map;

public class CheckTime {
	
	private Time startTime;
	
	private Time endTime;
	
	private String generation;
	
	private float rate;

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public Map<String, Float> getGenerationRate() {
		return null;
	}

	public void setGenerationRate(Map<String, Float> generationRate) {
		
	}
	
	
}

