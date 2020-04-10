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
import com.gridscape.sep.org.zigbee.sep.Response;
import com.gridscape.sep.org.zigbee.sep.ResponseList;

public interface ResponseListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ResponseList GETResponseList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADResponseList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTResponseList(Response response);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTResponseList(Response response);

    @DELETE
    void DELETEResponseList();

}