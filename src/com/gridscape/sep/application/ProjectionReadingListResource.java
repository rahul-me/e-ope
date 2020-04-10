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
import com.gridscape.sep.org.zigbee.sep.ProjectionReading;
import com.gridscape.sep.org.zigbee.sep.ProjectionReadingList;

public interface ProjectionReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ProjectionReadingList GETProjectionReadingList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADProjectionReadingList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTProjectionReadingList(ProjectionReading projectionreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTProjectionReadingList(ProjectionReading projectionreading);

    @DELETE
    void DELETEProjectionReadingList();

}