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
import com.gridscape.sep.org.zigbee.sep.PriceResponse;

public interface PriceResponseResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    PriceResponse GETPriceResponse();

    @HEAD
    void HEADPriceResponse();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPriceResponse(PriceResponse priceresponse);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPriceResponse(PriceResponse priceresponse);

    @DELETE
    @Produces("application/xml")
    PriceResponse DELETEPriceResponse();

}