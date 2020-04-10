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
import com.gridscape.sep.org.zigbee.sep.Prepayment;
import com.gridscape.sep.org.zigbee.sep.PrepaymentList;

public interface PrepaymentListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    PrepaymentList GETPrepaymentList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADPrepaymentList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTPrepaymentList(Prepayment prepayment);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTPrepaymentList(Prepayment prepayment);

    @DELETE
    void DELETEPrepaymentList();

}