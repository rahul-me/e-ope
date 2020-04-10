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
import com.gridscape.sep.org.zigbee.sep.LLInterface;

public interface LLInterfaceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    LLInterface GETLLInterface();

    @HEAD
    void HEADLLInterface();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTLLInterface(LLInterface llinterface);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTLLInterface(LLInterface llinterface);

    @DELETE
    @Produces("application/xml")
    LLInterface DELETELLInterface();

}