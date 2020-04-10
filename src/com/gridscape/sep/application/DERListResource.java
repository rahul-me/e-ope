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
import javax.ws.rs.QueryParam;
import com.gridscape.sep.org.zigbee.sep.DER;
import com.gridscape.sep.org.zigbee.sep.DERList;

public interface DERListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERList GETDERList(@QueryParam("s") Integer s, @QueryParam("l") Integer l, @PathParam("endDeviceId") Long endDeviceId);

    @HEAD
    void HEADDERList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERList(DER der);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERList(DER der);

    @DELETE
    void DELETEDERList();

}