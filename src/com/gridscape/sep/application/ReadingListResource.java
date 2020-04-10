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
import com.gridscape.sep.org.zigbee.sep.Reading;
import com.gridscape.sep.org.zigbee.sep.ReadingList;

public interface ReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ReadingList GETReadingList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADReadingList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTReadingList(Reading reading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTReadingList(Reading reading);

    @DELETE
    void DELETEReadingList();

}