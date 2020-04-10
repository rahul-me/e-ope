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
import com.gridscape.sep.org.zigbee.sep.FlowReservationResponse;

public interface FlowReservationResponseResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FlowReservationResponse GETFlowReservationResponse();

    @HEAD
    void HEADFlowReservationResponse();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFlowReservationResponse(FlowReservationResponse flowreservationresponse);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFlowReservationResponse(FlowReservationResponse flowreservationresponse);

    @DELETE
    @Produces("application/xml")
    FlowReservationResponse DELETEFlowReservationResponse();

}