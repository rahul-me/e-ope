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
import com.gridscape.sep.org.zigbee.sep.ReadingSet;
import com.gridscape.sep.org.zigbee.sep.ReadingSetList;

public interface ReadingSetListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ReadingSetList GETReadingSetList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADReadingSetList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTReadingSetList(ReadingSet readingset);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTReadingSetList(ReadingSet readingset);

    @DELETE
    void DELETEReadingSetList();

}