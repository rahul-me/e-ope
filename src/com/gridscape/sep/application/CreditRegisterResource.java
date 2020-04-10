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
import com.gridscape.sep.org.zigbee.sep.CreditRegister;

public interface CreditRegisterResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CreditRegister GETCreditRegister();

    @HEAD
    void HEADCreditRegister();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCreditRegister(CreditRegister creditregister);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCreditRegister(CreditRegister creditregister);

    @DELETE
    @Produces("application/xml")
    CreditRegister DELETECreditRegister();

}