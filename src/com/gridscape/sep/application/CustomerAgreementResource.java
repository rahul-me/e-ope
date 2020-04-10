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
import com.gridscape.sep.org.zigbee.sep.CustomerAgreement;

public interface CustomerAgreementResource {

    @GET
    @Produces({"application/sep+xml", "application/sep-exi" })
    CustomerAgreement GETCustomerAgreement();

    @HEAD
    void HEADCustomerAgreement();

    @PUT
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void PUTCustomerAgreement(CustomerAgreement customeragreement);

    @POST
    @Consumes({"application/sep+xml", "application/sep-exi" })
    void POSTCustomerAgreement(CustomerAgreement customeragreement);

    @DELETE
    @Produces("application/xml")
    CustomerAgreement DELETECustomerAgreement();

}