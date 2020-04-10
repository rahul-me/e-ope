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
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignments;
import com.gridscape.sep.org.zigbee.sep.FunctionSetAssignmentsList;

public interface FunctionSetAssignmentsListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FunctionSetAssignmentsList GETFunctionSetAssignmentsList(@PathParam("id") String id,@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADFunctionSetAssignmentsList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFunctionSetAssignmentsList(FunctionSetAssignments functionsetassignments);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFunctionSetAssignmentsList(FunctionSetAssignments functionsetassignments);

    @DELETE
    void DELETEFunctionSetAssignmentsList();

}