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

import com.gridscape.sep.org.zigbee.sep.BillingPeriod;

public interface BillingPeriodResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingPeriod GETBillingPeriod();

    @HEAD
    void HEADBillingPeriod();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingPeriod(BillingPeriod billingperiod);	

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingPeriod(BillingPeriod billingperiod);

    @DELETE
    @Produces("application/xml")
    BillingPeriod DELETEBillingPeriod();

}