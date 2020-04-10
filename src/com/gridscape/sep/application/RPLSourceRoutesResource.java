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
import com.gridscape.sep.org.zigbee.sep.RPLSourceRoutes;

public interface RPLSourceRoutesResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RPLSourceRoutes GETRPLSourceRoutes();

    @HEAD
    void HEADRPLSourceRoutes();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRPLSourceRoutes(RPLSourceRoutes rplsourceroutes);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRPLSourceRoutes(RPLSourceRoutes rplsourceroutes);

    @DELETE
    @Produces("application/xml")
    RPLSourceRoutes DELETERPLSourceRoutes();

}