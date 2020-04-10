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
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignments;

public interface FunctionSetAssignmentsResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FunctionSetAssignments GETFunctionSetAssignments(@PathParam("device_id") String device_id,@PathParam("function_id") String function_id);

    @HEAD
    void HEADFunctionSetAssignments();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFunctionSetAssignments(FunctionSetAssignments functionsetassignments);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFunctionSetAssignments(FunctionSetAssignments functionsetassignments);

    @DELETE
    @Produces("application/xml")
    FunctionSetAssignments DELETEFunctionSetAssignments();

}