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
import com.gridscape.sep.org.zigbee.sep.TimeTariffInterval;

public interface TimeTariffIntervalResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TimeTariffInterval GETTimeTariffInterval();

    @HEAD
    void HEADTimeTariffInterval();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTTimeTariffInterval(TimeTariffInterval timetariffinterval);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTTimeTariffInterval(TimeTariffInterval timetariffinterval);

    @DELETE
    @Produces("application/xml")
    TimeTariffInterval DELETETimeTariffInterval();

}