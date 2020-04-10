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
import com.gridscape.sep.org.zigbee.sep.HistoricalReading;

public interface HistoricalReadingResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    HistoricalReading GETHistoricalReading();

    @HEAD
    void HEADHistoricalReading();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTHistoricalReading(HistoricalReading historicalreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTHistoricalReading(HistoricalReading historicalreading);

    @DELETE
    @Produces("application/xml")
    HistoricalReading DELETEHistoricalReading();

}