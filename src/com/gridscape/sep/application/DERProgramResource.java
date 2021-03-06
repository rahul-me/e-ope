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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.gridscape.sep.org.zigbee.sep.DERProgram;

public interface DERProgramResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERProgram GETDERProgram(@PathParam("id") String id);

    @HEAD
    void HEADDERProgram();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERProgram(DERProgram derprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERProgram(DERProgram derprogram);

    @DELETE
    @Produces("application/xml")
    DERProgram DELETEDERProgram();

}