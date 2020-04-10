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
import com.gridscape.sep.org.zigbee.sep.MeterReading;
import com.gridscape.sep.org.zigbee.sep.MeterReadingList;

public interface MeterReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MeterReadingList GETMeterReadingList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADMeterReadingList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMeterReadingList(MeterReading meterreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTMeterReadingList(MeterReading meterreading);

    @DELETE
    void DELETEMeterReadingList();

}