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
import com.gridscape.sep.org.zigbee.sep.DERControl;

public interface DERControlResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERControl GETDERControl(@PathParam("derp_id") Long derpId, @PathParam("derc_id") Long dercId);

    @HEAD
    void HEADDERControl();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERControl(DERControl dercontrol);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERControl(DERControl dercontrol);

    @DELETE
    @Produces("application/xml")
    DERControl DELETEDERControl();

}