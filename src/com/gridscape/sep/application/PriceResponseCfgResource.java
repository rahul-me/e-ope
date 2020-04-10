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
import com.gridscape.sep.org.zigbee.sep.PriceResponseCfg;

public interface PriceResponseCfgResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    PriceResponseCfg GETPriceResponseCfg();

    @HEAD
    void HEADPriceResponseCfg();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPriceResponseCfg(PriceResponseCfg priceresponsecfg);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPriceResponseCfg(PriceResponseCfg priceresponsecfg);

    @DELETE
    @Produces("application/xml")
    PriceResponseCfg DELETEPriceResponseCfg();

}