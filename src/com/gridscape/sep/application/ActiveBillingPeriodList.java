/**
 * Created by Apache CXF WadlToJava code generator
**/
package com.gridscape.sep.application;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gridscape.sep.org.zigbee.sep.BillingPeriod;
import com.gridscape.sep.org.zigbee.sep.BillingPeriodList;

public interface ActiveBillingPeriodList {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingPeriodList GETActiveBillingPeriodList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADActiveBillingPeriodList();

    @PUT	
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTActiveBillingPeriodList(BillingPeriod billingperiod);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTActiveBillingPeriodList(BillingPeriod billingperiod);

    @DELETE
    void DELETEActiveBillingPeriodList();

}