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
import com.gridscape.sep.org.zigbee.sep.TextMessage;

public interface TextMessageResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TextMessage GETTextMessage();

    @HEAD
    void HEADTextMessage();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTextMessage(TextMessage textmessage);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTextMessage(TextMessage textmessage);

    @DELETE
    @Produces("application/xml")
    TextMessage DELETETextMessage();

}