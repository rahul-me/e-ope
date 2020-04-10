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
import com.gridscape.sep.org.zigbee.sep.FlowReservationRequest;

public interface FlowReservationRequestResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FlowReservationRequest GETFlowReservationRequest();

    @HEAD
    void HEADFlowReservationRequest();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFlowReservationRequest(FlowReservationRequest flowreservationrequest);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFlowReservationRequest(FlowReservationRequest flowreservationrequest);

    @DELETE
    @Produces("application/xml")
    FlowReservationRequest DELETEFlowReservationRequest();

}