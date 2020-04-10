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
import com.gridscape.sep.org.zigbee.sep.LLInterface;
import com.gridscape.sep.org.zigbee.sep.LLInterfaceList;

public interface LLInterfaceListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    LLInterfaceList GETLLInterfaceList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADLLInterfaceList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTLLInterfaceList(LLInterface llinterface);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTLLInterfaceList(LLInterface llinterface);

    @DELETE
    void DELETELLInterfaceList();

}