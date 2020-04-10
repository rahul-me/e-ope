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

import com.gridscape.sep.org.zigbee.sep.BillingReading;

public interface BillingReadingResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingReading GETBillingReading();

    @HEAD	
    void HEADBillingReading();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingReading(BillingReading billingreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingReading(BillingReading billingreading);

    @DELETE
    @Produces("application/xml")
    BillingReading DELETEBillingReading();

}