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
import com.gridscape.sep.org.zigbee.sep.FlowReservationResponse;
import com.gridscape.sep.org.zigbee.sep.FlowReservationResponseList;

public interface FlowReservationResponseListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    FlowReservationResponseList GETFlowReservationResponseList(@QueryParam("s") Integer s, @QueryParam("a") Integer a, @QueryParam("l") Integer l);

    @HEAD
    void HEADFlowReservationResponseList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTFlowReservationResponseList(FlowReservationResponse flowreservationresponse);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTFlowReservationResponseList(FlowReservationResponse flowreservationresponse);

    @DELETE
    void DELETEFlowReservationResponseList();

}