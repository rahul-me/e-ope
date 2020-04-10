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
import com.gridscape.sep.org.zigbee.sep.SupplyInterruptionOverride;

public interface SupplyInterruptionOverrideResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SupplyInterruptionOverride GETSupplyInterruptionOverride();

    @HEAD
    void HEADSupplyInterruptionOverride();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSupplyInterruptionOverride(SupplyInterruptionOverride supplyinterruptionoverride);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSupplyInterruptionOverride(SupplyInterruptionOverride supplyinterruptionoverride);

    @DELETE
    @Produces("application/xml")
    SupplyInterruptionOverride DELETESupplyInterruptionOverride();

}