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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.gridscape.sep.org.zigbee.sep.DER;

public interface DERResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DER GETDER(@PathParam("endDeviceId") Long endDeviceId, @PathParam("derId") Long derId);

    @HEAD
    void HEADDER();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDER(DER der);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDER(DER der);

    @DELETE
    @Produces("application/xml")
    DER DELETEDER();

}