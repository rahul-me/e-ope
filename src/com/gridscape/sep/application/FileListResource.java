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
import com.gridscape.sep.org.zigbee.sep.File;
import com.gridscape.sep.org.zigbee.sep.FileList;

public interface FileListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FileList GETFileList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADFileList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFileList(File file);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFileList(File file);

    @DELETE
    void DELETEFileList();

}