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
import com.gridscape.sep.org.zigbee.sep.DefaultDERControl;

public interface DefaultDERControlResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DefaultDERControl GETDefaultDERControl(@PathParam("derpId") Long derpId);

    @HEAD
    void HEADDefaultDERControl();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDefaultDERControl(DefaultDERControl defaultdercontrol);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDefaultDERControl(DefaultDERControl defaultdercontrol);

    @DELETE
    void DELETEDefaultDERControl();

}