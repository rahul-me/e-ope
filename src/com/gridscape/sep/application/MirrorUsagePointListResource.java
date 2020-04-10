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
import javax.ws.rs.core.Response;

import com.gridscape.sep.org.zigbee.sep.MirrorUsagePoint;
import com.gridscape.sep.org.zigbee.sep.MirrorUsagePointList;

public interface MirrorUsagePointListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MirrorUsagePointList GETMirrorUsagePointList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADMirrorUsagePointList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMirrorUsagePointList(MirrorUsagePoint mirrorusagepoint);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    Response POSTMirrorUsagePointList(MirrorUsagePoint mirrorusagepoint);

    @DELETE
    void DELETEMirrorUsagePointList();

}