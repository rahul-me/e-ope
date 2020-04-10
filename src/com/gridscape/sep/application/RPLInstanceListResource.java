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
import com.gridscape.sep.org.zigbee.sep.RPLInstance;
import com.gridscape.sep.org.zigbee.sep.RPLInstanceList;

public interface RPLInstanceListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RPLInstanceList GETRPLInstanceList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADRPLInstanceList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRPLInstanceList(RPLInstance rplinstance);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRPLInstanceList(RPLInstance rplinstance);

    @DELETE
    void DELETERPLInstanceList();

}