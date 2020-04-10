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
import com.gridscape.sep.org.zigbee.sep.HistoricalReading;
import com.gridscape.sep.org.zigbee.sep.HistoricalReadingList;

public interface HistoricalReadingListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    HistoricalReadingList GETHistoricalReadingList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADHistoricalReadingList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTHistoricalReadingList(HistoricalReading historicalreading);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTHistoricalReadingList(HistoricalReading historicalreading);

    @DELETE
    void DELETEHistoricalReadingList();

}