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
import com.gridscape.sep.org.zigbee.sep.ResponseSet;

public interface ResponseSetResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ResponseSet GETResponseSet();

    @HEAD
    void HEADResponseSet();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTResponseSet(ResponseSet responseset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTResponseSet(ResponseSet responseset);

    @DELETE
    @Produces("application/xml")
    ResponseSet DELETEResponseSet();

}