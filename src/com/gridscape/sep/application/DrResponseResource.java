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
import com.gridscape.sep.org.zigbee.sep.DrResponse;

public interface DrResponseResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DrResponse GETDrResponse();

    @HEAD
    void HEADDrResponse();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDrResponse(DrResponse drresponse);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDrResponse(DrResponse drresponse);

    @DELETE
    @Produces("application/xml")
    DrResponse DELETEDrResponse();

}