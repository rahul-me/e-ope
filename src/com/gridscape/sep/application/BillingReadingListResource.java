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

import com.gridscape.sep.org.zigbee.sep.BillingReading;
import com.gridscape.sep.org.zigbee.sep.BillingReadingList;

public interface BillingReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingReadingList GETBillingReadingList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADBillingReadingList();

    @PUT	
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingReadingList(BillingReading billingreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingReadingList(BillingReading billingreading);

    @DELETE
    void DELETEBillingReadingList();

}