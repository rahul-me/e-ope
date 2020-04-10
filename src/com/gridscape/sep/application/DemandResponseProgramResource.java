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
import com.gridscape.sep.org.zigbee.sep.DemandResponseProgram;

public interface DemandResponseProgramResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DemandResponseProgram GETDemandResponseProgram();

    @HEAD
    void HEADDemandResponseProgram();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDemandResponseProgram(DemandResponseProgram demandresponseprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDemandResponseProgram(DemandResponseProgram demandresponseprogram);

    @DELETE
    @Produces("application/xml")
    DemandResponseProgram DELETEDemandResponseProgram();

}