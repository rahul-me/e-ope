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
import com.gridscape.sep.org.zigbee.sep.MessagingProgram;

public interface MessagingProgramResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MessagingProgram GETMessagingProgram();

    @HEAD
    void HEADMessagingProgram();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMessagingProgram(MessagingProgram messagingprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTMessagingProgram(MessagingProgram messagingprogram);

    @DELETE
    @Produces("application/xml")
    MessagingProgram DELETEMessagingProgram();

}