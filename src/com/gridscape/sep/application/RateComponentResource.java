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
import com.gridscape.sep.org.zigbee.sep.RateComponent;

public interface RateComponentResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    RateComponent GETRateComponent();

    @HEAD
    void HEADRateComponent();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTRateComponent(RateComponent ratecomponent);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTRateComponent(RateComponent ratecomponent);

    @DELETE
    @Produces("application/xml")
    RateComponent DELETERateComponent();

}