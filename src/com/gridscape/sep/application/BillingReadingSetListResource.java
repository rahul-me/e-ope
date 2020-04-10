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
import com.gridscape.sep.org.zigbee.sep.BillingReadingSet;
import com.gridscape.sep.org.zigbee.sep.BillingReadingSetList;

public interface BillingReadingSetListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingReadingSetList GETBillingReadingSetList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADBillingReadingSetList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingReadingSetList(BillingReadingSet billingreadingset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingReadingSetList(BillingReadingSet billingreadingset);

    @DELETE
    void DELETEBillingReadingSetList();

}