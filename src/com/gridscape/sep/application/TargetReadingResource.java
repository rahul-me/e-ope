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
import com.gridscape.sep.org.zigbee.sep.TargetReading;

public interface TargetReadingResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TargetReading GETTargetReading();

    @HEAD
    void HEADTargetReading();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTargetReading(TargetReading targetreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTargetReading(TargetReading targetreading);

    @DELETE
    @Produces("application/xml")
    TargetReading DELETETargetReading();

}