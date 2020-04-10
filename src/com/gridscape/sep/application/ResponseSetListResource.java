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
import com.gridscape.sep.org.zigbee.sep.ResponseSet;
import com.gridscape.sep.org.zigbee.sep.ResponseSetList;

public interface ResponseSetListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ResponseSetList GETResponseSetList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADResponseSetList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTResponseSetList(ResponseSet responseset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTResponseSetList(ResponseSet responseset);

    @DELETE
    void DELETEResponseSetList();

}