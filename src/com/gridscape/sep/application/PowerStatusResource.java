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
import com.gridscape.sep.org.zigbee.sep.PowerStatus;

public interface PowerStatusResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    PowerStatus GETPowerStatus();

    @HEAD
    void HEADPowerStatus();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPowerStatus(PowerStatus powerstatus);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPowerStatus(PowerStatus powerstatus);

    @DELETE
    void DELETEPowerStatus();

}