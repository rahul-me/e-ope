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
import com.gridscape.sep.org.zigbee.sep.FileStatus;

public interface FileStatusResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FileStatus GETFileStatus();

    @HEAD
    void HEADFileStatus();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFileStatus(FileStatus filestatus);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFileStatus(FileStatus filestatus);

    @DELETE
    void DELETEFileStatus();

}