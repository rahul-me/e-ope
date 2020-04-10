package com.gridscape.sep.api.service;

import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.model.sep.UserCertificate;
import com.gridscape.sep.controller.Dst;
import com.gridscape.sep.org.zigbee.sep.Time;
import com.gridscape.sep.org.zigbee.sep.TimeOffsetType;
import com.gridscape.sep.org.zigbee.sep.TimeType;
import com.gridscape.sep.service.UserCertificateService;

@Component
public class TimeResourceAPIService {

	@Autowired
	private UserCertificateService userCertificateService;

	public Time GETTime(HttpServletRequest request) {

		Time time = new Time();

		UserCertificate userCertificate = userCertificateService.getUserCertificateCorrespondingToCertificateInComingRequest(request);
		if (userCertificate == null)
			return time;

		Calendar aGMTCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		TimeZone timeZone = TimeZone.getTimeZone("US/Central");
		Dst dst = Dst.calculate(timeZone, Calendar.getInstance().get(Calendar.YEAR));

		TimeType gmtCurrentTime = new TimeType();
		gmtCurrentTime.setValue((aGMTCalendar.getTimeInMillis() / 1000));
		time.setCurrentTime(gmtCurrentTime);

		TimeType localTime = new TimeType();
		long timeInLoing = System.currentTimeMillis();
		localTime.setValue(timeInLoing);
		time.setLocalTime(localTime);

		TimeOffsetType timeOffsetType = new TimeOffsetType();
		timeOffsetType.setValue(dst.offset);
		time.setDstOffset(timeOffsetType);
		TimeType dstStartTime = new TimeType();
		dstStartTime.setValue(dst.start);
		time.setDstStartTime(dstStartTime);

		TimeType dstEndTime = new TimeType();
		dstEndTime.setValue(dst.end);
		time.setDstEndTime(dstEndTime);

		time.setHref("/tm");
		time.setQuality((short) 0);
		timeOffsetType.setValue((timeZone.getOffset(Calendar.ZONE_OFFSET) / 1000));
		time.setTzOffset(timeOffsetType);
		return time;
	}
}
