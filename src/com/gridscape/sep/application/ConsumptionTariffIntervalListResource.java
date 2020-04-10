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
import com.gridscape.sep.org.zigbee.sep.ConsumptionTariffInterval;
import com.gridscape.sep.org.zigbee.sep.ConsumptionTariffIntervalList;

public interface ConsumptionTariffIntervalListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    ConsumptionTariffIntervalList GETConsumptionTariffIntervalList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADConsumptionTariffIntervalList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTConsumptionTariffIntervalList(ConsumptionTariffInterval consumptiontariffinterval);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTConsumptionTariffIntervalList(ConsumptionTariffInterval consumptiontariffinterval);

    @DELETE
    void DELETEConsumptionTariffIntervalList();

}