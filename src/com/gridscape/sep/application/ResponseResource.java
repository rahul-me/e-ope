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
import com.gridscape.sep.org.zigbee.sep.Response;

public interface ResponseResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Response GETResponse();

    @HEAD
    void HEADResponse();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTResponse(Response response);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTResponse(Response response);

    @DELETE
    @Produces("application/xml")
    Response DELETEResponse();

}