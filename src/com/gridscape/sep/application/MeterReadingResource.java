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
import com.gridscape.sep.org.zigbee.sep.MeterReading;

public interface MeterReadingResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    MeterReading GETMeterReading();

    @HEAD
    void HEADMeterReading();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTMeterReading(MeterReading meterreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTMeterReading(MeterReading meterreading);

    @DELETE
    @Produces("application/xml")
    MeterReading DELETEMeterReading();

}