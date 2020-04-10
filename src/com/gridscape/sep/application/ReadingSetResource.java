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
import com.gridscape.sep.org.zigbee.sep.ReadingSet;

public interface ReadingSetResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ReadingSet GETReadingSet();

    @HEAD
    void HEADReadingSet();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTReadingSet(ReadingSet readingset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTReadingSet(ReadingSet readingset);

    @DELETE
    @Produces("application/xml")
    ReadingSet DELETEReadingSet();

}