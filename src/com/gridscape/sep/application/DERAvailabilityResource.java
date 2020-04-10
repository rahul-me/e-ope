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
import com.gridscape.sep.org.zigbee.sep.DERAvailability;

public interface DERAvailabilityResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    DERAvailability GETDERAvailability();

    @HEAD
    void HEADDERAvailability();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTDERAvailability(DERAvailability deravailability);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTDERAvailability(DERAvailability deravailability);

    @DELETE
    void DELETEDERAvailability();

}