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
import com.gridscape.sep.org.zigbee.sep.CreditRegister;
import com.gridscape.sep.org.zigbee.sep.CreditRegisterList;

public interface CreditRegisterListResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CreditRegisterList GETCreditRegisterList(@QueryParam("s") Integer s, @QueryParam("l") Integer l);

    @HEAD
    void HEADCreditRegisterList();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCreditRegisterList(CreditRegister creditregister);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCreditRegisterList(CreditRegister creditregister);

    @DELETE
    void DELETECreditRegisterList();

}