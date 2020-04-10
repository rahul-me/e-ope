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
import com.gridscape.sep.org.zigbee.sep.TextResponse;

public interface TextResponseResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TextResponse GETTextResponse();

    @HEAD
    void HEADTextResponse();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTextResponse(TextResponse textresponse);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTextResponse(TextResponse textresponse);

    @DELETE
    @Produces("application/xml")
    TextResponse DELETETextResponse();

}