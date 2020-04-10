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
import com.gridscape.sep.org.zigbee.sep.MessagingProgram;
import com.gridscape.sep.org.zigbee.sep.MessagingProgramList;

public interface MessagingProgramListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MessagingProgramList GETMessagingProgramList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADMessagingProgramList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMessagingProgramList(MessagingProgram messagingprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTMessagingProgramList(MessagingProgram messagingprogram);

    @DELETE
    void DELETEMessagingProgramList();

}