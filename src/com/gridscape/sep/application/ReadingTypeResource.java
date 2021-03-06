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
import com.gridscape.sep.org.zigbee.sep.ReadingType;

public interface ReadingTypeResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ReadingType GETReadingType();

    @HEAD
    void HEADReadingType();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTReadingType(ReadingType readingtype);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTReadingType(ReadingType readingtype);

    @DELETE
    void DELETEReadingType();

}