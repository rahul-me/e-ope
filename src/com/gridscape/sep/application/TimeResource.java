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

import com.gridscape.sep.org.zigbee.sep.Time;

public interface TimeResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Time GETTime();

    @HEAD
    void HEADTime();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTime(Time time);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTime(Time time);

    @DELETE
    void DELETETime();

}