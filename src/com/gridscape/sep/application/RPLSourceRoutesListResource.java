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
import com.gridscape.sep.org.zigbee.sep.RPLSourceRoutes;
import com.gridscape.sep.org.zigbee.sep.RPLSourceRoutesList;

public interface RPLSourceRoutesListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RPLSourceRoutesList GETRPLSourceRoutesList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADRPLSourceRoutesList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRPLSourceRoutesList(RPLSourceRoutes rplsourceroutes);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRPLSourceRoutesList(RPLSourceRoutes rplsourceroutes);

    @DELETE
    void DELETERPLSourceRoutesList();

}