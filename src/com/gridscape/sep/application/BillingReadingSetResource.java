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
import com.gridscape.sep.org.zigbee.sep.BillingReadingSet;

public interface BillingReadingSetResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    BillingReadingSet GETBillingReadingSet();

    @HEAD
    void HEADBillingReadingSet();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTBillingReadingSet(BillingReadingSet billingreadingset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTBillingReadingSet(BillingReadingSet billingreadingset);

    @DELETE
    @Produces("application/xml")
    BillingReadingSet DELETEBillingReadingSet();

}