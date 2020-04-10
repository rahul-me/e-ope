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
import com.gridscape.sep.org.zigbee.sep.UsagePoint;
import com.gridscape.sep.org.zigbee.sep.UsagePointList;

public interface UsagePointListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    UsagePointList GETUsagePointList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADUsagePointList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTUsagePointList(UsagePoint usagepoint);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTUsagePointList(UsagePoint usagepoint);

    @DELETE
    void DELETEUsagePointList();

}