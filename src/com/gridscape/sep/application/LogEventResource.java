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
import com.gridscape.sep.org.zigbee.sep.LogEvent;

public interface LogEventResource {
	
	
    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    LogEvent GETLogEvent(@PathParam("edevId") Long edevId, @PathParam("leId") Long leId);

    @HEAD
    void HEADLogEvent();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTLogEvent(LogEvent logevent, @PathParam("edevId") Long edevId, @PathParam("leId") Long leId);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTLogEvent(LogEvent logevent);

    @DELETE
    @Produces("application/xml")
    LogEvent DELETELogEvent(@PathParam("edevId") Long edevId, @PathParam("leId") Long leId);

}