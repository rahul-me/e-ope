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
import com.gridscape.sep.org.zigbee.sep.Neighbor;
import com.gridscape.sep.org.zigbee.sep.NeighborList;

public interface NeighborListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    NeighborList GETNeighborList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADNeighborList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTNeighborList(Neighbor neighbor);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTNeighborList(Neighbor neighbor);

    @DELETE
    void DELETENeighborList();

}