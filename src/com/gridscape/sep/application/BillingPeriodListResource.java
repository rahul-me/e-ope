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

public interface BillingPeriodListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingPeriodList GETBillingPeriodList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADBillingPeriodList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingPeriodList(BillingPeriod billingperiod);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingPeriodList(BillingPeriod billingperiod);

    @DELETE
    void DELETEBillingPeriodList();

}