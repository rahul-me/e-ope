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
import com.gridscape.sep.org.zigbee.sep.DERControl;
import com.gridscape.sep.org.zigbee.sep.DERControlList;

public interface DERControlListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERControlList GETDERControlList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l, @PathParam("derp_id") Long derpId);

    @HEAD
    void HEADDERControlList();
    
    /*
     * Error
     */
    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERControlList(DERControl dercontrol);
    
    /*
     * OPTIONAL
     */
    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERControlList(DERControl dercontrol);

    @DELETE
    void DELETEDERControlList();

}