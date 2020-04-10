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

import com.gridscape.sep.org.zigbee.sep.DERControl;
import com.gridscape.sep.org.zigbee.sep.DERControlList;

public interface ActiveDERControlList {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERControlList GETActiveDERControlList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);
	
    @HEAD
    void HEADActiveDERControlList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTActiveDERControlList(DERControl dercontrol);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTActiveDERControlList(DERControl dercontrol);

    @DELETE
    void DELETEActiveDERControlList();

}