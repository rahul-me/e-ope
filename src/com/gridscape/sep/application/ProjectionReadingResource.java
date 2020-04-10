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
import com.gridscape.sep.org.zigbee.sep.ProjectionReading;

public interface ProjectionReadingResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ProjectionReading GETProjectionReading();

    @HEAD
    void HEADProjectionReading();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTProjectionReading(ProjectionReading projectionreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTProjectionReading(ProjectionReading projectionreading);

    @DELETE
    @Produces("application/xml")
    ProjectionReading DELETEProjectionReading();

}