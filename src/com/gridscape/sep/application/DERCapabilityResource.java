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
import com.gridscape.sep.org.zigbee.sep.DERCapability;

public interface DERCapabilityResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERCapability GETDERCapability(@PathParam("edevId") Long edevId, @PathParam("derId") Long derId);

    @HEAD
    void HEADDERCapability();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERCapability(DERCapability dercapability, @PathParam("edevId") Long edevId, @PathParam("derId") Long derId);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERCapability(DERCapability dercapability);

    @DELETE
    void DELETEDERCapability();

}