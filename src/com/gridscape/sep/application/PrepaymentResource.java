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
import com.gridscape.sep.org.zigbee.sep.Prepayment;

public interface PrepaymentResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    Prepayment GETPrepayment();

    @HEAD
    void HEADPrepayment();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPrepayment(Prepayment prepayment);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPrepayment(Prepayment prepayment);

    @DELETE
    @Produces("application/xml")
    Prepayment DELETEPrepayment();

}