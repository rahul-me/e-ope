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
import com.gridscape.sep.org.zigbee.sep.ConsumptionTariffInterval;

public interface ConsumptionTariffIntervalResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ConsumptionTariffInterval GETConsumptionTariffInterval();

    @HEAD
    void HEADConsumptionTariffInterval();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTConsumptionTariffInterval(ConsumptionTariffInterval consumptiontariffinterval);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTConsumptionTariffInterval(ConsumptionTariffInterval consumptiontariffinterval);

    @DELETE
    @Produces("application/xml")
    ConsumptionTariffInterval DELETEConsumptionTariffInterval();

}