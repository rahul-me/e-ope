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

public interface AssociatedUsagePoint {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    UsagePoint GETAssociatedUsagePoint();

    @HEAD
    void HEADAssociatedUsagePoint();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTAssociatedUsagePoint(UsagePoint usagepoint);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTAssociatedUsagePoint(UsagePoint usagepoint);

    @DELETE
    @Produces("application/xml")
    UsagePoint DELETEAssociatedUsagePoint();
	
}