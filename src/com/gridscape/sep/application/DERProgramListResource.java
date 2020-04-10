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
import javax.ws.rs.QueryParam;

import org.springframework.web.bind.annotation.PathVariable;

import com.gridscape.sep.org.zigbee.sep.DERProgram;
import com.gridscape.sep.org.zigbee.sep.DERProgramList;

public interface DERProgramListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERProgramList GETDERProgramList(@QueryParam("edev") Long deviceId,@QueryParam("s") Integer s, @QueryParam("l") Integer l);
    
    @HEAD
    void HEADDERProgramList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERProgramList(DERProgram derprogram);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERProgramList(DERProgram derprogram);

    @DELETE
    void DELETEDERProgramList();

}