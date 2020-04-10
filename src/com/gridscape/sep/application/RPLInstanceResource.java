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
import com.gridscape.sep.org.zigbee.sep.RPLInstance;

public interface RPLInstanceResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RPLInstance GETRPLInstance();

    @HEAD
    void HEADRPLInstance();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRPLInstance(RPLInstance rplinstance);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRPLInstance(RPLInstance rplinstance);

    @DELETE
    @Produces("application/xml")
    RPLInstance DELETERPLInstance();

}