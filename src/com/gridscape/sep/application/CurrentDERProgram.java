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
import com.gridscape.sep.org.zigbee.sep.DERProgram;

public interface CurrentDERProgram {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERProgram GETCurrentDERProgram();

    @HEAD
    void HEADCurrentDERProgram();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCurrentDERProgram(DERProgram derprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCurrentDERProgram(DERProgram derprogram);

    @DELETE
    @Produces("application/xml")
    DERProgram DELETECurrentDERProgram();

}