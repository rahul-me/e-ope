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

import com.gridscape.sep.org.zigbee.sep.TimeTariffInterval;
import com.gridscape.sep.org.zigbee.sep.TimeTariffIntervalList;

public interface ActiveTimeTariffIntervalList {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    TimeTariffIntervalList GETActiveTimeTariffIntervalList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADActiveTimeTariffIntervalList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTActiveTimeTariffIntervalList(TimeTariffInterval timetariffinterval);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTActiveTimeTariffIntervalList(TimeTariffInterval timetariffinterval);

    @DELETE	
    void DELETEActiveTimeTariffIntervalList();

}