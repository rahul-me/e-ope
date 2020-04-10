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
import com.gridscape.sep.org.zigbee.sep.LogEvent;
import com.gridscape.sep.org.zigbee.sep.LogEventList;

public interface LogEventListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    LogEventList GETLogEventList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l, @PathParam("edevId") Long edevId);

    @HEAD
    void HEADLogEventList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTLogEventList(LogEvent logevent);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTLogEventList(LogEvent logevent, @PathParam("edevId") Long edevId);

    @DELETE
    void DELETELogEventList();

}