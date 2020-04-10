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
import com.gridscape.sep.org.zigbee.sep.FlowReservationRequest;
import com.gridscape.sep.org.zigbee.sep.FlowReservationRequestList;

public interface FlowReservationRequestListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FlowReservationRequestList GETFlowReservationRequestList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADFlowReservationRequestList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFlowReservationRequestList(FlowReservationRequest flowreservationrequest);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFlowReservationRequestList(FlowReservationRequest flowreservationrequest);

    @DELETE
    void DELETEFlowReservationRequestList();

}