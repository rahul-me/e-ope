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
import com.gridscape.sep.org.zigbee.sep.SupplyInterruptionOverride;
import com.gridscape.sep.org.zigbee.sep.SupplyInterruptionOverrideList;

public interface SupplyInterruptionOverrideListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    SupplyInterruptionOverrideList GETSupplyInterruptionOverrideList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADSupplyInterruptionOverrideList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTSupplyInterruptionOverrideList(SupplyInterruptionOverride supplyinterruptionoverride);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTSupplyInterruptionOverrideList(SupplyInterruptionOverride supplyinterruptionoverride);

    @DELETE
    void DELETESupplyInterruptionOverrideList();

}