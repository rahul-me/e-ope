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
import com.gridscape.sep.org.zigbee.sep.UsagePoint;

public interface UsagePointResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    UsagePoint GETUsagePoint();

    @HEAD
    void HEADUsagePoint();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTUsagePoint(UsagePoint usagepoint);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTUsagePoint(UsagePoint usagepoint);

    @DELETE
    @Produces("application/xml")
    UsagePoint DELETEUsagePoint();

}