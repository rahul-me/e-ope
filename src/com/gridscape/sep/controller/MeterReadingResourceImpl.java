package com.gridscape.sep.controller;

import javax.ws.rs.Path;

import org.springframework.stereotype.Service;

import com.gridscape.sep.application.MeterReadingResource;
import com.gridscape.sep.jsoninput.MeterReadingSub;
import com.gridscape.sep.org.zigbee.sep.MeterReading;

@Service
@Path("/mr")
public class MeterReadingResourceImpl implements MeterReadingResource {

	@Override
	public MeterReading GETMeterReading() {
		MeterReading meterReading = (MeterReading)new MeterReadingSub();
		return meterReading;
	}

	@Override
	public void HEADMeterReading() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PUTMeterReading(MeterReading meterreading) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void POSTMeterReading(MeterReading meterreading) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MeterReading DELETEMeterReading() {
		// TODO Auto-generated method stub
		return null;
	}

}

