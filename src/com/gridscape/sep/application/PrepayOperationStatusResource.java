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
import com.gridscape.sep.org.zigbee.sep.PrepayOperationStatus;

public interface PrepayOperationStatusResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    PrepayOperationStatus GETPrepayOperationStatus();

    @HEAD
    void HEADPrepayOperationStatus();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPrepayOperationStatus(PrepayOperationStatus prepayoperationstatus);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPrepayOperationStatus(PrepayOperationStatus prepayoperationstatus);

    @DELETE
    void DELETEPrepayOperationStatus();

}