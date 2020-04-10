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
import com.gridscape.sep.org.zigbee.sep.TargetReading;
import com.gridscape.sep.org.zigbee.sep.TargetReadingList;

public interface TargetReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TargetReadingList GETTargetReadingList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADTargetReadingList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTargetReadingList(TargetReading targetreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTargetReadingList(TargetReading targetreading);

    @DELETE
    void DELETETargetReadingList();

}