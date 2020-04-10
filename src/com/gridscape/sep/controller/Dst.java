package com.gridscape.sep.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Dst {
	public long start;
    public long end;
    public int offset;

    public static Dst calculate(TimeZone tz, int year) {
        final Calendar c = Calendar.getInstance(tz);
        c.setLenient(false);
        c.set(year, Calendar.JANUARY, 1, 1, 0, 0);
        c.set(Calendar.MILLISECOND, 0);

        if (tz.getDSTSavings() == 0) {
            return null;
        }

        Dst dst = new Dst();

        boolean flag = false;

        do {
            Date date = c.getTime();
            boolean daylight = tz.inDaylightTime(date);

            if (daylight && !flag) {
                flag = true;
                dst.start = (date.getTime()/1000);
            }
            else if (!daylight && flag) {
                flag = false;
                dst.end = (date.getTime()/1000);
                dst.offset = (tz.getDSTSavings()/1000);
            }

            c.add(Calendar.HOUR_OF_DAY, 1);
        }
        while (c.get(Calendar.YEAR) == year);
        
        return dst;
    }	
}

