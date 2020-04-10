package com.gridscape.sep;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.gridscape.sep.controller.DERControlListResourceImpl;
import com.gridscape.sep.controller.DERControlResourceImpl;
import com.gridscape.sep.controller.DERCurveListResourceImpl;
import com.gridscape.sep.controller.DERCurveResourceImpl;
import com.gridscape.sep.controller.DERListResourceImpl;
import com.gridscape.sep.controller.DERProgramListResourceImpl;
import com.gridscape.sep.controller.DERProgramResourceImpl;
import com.gridscape.sep.controller.DERResourceImpl;
import com.gridscape.sep.controller.DERStatusResourceImpl;
import com.gridscape.sep.controller.EndDeviceListResourceImpl;
import com.gridscape.sep.controller.MeterReadingResourceImpl;
import com.gridscape.sep.controller.MirrorUsagePointListResourceImpl;
import com.gridscape.sep.controller.MirrorUsagePointResourceImpl;
import com.gridscape.sep.controller.SubscriptionListResourceImpl;
import com.gridscape.sep.controller.SubscriptionResourceImpl;
import com.gridscape.sep.controller.TestImpl;
import com.gridscape.sep.controller.TimeResourceImpl;

public class StartupApplication  extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public StartupApplication()throws Exception {	
		  singletons.add(new TimeResourceImpl());
		  singletons.add(new EndDeviceListResourceImpl());
		  singletons.add(new DERProgramListResourceImpl());
		  singletons.add(new DERProgramResourceImpl());
		  singletons.add(new SubscriptionListResourceImpl());
		  singletons.add(new SubscriptionResourceImpl());
		  singletons.add(new TestImpl());
		  singletons.add(new DERControlListResourceImpl());
		  singletons.add(new DERControlResourceImpl());
		  singletons.add(new DERCurveListResourceImpl());
		  singletons.add(new DERCurveResourceImpl());
		  singletons.add(new DERListResourceImpl());
		  singletons.add(new DERResourceImpl());
		  singletons.add(new DERStatusResourceImpl());
		  singletons.add(new MirrorUsagePointListResourceImpl());
		  singletons.add(new MirrorUsagePointResourceImpl());
		  singletons.add(new MeterReadingResourceImpl());
	}	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}	
}

